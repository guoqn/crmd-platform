package com.ffcs.crmd.platform.idempotency.core.constants;

/**
 * 
 * 幂等性实现机制常量类.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2015年12月1日
 * @功能说明：
 *
 */
public class IdempotencyConstant {
    
    /**
     * 
     * 幂等性处理过程中状态.
     * 
     */
    public final static class SysWorkStatus {
        /**
         * 执行中
         */
        public final static String RUNNING    = "runnig";
        
        /**
         * 存储中
         */
        public final static String SAVING     = "saving";
        
        /**
         * 处理中
         */
        public final static String PROCESSING = "processing";
    }
    
    /**
     * 
     * 数据操作类型.
     * 
     */
    public final static class OperType {
        
        /**
         * insert
         */
        public final static String INSERT                          = "insert";
        
        /**
         * updateByPrimaryKey
         */
        public final static String UPDATE_BY_PRIMARY_KEY           = "updateByPrimaryKey";
        
        /**
         * deleteByPrimaryKey
         */
        public final static String DELETE_BY_PRIMARY_KEY           = "deleteByPrimaryKey";
        
        /**
         * updateSelectiveByPrimaryKey
         */
        public final static String UPDATE_SELECTIVE_BY_PRIMARY_KEY = "updateSelectiveByPrimaryKey";
    }
    
    /**
     * 分片类型.
     */
    public final static class ShardingType {
        
        /**
         * 全局表
         */
        public final static String GLOBAL   = "GLOBAL";
        
        /**
         * 单库表
         */
        public final static String SINGLE   = "SINGLE";
        
        /**
         * 分片表
         */
        public final static String SHARDING = "SHARDING";
    }
    
    /**
     * 事务事件集状态.
     */
    public final static class SysWorkSheetStatus {
        public final static String CREATE   = "1299";
        public final static String COMPLETE = "1000";
    }
    
    /**
     * 事务事件集状态.
     */
    public final static class SysWorkItemStatus {
        public final static String CREATE   = "1299";
        public final static String COMPLETE = "1000";
    }
    
    /**
     * 事务事件集状态.
     */
    public final static class SysWorkActionStatus {
        public final static String CREATE   = "1299";
        public final static String COMPLETE = "1000";
    }
    
    /**
     * 分片键数据类型.
     */
    public final static class ShardingIdType {
        public final static String Long      = "Long";
        public final static String String    = "String";
        public final static String Timestamp = "Timestamp";
    }
    
    /**
     * 事件项响应表主键序列名
     */
    public final static String SEQ_SYS_WORK_ITEM_ACTION_ID = "SEQ_SYS_WORK_ITEM_ACTION_ID";
    
    /**
     * 分隔符
     */
    public final static String SEPARATOR                   = "_#_";
    
}
