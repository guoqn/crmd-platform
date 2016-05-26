package com.ffcs.crmd.platform.pub.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import com.ctg.itrdc.event.rule.RPCRuleResDecoder;
import com.ctg.itrdc.event.rule.RuleResult;
import com.ctg.itrdc.event.utils.RPCResultHelper;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ctg.itrdc.platform.pub.proxylog.ProxyLogFactory;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.metric.ext.entity.CrmdCounter;
import com.ffcs.crmd.metric.ext.entity.CrmdMeter;
import com.ffcs.crmd.metric.ext.entity.CrmdMetricRegistry;
import com.ffcs.crmd.metric.ext.entity.CrmdTimer;
import com.ffcs.crmd.metric.ext.utils.MetricUtils;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.proxy.callframework.CallContextConstants;
import com.ffcs.crmd.platform.pub.proxy.callframework.CallEntity;
import com.ffcs.crmd.platform.pub.proxy.callframework.ICallContext;

public class CrmServiceProxyHandler implements InvocationHandler, RPCRuleResDecoder<ReqResult> {

    private static final ILogger logger = LoggerFactory.getLogger(CrmServiceProxyHandler.class);

    private Properties serviceConfig;

    public CrmServiceProxyHandler(Properties serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (serviceConfig == null) {
            throw new IllegalArgumentException("'serviceConfig' must not be null");
        }
        String reqStr = "";

        String retStr = "";
        CrmdTimer.CrmdContext context = null;
        CrmdMeter meter = null;
        Long beginTime = System.nanoTime();
        try {
            logger.debug("invoke start...");
            String serialType = serviceConfig.getProperty("serialType");
            String serviceName = serviceConfig.getProperty("serviceName");
            // 增加模块名称作为后端服务的区分标志
            String modName = serviceConfig.getProperty("modName");

            if (StringUtils.isNullOrEmpty(modName)) {
                throw new RtManagerException("modName must not be null");
            }
            try {
                CrmdTimer timer = MetricUtils
                    .getTimer(ProxyConstants.METRIC_GROUP, modName, serviceName, method.getName());
                context = timer.time2();
                meter = MetricUtils
                    .getMeter(ProxyConstants.METRIC_GROUP, modName, serviceName, method.getName(),
                        "Exception");
            } catch (Exception e) {
                //ignore
            }
            //批量调用
            if (!StringUtils.isNullOrEmpty(SessionContext
                .getObject4TreadLocal(CallContextConstants.CONTEXT_BATCH_START_FALG))) {
                ICallContext callContext = (ICallContext) SessionContext
                    .getObject4TreadLocal(CallContextConstants.CONTEXT_THREAD_KEY);
                CallEntity callEntity = new CallEntity(modName, serviceName, serialType,
                    method.getName(), method.getReturnType(), args);
                callContext.addCallEntity(callEntity);
                return CrmServiceHelper.getEmptyReturn(method.getReturnType());
            } else if (!StringUtils.isNullOrEmpty(SessionContext
                .getObject4TreadLocal(CallContextConstants.CONTEXT_DATA_START_FALG))) {
                ICallContext callContext = (ICallContext) SessionContext
                    .getObject4TreadLocal(CallContextConstants.CONTEXT_THREAD_KEY);
                CallEntity callEntity = new CallEntity(modName, serviceName, serialType,
                    method.getName(), method.getReturnType(), args);
                ReqResult reqResult = callContext.getReqResult(callEntity);
                if (reqResult == null) {
                    ExceptionUtils.throwEx(new RtManagerException("调用异常,无返回"));
                    return CrmServiceHelper.getEmptyReturn(method.getReturnType());
                } else {
                    if (reqResult != null && ReqResult.RET_ERROR.equals(reqResult.getResult())) {
                        getRealTimeResults(reqResult);
                        ExceptionUtils.readEx(reqResult); // 异常处理
                        throw new RtManagerException(reqResult.getMessage());
                    }
                    return CrmServiceHelper
                        .getMethodTargetResult(reqResult, method.getReturnType());
                }
            } else {

                IExchangeService exchangeService = ApplicationContextUtil
                    .getBean(StringUtils.first2Lower(modName) + "ExchangeService");

                return CrmServiceHelper
                    .callExchange(exchangeService, modName, serialType, serviceName, method, args,
                        this, reqStr, retStr);
            }
        } catch (Exception e) {
        
            if (meter != null) {
                meter.mark();
            }
            ProxyLogFactory.getLogger().fail(reqStr, retStr, e);
            // dubbo调用处理
            String exClazz = e.getClass().getName();
            if (!StringUtils.isNullOrEmpty(exClazz)
            		&& exClazz.startsWith("com.alibaba.dubbo")) {
            	e = new RtManagerException("dubbo服务调用异常！");
            }
            throw e;
        } finally {
            if (context != null) {
                context.stop();
            }
            logger.debug("total Coast(ns):" + (System.nanoTime() - beginTime));
        }

    }

    @Override
    public List<RuleResult> decode(ReqResult arg0) {
        return arg0.getHeadInfo().getRuleResults();
    }

    @Override
    public void getRealTimeResults(ReqResult arg0) {
        RPCResultHelper.getRealTimeResults(this, arg0);
    }

    @Override
    public void getWarnResults(ReqResult arg0) {
        RPCResultHelper.getWarnResults(this, arg0);
    }
}
