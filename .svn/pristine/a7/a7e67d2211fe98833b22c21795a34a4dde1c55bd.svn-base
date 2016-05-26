package com.ffcs.crmd.platform.cache.core.config;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.cache.api.constants.CacheConstants;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public class ServicePropCacheConfigLoader extends PropCacheConfigLoader {
    public ServicePropCacheConfigLoader(String fileName) {
        super(fileName);
    }

    @Override
    public Long getGlobalMaxSize(String level) {

        if (CacheConstants.SERVICE_CACHE_LEVEL_REQUEST.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_REQUEST_GLOBAL_MAX_SIZE_KEY,
                CacheConstants.DEFAULT_SERVICE_REQUEST_GLOBAL_MAX_SIZE, true);
        } else if (CacheConstants.SERVICE_CACHE_LEVEL_GLOBAL.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_GLOBAL_MAX_SIZE_KEY,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_GLOBAL_MAX_SIZE, true);
        }
        return 0L;
    }

    @Override
    public Long getDefaultGlobalMaxExpireAfterAccess(String level) {
        if (CacheConstants.SERVICE_CACHE_LEVEL_REQUEST.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_REQUEST_GLOBAL_EXPIRE_KEY,
                CacheConstants.DEFAULT_SERVICE_REQUEST_GLOBAL_EXPIRE, true);
        } else if (CacheConstants.SERVICE_CACHE_LEVEL_GLOBAL.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_GLOBAL_EXPIRE_KEY,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_GLOBAL_EXPIRE, true);
        }
        return 0L;
    }

    @Override
    public Long getLocalMaxSize(String level) {
        if (CacheConstants.SERVICE_CACHE_LEVEL_REQUEST.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_REQUEST_LOCAL_MAX_SIZE_KEY,
                CacheConstants.DEFAULT_SERVICE_REQUEST_LOCAL_MAX_SIZE, true);
        } else if (CacheConstants.SERVICE_CACHE_LEVEL_GLOBAL.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_LOCAL_MAX_SIZE_KEY,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_LOCAL_MAX_SIZE, true);
        }
        return 0L;
    }

    @Override
    public Long getDefaultLocalMaxExpireAfterAccess(String level) {
        if (CacheConstants.SERVICE_CACHE_LEVEL_REQUEST.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_REQUEST_LOCAL_EXPIRE_KEY,
                CacheConstants.DEFAULT_SERVICE_REQUEST_LOCAL_EXPIRE, true);
        } else if (CacheConstants.SERVICE_CACHE_LEVEL_GLOBAL.equals(level)) {
            return getValueFromProp(properties,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_LOCAL_EXPIRE_KEY,
                CacheConstants.DEFAULT_SERVICE_GLOBAL_LOCAL_EXPIRE, true);
        }
        return 0L;
    }
}
