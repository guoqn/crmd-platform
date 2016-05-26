package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysConfig;
import com.ffcs.crmd.platform.pub.vo.RetVo;

public interface ISysConfigService extends
		ICrmDomGenericService<SysConfig, Long> {

	/**
	 * 查询列表
	 * 
	 * @param name
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PageInfo<SysConfig> querySysConfigInfo(String name, int pageNumber,
			int pageSize);

	/**
	 * 保存
	 * 
	 * @param sysConfig
	 * @return
	 */
	RetVo saveSysConfig(SysConfig sysConfig);

	/**
	 * 删除
	 * 
	 * @param confId
	 * @return
	 */
	RetVo delSysConfig(Long confId);

	/**
	 * 根据id获取名称
	 * @param confId
	 * @return
	 */
	String getNameById(Long confId);
}
