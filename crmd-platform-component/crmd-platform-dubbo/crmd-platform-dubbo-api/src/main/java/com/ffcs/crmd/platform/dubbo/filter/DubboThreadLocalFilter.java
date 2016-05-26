package com.ffcs.crmd.platform.dubbo.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.context.SessionContext;

public class DubboThreadLocalFilter implements Filter {
    private static final ILogger LOG = LoggerFactory.getLogger(DubboThreadLocalFilter.class);
    
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        LOG.debug("dubbo请求，线程变量清理");
        SessionContext.initialBaseInfo();
        Result result = invoker.invoke(invocation);
        SessionContext.clearBaseInfo();
        return result;
    }
    
}
