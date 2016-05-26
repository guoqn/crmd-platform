package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicStyle;
import com.ffcs.crmd.platform.meta.repository.IDynamicStyleRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicStyleService;

@Service("dynamicStyleService")
public class DynamicStyleServiceImpl extends AbstractCrmDomGenericService<DynamicStyle, Long>
		implements IDynamicStyleService {

	@Autowired
	IDynamicStyleRepository dynamicStyleRepository;

	@Override
	public List<DynamicStyle> qryThemeStyles() {
		return dynamicStyleRepository.qryThemeStyles();
	}

	@Override
	public List<DynamicStyle> qryChildStylesByPId(Long pId) {
		return dynamicStyleRepository.qryChildStylesByPId(pId);
	}

	@Override
	public int qryCountByPId(Long pId) {
		return dynamicStyleRepository.qryCountByPId(pId);
	}

	@Override
	public int insertDyStyle(DynamicStyle style) {
		return this.save(style);
	}

	@Override
	public int updateDyStyle(DynamicStyle style) {
		return this.update(style);
	}

	@Override
	public int deleteDyStyle(Long id) {
		DynamicStyle style = this.get(id);
		if (style != null) {
			return this.remove(style);
		}
		return 0;
	}

	@Override
	public List<DynamicStyle> qryAllStyleTreeData() {
		return dynamicStyleRepository.qryAllStyleTreeData();
	}

	@Override
	public void batchInsertStyle(List<DynamicStyle> styles) {
		if (styles != null && styles.size() > 0) {
			for (DynamicStyle style : styles) {
				style.setStatusCd("1000");
				insertDyStyle(style);
			}
		}

	}

	@Override
	public void batchDelSyles(List<Long> ids) {
		if (ids != null && ids.size() > 0) {
			for (Long id : ids) {
				deleteDyStyle(id);
			}
		}

	}

	@Override
	public List<DynamicStyle> qryStylesByComponentId(Long componentId) {
		return dynamicStyleRepository.qryStylesByComponentId(componentId);
	}

}
