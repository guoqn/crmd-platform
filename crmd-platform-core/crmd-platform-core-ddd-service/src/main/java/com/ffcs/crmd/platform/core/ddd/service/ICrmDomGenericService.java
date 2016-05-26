package com.ffcs.crmd.platform.core.ddd.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;

public interface ICrmDomGenericService<T extends AbstractCrmDomBaseEntityImpl, ID extends Serializable> {
    /**
     * @param id
     * @param shardingId
     * @return
     */
    public T getByIdAndShardingId(ID id, Long shardingId);

    /**
     * 添加新实体
     */
    int save(T t);

    /**
     * 删除实体
     */
    int remove(T t);

    /**
     * 修改实体
     */
    int update(T t);

    /**
     * 通过ID获取实体
     */
    T get(ID id);

    /**
     * 根据框架生成查询语句，尽量少用
     */
    List<T> listAll();

    /**
     * 根据框架生成查询语句，尽量少用
     */
    List<T> listByMap(Map<String, Object> map);

    /**
     * 根据框架生成查询语句，尽量少用
     */
    PageInfo findPageInfoByMap(Map<String, Object> map, int page, int pageSize);

    /**
     * 通过ID获取实体
     */
    T get(ID id, boolean isCache);

    /**
     * 根据框架生成查询语句，尽量少用
     */
    List<T> listAll(boolean isCache);

    /**
     * 根据框架生成查询语句，尽量少用
     */
    List<T> listByMap(Map<String, Object> map, boolean isCache);

    /**
     * 根据框架生成查询语句，尽量少用
     */
    PageInfo findPageInfoByMap(Map<String, Object> map, int page, int pageSize, boolean isCache);
}
