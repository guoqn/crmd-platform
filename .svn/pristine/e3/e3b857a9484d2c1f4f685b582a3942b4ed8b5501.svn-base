package com.ffcs.crmd.platform.cache.core.thread;

import com.ctg.itrdc.event.utils.StringUtils;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ffcs.crmd.platform.cache.api.Element;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.AbstractCache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class ThreadCache extends AbstractCache {

    private static final String THREAD_CACHE_PREFIX = "threadCache:";

    public ThreadCache(String regionName) {
        super(regionName,-1L,-1L);
    }

    @Override
    public String name() {
        return "threadLocal";
    }

    @Override
    public void putElementInternal(String key, Element element) {
        SessionContext
            .putTheadLocalVariable(THREAD_CACHE_PREFIX + StringUtils.strnull(key), element);
    }

    @Override
    protected <T extends Serializable> T getInternal(String key) {
        return (T) SessionContext
            .getObject4TreadLocal(THREAD_CACHE_PREFIX + StringUtils.strnull(key));
    }

    @Override
    public List<String> keys() throws CacheException {
        return new ArrayList(
            SessionContext.getThreadLocalValMapByPrefix(THREAD_CACHE_PREFIX).keySet());
    }

    @Override
    public void evictInternal(String key) throws CacheException {
        SessionContext.loadBaseInfo().remove(THREAD_CACHE_PREFIX + StringUtils.strnull(key));
    }

    @Override
    public void evictInternal(List<String> keys) throws CacheException {
        for (String key : keys) {
            evictInternal(key);
        }
    }

    @Override
    public void clearInternal() throws CacheException {
        evict(keys());
    }

    @Override
    public void destroy() throws CacheException {

    }

}
