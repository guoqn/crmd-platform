package com.ffcs.crmd.platform.dubbo.core;

import static com.ctg.itrdc.platform.pub.constant.ServantConstants.SERVICE_DATA;
import static com.ctg.itrdc.platform.pub.constant.ServantConstants.SERVICE_SEARIL_TYPE;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.ctg.itrdc.platform.common.fileconfig.SystemConfigHelper;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.metric.ext.entity.CrmdMeter;
import com.ffcs.crmd.metric.ext.entity.CrmdTimer;
import com.ffcs.crmd.metric.ext.utils.MetricUtils;
import com.ffcs.crmd.platform.base.utils.CrmNetUtils;
import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.proxy.CrmServiceHelper;
import com.ffcs.crmd.platform.pub.proxy.ProxyConstants;
import com.ffcs.crmd.platform.pub.proxy.callfilter.ICallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.ServerCallFilterFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.event.dto.EventProxyCtxDTO;
import com.ctg.itrdc.event.rule.RPCRuleResCoder;
import com.ctg.itrdc.event.rule.RuleContext;
import com.ctg.itrdc.event.rule.RuleResult;
import com.ctg.itrdc.event.utils.Constants;
import com.ctg.itrdc.event.utils.EventDrivenUtil;
import com.ctg.itrdc.event.utils.EventPublisher;
import com.ctg.itrdc.event.utils.JSONUtils;
import com.ctg.itrdc.event.utils.RPCResultHelper;
import com.ctg.itrdc.platform.common.exception.ExceptionUtil;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
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
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.proxy.IExchangeService;
import com.ffcs.crmd.platform.pub.proxy.provider.ServiceLoader;
import com.ffcs.crmd.platform.pub.vo.ExceptionVo;
import com.google.common.base.Strings;

@Service("exchangeService")
public class ExchangeServiceImpl implements IExchangeService, RPCRuleResCoder<ReqResult> {
    private String defaultSerialType = ServantSerialFormat.XML.getFormat();

    private static final ILogger LOGGER = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    private ServiceLoader factory = ServiceLoader.getDefaultFactory();

    @Override
    public ReqResult exchange(ReqData reqData, String serialType) {
        //        清空线程变量
        //        SessionContext.clearBaseInfo();
        Long exchangeBegin = System.nanoTime();
        CrmdTimer.CrmdContext context = null;
        CrmdMeter failMeter = null;
        try {
            CrmdTimer timer = MetricUtils
                .getTimer(ProxyConstants.METRIC_GROUP, reqData.getServiceName(), reqData.getMethod());
            context = timer.time2();
            failMeter = MetricUtils
                .getMeter(ProxyConstants.METRIC_GROUP, reqData.getServiceName(), reqData.getMethod(),
                    "Fail");
        } catch (Exception e) {
            //igonre
        }
        ReqResult reqResult = null;
        try {
            if (Strings.isNullOrEmpty(serialType)) {
                serialType = defaultSerialType;
            }
            Serializer serializer = SerializerFactory.getSerializer(serialType);
            String serviceData = serializer.serialize(reqData);
            if (reqData == null) {
                reqResult = serviceDataEmptyError(serializer, serviceData, null);
                if (failMeter != null) {
                    failMeter.mark();
                }
                return reqResult;
            }
            LOGGER.debug(
                SERVICE_DATA + "=" + serviceData + "\n" + SERVICE_SEARIL_TYPE + "=" + serialType
                    + "\n");

            reqResult = doInnerCall(serializer, serviceData);
            if (reqResult == null || ReqResult.RET_ERROR.equals(reqResult.getResult())) {
                if (failMeter != null) {
                    failMeter.mark();
                }
            }
            return reqResult;
        } finally {
            if (context != null) {
                context.stop();
            }
            LOGGER.debug("exchange Total Coast(ns):" + (System.nanoTime() - exchangeBegin));
        }
    }

