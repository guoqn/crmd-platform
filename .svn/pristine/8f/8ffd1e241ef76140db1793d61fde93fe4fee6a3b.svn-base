package com.ffcs.crmd.platform.cache.core.global;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crm.tools.cache.CacheHashMap;
import com.ffcs.crm.tools.cache.CacheObject;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheConfig;
import com.ffcs.crmd.platform.cache.api.CacheConfigLoader;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.AbstractCacheProvider;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class GlobalCacheProvider extends AbstractCacheProvider {

    public GlobalCacheProvider(CacheConfigLoader loader) {
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
            CacheHashMap map = new CacheHashMap(regionName);

            Cache localCache = new GlobalCache(regionName,map,config.getGlobalMaxSize(),config.getGlobalExpireAfterAccess());
            cacheMap.putIfAbsent(regionName, localCache);
        }
        return cacheMap.get(regionName);
    }

}
