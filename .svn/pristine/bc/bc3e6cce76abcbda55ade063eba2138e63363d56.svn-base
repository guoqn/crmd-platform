package com.ffcs.crmd.platform.idempotency.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.ShardingRule;
import com.ffcs.crmd.platform.idempotency.core.repository.IShardingRuleRepository;

@Repository("shardingRuleRepository")
public class ShardingRuleRepositoryImpl extends AbstractCrmDomBaseRepository<ShardingRule, Long>
    implements IShardingRuleRepository {
    
    public ShardingRuleRepositoryImpl() {
        super(ShardingRule.class);
    }
    
    @Override
    public ShardingRule getShardingRule(String tableName) {
        List<Object> params = new ArrayList<Object>();
        params.add(tableName);
        List<ShardingRule> list = this.jdbcFindListByName("shardingRuleRepository.getShardingRule",
            ShardingRule.class, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
