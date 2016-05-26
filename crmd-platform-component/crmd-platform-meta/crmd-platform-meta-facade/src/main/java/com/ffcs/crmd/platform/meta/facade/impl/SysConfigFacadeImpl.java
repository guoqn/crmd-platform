package com.ffcs.crmd.platform.meta.facade.impl;

import java.util.List;

import com.ffcs.crmd.platform.meta.util.SamplingUtil;
import com.ffcs.crmd.platform.meta.util.SwitchUtil;
import com.ffcs.crmd.platform.meta.util.SysConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.event.utils.StringUtils;
import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysConfigDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysConfigFacade;
import com.ffcs.crmd.platform.meta.api.vo.SysConfigVo;
import com.ffcs.crmd.platform.meta.entity.SysConfig;
import com.ffcs.crmd.platform.meta.service.ISysConfigService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

@Service("sysconfigFacade")
public class SysConfigFacadeImpl extends AbstractCrmDomFacade implements
		ISysConfigFacade {

	@Autowired
	private ISysConfigService sysconfigService;

	@Override
	public PageInfo<SysConfigDTO> querySysConfigList(String name,
			Integer pageNumber, Integer pageSize) {
		PageInfo pageInfo = sysconfigService.querySysConfigInfo(name,
				pageNumber, pageSize);
		if (pageInfo != null && pageInfo.getList() != null) {
			try {
				List<SysConfigDTO> sysConfigDtoList = BeanUtils.copyList(
						pageInfo.getList(), SysConfigDTO.class);
				for (SysConfigDTO dto : sysConfigDtoList) {
					if (StringUtils.isNullOrEmpty(dto.getParentId()))
						continue;
					String parentName = sysconfigService.getNameById(dto
							.getParentId());
					if (!StringUtils.isNullOrEmpty(parentName)) {
						dto.setParentName(parentName);
					}
				}
				pageInfo.setList(sysConfigDtoList);
			} catch (Exception e) {
				ExceptionUtils.transEx(e);
			}
		}
		return pageInfo;
	}

	@Override
	public RetVo saveSysConfig(SysConfigVo sysConfigVo) {
		SysConfig sysConfig = new SysConfig();
		try {
			BeanUtils.applyIf(sysConfig, sysConfigVo);
			return sysconfigService.saveSysConfig(sysConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RetVo delSysConfig(Long confId) {
		return sysconfigService.delSysConfig(confId);
	}

	@Override
	public RetVo clearCacheByPath(SysConfigVo sysConfigVo) {
		RetVo retVo = new RetVo(false);
		if (!StringUtils.isNullOrEmpty(sysConfigVo.getCachePath())) { // 清理路径缓存
			retVo = SysConfigUtil.cleanCacheByNode(sysConfigVo.getCachePath());
		} else if (!StringUtils.isNullOrEmpty(sysConfigVo.getSwitchPath())) { // 开关缓存
			retVo = SwitchUtil.clearSwtichByPath(sysConfigVo.getSwitchPath());
		} else if (!StringUtils.isNullOrEmpty(sysConfigVo.getSamplingPath())) { // 抽样缓存
			retVo = SamplingUtil.clearSamplingByPath(sysConfigVo
					.getSamplingPath());
		}
		return retVo;
	}

	@Override
	public RetVo clearAllCache(SysConfigVo sysConfigVo) {
		RetVo retVo = null;
		if (!StringUtils.isNullOrEmpty(sysConfigVo.getCachePath())) {
			retVo = SysConfigUtil.cleanAllCache(); // 清理所有缓存
		} else if (!StringUtils.isNullOrEmpty(sysConfigVo.getSwitchPath())) {
			retVo = SwitchUtil.clearAllSwtich(); // 清理所有开关缓存
		} else if (!StringUtils.isNullOrEmpty(sysConfigVo.getSamplingPath())) {
			retVo = SamplingUtil.clearAllSampling(); // 清理所有抽样缓存
		}
		return retVo;
	}

	@Override
	public RetVo clearChildCache(SysConfigVo sysConfigVo) {
		RetVo retVo = null;
		if (!StringUtils.isNullOrEmpty(sysConfigVo.getCachePath())) {
			retVo = SysConfigUtil.clearChildByPath(sysConfigVo.getCachePath()); // 清理所有缓存
		} else if (!StringUtils.isNullOrEmpty(sysConfigVo.getSwitchPath())) {
			retVo = SwitchUtil.clearChildByPath(sysConfigVo.getSwitchPath()); // 清理所有开关缓存
		} else if (!StringUtils.isNullOrEmpty(sysConfigVo.getSamplingPath())) {
			retVo = SamplingUtil.clearChildSamplingByPath(sysConfigVo.getSamplingPath()); // 清理所有抽样缓存
		}
		return retVo;
	}

}