    /**
     * 内部服务方法调用，并将处理结果返回到输出流
     *
     * @param serializer
     * @param serviceData
     * @return
     */
    private ReqResult doInnerCall(Serializer serializer, String serviceData) {
        Long innerBegin = System.nanoTime();
        EventProxyCtxDTO eventProxyCtxDTO = null;
        List<ICallFilter> filters = new ArrayList<ICallFilter>();
        try {
            ReqData req = (ReqData) serializer.deserialize(serviceData, ReqData.class);
            // 清空线程信息
            RuleContext.removeContext();
            setEventFactor(req);
            eventProxyCtxDTO = EventPublisher
                .onBeforePublish(req.getServiceName(), req.getMethod());
            String oldSerivceDate = new String(serviceData);
            serviceData = doEventFilter(serviceData, req, serializer);
            if (!oldSerivceDate.equals(serviceData)) {
                req = (ReqData) serializer.deserialize(serviceData, ReqData.class);
            }
            CrmServiceHelper.setSerialFlag(req);
            HeadInfo.setServiceDefPropToThreadLocalAndSession(req.getHeadInfo());
            //保存headInfo
            SessionContext.setObject2TreadLocal(BaseUnitConstants.REQ_HEAD, req.getHeadInfo());
            //变量处理
            filters = ServerCallFilterFactory
                .getServerCallFilters(req.getServiceName(), req.getMethod());
            Map<String, String> reqPropsMap = req.getHeadInfo().getPropsMap();
            if (filters != null && filters.size() > 0) {
                for (ICallFilter filter : filters) {
                    filter.putPropsMap(reqPropsMap);
                }
            }

            Object service = null;
            try {
                service = this.factory.getServiceInstance(req.getServiceName());
            } catch (final Exception e) {
                return getServiceInstanceError(serializer, serviceData, e, filters);
            }
            if (service == null) {
                return serviceInstanceNotExistError(serializer, serviceData, filters);
            }
            final Method method = this.factory
                .getClazzMethod(service, req.getMethod(), req.getArgs());
            if (method == null) {
                return methodNotFoundError(serializer, serviceData, filters);
            }
            Object ret = null;
            try {
                ret = method.invoke(service, req.getArgs());
            } catch (final Exception e) {
                return methodInvokeError(serializer, serviceData, e, filters);
            }

            ReqResult result = new ReqResult();
            if (RPCResultHelper.hasRealTimeResults()) {
                result = this.dealRealTimeRuleResult(serviceData);
            } else {
                result = ReqResult.genReqResult(ReqResult.RET_SUCCESS, "操作成功", ret);
                this.setWarnResults(result);
            }

            // 添加提示异常
            ExceptionUtils.fillWarnings(result, CrmSessionContext.getWarnings());

            String res = serialResult(serializer,result,filters);
            ProxyLogFactory.getLogger().success(serviceData, res);
            return result;
        } catch (Exception e) {
            LOGGER.error("调用出错" + e.getMessage());
            return serviceCallError(serviceData, serializer, e, filters);
        } finally {
            try {
                EventPublisher.onAfterPublish(eventProxyCtxDTO);
            } catch (Exception e) {
                // 日志无需提示
            }
            //清楚headInfo
            SessionContext.setObject2TreadLocal(BaseUnitConstants.REQ_HEAD, null);
            LOGGER.debug("inner coast(ns):" + (System.nanoTime() - innerBegin));
        }
    }

    /**
     * 服务数据为空的错误处理
     *
     * @param out
     * @param serializer
     * @param serviceData
     * @return
     */
    private ReqResult serviceDataEmptyError(Serializer serializer, String serviceData,
        List<ICallFilter> serverFilters) {
        ReqResult result;
        result = ReqResult.genReqResult(ReqResult.RET_ERROR, ExceptionVo.toString("入参错误，data为空"), null);
        //        String res = serializer.serialize(result);
        String res = serialResult(serializer, result, serverFilters);
        ProxyLogFactory.getLogger().fail(serviceData, res, null);
        return result;
    }

