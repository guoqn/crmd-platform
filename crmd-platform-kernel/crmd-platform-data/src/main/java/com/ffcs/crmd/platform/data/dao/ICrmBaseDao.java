package com.ffcs.crmd.platform.data.dao;

import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.data.dao.IBaseDao;

public interface ICrmBaseDao extends IBaseDao {
	int jdbcQueryForIntByName(String name, Object... args);

	int jdbcQueryForIntByName(String name, Object[] args, int[] argTypes);

	int jdbcQueryForIntByName(String name);

	<E> List<E> jdbcFindListByName(String name, Class<E> elementType);

	<E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params);

	int jdbcGetSizeByName(String name, List<Object> params);

	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, int currentPage, int perPageNum);

	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, List<Object> params, int currentPage,
			int perPageNum);

	long jdbcQueryForLongByName(String name, Object... args);

	long jdbcQueryForLongByName(String name, Object[] args, int[] argTypes);

	long jdbcQueryForLongByName(String name);

	/**
	 * 动态配置SQL查询,获取List
	 * 
	 * @param name
	 * @param params
	 * @param elementType
	 * @return
	 * @author LAIYONGMIN-PC
	 */
	<E> List<E> queryListByName(String name, Class<E> elementType, Map<String, Object> params);

	/**
	 * 动态配置SQL查询,获取PageInfo
	 * 
	 * @param name
	 * @param params
	 * @param elementType
	 * @param page
	 * @param pageSize
	 * @param isCache
	 * @return
	 */
	<E> PageInfo<E> queryPageInfoByName(String name, Class<E> elementType, Map<String, Object> params, int page,
			int pageSize);

	/**
	 * 动态配置SQL，获取INT值
	 * 
	 * @param name
	 * @param params
	 * @return
	 */
	int queryForIntByName(String name, Map<String, Object> params);

	/**
	 * 动态配置SQL，获取LONG值
	 * 
	 * @param name
	 * @param params
	 * @return
	 */
	long queryForLongByName(String name, Map<String, Object> params);

}
