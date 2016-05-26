package com.ffcs.crmd.platform.cache.core.local;

import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheConfig;
import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;
import com.ffcs.crmd.platform.cache.api.CacheProvider;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.AbstractCacheProvider;
import com.google.common.cache.CacheBuilder;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class LocalCacheProvider extends AbstractCacheProvider {

    public LocalCacheProvider(CacheConfigLoader loader) {
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
            com.google.common.cache.Cache<Object, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(config.getLocalMaxSize())
                .expireAfterAccess(config.getLocalExpireAfterAccess(), TimeUnit.SECONDS)
                .recordStats().build();
            Cache localCache = new LocalCache(regionName,cache,config.getLocalMaxSize(),config.getLocalExpireAfterAccess());
            cacheMap.putIfAbsent(regionName, localCache);
        }
        return cacheMap.get(regionName);
    }

}
