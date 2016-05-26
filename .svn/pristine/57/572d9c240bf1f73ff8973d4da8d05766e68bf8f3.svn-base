package com.ffcs.crmd.platform.idempotency.core.repository;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.ShardingRule;

public interface IShardingRuleRepository extends ICrmDomBaseRepository<ShardingRule, Long> {
    
    /**
     * 
     * 查询分片规则.
     * @param tableName
     * @return
     */
    public ShardingRule getShardingRule(String tableName);
    
}
