package com.ffcs.crmd.platform.cache.core.thread;

import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheConfig;
import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.AbstractCacheProvider;
import com.ffcs.crmd.platform.cache.core.local.LocalCache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class ThreadCacheProvider extends AbstractCacheProvider {

    public ThreadCacheProvider(CacheConfigLoader loader) {
        super(loader);
    }

    @Override
    public Cache buildCache(String regionName) throws CacheException {
        if (!cacheMap.containsKey(regionName)) {
            CacheConfig config = loader.getCacheConfig(regionName);
            if (config == null) {
                logger.warn("not cache config,could not cache");
                return null;
            }
            Cache localCache = new ThreadCache(regionName);
            cacheMap.putIfAbsent(regionName, localCache);
        }
        return cacheMap.get(regionName);
    }
}
