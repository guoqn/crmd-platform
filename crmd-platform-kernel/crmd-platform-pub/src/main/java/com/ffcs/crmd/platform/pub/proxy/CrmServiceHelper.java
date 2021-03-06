package com.ffcs.crmd.platform.pub.proxy;

import com.ctg.itrdc.event.dto.EventProxyCtxDTO;
import com.ctg.itrdc.event.rule.RPCRuleResDecoder;
import com.ctg.itrdc.event.utils.EventDrivenUtil;
import com.ctg.itrdc.event.utils.JSONUtils;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.fileconfig.SystemConfigHelper;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.serializer.Serializer;
import com.ctg.itrdc.platform.common.utils.serializer.SerializerFactory;
import com.ctg.itrdc.platform.common.utils.serializer.ServantSerialFormat;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.bean.HeadInfo;
import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ctg.itrdc.platform.pub.constant.BaseUnitConstants;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ctg.itrdc.platform.pub.proxylog.ProxyLogFactory;
import com.ffcs.crmd.platform.base.utils.CrmNetUtils;
import com.ffcs.crmd.platform.pub.cache.context.service.ServiceCacheContext;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.proxy.callfilter.ICallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.ProxyCallFilterFactory;
import com.ffcs.crmd.platform.pub.vo.ExceptionVo;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public class CrmServiceHelper {

    private static final ILogger LOGGER = LoggerFactory.getLogger(CrmServiceHelper.class);

    private CrmServiceHelper() {

    }

    public static Object getEmptyReturn(Class<?> returnType)
        throws IllegalAccessException, InstantiationException {
        if (List.class.isAssignableFrom(returnType)) {
            return new ArrayList();
        } else if (Set.class.isAssignableFrom(returnType)) {
            return new HashSet();
        } else if (returnType.isArray()) {
            return returnType.cast(Array.newInstance(returnType.getComponentType(), 0));
        } else if ("void".equals(returnType.getSimpleName()) || returnType.isInterface()) {
            return null;
        } else {
            return returnType.newInstance();
        }
    }

    /**
     * 根据请求返回数据结果，以及目标方法的返回类型，获取目标调用的返回对象
     *
     * reqResult里面包含了目标调用的返回对象，以及其他头部信息、尾部信息，因此需要从里面分析出目标调用的返回对象
     *
     * @param result
     * @param returnType
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static Object getMethodTargetResult(ReqResult result, Class<?> returnType)
        throws InstantiationException, IllegalAccessException {
        if (result != null && result.getData() != null && result.getData().length >= 1) {
            if (List.class.isAssignableFrom(returnType)) {
                List list = new ArrayList();
                for (Object obj : result.getData()) {
                    list.add(obj);
                }
                return list;
            }
            if (Set.class.isAssignableFrom(returnType)) {
                Set<Object> list = new HashSet();
                for (Object obj : result.getData()) {
                    list.add(obj);
                }
                return list;
            } else if (returnType.isArray()) {
                return result.getData();
            } else {
                if (result.getData().length == 1) {
                    return result.getData()[0];
                }
            }
        }
        return CrmServiceHelper.getEmptyReturn(returnType);
    }

    /**
     * 远程调用
     * @param exchangeService
     * @param modName
     * @param serialType
     * @param serviceName
     * @param method
     * @param args
     * @param decoder
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object callExchange(IExchangeService exchangeService, String modName,
        String serialType, String serviceName, Method method, Object[] args,
        RPCRuleResDecoder<ReqResult> decoder, String reqStr, String retStr)
        throws IllegalAccessException, InstantiationException {
        if (exchangeService == null) {
            throw new RtManagerException("service " + modName + "ExchangeService" + " must define");
        }

        if (StringUtils.isBlank(serialType)) {
            serialType = ServantSerialFormat.XML.getFormat();
        }

        if (StringUtils.isBlank(serviceName)) {
            throw new IllegalArgumentException("'serviceName' must not be null");
        }

        ReqData req = new ReqData();
        req.setServiceName(serviceName);
        req.setMethod(method.getName());
        req.setArgs(args);

        // 处理因子信息
        // 将因子信息填充进去
        // 填充因子回到HeadInfo
        HeadInfo info = req.getHeadInfo();
        info.setFrom(SystemConfigHelper.getApp());
        EventProxyCtxDTO eventProxyCtxDTO = EventDrivenUtil
            .onBeforeEvent(req.getServiceName(), req.getMethod());
        info.setPropsMap(eventProxyCtxDTO.getFactor());

        //添加自定义线程变量信息
        info = HeadInfo.fillServiceDefPropFromThreadLocalAndSession(info);

        //调用拦截器填充属性到线程变量
        //        ICallFilter filter = ProxyCallFilterFactory
        //            .getProxyCallFilter(modName, serviceName, method.getName());
        List<ICallFilter> filters = ProxyCallFilterFactory
            .getProxyCallFilters(modName, serviceName, method.getName());
        Map<String,String> propsMap = new HashMap<String,String>();

        if (filters != null && filters.size() > 0) {
            for (ICallFilter filter : filters) {
                Map<String, String> tmpPropsMap = filter.getPropsMap();
                propsMap.putAll(tmpPropsMap);
            }
        }

        for (Map.Entry<String, String> entry : propsMap.entrySet()) {
            info.addProp(entry.getKey(), entry.getValue());
        }
        //填充请求的机器IP
        req.getHeadInfo().setFromHost(CrmNetUtils.getLocalHost());

        Serializer serializer = SerializerFactory.getSerializer(serialType);
        reqStr = serializer.serialize(req);
        LOGGER.debug("REQ_INFO:\n" + reqStr);
        ReqResult reqResult = null;

        Long remoteBegin = System.nanoTime();
        try {
            reqResult = ServiceCacheContext.getInstance()
                .getResFromCache(serviceName, method.getName(), args);
        } catch (Exception e) {
            reqResult = null;
        }
        if (reqResult != null) {
            reqResult = ServiceCacheContext.getInstance().rebuildReqResult(req, reqResult);
            LOGGER.debug("get from cache Total Coast(ns):" + (System.nanoTime() - remoteBegin));
        } else {
            try {

                reqResult = exchangeService.exchange(req, serialType);
                Long cacheBegin = System.nanoTime();
                try {
                    ServiceCacheContext.getInstance()
                        .putResToCache(serviceName, method.getName(), args, reqResult);
                } catch (Exception e) {
                    //ignore
                } finally {
                    LOGGER
                        .debug("put to cache Total Coast(ns):" + (System.nanoTime() - cacheBegin));
                }
            } finally {
                LOGGER.debug("remote Total Coast(ns):" + (System.nanoTime() - remoteBegin));
            }
        }
        if (reqResult == null) {
            LOGGER.debug("RES_INFO:\n" + "为空");

            RtManagerException rt = new RtManagerException("返回结果:为空");
            throw rt;
        }
        retStr = serializer.serialize(reqResult);
        LOGGER.debug("RES_INFO:\n" + retStr);

        if (reqResult != null && ReqResult.RET_ERROR.equals(reqResult.getResult())) {
            decoder.getRealTimeResults(reqResult);
            // mark：原逻辑 2016 5 12
//            ExceptionUtils.readEx(reqResult); // 异常处理
//            RtManagerException rt = new RtManagerException(reqResult.getMessage());
//            ProxyLogFactory.getLogger().fail(reqStr, serializer.serialize(reqResult), rt);
//            throw rt;
            // 代码调整
            String exStr = reqResult.getMessage();
            if (!StringUtils.isNullOrEmpty(exStr)) {
            	ExceptionVo exceptionVo = JSONUtils.jsonToObject(exStr, ExceptionVo.class);
            	if (exceptionVo != null) {
            		if (StringUtils.isNullOrEmpty(
            				exceptionVo.getErrorCode())) {
            			// 转换成BaseAppException
            			BaseAppException rt = new BaseAppException(exceptionVo.getMessage());
            			ProxyLogFactory.getLogger().fail(reqStr, serializer.serialize(reqResult), rt);
            			throw rt;
            		} else {
            			BaseAppException baseAppException = new BaseAppException(exceptionVo.getMessage(), exceptionVo.getErrorCode());
            			ProxyLogFactory.getLogger().fail(reqStr, serializer.serialize(reqResult), baseAppException);
            			throw baseAppException;
            		}
            	} else {
            		throw new RtManagerException(exStr);
            	}
            }
            
        }
        decoder.getWarnResults(reqResult);
        ExceptionUtils.readWarnings(reqResult);
        // 将因子信息回填到当前线程中
        EventDrivenUtil.onAfterEvent(eventProxyCtxDTO, reqResult.getHeadInfo().getPropsMap());

        HeadInfo.setServiceDefPropToThreadLocalAndSession(reqResult.getHeadInfo());

        //属性回填处理
        Map<String, String> respPropsMap = reqResult.getHeadInfo().getPropsMap();

        if (filters != null && filters.size() > 0) {
            for (ICallFilter filter : filters) {
                filter.putPropsMap(respPropsMap);
            }
        }

        ProxyLogFactory.getLogger().success(reqStr, serializer.serialize(reqResult));

        Class<?> returnType = method.getReturnType();
        return getMethodTargetResult(reqResult, returnType);
    }

    public static void setSerialFlag(ReqData req) {
        if (req != null && req.getHeadInfo() != null) {
            String serial = req.getHeadInfo().getSerial();
            SessionContext.putTheadLocalVariable(BaseUnitConstants.REQ_SERIAL, serial);
        }
    }
}
