package com.ffcs.crmd.platform.cache.api;

import com.ffcs.crmd.platform.cache.api.exception.CacheException;

import java.util.List;
import java.util.Properties;

/**
 * Support for pluggable caches.
 */
public interface CacheProvider {

	/**
	 * Configure the cache
	 *
	 * @param regionName the name of the cache region
	 * @return return cache instance
	 * @throws CacheException cache exception
	 */
	public Cache buildCache(String regionName) throws
		CacheException;

	public List<Cache> getAllCache();

}
