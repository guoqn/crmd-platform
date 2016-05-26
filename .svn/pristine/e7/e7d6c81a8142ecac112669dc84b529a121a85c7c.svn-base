package com.ffcs.crmd.platform.data.dao;

import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.data.dao.IBaseCacheDao;

public interface ICrmBaseCacheDao extends IBaseCacheDao {

	/**
	 * 
	 * 方法功能: 查询列表.
	 * 
	 * @param name
	 * @param elementType
	 * @param isCache
	 *            是否调用缓存处理
	 * @return
	 * @author: linzq @修改记录：
	 *          ==============================================================
	 *          <br>
	 *          日期:2014-12-23 linzq 创建方法，并实现其功能
	 *          ==============================================================
	 *          <br>
	 */
	<E> List<E> jdbcFindListByName(String name, Class<E> elementType, boolean isCache);

	/**
	 * 
	 * 方法功能: .
	 * 
	 * @param name
	 * @param elementType
	 * @param params
	 * @param isCache
	 *            是否调用缓存处理
	 * @return
	 * @author: linzq @修改记录：
	 *          ==============================================================
	 *          <br>
	 *          日期:2014-12-23 linzq 创建方法，并实现其功能
	 *          ==============================================================
	 *          <br>
	 */
	<E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params, boolean isCache);

	/**
	 * 
	 * 方法功能: .
	 * 
	 * @param name
	 * @param elementType
	 * @param currentPage
	 * @param perPageNum
	 * @param isCache
	 *            是否调用缓存处理
	 * @return
	 * @author: linzq @修改记录：
	 *          ==============================================================
	 *          <br>
	 *          日期:2014-12-23 linzq 创建方法，并实现其功能
	 *          ==============================================================
	 *          <br>
	 */
	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, int currentPage, int perPageNum,
			boolean isCache);

	<E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, List<Object> params, int currentPage,
			int perPageNum, boolean isCache);

	/**
	 * 动态配置SQL查询,获取List
	 * 
	 * @param name
	 * @param params
	 * @param elementType
	 * @return
	 * @author LAIYONGMIN-PC
	 */
	<E> List<E> queryListByName(String name, Class<E> elementType, Map<String, Object> params, boolean isCache);

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
			int pageSize, boolean isCache);

}
