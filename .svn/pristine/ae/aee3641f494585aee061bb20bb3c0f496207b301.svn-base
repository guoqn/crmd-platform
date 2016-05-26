package com.ffcs.crmd.platform.cache.core.config;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.base.utils.CrmPropertiesUtil;
import com.ffcs.crmd.platform.cache.api.CacheConfig;
import com.ffcs.crmd.platform.cache.api.constants.CacheConstants;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class PropCacheConfigLoader extends AbstractCacheConfigLoader {

    protected Map<String, String> properties = null;

    public PropCacheConfigLoader(String fileName) {
        properties = CrmPropertiesUtil.getProperties(fileName, true);
        loadConfig();
    }

    private void loadConfig() {
        logger.debug("begin Load config");
        Set<String> keys = properties.keySet();

        for (String key : keys) {
            if (key.startsWith(CacheConstants.LEVEL_PREFIX)) {
                String region = key.substring(CacheConstants.LEVEL_PREFIX.length());
                if (!configMap.containsKey(region)) {
                    CacheConfig config = new CacheConfig(region);
                    configMap.put(region, config);
                }
                CacheConfig cacheConfig = configMap.get(region);
                cacheConfig.setLevel(properties.get(CacheConstants.LEVEL_PREFIX + region));
                cacheConfig.setGlobalExpireAfterAccess(
                    getValue(CacheConstants.GLOBAL_EXPIRE_PREFIX, region,
                        getDefaultGlobalMaxExpireAfterAccess(cacheConfig.getLevel())));
                cacheConfig.setGlobalMaxSize(getValue(CacheConstants.GLOBAL_MAX_SIZE_PREFIX, region,
                    getGlobalMaxSize(cacheConfig.getLevel())));
                cacheConfig.setLocalExpireAfterAccess(
                    getValue(CacheConstants.LOCAL_EXPIRE_PREFIX, region,
                        getDefaultLocalMaxExpireAfterAccess(cacheConfig.getLevel())));
                cacheConfig.setLocalMaxSize(getValue(CacheConstants.LOCAL_MAX_SIZE_PREFIX, region,
                    getLocalMaxSize(cacheConfig.getLevel())));
            }
        }
        logger.debug("config load end.size:" + configMap.size());

    }

    protected Long getValue(String keyPrefix, String region, Long defaultValue) {
        if (!StringUtils.isNullOrEmpty(properties.get(keyPrefix + region))) {
            return NumberUtils.nullToLongZero(properties.get(keyPrefix + region));
        }
        return defaultValue;
    }

    @Override
    public Long getDefaultLocalMaxExpireAfterAccess(String level) {
        return getValueFromProp(properties, CacheConstants.DEFAULT_ENTT_LOCAL_EXPIRE_KEY,
            CacheConstants.DEFAULT_LOCAL_EXPIRE, true);
    }

    @Override
    public Long getLocalMaxSize(String level) {
        return getValueFromProp(properties, CacheConstants.DEFAULT_ENTT_LOCAL_MAX_SIZE_KEY,
            CacheConstants.DEFAULT_LOCAL_MAX_SIZE, true);
    }

    @Override
    public Long getDefaultGlobalMaxExpireAfterAccess(String level) {
        return getValueFromProp(properties, CacheConstants.DEFAULT_ENTT_GLOBAL_EXPIRE_KEY,
            CacheConstants.DEFAULT_GLOBAL_EXPIRE, true);
    }

    @Override
    public Long getGlobalMaxSize(String level) {
        return getValueFromProp(properties, CacheConstants.DEFAULT_ENTT_GLOBAL_MAX_SIZE_KEY,
            CacheConstants.DEFAULT_GLOBAL_MAX_SIZE, true);
    }

    protected Long getValueFromProp(Map<String, String> properties, String key, Long defaultValue,
        boolean isZeroToDefault) {
        Long size = 0L;
        if (properties != null && properties.containsKey(key)) {
            size = NumberUtils.nullToLongZero(properties.get(key));
        }
        if (size == 0L && isZeroToDefault) {
            return defaultValue;
        }
        return size;
    }
}
