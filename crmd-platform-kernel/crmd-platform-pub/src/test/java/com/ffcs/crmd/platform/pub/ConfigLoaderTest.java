/**
 * 
 */
package com.ffcs.crmd.platform.pub;

import java.text.MessageFormat;

import org.junit.Assert;
import org.junit.Test;

import com.ffcs.crmd.platform.pub.ex.config.ConfigLoaderFactory;
import com.ffcs.crmd.platform.pub.ex.config.IConfigLoader;

import junit.framework.TestCase;

/**
 * 测试配置文件的加载
 * .
 * @author hehuang
 *
 */
public class ConfigLoaderTest extends TestCase {

	@Test
	public void testLoadConfig() {
		IConfigLoader loader = ConfigLoaderFactory.getDefaultConfigLoader();
		String hintTemplate = loader.loadConfig("10000");
		Assert.assertEquals("客户{0}的账户信息有误！", hintTemplate);
		
	}
	
	@Test
	public void testTemplateFormat() {
		IConfigLoader loader = ConfigLoaderFactory.getDefaultConfigLoader();
		String hintTemplate = loader.loadConfig("10000");
		Assert.assertEquals("客户{0}的账户信息有误！", hintTemplate);
		String hint = MessageFormat.format(hintTemplate, "hehuang");
		
		Assert.assertEquals("客户hehuang的账户信息有误！", hint);
	}
}
