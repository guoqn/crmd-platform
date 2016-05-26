package com.ffcs.crmd.platform.core.ddd.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.entity.ICrmDomBaseEntity;
import com.ffcs.crmd.platform.data.dao.ICrmBaseCacheDao;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;

public interface ICrmDomBaseRepository<T extends ICrmDomBaseEntity, ID extends Serializable>
		extends ICrmBaseDao, ICrmBaseCacheDao {
	/**
	 * @param id
	 * @param shardingId
	 * @return
	 */
	T getByIdAndShardingId(ID id, Object shardingId);


	public void setRepositoryClass(Class<T> clazz);

	public Class<T> getRepositoryClass();

	/**
	 * 通过ID获取实体
	 */
	T getById(ID id);

	/**
	 * 通过ID获取实体
	 */
	T getById(ID id, boolean isCache);


	/**
	 * 通过模版获取实体
	 * 增加分片字段的支持。
	 */
	T getSingleByExample(T t);

	/**
	 * 通过模版获取实体
	 * 增加分片字段的支持。
	 */
	T getSingleByExample(T t, boolean isCache);

	/**
	 * 根据框架生成查询语句
	 */
	List<T> queryAll();

	/**
	 * 根据框架生成查询语句
	 */
	List<T> queryAll(boolean isCache);

	/**
	 * 根据框架生成查询语句
	 */
	List<T> queryByMap(Map<String, Object> map);

	/**
	 * 根据框架生成查询语句
	 */
	PageInfo queryPageInfoByMap(Map<String, Object> map, int page, int pageSize);

	/**
	 * 根据框架生成查询语句
	 */
	List<T> queryByMap(Map<String, Object> map, boolean isCache);

	/**
	 * 根据框架生成查询语句
	 */
	PageInfo queryPageInfoByMap(Map<String, Object> map, int page, int pageSize, boolean isCache);

	int jdbcQueryForIntByName(String name, Object... args);

	int jdbcQueryForIntByName(String name, Object[] args, int[] argTypes);

	int jdbcQueryForIntByName(String name);

	<E> List<E> jdbcFindListByName(String name, Class<E> elementType);

	<E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params);

	int jdbcGetSizeByName(String name, List<Object> params);

	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, int currentPage,
		int perPageNum);

	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, List<Object> params,
		int currentPage, int perPageNum);

	long jdbcQueryForLongByName(String name, Object... args);

	long jdbcQueryForLongByName(String name, Object[] args, int[] argTypes);

	long jdbcQueryForLongByName(String name);

	/**
	 *
	 * 方法功能:
	 *  查询列表.
	 * @param name
	 * @param elementType
	 * @param isCache  是否调用缓存处理
	 * @return
	 * @author: linzq
	 * @修改记录：
	 * ==============================================================<br>
	 * 日期:2014-12-23 linzq 创建方法，并实现其功能
	 * ==============================================================<br>
	 */
	<E> List<E> jdbcFindListByName(String name, Class<E> elementType, boolean isCache);

	/**
	 *
	 * 方法功能:
	 *  .
	 * @param name
	 * @param elementType
	 * @param params
	 * @param isCache  是否调用缓存处理
	 * @return
	 * @author: linzq
	 * @修改记录：
	 * ==============================================================<br>
	 * 日期:2014-12-23 linzq 创建方法，并实现其功能
	 * ==============================================================<br>
	 */
	<E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params,
		boolean isCache);

	/**
	 *
	 * 方法功能:
	 *  .
	 * @param name
	 * @param elementType
	 * @param currentPage
	 * @param perPageNum
	 * @param isCache 是否调用缓存处理
	 * @return
	 * @author: linzq
	 * @修改记录：
	 * ==============================================================<br>
	 * 日期:2014-12-23 linzq 创建方法，并实现其功能
	 * ==============================================================<br>
	 */
	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, int currentPage,
		int perPageNum, boolean isCache);

	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, List<Object> params,
		int currentPage, int perPageNum, boolean isCache);

}
