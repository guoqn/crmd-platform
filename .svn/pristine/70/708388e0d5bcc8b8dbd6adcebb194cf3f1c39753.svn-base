package com.ffcs.crmd.platform.idempotency.core.aop;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.base.utils.CastorUtils;
import com.ffcs.crmd.platform.idempotency.core.constants.IdempotencyConstant;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkSheet;
import com.ffcs.crmd.platform.idempotency.core.service.IIdempotencyService;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

/**
 * 
 * 幂等性处理切面类.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2015年11月28日
 * @功能说明：
 *
 */
public class IdempotencyAdvisor implements MethodInterceptor {
    
    private static final ILogger LOGGER = LoggerFactory.getLogger(CastorUtils.class);
    
    @Resource
    private IIdempotencyService  idempotencyService;
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        LOGGER.debug("开始分布式事务...");
        boolean isNest = false;
        try {
            //如果分布式事务嵌套分布式事务，直接执行原方法
            if (IdempotencyConstant.SysWorkStatus.RUNNING.equals(CrmSessionContext.getContext()
                .getSysWorkStatus())) {
                isNest = true;
                return invocation.proceed();
            }
            //开始分布式事务，状态标识为执行中
            CrmSessionContext.getContext().setSysWorkStatus(
                IdempotencyConstant.SysWorkStatus.RUNNING);
            //执行原方法
            Object retVal = invocation.proceed();
            //存储事务事件集，状态标识为存储处理中
            CrmSessionContext.getContext().setSysWorkStatus(
                IdempotencyConstant.SysWorkStatus.SAVING);
            //加载或创建事务事件集
            SysWorkSheet sysWorkSheet = idempotencyService.loadOrCreateSysWorkSheet(invocation);
            //提交事务事件集
            idempotencyService.commitSysWorkSheet(sysWorkSheet);
            //执行事务事件集，状态标识为执行处理中
            CrmSessionContext.getContext().setSysWorkStatus(
                IdempotencyConstant.SysWorkStatus.PROCESSING);
            //执行事务事件集
            idempotencyService.processSysWorkSheet(sysWorkSheet);
            //归档事务事件集
            idempotencyService.completeSysWorkSheet(sysWorkSheet);
            return retVal;
        } finally {
            //最外层的分布式事务方法统一做清理
            if (!isNest) {
                CrmSessionContext.getContext().clearSysWorkSheet();
            }
            LOGGER.debug("结束分布式事务...");
        }
    }
}
