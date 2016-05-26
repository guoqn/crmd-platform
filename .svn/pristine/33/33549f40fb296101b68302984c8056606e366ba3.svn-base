package com.ffcs.crmd.platform.cache.core;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;
import com.ffcs.crmd.platform.cache.api.CacheProvider;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.google.common.cache.CacheBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public abstract class AbstractCacheProvider implements CacheProvider {

    protected ILogger                      logger   = LoggerFactory.getLogger(this.getClass());
    protected ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
    protected CacheConfigLoader            loader   = null;

    public AbstractCacheProvider(CacheConfigLoader loader) {
        this.loader = loader;
    }

    @Override
    public List<Cache> getAllCache() {
        return new ArrayList<Cache>(cacheMap.values());
    }
}
