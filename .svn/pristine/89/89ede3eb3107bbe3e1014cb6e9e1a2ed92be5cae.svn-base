package com.ffcs.crmd.platform.pub.cache.context.service;

import com.ctg.itrdc.event.dto.EventProxyCtxDTO;
import com.ctg.itrdc.event.rule.RuleContext;
import com.ctg.itrdc.event.utils.EventDrivenUtil;
import com.ctg.itrdc.event.utils.EventPublisher;
import com.ctg.itrdc.event.utils.RPCResultHelper;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.fileconfig.SystemConfigHelper;
import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.bean.HeadInfo;
import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ctg.itrdc.platform.pub.constant.BaseUnitConstants;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ctg.itrdc.platform.pub.proxylog.ProxyLogFactory;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ctg.itrdc.platform.pub.util.HostUtils;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheConfig;
import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;
import com.ffcs.crmd.platform.cache.api.CacheProvider;
import com.ffcs.crmd.platform.cache.api.constants.CacheConstants;
import com.ffcs.crmd.platform.pub.cache.context.AbstractCacheContext;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.proxy.CrmServiceHelper;
import com.ffcs.crmd.platform.pub.proxy.ProxyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class ServiceCacheContext extends AbstractCacheContext {
    private ConcurrentMap<String, CacheConfig> regionMap         = new ConcurrentHashMap<String, CacheConfig>();
    private ConcurrentMap<String, String>      nullRegionFlagMap = new ConcurrentHashMap<String, String>();

    private CacheProvider localCache;

    private CacheProvider globalCache;

    private CacheConfigLoader configLoader;

    private static class ServiceCacheContextHolder {
        private static ServiceCacheContext CONTEXT = new ServiceCacheContext();
    }

    private ServiceCacheContext() {
        if (ApplicationContextUtil
            .containsBean(CacheConstants.SERVICE_LOCAL_CACHE_PROVIDER_BEAN_NAME)) {
            localCache = ApplicationContextUtil
                .getBean(CacheConstants.SERVICE_LOCAL_CACHE_PROVIDER_BEAN_NAME);
        }
        if (ApplicationContextUtil
            .containsBean(CacheConstants.SERVICE_GLOBAL_CACHE_PROVIDER_BEAN_NAME)) {
            globalCache = ApplicationContextUtil
                .getBean(CacheConstants.SERVICE_GLOBAL_CACHE_PROVIDER_BEAN_NAME);
        }
        if (ApplicationContextUtil
            .containsBean(CacheConstants.SERVICE_CACHE_CONFIG_LOADE_BEAN_NAME)) {
            configLoader = ApplicationContextUtil
                .getBean(CacheConstants.SERVICE_CACHE_CONFIG_LOADE_BEAN_NAME);
        }
    }

    public static ServiceCacheContext getInstance() {
        return ServiceCacheContextHolder.CONTEXT;
    }

    public void putResToCache(String serviceName, String methodName, Object[] params,
        ReqResult result) {
        CacheConfig config = getCacheConfig(serviceName, methodName);

        if (config == null) {
            logger.warn("no cache Config , do not need cache");
        } else {
            String regionName = config.getRegionName();
            String keyString = getKeyString(config, serviceName, params, methodName);
            if (CacheConstants.SERVICE_CACHE_LEVEL_GLOBAL.equals(config.getLevel())) {
                //异常返回不做全局缓存
                if (result != null && ReqResult.RET_ERROR.equals(result.getResult())) {
                    return;
                }
            }
            setObjectToCacheProvider(localCache, regionName, keyString, result);
            setObjectToCacheProvider(globalCache, regionName, keyString, result);
        }
    }

    private String getKeyString(CacheConfig config, String serviceName, Object[] params,
        String methodName) {
        CacheKey key = new CacheKey(serviceName, methodName, params);
        String keyString = "";
        if (CacheConstants.SERVICE_CACHE_LEVEL_GLOBAL.equals(config.getLevel())) {
            keyString = JSONUtils.toJsonString(key);
        } else if (CacheConstants.SERVICE_CACHE_LEVEL_REQUEST.equals(config.getLevel())) {
            key.setUuid(getSerial());
            keyString = JSONUtils.toJsonString(key);
        }
        return keyString;
    }

    public ReqResult getResFromCache(String serviceName, String methodName, Object[] params) {
        CacheConfig config = getCacheConfig(serviceName, methodName);

        if (config == null) {
            logger.warn("no cache Config , do not need cache");
        } else {
            String regionName = config.getRegionName();
            String keyString = getKeyString(config, serviceName, params, methodName);
            Serializable value = getObjectFromCacheProvider(localCache, regionName, keyString);
            if (value == null) {
                value = getObjectFromCacheProvider(globalCache, regionName, keyString);
                if (value != null) {
                    setObjectToCacheProvider(localCache, regionName, keyString, value);
                }
            }
            return (ReqResult) value;
        }
        return null;
    }

    public ReqResult removeResFromCache(String serviceName, String methodName, Object[] params) {
        CacheConfig config = getCacheConfig(serviceName, methodName);

        if (config == null) {
            logger.warn("no cache Config , do not need cache");
        } else {
            String regionName = config.getRegionName();
            String keyString = getKeyString(config, serviceName, params, methodName);
            removeObjectFromCacheProvider(localCache, regionName, keyString, null);
            removeObjectFromCacheProvider(globalCache, regionName, keyString, null);
        }
        return null;
    }

    private String getSerial() {
        if (StringUtils.isNullOrEmpty(
            SessionContext.getObject4TreadLocal(ProxyConstants.SERVICE_CACHE_SERIAL))) {
            SessionContext.setObject2TreadLocal(ProxyConstants.SERVICE_CACHE_SERIAL,
                UUID.randomUUID().toString());
        }
        return StringUtils
            .strnull(SessionContext.getObject4TreadLocal(ProxyConstants.SERVICE_CACHE_SERIAL));
    }

    private CacheConfig getCacheConfig(String serviceName, String methodName) {
        if (configLoader == null) {
            logger.error("configLoader Not define");
            return null;
        }
        String orginKey = serviceName + "." + methodName;
        if (!regionMap.containsKey(orginKey) && !nullRegionFlagMap.containsKey(orginKey)) {
            CacheConfig myConfig = null;
            List<CacheConfig> configs = configLoader.getAllCacheConfig();
            List<String> serviceStr = new ArrayList<String>();
            serviceStr.add(orginKey);
            for (int i = serviceName.length(); i >= 0; i--) {
                String newServiceName = serviceName;
                if (i != serviceName.length()) {
                    newServiceName = serviceName.substring(0, i) + "*";
                }
                for (int j = methodName.length() - 1; j >= 0; j--) {
                    serviceStr.add(newServiceName + "." + methodName.substring(0, j) + "*");
                }
            }
            for (String sStr : serviceStr) {
                if (myConfig == null) {
                    for (CacheConfig config : configs) {
                        if (config.getRegionName().equals(sStr)) {
                            myConfig = config;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (myConfig != null) {
                regionMap.putIfAbsent(orginKey, myConfig);
            } else {
                nullRegionFlagMap.putIfAbsent(orginKey,"1");
            }
        }
        return regionMap.get(orginKey);
    }

    public List<String> getAllRegionName() {
        return configLoader.getAllRegionName();
    }

    public void clearCache(String serviceName, String methodName) {
        CacheConfig config = getCacheConfig(serviceName, methodName);

        if (config == null) {
            logger.warn("no cache Config , do not need cache");
        } else {
            logger.warn("no cache Config , do not need cache");
            Cache global = getCache(globalCache, config.getRegionName());
            global.clear();
            Cache local = getCache(localCache, config.getRegionName());
            local.clear();
        }
    }

    public void clearAllCache() {
        clearAllCache(globalCache);
        clearAllCache(localCache);
    }

    public ReqResult rebuildReqResult(ReqData reqData, ReqResult reqResult) {
        Long innerBegin = System.nanoTime();
        EventProxyCtxDTO eventProxyCtxDTO = null;
        try {
            EventDrivenUtil.setAllEventFactor(reqData.getHeadInfo().getPropsMap());
            CrmServiceHelper.setSerialFlag(reqData);
            //保存headInfo
            SessionContext.setObject2TreadLocal(BaseUnitConstants.REQ_HEAD, reqData.getHeadInfo());
            HeadInfo.setServiceDefPropToThreadLocalAndSession(reqData.getHeadInfo());

            // 填充因子回到HeadInfo
            HeadInfo info = new HeadInfo();
            HeadInfo reqInfo = (HeadInfo) SessionContext
                .getObject4TreadLocal(BaseUnitConstants.REQ_HEAD);
            info.setPropsMap(EventDrivenUtil.getEventFactor());
            if (reqInfo != null) {
                info.setFromSerial(reqInfo.getSerial());
                info.setFrom(reqInfo.getFrom());
            } else {
                String fromSerial = StringUtils
                    .strnull(SessionContext.getObject4TreadLocal(BaseUnitConstants.REQ_SERIAL));
                info.setFromSerial(fromSerial);
                info.setFrom(SystemConfigHelper.DEFAULT_APP);
            }
            info.setFromHost(HostUtils.getInstance().getFromHost());
            info.setToHost(HostUtils.getInstance().getLocalHost());
            info.setTo(SystemConfigHelper.getApp());
            info = HeadInfo.fillServiceDefPropFromThreadLocalAndSession(info);
            reqResult.setHeadInfo(info);

        } catch (Exception e) {

        } finally {
            SessionContext.setObject2TreadLocal(BaseUnitConstants.REQ_HEAD, null);
        }
        return reqResult;
    }
}
