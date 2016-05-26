package com.ffcs.crmd.platform.meta.client.meta;

import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ctg.itrdc.platform.data.entity.ClassInfoUtils;
import com.ffcs.crmd.platform.cache.api.utils.CacheUtils;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.provider.BusiObjProvider;
import com.ffcs.crmd.platform.meta.provider.BusiTypeProvider;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.meta.provider.MetaProvider;
import com.ffcs.crmd.platform.meta.client.meta.service.ICustService;
import com.ffcs.crmd.platform.meta.repository.impl.AttrSpec2RepositoryImpl;
import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.cache.context.entt.EnttCacheContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by linzq on 2016/1/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath*:conf/spring/applicationContext.xml",
    "classpath*:conf/spring/applicationContext*.xml",
    "classpath*:conf/spring/**/applicationContext*.xml",
    "classpath*:conf/spring/applicationContext-cache-test.xml"})
public class TestMeta extends AbstractJUnit4SpringContextTests {

    @Test
    public void testInit() {
        IBusiType type = BusiTypeProvider.getBusiTypeByEntityName("Cust");
        System.out.println(type);
        List<IBusiObj> busiObjs = BusiObjProvider.getAllBusiObjByBusiTypeId(type.getId());
        System.out.println(busiObjs);
        Map<String,ITableMetaData> tableMetaMap = MetaProvider.getEntityMetaDataByBusiObj(busiObjs.get(0));
        System.out.println(tableMetaMap.size());
//        for (Map.Entry<String,ITableMetaData> entry : tableMetaMap.entrySet()) {
//            System.out.println("\n\n\n");
//            System.out.println(entry.getKey());
//            for (IBusiObjAttr attr :entry.getValue().getTableBaseAttr()) {
//                System.out.printf(attr.readAttrNbr() + "#" + attr.getId() + "#" + attr.getAttrId() + "\n");
//            }
//            System.out.println();
//            for (IBusiObjAttr attr :entry.getValue().getTableDanyAttr()) {
//                System.out.printf(attr.readAttrNbr() + "#" + attr.getId() + "#" + attr.getAttrId() + "\n");
//            }
//            System.out.println();
//
////            System.out.println(entry.getValue());
//            System.out.println(entry.getValue().getAttrNbrToColumnNameMap());
//            System.out.println(entry.getValue().getColumnNameToAttrNbrMap());
//            System.out.println(entry.getValue().getInsertAutoPkOp().getSql());
//            System.out.println(entry.getValue().getInsertAutoPkOp().getAttrs());
//
//            System.out.println(entry.getValue().getInsertWithPkOp().getSql());
//            System.out.println(entry.getValue().getInsertWithPkOp().getAttrs());
//
//            System.out.println(entry.getValue().getDeleteOpByPkAndAllSk().getSql());
//            System.out.println(entry.getValue().getDeleteOpByPkAndAllSk().getAttrs());
//
//            System.out.println(entry.getValue().getDeleteOpByPkAndTableSk().getSql());
//            System.out.println(entry.getValue().getDeleteOpByPkAndTableSk().getAttrs());
//
//            System.out.println(entry.getValue().getUpdateOpByPkAndAllSk().getSql());
//            System.out.println(entry.getValue().getUpdateOpByPkAndAllSk().getAttrs());
//
//            System.out.println(entry.getValue().getUpdateOpByPkAndTableSk().getSql());
//            System.out.println(entry.getValue().getUpdateOpByPkAndTableSk().getAttrs());
//
//            System.out.println(entry.getValue().getInsertHisTableOp().getSql());
//            System.out.println(entry.getValue().getInsertHisTableOp().getAttrs());
//
//            System.out.println(entry.getValue().getSelectByPrimaryKey().getSql());
//            System.out.println(entry.getValue().getSelectByPrimaryKey().getAttrs());
//
//            System.out.println(entry.getValue().getSelectByPrimaryKeyAndAllSK().getSql());
//            System.out.println(entry.getValue().getSelectByPrimaryKeyAndAllSK().getAttrs());
//
//            System.out.println(entry.getValue().getSelectByPrimaryKeyAndTableSK().getSql());
//            System.out.println(entry.getValue().getSelectByPrimaryKeyAndTableSK().getAttrs());
//
//            System.out.println(entry.getValue().getSelectByMasterKey().getSql());
//            System.out.println(entry.getValue().getSelectByMasterKey().getAttrs());
//
//            System.out.println(entry.getValue().getSelectByMasterKeyAndAllSK().getSql());
//            System.out.println(entry.getValue().getSelectByMasterKeyAndAllSK().getAttrs());
//
//            System.out.println(entry.getValue().getSelectByMasterKeyAndTableSK().getSql());
//            System.out.println(entry.getValue().getSelectByMasterKeyAndTableSK().getAttrs());
//
//        }
    }

    @Test
    public void testCust() {
        Cust cust = new Cust();
        cust.setId(1L);
        cust.setCustName("testCust");
        cust.writeAttr("statusCd","1000");
        cust.writeAttr("vipLevel","1");
        ICustService service = (ICustService) applicationContext.getBean("custService");
        service.saveCust(cust);
    }

