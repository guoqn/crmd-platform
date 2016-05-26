package com.ffcs.crmd.platform.cache.core.config;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.cache.api.CacheConfig;
import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public abstract class AbstractCacheConfigLoader implements CacheConfigLoader {

    protected ILogger                  logger    = LoggerFactory.getLogger(this.getClass());
    protected Map<String, CacheConfig> configMap = new HashMap<String, CacheConfig>();

    @Override
    public List<String> getAllRegionName() {
        return new ArrayList<String>(configMap.keySet());
    }

    @Override
    public List<CacheConfig> getAllCacheConfig() {
        return new ArrayList<CacheConfig>(configMap.values());
    }

    @Override
    public CacheConfig getCacheConfig(String regionName) {
        return configMap.get(regionName);
    }

    @Override
    public abstract Long getDefaultLocalMaxExpireAfterAccess(String level);

    @Override
    public abstract Long getLocalMaxSize(String level);

    @Override
    public abstract Long getDefaultGlobalMaxExpireAfterAccess(String level);

    @Override
    public abstract Long getGlobalMaxSize(String level);
}
