package com.ffcs.crmd.platform.idempotency.core.aspect;

import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.idempotency.core.annotation.Distributed;
import com.ffcs.crmd.platform.idempotency.core.entity.Cust;
import com.ffcs.crmd.platform.idempotency.core.entity.ProdInst;

@Service("testPointcut2")
public class TestPointcut2Impl implements ITestPointcut2 {
    
    @Override
    @Distributed(index = 2)
    public String test1(String arg1, Long arg2) {
        Cust cust = new Cust(true);
        cust.setCustNumber(cust.getCustId() + "");
        cust.setShardingId(cust.getCustId());
        cust.save();
        Cust cust1 = new Cust(true);
        cust1.setCustNumber(cust1.getCustId() + "");
        cust1.setShardingId(cust1.getCustId());
        cust1.save();
        ProdInst prodInst = new ProdInst(true);
        prodInst.setAccNbr("131231");
        prodInst.setShardingId(cust.getCustId());
        prodInst.setVersion(0L);
        prodInst.save();
        ProdInst prodInst1 = new ProdInst(true);
        prodInst1.setAccNbr("131232");
        prodInst1.setShardingId(cust.getCustId());
        prodInst1.setVersion(0L);
        prodInst1.save();
        return "124";
    }
}
