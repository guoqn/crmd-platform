package com.ffcs.crmd.platform.pub.cache.servlet;

import com.ffcs.crmd.platform.cache.api.constants.CacheConstants;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public class EnttLocalCacheServlet extends AbstractCacheServlet {
    @Override
    protected String providerName() {
        return CacheConstants.ENTT_LOCAL_CACHE_PROVIDER_BEAN_NAME;
    }
}