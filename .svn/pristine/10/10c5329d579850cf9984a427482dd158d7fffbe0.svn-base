package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.api.facade.IDomBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysConfigDTO;
import com.ffcs.crmd.platform.meta.api.vo.SysConfigVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * sysConfig api
 * 
 * @author FFSC-GUOQN
 *
 */
public interface ISysConfigFacade extends IDomBaseFacade {

	/**
	 * 查询列表
	 * 
	 * @param name
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public PageInfo<SysConfigDTO> querySysConfigList(String name, Integer pageNumber,
			Integer pageSize);

	/**
	 * 保存
	 * 
	 * @param sysConfigVo
	 * @return
	 */
	public RetVo saveSysConfig(SysConfigVo sysConfigVo);

	/**
	 * 删除
	 * 
	 * @param confId
	 * @return
	 */
	public RetVo delSysConfig(Long confId);

	/**
	 * 根据路径清理缓存
	 * @param sysConfigVo
	 * @return
     */
	RetVo clearCacheByPath(SysConfigVo sysConfigVo);

	/**
	 * 清理所有缓存
	 * @return
     */
	RetVo clearAllCache(SysConfigVo sysConfigVo);
	
	/**
	 * 清理路径子节点
	 * @param sysConfigVo
	 * @return
	 */
	RetVo clearChildCache(SysConfigVo sysConfigVo);
}
