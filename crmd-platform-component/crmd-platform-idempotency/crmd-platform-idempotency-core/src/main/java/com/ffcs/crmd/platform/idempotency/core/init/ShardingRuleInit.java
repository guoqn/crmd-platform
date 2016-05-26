package com.ffcs.crmd.platform.idempotency.core.init;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.idempotency.core.utils.ShardingRuleUtil;

@Service
public class ShardingRuleInit {
    
    @PostConstruct
    public void init() {
        ShardingRuleUtil.init();
    }
    
}
