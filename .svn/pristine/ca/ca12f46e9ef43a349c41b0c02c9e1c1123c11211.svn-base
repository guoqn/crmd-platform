package com.ffcs.crmd.platform.cache.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public interface CacheConfigLoader {

    List<String> getAllRegionName();

    List<CacheConfig> getAllCacheConfig();

    CacheConfig getCacheConfig(String regionName);

    Long getDefaultLocalMaxExpireAfterAccess(String level);

    Long getLocalMaxSize(String level);

    Long getDefaultGlobalMaxExpireAfterAccess(String level);

    Long getGlobalMaxSize(String level);

}
