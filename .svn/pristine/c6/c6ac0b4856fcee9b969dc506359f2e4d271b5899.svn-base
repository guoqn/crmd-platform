package com.ffcs.crmd.platform.idempotency.core.service;

import org.aopalliance.intercept.MethodInvocation;

import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkSheet;

/**
 * 
 * 幂等性实现管理类.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2015年11月30日
 * @功能说明：
 *
 */
public interface IIdempotencyService {
    
    /**
     * 
     * 保存或加载事务事件集.
     * 
     * @param joinPoint
     * @return
     * @author chenye
     */
    public SysWorkSheet loadOrCreateSysWorkSheet(MethodInvocation joinPoint);
    
    /**
     * 
     * 独立事务提交事务事件集.
     * @param sysWorkSheet
     * @author chenye
     */
    public void commitSysWorkSheet(SysWorkSheet sysWorkSheet);
    
    /**
     * 
     * 执行事务事件集.
     * 
     * @param sysWorkSheet
     */
    public void processSysWorkSheet(SysWorkSheet sysWorkSheet);
    
    /**
     * 
     * 完成事务事件集并归档.
     * 
     * @param sysWorkSheet
     */
    public void completeSysWorkSheet(SysWorkSheet sysWorkSheet);
    
}
