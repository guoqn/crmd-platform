package com.ffcs.crmd.platform.cache.core.global;

import com.alibaba.fastjson.JSON;
import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crm.tools.cache.CacheHashMap;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.Element;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.AbstractCache;
import org.apache.commons.collections.ListUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class GlobalCache extends AbstractCache {

    private CacheHashMap map = null;


    public GlobalCache(String regionName,CacheHashMap map, Long maxSize,Long expire) {
        super(regionName,maxSize,expire);
        this.map = map;
    }

    @Override
    public String name() {
        return "global";
    }

    @Override
    public void putElementInternal(String key, Element element) {
        if (getExpire() > 0) {
            map.putByte(key, element, getExpire().intValue());
        } else {
            map.putByte(key, element);
        }
    }

    @Override
    protected <T extends Serializable> T getInternal(String key) {
        return (T) map.getByte(key,Element.class);
    }

    @Override
    public List<String> keys() throws CacheException {
        return Arrays.asList(map.getKeys());
    }

    @Override
    public void evictInternal(String key) throws CacheException {
        map.remove(key);
    }

    @Override
    public void evictInternal(List<String> keys) throws CacheException {
        for (String key : keys) {
            evictInternal(key);
        }
    }

    @Override
    public void clearInternal() throws CacheException {
        map.clear();
    }

    @Override
    public void destroy() throws CacheException {

    }
}
