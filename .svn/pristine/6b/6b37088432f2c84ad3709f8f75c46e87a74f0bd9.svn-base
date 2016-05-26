package com.ffcs.crmd.platform.pub.ex.config;

/**
 * 创建配置加载工厂
 * .
 * @author hehuang
 * 
 *
 */
public class ConfigLoaderFactory {

	private static IConfigLoader defaultConfigLoader;
	
	/**
	 * 获取默认,需要使用单例
	 * .
	 * @return
	 */
	public static IConfigLoader getDefaultConfigLoader() {
		if (defaultConfigLoader == null) {
			defaultConfigLoader = new LocaleConfigLoader();
		}
		
		return defaultConfigLoader;
	}
}
