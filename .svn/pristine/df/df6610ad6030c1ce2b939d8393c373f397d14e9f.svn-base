package com.ffcs.crmd.platform.cache.core.local;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.cache.api.Element;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.AbstractCache;
import com.google.common.cache.Cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class LocalCache extends AbstractCache {

    private com.google.common.cache.Cache<Object, Object> cache;

    public LocalCache(String regionName, com.google.common.cache.Cache cache,Long maxSize,Long expire) {
        super(regionName,maxSize,expire);
        this.cache = cache;
    }

    @Override
    public String name() {
        return "guava";
    }

    @Override
    public void putElementInternal(String key, Element element) {
        cache.put(key,element);
    }

    @Override
    protected <T extends Serializable> T getInternal(String key) {
        return (T) cache.getIfPresent(key);
    }

    @Override
    public List<String> keys() throws CacheException {
        Set<Object> sets = cache.asMap().keySet();
        List<String> keys = new ArrayList<String>();
        for (Object key : sets) {
            keys.add(StringUtils.strnull(key));
        }
        return keys;
    }

    @Override
    public void evictInternal(String key) throws CacheException {
        cache.invalidate(key);
    }

    @Override
    public void evictInternal(List<String> keys) throws CacheException {
        cache.invalidateAll(keys);
    }

    @Override
    public void clearInternal() throws CacheException {
        cache.invalidateAll();
    }

    @Override
    public void destroy() throws CacheException {
    }
}
