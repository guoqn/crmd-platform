package com.ffcs.crmd.platform.cache.api;

/**
 * Created by linzhiqiang on 16/3/30.
 */
public class CacheStatus {
    private String name;
    private String regionName;
    private Long putIn;
    private Long hits;
    private Long misses;
    private Long evicts;
    private Long currentSize;
    private Long liveTime;
    private Long maxSize;

    public CacheStatus(String name, String regionName, Long putIn, Long hits, Long misses,
        Long evicts, Long currentSize, Long liveTime, Long maxSize) {
        this.name = name;
        this.regionName = regionName;
        this.putIn = putIn;
        this.hits = hits;
        this.misses = misses;
        this.evicts = evicts;
        this.currentSize = currentSize;
        this.liveTime = liveTime;
        this.maxSize = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getPutIn() {
        return putIn;
    }

    public void setPutIn(Long putIn) {
        this.putIn = putIn;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public Long getMisses() {
        return misses;
    }

    public void setMisses(Long misses) {
        this.misses = misses;
    }

    public Long getEvicts() {
        return evicts;
    }

    public void setEvicts(Long evicts) {
        this.evicts = evicts;
    }

    public Long getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Long currentSize) {
        this.currentSize = currentSize;
    }

    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    public Long getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(Long liveTime) {
        this.liveTime = liveTime;
    }

    @Override
    public String toString() {
        return "CacheStatus{" +
            "name='" + name + '\'' +
            ", regionName='" + regionName + '\'' +
            ", putIn=" + putIn +
            ", hits=" + hits +
            ", misses=" + misses +
            ", evicts=" + evicts +
            ", currentSize=" + currentSize +
            ", liveTime=" + liveTime +
            ", maxSize=" + maxSize +
            '}';
    }
}
