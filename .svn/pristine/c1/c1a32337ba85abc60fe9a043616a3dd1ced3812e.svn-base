package com.ffcs.crmd.platform.idempotency.core.aspect;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.idempotency.core.annotation.Distributed;
import com.ffcs.crmd.platform.idempotency.core.entity.Cust;
import com.ffcs.crmd.platform.idempotency.core.entity.ProdInst;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

@Service("testPointcut")
public class TestPointcutImpl implements ITestPointcut {
    
    @Resource
    private ITestPointcut2 testPointcut2;
    
    @Resource
    private ICrmBaseDao    crmBaseDao;
    
    @Override
    @Distributed(index = 3)
    public String test1(String arg1, Long arg2, int arg3) {
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
        System.out.println("运行中...");
        return "124";
    }
    
    @Override
    public String test2() {
        CrmSessionContext.getContext().setSysWorkSheetCd("s:" + DateUtils.getNowDate().getTime());
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
        return "123";
    }
    
    @Override
    @Distributed(index = 2)
    public void test3(String arg1, Long arg2) {
        Cust cust = new Cust(true);
        cust.setCustNumber(cust.getCustId() + "");
        cust.setShardingId(cust.getCustId());
        Cust.repository().insert(cust);
        Cust cust1 = new Cust(true);
        cust1.setCustNumber(cust1.getCustId() + "");
        cust1.setShardingId(cust1.getCustId());
        crmBaseDao.insert(cust1);
    }
    
    @Override
    @Distributed(index = 2)
    public void test4(String arg1, Long arg2) {
        Cust cust = new Cust();
        cust.setCustId(2009L);
        cust.setCustNumber(cust.getCustId() + "23423423");
        cust.setShardingId(cust.getCustId());
        Cust.repository().updateByPrimaryKey(cust);
        Cust cust1 = new Cust();
        cust1.setCustId(2010L);
        cust1.setCustNumber(cust1.getCustId() + "34534534");
        cust1.setShardingId(cust1.getCustId());
        crmBaseDao.updateByPrimaryKey(cust1);
    }
    
    @Override
    @Distributed(index = 2)
    public void test5(String arg1, Long arg2) {
        Cust cust = new Cust();
        cust.setCustId(2009L);
        cust.setCustNumber(cust.getCustId() + "111111");
        cust.setShardingId(cust.getCustId());
        Cust.repository().updateSelectiveByPrimaryKey(cust);
        Cust cust1 = new Cust();
        cust1.setCustId(2010L);
        cust1.setCustNumber(cust1.getCustId() + "111111");
        cust1.setShardingId(cust1.getCustId());
        crmBaseDao.updateSelectiveByPrimaryKey(cust1);
    }
    
    @Override
    @Distributed(index = 2)
    public void test6(String arg1, Long arg2) {
        Cust cust = new Cust();
        cust.setCustId(2009L);
        cust.setCustNumber(cust.getCustId() + "111111");
        cust.setShardingId(cust.getCustId());
        Cust.repository().deleteByPrimaryKey(cust);
        Cust cust1 = new Cust();
        cust1.setCustId(2010L);
        cust1.setCustNumber(cust1.getCustId() + "111111");
        cust1.setShardingId(cust1.getCustId());
        crmBaseDao.deleteByPrimaryKey(cust1);
    }
    
    @Override
    @Distributed(index = 2)
    public void test7(String arg1, Long arg2) {
        Cust cust = new Cust();
        cust.setId(2013L);
        cust.setCustNumber(cust.getCustId() + "1111111");
        cust.setShardingId(cust.getCustId());
        cust.update();
        Cust cust1 = new Cust();
        cust1.setId(2014L);
        cust1.setCustNumber(cust1.getCustId() + "111111111");
        cust1.setShardingId(cust1.getCustId());
        cust1.update();
        ProdInst prodInst = new ProdInst();
        prodInst.setId(2011L);
        prodInst.setAccNbr("13123123423423423");
        prodInst.setShardingId(cust.getCustId());
        prodInst.setVersion(0L);
        prodInst.update();
        ProdInst prodInst1 = new ProdInst();
        prodInst1.setId(2012L);
        prodInst1.setAccNbr("13123234234234234");
        prodInst1.setShardingId(cust.getCustId());
        prodInst1.setVersion(0L);
        prodInst1.update();
    }
    
    @Override
    @Distributed(index = 2)
    public void test8(String arg1, Long arg2) {
        Cust cust = new Cust();
        cust.setId(2013L);
        cust.setCustNumber(cust.getCustId() + "1111111");
        cust.setShardingId(cust.getCustId());
        cust.remove();
        Cust cust1 = new Cust();
        cust1.setId(2014L);
        cust1.setCustNumber(cust1.getCustId() + "111111111");
        cust1.setShardingId(cust1.getCustId());
        cust1.remove();
        ProdInst prodInst = new ProdInst();
        prodInst.setId(2011L);
        prodInst.setAccNbr("13123123423423423");
        prodInst.setShardingId(cust.getCustId());
        prodInst.setVersion(0L);
        prodInst.remove();
        ProdInst prodInst1 = new ProdInst();
        prodInst1.setId(2012L);
        prodInst1.setAccNbr("13123234234234234");
        prodInst1.setShardingId(cust.getCustId());
        prodInst1.setVersion(0L);
        prodInst1.remove();
    }
    
    @Override
    @Distributed(index = 2)
    public void test9(String arg1, Long arg2) {
        Cust cust = new Cust();
        cust.setId(2013L);
        cust.setCustNumber(cust.getCustId() + "1111111");
        cust.setShardingId(cust.getCustId());
        cust.save();
        Cust cust1 = new Cust();
        cust1.setId(2014L);
        cust1.setCustNumber(cust1.getCustId() + "111111111");
        cust1.setShardingId(cust1.getCustId());
        cust1.save();
        ProdInst prodInst = new ProdInst();
        prodInst.setId(2011L);
        prodInst.setAccNbr("13123123423423423");
        prodInst.setShardingId(cust.getCustId());
        //首次执行注释，补偿时取消注释
        prodInst.setVersion(0L);
        prodInst.save();
        ProdInst prodInst1 = new ProdInst();
        prodInst1.setId(2012L);
        prodInst1.setAccNbr("13123234234234234");
        prodInst1.setShardingId(cust.getCustId());
        prodInst1.setVersion(0L);
        prodInst1.save();
    }
    
    @Override
    @Distributed(index = 2)
    public void test10(String arg1, Long arg2) {
        Cust cust = new Cust(true);
        cust.setCustNumber(cust.getCustId() + "1111111");
        cust.setShardingId(cust.getCustId());
        cust.save();
        testPointcut2.test1(arg1, 2L);
        Cust cust1 = new Cust(true);
        cust1.setCustNumber(cust1.getCustId() + "111111111");
        cust1.setShardingId(cust1.getCustId());
        cust1.save();
    }
    
    @Override
    public void saveXXXX(String arg1, Long arg2) {
        Cust cust = new Cust(true);
        cust.setCustNumber(cust.getCustId() + "1111111");
        cust.setShardingId(cust.getCustId());
        cust.save();
        Cust cust1 = new Cust(true);
        cust1.setCustNumber(cust1.getCustId() + "111111111");
        cust1.setShardingId(cust1.getCustId());
        cust1.save();
    }
}
