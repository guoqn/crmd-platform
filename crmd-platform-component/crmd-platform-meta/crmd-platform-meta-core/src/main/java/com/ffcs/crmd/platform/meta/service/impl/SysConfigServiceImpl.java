package com.ffcs.crmd.platform.meta.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysConfig;
import com.ffcs.crmd.platform.meta.repository.ISysConfigRepository;
import com.ffcs.crmd.platform.meta.service.ISysConfigService;
import com.ffcs.crmd.platform.pub.vo.RetVo;

@Service("sysconfigService")
public class SysConfigServiceImpl extends
		AbstractCrmDomGenericService<SysConfig, Long> implements
		ISysConfigService {

	@Autowired
	private ISysConfigRepository sysConfigRepository;

	@Override
	public PageInfo<SysConfig> querySysConfigInfo(String name, int pageNumber,
			int pageSize) {
		PageInfo<SysConfig> pageInfo = new PageInfo<SysConfig>();
		if (StringUtils.isNullOrEmpty(name)){
			pageInfo = sysConfigRepository.qrySysConfig(pageNumber,pageSize);
		} else {
			List params = new ArrayList();
			params.add("%"+name+"%");
			pageInfo = sysConfigRepository.jdbcFindPageInfoByName(
					"sysConfigRepository.getNodeByName", SysConfig.class, params,
					pageNumber, pageSize);
		}
		return pageInfo;
	}

	@Override
	public RetVo saveSysConfig(SysConfig sysConfig) {
		RetVo retVo = new RetVo(true);
		int result = 0;
		if (StringUtils.isNullOrEmpty(sysConfig.getConfId())){
			try {
				SysConfig sysConfig2 = new SysConfig(true);
				BeanUtils.applyIf(sysConfig2, sysConfig,false);
				result = sysConfigRepository.insert(sysConfig2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			SysConfig oldsysConfig = sysConfigRepository.getById(sysConfig
					.getConfId());
			if (oldsysConfig != null) {
				result = sysConfigRepository.updateByPrimaryKey(sysConfig);
			}
		}
		if (result > 0) {
			return retVo;
		}
		retVo.setResult(false);
		return retVo;
	}

	@Override
	public RetVo delSysConfig(Long confId) {
		int result = 0;
		RetVo retVo = new RetVo(true);
		List<SysConfig> childNodeList = sysConfigRepository.getChildCode(confId);
		if (childNodeList != null ){
			retVo.setResult(false);
			retVo.setMsgTitle("次节点有存在子级节点,不能被删除!");
			return retVo;
		}
		SysConfig sysConfig = sysConfigRepository.getById(confId);
		result = sysConfigRepository.deleteByPrimaryKey(sysConfig);
		if (result > 0) {
			return retVo;
		}
		retVo.setResult(false);
		return retVo;
	}

	@Override
	public String getNameById(Long confId) {
		SysConfig oldsysConfig = sysConfigRepository.getById(confId);
		if (oldsysConfig != null) {
			return oldsysConfig.getName();
		}
		return "";
	}

}
