package com.ffcs.crmd.platform.cache.api;

import com.ffcs.crmd.platform.cache.api.exception.CacheException;

import java.io.Serializable;
import java.util.List;

/**
 * Implementors define a caching algorithm. All implementors
 * <b>must</b> be threadsafe.
 */
public interface Cache {

	/**
	 * 保存 Element 对象到缓存，使用缺省的缓存超时时间
	 *
	 * @param key     键
	 * @param element 要缓存的元素
	 */
	public void putElement(String key, Element element);


	/**
	 * 放置对象到缓存中
	 *
	 * @param key   对象key
	 * @param value 对象值
	 */
	public void put(String key, Serializable value);

	/**
	 * 更新缓存的超时时间，超时时间由属性 timeToIdle 决定。
	 *
	 * @param key 要更新超时时间的缓存 key
	 */
	public void touch(String key);

	/**
	 * 从缓存中获取对象
	 *
	 * @param key 对象key
	 *
	 * @return 对象值
	 */
	public <T extends Serializable> T get(String key);

	/**
	 * 从缓存中获取对象
	 *
	 * @param key  对象key
	 * @param type 对象类型
	 * @param <T>  对象类型
	 *
	 * @return 对象值
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T get(String key, Class<T> type);

	/**
	 * 从缓存中获取 Element 元素
	 *
	 * @param key 对象key
	 *
	 * @return 对象值
	 *
	 */
	public <E extends Serializable> Element<E> getElement(String key);


	@SuppressWarnings("rawtypes")
	public List<String> keys() throws CacheException ;
	
	/**
	 * @param key Cache key
	 * Remove an item from the cache
	 */
	public void evict(String key) throws CacheException;
	
	/**
	 * Batch remove cache objects
	 * @param keys the cache keys to be evicted
	 */
	@SuppressWarnings("rawtypes")
	public void evict(List<String> keys) throws CacheException;
	
	/**
	 * Clear the cache
	 */
	public void clear() throws CacheException;
	
	/**
	 * Clean up
	 */
	public void destroy() throws CacheException;

	public CacheStatus status();
}
