package com.ffcs.crmd.platform.cache.api;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class CacheConfig {

    private String regionName;

    private String level;

    private Long localMaxSize;

    private Long localExpireAfterAccess;

    private Long globalMaxSize;

    private Long globalExpireAfterAccess;

    public CacheConfig(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getLocalMaxSize() {
        return localMaxSize;
    }

    public void setLocalMaxSize(Long localMaxSize) {
        this.localMaxSize = localMaxSize;
    }

    public Long getLocalExpireAfterAccess() {
        return localExpireAfterAccess;
    }

    public void setLocalExpireAfterAccess(Long localExpireAfterAccess) {
        this.localExpireAfterAccess = localExpireAfterAccess;
    }

    public Long getGlobalMaxSize() {
        return globalMaxSize;
    }

    public void setGlobalMaxSize(Long globalMaxSize) {
        this.globalMaxSize = globalMaxSize;
    }

    public Long getGlobalExpireAfterAccess() {
        return globalExpireAfterAccess;
    }

    public void setGlobalExpireAfterAccess(Long globalExpireAfterAccess) {
        this.globalExpireAfterAccess = globalExpireAfterAccess;
    }

    @Override
    public String toString() {
        return "CacheConfig{" +
            "regionName='" + regionName + '\'' +
            ", level='" + level + '\'' +
            ", localMaxSize=" + localMaxSize +
            ", localExpireAfterAccess=" + localExpireAfterAccess +
            ", globalMaxSize=" + globalMaxSize +
            ", globalExpireAfterAccess=" + globalExpireAfterAccess +
            '}';
    }
}
