package com.ffcs.crmd.platform.data.cache;

import com.ctg.itrdc.platform.cache.ICacheEntityService;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;

import java.util.List;

/**
 * Created by linzhiqiang on 16/3/29.
 */
public interface ICrmCacheEntityService extends ICacheEntityService {

    /**
     * 将对象存放到缓存中
     *  @param Id
     * @param object
     * @param TTL
     * @param classType
     */
    public <T> void putObjectList(Class<?> classType,String sql,List<Object> params,List<T> objs);

    /**
     * 将对象列表从缓存中获取
     *
     * @param Id
     * @return
     */
    public <T> List<T> getObjectList(Class<T> classType,String sql,List<Object> params,ICrmBaseDao dao);
}
