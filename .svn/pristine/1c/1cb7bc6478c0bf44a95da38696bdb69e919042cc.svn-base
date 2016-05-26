package com.ffcs.crmd.platform.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;
import com.alibaba.dubbo.monitor.MonitorService;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.support.RpcUtils;
import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ffcs.crmd.platform.pub.proxy.IExchangeService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linzhiqiang on 16/5/11.
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class CrmdMonitorFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CrmdMonitorFilter.class);

    private final ConcurrentMap<String, AtomicInteger> concurrents = new ConcurrentHashMap<String, AtomicInteger>();

    private MonitorFactory monitorFactory;

    public void setMonitorFactory(MonitorFactory monitorFactory) {
        this.monitorFactory = monitorFactory;
    }

    // 调用过程拦截
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (invoker.getUrl().hasParameter(Constants.MONITOR_KEY)) {
            RpcContext context = RpcContext.getContext(); // 提供方必须在invoke()之前获取context信息
            long start = System.currentTimeMillis(); // 记录起始时间戮
            getConcurrent(invoker, invocation).incrementAndGet(); // 并发计数
            try {
                Result result = invoker.invoke(invocation); // 让调用链往下执行
                collect(invoker, invocation, result, context, start, false);
                return result;
            } catch (RpcException e) {
                collect(invoker, invocation, null, context, start, true);
                throw e;
            } finally {
                getConcurrent(invoker, invocation).decrementAndGet(); // 并发计数
            }
        } else {
            return invoker.invoke(invocation);
        }
    }

    // 信息采集
    private void collect(Invoker<?> invoker, Invocation invocation, Result result, RpcContext context, long start, boolean error) {
        try {
            // ---- 服务信息获取 ----
            long elapsed = System.currentTimeMillis() - start; // 计算调用耗时
            int concurrent = getConcurrent(invoker, invocation).get(); // 当前并发数
            String application = invoker.getUrl().getParameter(Constants.APPLICATION_KEY);
            String service = invoker.getInterface().getName(); // 获取服务名称
            String method = RpcUtils.getMethodName(invocation); // 获取方法名
            URL url = invoker.getUrl().getUrlParameter(Constants.MONITOR_KEY);
            Monitor monitor = monitorFactory.getMonitor(url);
            if (service.equals(IExchangeService.class.getName()) && method.equals("exchange")) {
                Object[] params = RpcUtils.getArguments(invocation);
                if (params.length == 2) {
                    if (params[0] != null && params[0] instanceof ReqData) {
                        ReqData data = (ReqData) params[0];
                        service = data.getServiceName();
                        method = data.getMethod();
                    }
                }
            }
            int localPort;
            String remoteKey;
            String remoteValue;
            if (Constants.CONSUMER_SIDE.equals(invoker.getUrl().getParameter(Constants.SIDE_KEY))) {
                // ---- 服务消费方监控 ----
                context = RpcContext.getContext(); // 消费方必须在invoke()之后获取context信息
                localPort = 0;
                remoteKey = MonitorService.PROVIDER;
                remoteValue = invoker.getUrl().getAddress();
            } else {
                // ---- 服务提供方监控 ----
                localPort = invoker.getUrl().getPort();
                remoteKey = MonitorService.CONSUMER;
                remoteValue = context.getRemoteHost();
            }
            String input = "", output = "";
            if (invocation.getAttachment(Constants.INPUT_KEY) != null) {
                input = invocation.getAttachment(Constants.INPUT_KEY);
            }
            if (result != null && result.getAttachment(Constants.OUTPUT_KEY) != null) {
                output = result.getAttachment(Constants.OUTPUT_KEY);
            }
            monitor.collect(new URL(Constants.COUNT_PROTOCOL,
                NetUtils.getLocalHost(), localPort,
                service + "/" + method,
                MonitorService.APPLICATION, application,
                MonitorService.INTERFACE, service,
                MonitorService.METHOD, method,
                remoteKey, remoteValue,
                error ? MonitorService.FAILURE : MonitorService.SUCCESS, "1",
                MonitorService.ELAPSED, String.valueOf(elapsed),
                MonitorService.CONCURRENT, String.valueOf(concurrent),
                Constants.INPUT_KEY, input,
                Constants.OUTPUT_KEY, output));
        } catch (Throwable t) {
            logger.error("Failed to monitor count service " + invoker.getUrl() + ", cause: " + t.getMessage(), t);
        }
    }

    // 获取并发计数器
    private AtomicInteger getConcurrent(Invoker<?> invoker, Invocation invocation) {
        String key = invoker.getInterface().getName() + "." + invocation.getMethodName();
        AtomicInteger concurrent = concurrents.get(key);
        if (concurrent == null) {
            concurrents.putIfAbsent(key, new AtomicInteger());
            concurrent = concurrents.get(key);
        }
        return concurrent;
    }
}