    @Test
    public void testCustSelect() {
        ICrmBaseDao dao = (ICrmBaseDao) applicationContext.getBean("crmBaseDao");
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        List<Cust> custs = dao.jdbcFindList("select * from cust a where a.cust_id=?",Cust.class,list);
        Cust cust = custs.get(0);
        System.out.println(cust.getCustName());
        System.out.println(cust.readAttr("vipLevel"));
        cust.writeAttr("vipLevel",34);
        cust.setCustName("testCust223");
        cust.writeAttr("statusCd",1000);
        ICustService service = (ICustService) applicationContext.getBean("custService");
        service.updateCust(cust);
        List<Cust> custs2 = dao.jdbcFindList("select * from cust a where a.cust_id=?",Cust.class,list);
        Cust cust2 = custs2.get(0);
        System.out.println(cust2.getCustName());
        System.out.println(cust.readAttr("vipLevel"));

        System.out.println(cust.readAttrName("statusCd"));

    }

    @Test
    public void testCustRemove() {
        ICrmBaseDao dao = (ICrmBaseDao) applicationContext.getBean("crmBaseDao");
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        List<Cust> custs = dao.jdbcFindList("select * from cust a where a.cust_id=?",Cust.class,list);
        Cust cust = custs.get(0);
        ICustService service = (ICustService) applicationContext.getBean("custService");
        service.removeCust(cust);
    }

    @Test
    public void testSerial() {
        ICrmBaseDao dao = (ICrmBaseDao) applicationContext.getBean("crmBaseDao");
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        List<Cust> custs = dao.jdbcFindList("select * from cust a where a.cust_id=?",Cust.class,list);
        Cust cust = custs.get(0);
        String json = JSONUtils.ToJsonString(cust);
        System.out.println(json);
        Cust newCust = JSONUtils.jsonToObject(json,Cust.class);
        System.out.println(newCust.getCustName());
        System.out.println(newCust.readAttr("vipLevel"));
        System.out.println();
        System.out.println(cust.getCustName());
        System.out.println(cust.readAttr("vipLevel"));
        json = JSONUtils.ToJsonString(cust);
        System.out.println(json);
        newCust = JSONUtils.jsonToObject(json,Cust.class);
        System.out.println(newCust.getCustName());
        System.out.println(newCust.readAttr("vipLevel"));

    }

    @Test
    public void testScan() {
        try {
            ClassInfoUtils.initEntityInfo(ScanCust.class);
            System.out.println(ClassInfoUtils.getColumnMap().get(ScanCust.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testCache() throws InterruptedException {
        EnttCacheContext.getInstance().clearAllCache();
        for (int i =0;i<2;i++) {
//            testInit();
            System.out.println("第" + i + "次");
            System.out.println("query 1");
            BusiObj.repository().queryBusiObjByTypeId(1L);
            System.out.println("query 2");
            BusiObj.repository().queryBusiObjByBusiObjNbrAndStatusCd("Cust");
        }
        System.out.println("获取1");
        System.out.println(EnttCacheContext.getInstance().getEnttFromCache(CacheUtils
            .generateKey(BusiObj.class.getName(), 1L),BusiObj.class));
        System.out.println("====================================================");
        System.out.println("++++++++++++++++++++++++++++++++++++sleep~~~~~~~~~~~");

        Thread.sleep(10000L);
        System.out.println("====================================================");
        System.out.println("获取1");
        System.out.println(EnttCacheContext.getInstance().getEnttFromCache(CacheUtils
            .generateKey(BusiObj.class.getName(), 1L),BusiObj.class));
        for (int i =0;i<2;i++) {
//            testInit();
            BusiObj.repository().queryBusiObjByTypeId(1L);
            BusiObj.repository().queryBusiObjByBusiObjNbrAndStatusCd("Cust");
        }
        System.out.println("====================================================");
        System.out.println("++++++++++++++++++++++++++++++++++++clear~~~~~~~~~~~");
        EnttCacheContext.getInstance().clearAllCache();
        System.out.println("====================================================");

        for (int i =0;i<2;i++) {
//            testInit();
            BusiObj.repository().queryBusiObjByTypeId(1L);
            BusiObj.repository().queryBusiObjByBusiObjNbrAndStatusCd("Cust");
        }
        System.out.println("获取1");
        System.out.println(EnttCacheContext.getInstance().getEnttFromCache(CacheUtils
            .generateKey(BusiObj.class.getName(), 1L),BusiObj.class));
        System.out.println("删除");
        EnttCacheContext.getInstance().removeEnttFromCache(BusiObj.class.getName(),CacheUtils
            .generateKey(BusiObj.class.getName(), 1L),null);
        System.out.println("获取2");
        System.out.println(EnttCacheContext.getInstance().getEnttFromCache(CacheUtils
            .generateKey(BusiObj.class.getName(), 1L),BusiObj.class));

    }

    @Test
    public void testCopyLazy() {
        ICrmBaseDao dao = (ICrmBaseDao) applicationContext.getBean("crmBaseDao");
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        List<Cust> custs = dao.jdbcFindList("select * from cust a where a.cust_id=?",Cust.class,list);
        Cust cust = custs.get(0);
        System.out.println();
        System.out.println(cust);
        CustDTO dto = new CustDTO();
        CrmBeanUtils.applyIf(dto,cust);
        System.out.println();
        System.out.println(dto.toString());
    }
}
