package com.ffcs.crmd.platform.cache.core;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheStatus;
import com.ffcs.crmd.platform.cache.api.Element;
import com.ffcs.crmd.platform.cache.api.StatsCounter;
import com.ffcs.crmd.platform.cache.api.exception.CacheException;
import com.ffcs.crmd.platform.cache.core.metric.impl.SimpleStatusCounter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/30.
 */
public abstract class AbstractCache implements Cache {
    protected ILogger      logger  = LoggerFactory.getLogger(this.getClass());
    protected StatsCounter counter = new SimpleStatusCounter();
    private String regionName;
    private Long maxSize = 0L;
    private Long expire  = 0L;

    public AbstractCache(String regionName, Long maxSize, Long expire) {
        this.regionName = regionName;
        this.maxSize = maxSize;
        this.expire = expire;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public abstract String name();

    @Override
    public void putElement(String key, Element element) {
        putElementInternal(key,element);
        counter.recordPutIn(1);
    }

    public abstract void putElementInternal(String key, Element element);


    @Override
    public void put(String key, Serializable value) {
        Element element = new Element(value);
        putElement(key, element);
    }

    @Override
    public void touch(String key) {
        get(key);
    }

    @Override
    public <T extends Serializable> T get(String key) {
        Serializable value = getInternal(key);

        if (value == null) {
            counter.recordMisses(1);
            logger.info("Cache missing: {}", key);
            return null;
        } else {
            counter.recordHits(1);
            logger.debug("Cache hit: {}", key);
        }

        // 剥去包装
        if (value instanceof Element) {
            value = ((Element) value).getValue();
        } else {
            logger.debug("Cache value of '" + key + "' is not an Element: " + value.getClass());
        }

        return (T) value;
    }

    protected abstract <T extends Serializable> T getInternal(String key);

    @Override
    public <T extends Serializable> T get(String key, Class<T> type) {
        Serializable value = get(key);

        if (value == null) {
            return null;
        }

        if (!type.isAssignableFrom(value.getClass())) {
            throw new ClassCastException(
                "Cache value of \"" + key + "\" of type " + value.getClass() + " cannot be cast to "
                    + type.getClass());
        }

        return (T) value;
    }

    @Override
    public <E extends Serializable> Element<E> getElement(String key) {
        Serializable value = getInternal(key);

        if (value == null) {
            counter.recordMisses(1);
            logger.info("Cache missing: {}", key);
            return null;
        } else {
            counter.recordHits(1);
            logger.debug("Cache hit: {}", key);
        }

        if (value instanceof Element) {
            return (Element<E>) value;
        } else {
            throw new CacheException(
                "Cache value of \"" + key + "\" is not an Element (" + value.getClass() + ")");
        }
    }

    @Override
    public abstract List<String> keys() throws CacheException;

    @Override
    public void evict(String key) throws CacheException {
        counter.recordEviction(1);
        evictInternal(key);
    }

    public abstract void evictInternal(String key) throws CacheException;


    @Override
    public void evict(List<String> keys) throws CacheException {
        counter.recordEviction(keys.size());
        evictInternal(keys);
    }

    public abstract void evictInternal(List<String> keys) throws CacheException;


    @Override
    public void clear() throws CacheException {
        counter.recordEviction(keys().size());
        clearInternal();
    }

    public abstract void clearInternal() throws CacheException;


    @Override
    public abstract void destroy() throws CacheException;

    @Override
    public CacheStatus status() {
        CacheStatus cacheStatus = new CacheStatus(name(), getRegionName(), counter.getPutIn(),
            counter.getHits(), counter.getMisses(), counter.getEvicts(),
            NumberUtils.nullToLongZero(keys().size()), getExpire(), getMaxSize());
        return cacheStatus;
    }
}
