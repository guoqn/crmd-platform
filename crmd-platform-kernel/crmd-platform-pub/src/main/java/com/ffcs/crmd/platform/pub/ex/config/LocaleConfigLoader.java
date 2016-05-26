/**
 * 
 */
package com.ffcs.crmd.platform.pub.ex.config;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * 通过本地化配置获取配置
 * .
 * @author hehuang
 *
 */
public class LocaleConfigLoader implements IConfigLoader {
	
	private static final Logger logger = Logger.getLogger(LocaleConfigLoader.class); 
	
	private static final String DEAULT_TOPIC = "exhint";
	
	private Locale defaultLocale = Locale.CHINA;
	
	private ICacheable<String> cache = new MapCache<String>();
	
	public void setDefaultLocale(Locale locale) {
		this.defaultLocale = locale;
	}
	
	public Locale getDefaultLocale() {
		return this.defaultLocale;
	}

	@Override
	public String loadConfig(String key) {
		return this.loadConfig(DEAULT_TOPIC, key, this.getDefaultLocale());
	}
	
	public String loadConfig(String topic, String key, Locale locale) {
		// TODO 缓存管理功能
		String config = "";
		
		try {
			logger.debug("开始加载配置信息:" + key);
			
			ResourceBundle bundle = ResourceBundle.getBundle(topic, locale);
			if (bundle != null) {
				config = bundle.getString(key);
				logger.debug("加载配置信息成功:" + key);
			}
		} catch (Exception e) {
			logger.warn("本地化配置信息加载失败！", e);
		}
		
		return config;
	}

	@Override
	public String loadConfig(String topic, String key) {
		return this.loadConfig(topic, key, getDefaultLocale());
	}

	@Override
	public String getCache(String key) {
		return cache.getCache(key);
	}

	@Override
	public void setCache(String key, String value) {
		cache.setCache(key, value);
	}
	
	@Override
	public void clearCache() {
		cache.clearCache();
	}

}
