package com.ffcs.crmd.platform.idempotency.api.service;

import com.ctg.itrdc.platform.pub.entity.BaseEntity;

/**
 * 
 * .
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2015年12月16日
 * @功能说明：
 *
 */
public interface IIdempotencyDataService {
    
    /**
     * 
     * 判断是否正在执行幂等性方法.
     * 
     */
    public boolean isSysWorkRunning();
    
    /**
     * 
     * insert.
     * 
     * @param entity
     * @return
     */
    public int insert(BaseEntity<?> entity);
    
    /**
     * 
     * updateByPrimaryKey.
     * 
     * @param entity
     * @return
     */
    public int updateByPrimaryKey(BaseEntity<?> entity);
    
    /**
     * 
     * deleteByPrimaryKey.
     * 
     * @param entity
     * @return
     */
    public int deleteByPrimaryKey(BaseEntity<?> entity);
    
    /**
     * 
     * updateSelectiveByPrimaryKey.
     * 
     * @param entity
     * @return
     */
    public int updateSelectiveByPrimaryKey(BaseEntity<?> entity);
    
}
