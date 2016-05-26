package com.ffcs.crmd.platform.idempotency.core.utils;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.data.entity.ClassInfoUtils;
import com.ffcs.crmd.platform.idempotency.core.entity.ShardingRule;

public class ShardingRuleUtil {
    
    private static final ILogger                       LOGGER              = LoggerFactory
                                                                               .getLogger(ClassInfoUtils.class);
    
    /**
     * 用于判断是否已初始化
     */
    private static ConcurrentMap<String, Boolean>      initShardingRuleMap = new ConcurrentHashMap<String, Boolean>();
    
    /**
     * 根据Class获取分片规则的Map
     */
    private static ConcurrentMap<String, ShardingRule> shardingRuleMap     = new ConcurrentHashMap<String, ShardingRule>();
    
    /**
     * 加载类列表
     */
    private static ConcurrentLinkedQueue<Class<?>>     clazzQueue          = new ConcurrentLinkedQueue<Class<?>>();
    
    /**
     * 
     * 扫描类到队列中，供后续初始化使用.
     * 
     * @param entity
     */
    public static <ID extends Serializable> void scanClazz(Class<?> clazz) {
        clazzQueue.add(clazz);
    }
    
    /**
     * 
     * 分片规则初始化.
     * 初定使用类名加载分片规则
     */
    public static void init() {
        for (Class<?> clazz : clazzQueue) {
            ShardingRuleUtil.loadShardingRule(StringUtils.parsePropertyName2ColumnName(
                clazz.getSimpleName()).toUpperCase());
        }
    }
    
    /**
     * 由容器启动时执行EntityScanner的doScan来调用该方法
     * @param tableName
     */
    public static void loadShardingRule(String tableName) {
        LOGGER.debug("loadShardingRule:" + tableName);
        if (!initShardingRuleMap.containsKey(tableName)) {
            //查询分片规则
            ShardingRule shardingRule = ShardingRule.repository().getShardingRule(tableName);
            if (shardingRule != null) {
                shardingRuleMap.putIfAbsent(tableName, shardingRule);
            }
            //标记为已初始
            initShardingRuleMap.putIfAbsent(tableName, Boolean.TRUE);
        }
    }
    
    /**
     * 
     * 获取分片规则.
     * 
     * @param tableName
     * @return
     */
    public static ShardingRule getShardingRule(String tableName) {
        //已初始化
        if (initShardingRuleMap.containsKey(tableName)) {
            return shardingRuleMap.get(tableName);
        } else {
            //初始化
            ShardingRuleUtil.loadShardingRule(tableName);
            return shardingRuleMap.get(tableName);
        }
    }
    
}
