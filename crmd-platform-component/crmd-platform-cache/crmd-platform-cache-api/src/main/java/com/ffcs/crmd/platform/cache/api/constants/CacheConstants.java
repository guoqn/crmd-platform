package com.ffcs.crmd.platform.cache.api.constants;

/**
 * Created by linzhiqiang on 16/3/26.
 */
public class CacheConstants {
    public static final String KEY_SPLIT = "_#_";

    public static final String LOCAL_MAX_SIZE_PREFIX  = "local.maxSize.";
    public static final String LOCAL_EXPIRE_PREFIX    = "local.expire.";
    public static final String GLOBAL_MAX_SIZE_PREFIX = "global.maxSize.";
    public static final String GLOBAL_EXPIRE_PREFIX   = "global.expire.";
    public static final String LEVEL_PREFIX           = "level.";

    public static final String DEFAULT_ENTT_LOCAL_MAX_SIZE_KEY  = "default.local.maxSize";
    public static final String DEFAULT_ENTT_LOCAL_EXPIRE_KEY    = "default.local.expire";
    public static final String DEFAULT_ENTT_GLOBAL_MAX_SIZE_KEY = "default.global.maxSize";
    public static final String DEFAULT_ENTT_GLOBAL_EXPIRE_KEY   = "default.global.expire";

    public static final Long DEFAULT_GLOBAL_EXPIRE   = 3600L;
    public static final Long DEFAULT_LOCAL_EXPIRE    = 1800L;
    public static final Long DEFAULT_GLOBAL_MAX_SIZE = 10000 * 2L;
    public static final Long DEFAULT_LOCAL_MAX_SIZE  = 10000 * 1L;

    public static final String ENTT_CACHE_LEVEL_THREAD = "1";
    public static final String ENTT_CACHE_LEVEL_LOCAL  = "3";
    public static final String ENTT_CACHE_LEVEL_GLOBAL = "5";
    public static final String ENTT_CACHE_LEVEL_MIX    = "8";

    public static final String ENTT_LOCAL_CACHE_PROVIDER_BEAN_NAME  = "enttLocalCacheProvider";
    public static final String ENTT_GLOBAL_CACHE_PROVIDER_BEAN_NAME = "enttGlobalCacheProvider";
    public static final String ENTT_CACHE_CONFIG_LOADE_BEAN_NAME    = "enttCacheConfigLoader";
    public static final String ENTT_THREAD_CACHE_PROVIDER_BEAN_NAME = "enttThreadCacheProvider";

    public static final String SERVICE_CACHE_CONFIG_LOADE_BEAN_NAME    = "serviceCacheConfigLoader";
    public static final String SERVICE_LOCAL_CACHE_PROVIDER_BEAN_NAME  = "serviceLocalCacheProvider";
    public static final String SERVICE_GLOBAL_CACHE_PROVIDER_BEAN_NAME = "serviceGlobalCacheProvider";

    public static final String SERVICE_CACHE_LEVEL_GLOBAL                  = "12";
    public static final String SERVICE_CACHE_LEVEL_REQUEST                 = "11";
    public static final String DEFAULT_SERVICE_REQUEST_LOCAL_MAX_SIZE_KEY  = "default.request.local.maxSize";
    public static final String DEFAULT_SERVICE_REQUEST_LOCAL_EXPIRE_KEY    = "default.request.local.expire";
    public static final String DEFAULT_SERVICE_REQUEST_GLOBAL_MAX_SIZE_KEY = "default.request.global.maxSize";
    public static final String DEFAULT_SERVICE_REQUEST_GLOBAL_EXPIRE_KEY   = "default.request.global.expire";
    public static final String DEFAULT_SERVICE_GLOBAL_LOCAL_MAX_SIZE_KEY   = "default.global.local.maxSize";
    public static final String DEFAULT_SERVICE_GLOBAL_LOCAL_EXPIRE_KEY     = "default.global.local.expire";
    public static final String DEFAULT_SERVICE_GLOBAL_GLOBAL_MAX_SIZE_KEY  = "default.global.global.maxSize";
    public static final String DEFAULT_SERVICE_GLOBAL_GLOBAL_EXPIRE_KEY    = "default.global.global.expire";

    public static final Long DEFAULT_SERVICE_REQUEST_GLOBAL_EXPIRE   = 300L;
    public static final Long DEFAULT_SERVICE_REQUEST_LOCAL_EXPIRE    = 300L;
    public static final Long DEFAULT_SERVICE_REQUEST_GLOBAL_MAX_SIZE = 10000 * 2L;
    public static final Long DEFAULT_SERVICE_REQUEST_LOCAL_MAX_SIZE  = 10000 * 1L;

    public static final Long DEFAULT_SERVICE_GLOBAL_GLOBAL_EXPIRE   = 3600L;
    public static final Long DEFAULT_SERVICE_GLOBAL_LOCAL_EXPIRE    = 1800L;
    public static final Long DEFAULT_SERVICE_GLOBAL_GLOBAL_MAX_SIZE = 10000 * 2L;
    public static final Long DEFAULT_SERVICE_GLOBAL_LOCAL_MAX_SIZE  = 10000 * 1L;

}

