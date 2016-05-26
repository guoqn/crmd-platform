package com.ffcs.crmd.platform.pub.convert;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ffcs.crmd.platform.pub.bean.CrmBeanUtils;
import com.ffcs.crmd.platform.pub.bean.provider.BeanConvertProvider;
import com.ffcs.crmd.platform.pub.entity.Cust;
import com.ffcs.crmd.platform.pub.entity.CustDTO;
import com.ffcs.crmd.platform.pub.entity.CustDTO2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:conf/spring/applicationContext-convert-*.xml" })
public class ConvertTest extends AbstractJUnit4SpringContextTests {
    
    @Test
    public void testConvert() {
        System.out.println(BeanConvertProvider.getConvert(Cust.class, CustDTO.class));
        System.out.println(BeanConvertProvider.getConvert(Cust.class, CustDTO2.class));
        System.out.println(BeanConvertProvider.getConvert(CustDTO.class, Cust.class));
        System.out.println(BeanConvertProvider.getConvert(CustDTO2.class, Cust.class));
        Cust cust = new Cust();
        cust.setCustName("testCust");
        cust.setCustNbr("12345");
        
        CustDTO dto = new CustDTO();
        CrmBeanUtils.applyIf(dto, cust);
        Assert.assertEquals(dto.getCustName(), cust.getCustName() + "dto");
        
        CustDTO2 dto2 = new CustDTO2();
        CrmBeanUtils.applyIf(dto2, cust);
        Assert.assertEquals(dto2.getCustName(), cust.getCustName());
        
        CustDTO sourceDto = new CustDTO();
        sourceDto.setCustName("custDto");
        Cust dCust = new Cust();
        CrmBeanUtils.applyIf(dCust, sourceDto);
        Assert.assertEquals(dCust.getCustName(), sourceDto.getCustName() + "Entity");
        
        CustDTO2 souCustDTO2 = new CustDTO2();
        souCustDTO2.setCustName("custDto2");
        souCustDTO2.setCustNbr("custDto2Nbr");
        Cust dCust2 = new Cust();
        CrmBeanUtils.applyIf(dCust2, souCustDTO2);
        Assert.assertEquals(dCust2.getCustName(), souCustDTO2.getCustName());
        Assert.assertEquals(dCust2.getCustNbr(), souCustDTO2.getCustNbr());
        
        List<Cust> custs = new ArrayList<Cust>();
        Cust cust1 = new Cust();
        cust1.setCustName("testCust1");
        cust1.setCustNbr("12345");
        Cust cust2 = new Cust();
        cust2.setCustName("testCust2");
        cust2.setCustNbr("12345");
        custs.add(cust1);
        custs.add(cust2);
        
        List<CustDTO> list = CrmBeanUtils.copyList(custs, CustDTO.class);
        Assert.assertEquals(list.get(0).getCustName(), cust1.getCustName() + "dto");
        Assert.assertEquals(list.get(1).getCustName(), cust2.getCustName() + "dto");
    }
}
