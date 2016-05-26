package com.ffcs.crmd.platform.pub.cache.context;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheProvider;

import java.io.Serializable;

/**
 * Created by linzhiqiang on 16/3/29.
 */
public class AbstractCacheContext {
    protected ILogger logger = LoggerFactory.getLogger(this.getClass());

    protected <T extends Serializable> T getObjectFromCacheProvider(CacheProvider provider,
        String regionName, String key) {
        Cache cache = getCache(provider, regionName);
        if (cache == null) {
            logger.error("count not get cache config ,regionName:" + regionName);
            return null;
        } else {
            return cache.get(key);
        }
    }

    protected void setObjectToCacheProvider(CacheProvider provider, String regionName, String key,
        Serializable value) {
        Cache cache = getCache(provider, regionName);
        if (cache == null) {
            logger.error("count not get cache config,regionName:" + regionName);
        } else {
            cache.put(key, value);
        }
    }

    protected void removeObjectFromCacheProvider(CacheProvider provider, String regionName,
        String key, Serializable value) {
        Cache cache = getCache(provider, regionName);
        if (cache == null) {
            logger.error("count not get cache config,regionName:" + regionName);
        } else {
            cache.evict(key);
        }
    }

    protected Cache getCache(CacheProvider provider, String regionName) {
        if (provider == null) {
            logger.error("provider is null");
            return null;
        }
        Cache cache = provider.buildCache(regionName);
        return cache;
    }

    protected void clearAllCache(CacheProvider provider) {
        for (Cache cache : provider.getAllCache()) {
            cache.clear();
        }
    }
}
