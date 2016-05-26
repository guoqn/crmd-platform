package com.ffcs.crmd.platform.pub.ex.config;

/**
 * @author Administrator
 *
 */
public interface ICacheable<T> {
	
	T getCache(String key);
	
	void setCache(String key, T value);
	
	void clearCache();
}