    /**
     * 获取服务实例错误处理
     *
     * @param out
     * @param serializer
     * @param serviceData
     * @param e
     * @return
     */
    private ReqResult getServiceInstanceError(Serializer serializer, String serviceData,
        final Exception e, List<ICallFilter> serverFilters) {
        ReqResult result;
        LOGGER.error("获取服务异常", e);
        result = ReqResult.genReqResult(ReqResult.RET_ERROR,
        		ExceptionVo.toString(e.getMessage(), "入参:" + serviceData + "\n--exceptionInfo:" + e.getMessage() + "\n--traceInfo:\n:"
                        + ExceptionUtil.getTraceInfo(e))
            , null);
        //        String res = serializer.serialize(result);
        String res = serialResult(serializer, result, serverFilters);
        ProxyLogFactory.getLogger().fail(serviceData, res, e);
        return result;
    }

    /**
     * 服务实例不存在错误处理
     *
     * @param out
     * @param serializer
     * @param serviceData
     * @return
     */
    private ReqResult serviceInstanceNotExistError(Serializer serializer, String serviceData,
        List<ICallFilter> serverFilters) {
        ReqResult result = ReqResult
            .genReqResult(ReqResult.RET_ERROR, ExceptionVo.toString("获取不到服务" + ",入参:" + serviceData), null);
        //        String res = serializer.serialize(result);
        String res = serialResult(serializer, result, serverFilters);
        ProxyLogFactory.getLogger().fail(serviceData, res, null);
        return result;
    }

    /**
     * 服务方法调用异常
     *
     * @param out
     * @param serializer
     * @param serviceData
     * @param e
     * @return
     */
    private ReqResult methodInvokeError(Serializer serializer, String serviceData,
        final Exception e, List<ICallFilter> serverFilters) {
    	Throwable t = e;
    	// method.invoke异常处理，cause剥离
    	if (e instanceof InvocationTargetException) {
    		Throwable cause = ((InvocationTargetException) e).getCause();
    		if (cause != null) {
    			t = cause;
    		}
    	}
        LOGGER.error("服务方法调用异常", t);

        ReqResult result = new ReqResult();

        if (RPCResultHelper.hasRealTimeResults()) {
            result = dealRealTimeRuleResult(serviceData);
        } else {
            ExceptionVo exceptionVo = new ExceptionVo();
            
            exceptionVo.setTraceInfo("方法调用异常" + ",入参:" + serviceData + "\n--exceptionInfo:" + t.getMessage()
            + "\n--traceInfo:\n" + ExceptionUtil.getTraceInfo(t));
            if (t instanceof BaseAppException) {
            	BaseAppException baseAppException = (BaseAppException) t;
            	exceptionVo.setErrorCode(baseAppException.getErrorCode());
            	exceptionVo.setMessage(baseAppException.getBusinessHint());
            } else {
            	exceptionVo.setMessage(t.getMessage());
            }
            
            result = ReqResult.genReqResult(ReqResult.RET_ERROR, JSONUtils.toJsonString(exceptionVo)
            		, null); 
        }
        //        String res = serializer.serialize(result);
        String res = serialResult(serializer, result, serverFilters);
        ProxyLogFactory.getLogger().fail(serviceData, res, e);
        return result;
    }

    /**
     * 找不到服务方法错误处理
     *
     * @param out
     * @param serializer
     * @param serviceData
     * @return
     */
    private ReqResult methodNotFoundError(Serializer serializer, String serviceData,
        List<ICallFilter> serverFilters) {
        LOGGER.error("找不到服务方法异常,serviceData is:{}", serviceData);
        ReqResult result = ReqResult
            .genReqResult(ReqResult.RET_ERROR, ExceptionVo.toString("获取不到方法" + ",入参:" + serviceData), null);
        //        String res = serializer.serialize(result);
        String res = serialResult(serializer, result, serverFilters);
        ProxyLogFactory.getLogger().fail(serviceData, res, null);
        return result;
    }

    /**
     * 服务主流程调用异常处理
     * @param serviceData
     *
     * @param out
     * @param serializer
     * @param e
     */
    private ReqResult serviceCallError(String serviceData, Serializer serializer, Exception e,
        List<ICallFilter> serverFilters) {
        LOGGER.error("服务主流程调用异常", e);
        try {
            ReqResult result = ReqResult.genReqResult(ReqResult.RET_ERROR,
            		ExceptionVo.toString(e.getMessage(), "服务异常" + e.getMessage() + "\n--traceInfo:\n" + ExceptionUtil.getTraceInfo(e))
                , null);
            //            String res = serializer.serialize(result);
            String res = serialResult(serializer, result, serverFilters);
            ProxyLogFactory.getLogger().fail(serviceData, res, e);
            return result;
        } catch (Exception e2) {
            throw new RtManagerException(
                "服务异常" + e2.getMessage() + "\n--traceInfo:\n" + ExceptionUtil.getTraceInfo(e2));
        }
    }

