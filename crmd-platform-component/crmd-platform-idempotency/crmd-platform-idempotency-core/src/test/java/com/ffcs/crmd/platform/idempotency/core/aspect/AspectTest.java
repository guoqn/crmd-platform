package com.ffcs.crmd.platform.idempotency.core.aspect;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:conf/applicationContext*.xml",
        "classpath*:conf/spring/applicationContext*.xml" })
public class AspectTest extends AbstractJUnit4SpringContextTests {
    
    private ITestPointcut pointcut;
    
    @Before
    public void init() {
        pointcut = ApplicationContextUtil.getBean("testPointcut");
    }
    
    /**
     * 
     * 测试DDD模式Save.
     * 
     */
    @Test
    public void test1() {
        String str = pointcut.test1("String", 2L, 3);
        System.out.println(str);
    }
    
    /**
     * 
     * 测试手工设置SheetCd.
     * 
     */
    @Test
    public void test2() {
        String str = pointcut.test2();
        System.out.println(str);
    }
    
    /**
     * 
     * 测试DAo模式insert.
     * 
     */
    @Test
    public void test3() {
        pointcut.test3("sss", 3L);
    }
    
    /**
     * 
     * 测试DAo模式updateByPrimaryKey.
     * 
     */
    @Test
    public void test4() {
        pointcut.test4("sss", 4L);
    }
    
    /**
     * 
     * 测试DAo模式updateSelectiveByPrimaryKey.
     * 
     */
    @Test
    public void test5() {
        pointcut.test5("sss", 5L);
    }
    
    /**
     * 
     * 测试DAo模式deleteByPrimaryKey.
     * 
     */
    @Test
    public void test6() {
        pointcut.test6("sss", 6L);
    }
    
    /**
     * 
     * 测试DDD模式update.
     * 
     */
    @Test
    public void test7() {
        pointcut.test7("sss", 77L);
    }
    
    /**
     * 
     * 测试DDD模式remove.
     * 
     */
    @Test
    public void test8() {
        pointcut.test8("sss", 8L);
    }
    
    /**
     * 
     * 测试补偿.
     * 
     */
    @Test
    public void test9() {
        pointcut.test9("sss", 9L);
    }
    
    /**
     * 
     * 测试事务嵌套.
     * 
     */
    @Test
    public void test10() {
        pointcut.test10("sss", 10L);
    }
    
    /**
     * 
     * 测试使用幂等性组件.
     * 
     */
    @Test
    public void test11() {
        pointcut.saveXXXX("sss", 10L);
    }
}
