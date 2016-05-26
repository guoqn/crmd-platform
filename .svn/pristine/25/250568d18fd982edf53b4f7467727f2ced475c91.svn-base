/**
 * 
 */
package com.ffcs.crmd.platform.pub.ex.config;

import java.util.HashMap;

/**
 * @author Administrator
 *
 */
public class MapCache<T> extends HashMap<String, T> implements ICacheable<T> {

	private static final long serialVersionUID = 1L;

	@Override
	public T getCache(String key) {
		return get(key);
	}

	@Override
	public void setCache(String key, T value) {
		put(key, value);
	}

	@Override
	public void clearCache() {
		clear();
	}

}
