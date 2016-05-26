package com.ffcs.crmd.platform.cache.api;

import java.io.Serializable;

/**
 * 对缓存元素的包装
 *
 */
public class Element<E extends Serializable> implements Serializable {

    // DO NOT CHANGE THIS OR YOU MAY GET SERIALIZATION ERROR
    public static final long serialVersionUID = -1239539875870833481L;

    private E value;

    private long lastUpdate;

    public Element() {
    }

    public Element(E value) {
        this(value, System.nanoTime());
    }

    public Element(E value, long lastUpdate) {
        this.value = value;
        this.lastUpdate = lastUpdate;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
