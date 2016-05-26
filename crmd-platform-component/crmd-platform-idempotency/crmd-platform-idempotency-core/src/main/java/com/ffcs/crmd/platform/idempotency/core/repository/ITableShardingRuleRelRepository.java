package com.ffcs.crmd.platform.idempotency.core.repository;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.TableShardingRuleRel;

public interface ITableShardingRuleRelRepository
    extends ICrmDomBaseRepository<TableShardingRuleRel, Long> {
    
}
