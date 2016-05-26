/**
 * 
 */
package com.ffcs.crmd.platform.pub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.ctg.itrdc.platform.pub.bean.HeadInfo;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExType;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.ex.text.ExceptionFormat;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

import junit.framework.TestCase;

/**
 * 异常测试
 * .
 * @author hehuang
 *
 */
public class ExceptionTest extends TestCase {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	/**
	 * 测试是否可以正常的抛出异常
	 * .
	 */
	@Test
	public void testThrowEx() {
		
		
		
		Exception e = new Exception("hello");
		
		
		
		// ExceptionUtils.throwEx("100001");
		// ExceptionUtils.throwEx(10000L);
		ExceptionUtils.throwEx(e, "10000" , "hehuang");
	}
	
	@Test
	public void testThrowEx1() {
		Exception e = new Exception("hello");
		ExceptionUtils.throwExHint("提示", e, "10000");
	}
	
	public void testThrowEx2() {
		ExceptionUtils.throwEx("10000");
	} 
	
	@Test
	public void testThrowEx3() {
		ExceptionUtils.throwEx(new NullPointerException(), "10000", "hehuang");
	}
	
	@Test
	public void testTransEx() {
		ExceptionUtils.throwEx(new NullPointerException());
	}
	
	@Test
	public void testTransEx1() {
		Assert.assertTrue(ExceptionUtils.transEx(new NullPointerException()) instanceof BaseAppException);
	}
	
	@Test
	public void testTransEx2() {
		Exception e = new BaseAppException();
		Assert.assertTrue(ExceptionUtils.transEx(e) instanceof BaseAppException);
		Assert.assertEquals(e, ExceptionUtils.transEx(e));
	}
	
	@Test
	public void testTransEx3() {
		throw ExceptionUtils.transEx(new NullPointerException(), "10000");
	}
	
	@Test
	public void testWarn1() {
		SessionContext.initialBaseInfo();
		ExceptionUtils.warn("10000", "hehuang");
		
		Assert.assertTrue(CrmSessionContext.getWarnings() != null && CrmSessionContext.getWarnings().size() == 1);
	}
	
	@Test
	public void testWarn2() {
		SessionContext.initialBaseInfo();
		
		ExceptionUtils.warn(new NullPointerException(), "10000", "hehuang");
		ExceptionUtils.warn(new NullPointerException(), "10000", "hehuang");
		
		Assert.assertTrue(CrmSessionContext.getWarnings() != null && CrmSessionContext.getWarnings().size() == 2);
	}
	
	@Test
	public void testWarnMsg1() {
		SessionContext.initialBaseInfo();
		
		ExceptionUtils.warnMsg("hehuang", "11111");
		
		Assert.assertTrue(CrmSessionContext.getWarnings() != null && CrmSessionContext.getWarnings().size() == 1);
	}
	
	@Test
	public void testFillEx() {
		ReqResult result = new ReqResult();
		result.setHeadInfo(new HeadInfo());
		try {
			Exception e = new Exception("hello");
			
			ExceptionUtils.throwEx(e, "10000" , "hehuang");
		} catch (Exception e) {
			BaseAppException ex = ExceptionUtils.transEx(e);
			ExceptionUtils.fillEx(result, ex);
			Assert.assertEquals("10000$:$客户hehuang的账户信息有误！$:$ERROR", result.getHeadInfo().getPropsMap().get("PROP_EX_KEY"));
		}
		
		
	}
	
	@Test
	public void testFillWarnings() {
		List<BaseAppException> exs = new ArrayList<BaseAppException>();
		BaseAppException ex = new BaseAppException("客户hehuang的账户信息有误！", "10000");
		ex.setExType(ExType.WARNING);
		
		exs.add(ex);
		exs.add(ex);
		ReqResult result = new ReqResult();
		result.setHeadInfo(new HeadInfo());
		ExceptionUtils.fillWarnings(result, exs);
		
		Assert.assertEquals("10000$:$客户hehuang的账户信息有误！$:$WARNING$#$10000$:$客户hehuang的账户信息有误！$:$WARNING", result.getHeadInfo().getPropsMap().get("PROP_WARN_KEY"));
	}
 	
	public void testReadEx() {
		ReqResult result = new ReqResult();
		result.setHeadInfo(new HeadInfo());
		result.getHeadInfo().addProp("PROP_EX_KEY", "10000$:$客户hehuang的账户信息有误！$:$ERROR");
		ExceptionUtils.readEx(result);
	}
	
	public void testReadWarnings() {
		SessionContext.initialBaseInfo();
		ReqResult result = new ReqResult();
		result.setHeadInfo(new HeadInfo());
		result.getHeadInfo().addProp("PROP_WARN_KEY", "10000$:$客户hehuang的账户信息有误！$:$WARNING$#$10000$:$客户hehuang的账户信息有误！$:$WARNING");
		ExceptionUtils.readWarnings(result);
		Assert.assertTrue(CrmSessionContext.getWarnings() != null && CrmSessionContext.getWarnings().size() == 2);
	}
	
	@Test
	public void testFormat() {
		try {
			Exception e = new Exception("hello");
			
			ExceptionUtils.throwEx(e, "10000" , "hehuang");
		} catch (Exception e) {
			BaseAppException ex = ExceptionUtils.transEx(e);
			
			Assert.assertEquals("10000$:$客户hehuang的账户信息有误！$:$ERROR", ExceptionFormat.format(ex));
		}
	}
	
	@Test
	public void testParse() {
		List<BaseAppException> exs = ExceptionFormat.parse("10000$:$客户hehuang的账户信息有误！$:$WARNING$#$10000$:$客户hehuang的账户信息有误！$:$WARNING");
		System.out.println("hello");
	}
	
}