    /**
     * 将因子放入线程变量
     *
     * @param req
     */
    private void setEventFactor(ReqData req) {
        EventDrivenUtil.setAllEventFactor(req.getHeadInfo().getPropsMap());

    }

    /**
     * 切入事件驱动框架的拦截器
     *
     * @param serviceData
     * @param req
     * @param serializer
     * @return
     */
    private String doEventFilter(String serviceData, final ReqData req, Serializer serializer) {
        Map<String, String> map = EventPublisher
            .doServiceRoute(req.getServiceName(), req.getMethod());
        if (map != null && map.size() > 0) {
            String clazzName = map.get(Constants.SERVICE_NAME);
            String method = map.get(Constants.METHOD_NAME);
            if (!StringUtils.isNullOrEmpty(clazzName)) {
                req.setServiceName(clazzName);
            }
            if (!StringUtils.isNullOrEmpty(method)) {
                req.setMethod(method);
            }

            LOGGER.debug("事件拦截后的服务名{},方法名{}", clazzName, method);
            //            serviceData = serializer.serialize(req);
            LOGGER.info("转换后的报文为：{}", serializer.serialize(req));
        }
        //需要事件驱动框架理清这部分处理
        //原始报文不变化
        return serviceData;
    }

    @Override
    public void code(ReqResult obj, List<RuleResult> results) {
        obj.getHeadInfo().setRuleResults(new Vector<RuleResult>(results));
    }

    @Override
    public void setRealTimeResults(ReqResult obj) {
        RPCResultHelper.setRealTimeResults(this, obj);
    }

    @Override
    public void setWarnResults(ReqResult obj) {
        if (RPCResultHelper.hasWarnResults()) {
            RPCResultHelper.setWarnResults(this, obj);
        }
    }

    public ReqResult dealRealTimeRuleResult(String serviceData) {
        if (!RPCResultHelper.hasRealTimeResults()) {
            return null;
        }
        // 实时交互规则异常，也是调用失败--规则异常被封装
        LOGGER.error("规则调用异常", RuleContext.getContext().getRealTimeResult());
        ReqResult reqResult = new ReqResult();
        reqResult = ReqResult
            .genReqResult(ReqResult.RET_ERROR, "规则执行异常" + ",入参:" + serviceData, null);
        this.setRealTimeResults(reqResult);
        return reqResult;
    }

    protected String serialResult(Serializer serializer, ReqResult result,
        List<ICallFilter> serverFilter) {
        Map<String, String> propsMap = new HashMap<String, String>();

        if (serverFilter != null && serverFilter.size() > 0) {
            for (ICallFilter filter : serverFilter) {
                Map<String, String> tmpPropsMap = filter.getPropsMap();
                propsMap.putAll(tmpPropsMap);
            }
        }

        for (Map.Entry<String, String> entry : propsMap.entrySet()) {
            result.getHeadInfo().addProp(entry.getKey(), entry.getValue());
        }

        HeadInfo reqInfo = (HeadInfo) SessionContext
            .getObject4TreadLocal(BaseUnitConstants.REQ_HEAD);
        if (reqInfo != null) {
            result.getHeadInfo().setFromHost(reqInfo.getFromHost());
        }
        if (CrmStringUtils.isNullOrEmpty(result.getHeadInfo().getFromHost())) {
            result.getHeadInfo().setFromHost(
                RpcContext.getContext().getRemoteHost() + ":" + RpcContext.getContext().getRemotePort());
        }
        result.getHeadInfo().setToHost(
            RpcContext.getContext().getLocalHost() + ":" + RpcContext.getContext()
                .getLocalPort());
        String res = serializer.serialize(result);
        return res;
    }

}
