package com.ffcs.crmd.platform.meta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicTempPartRel;
import com.ffcs.crmd.platform.meta.entity.DynamicTemplate;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;
import com.ffcs.crmd.platform.meta.repository.IDynamicTempPartRelRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicTemplateRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicWindowRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicTemplateService;
import com.ffcs.crmd.platform.meta.service.IDynamicWindowService;

@Service("dynamicTemplateService")
public class DynamicTemplateServiceImpl extends AbstractCrmDomGenericService<DynamicTemplate, Long>
		implements IDynamicTemplateService {

	private static final String TPL_TYPE_WIN = "wtpl";

	private static final String TPL_TYPE_PART = "ptpl";

	@Autowired
	IDynamicTemplateRepository dynamicTemplateRepository;
	@Autowired
	IDynamicWindowService windowService;
	@Autowired
	IDynamicWindowRepository winRepository;
	@Autowired
	IDynamicTempPartRelRepository tpRelRepository;

	@Override
	public PageInfo<DynamicTemplate> qryTplPageInfo(DynamicTemplate tpl, int page, int pageSize) {
		return dynamicTemplateRepository.qryTplPageInfo(tpl, page, pageSize);
	}

	@Override
	public DynamicTemplate getTplByCode(String code) {
		return dynamicTemplateRepository.getTplByCode(code);
	}

	@Override
	public void saveTpl(DynamicTemplate tpl) {
		if (!StringUtils.isNullOrEmpty(tpl.getTemplateType())) {
			switch (tpl.getTemplateType()) {
			case TPL_TYPE_WIN:
				windowService.saveTypeWindow(tpl.getTemplateId(), "tpl");
				tpl.save();
				break;
			case TPL_TYPE_PART:
				// 保存模版
				tpl.save();
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void delTpl(Long id) {
		DynamicTemplate tpl = DynamicTemplate.repository().getByIdAndShardingId(id, id);
		if (tpl != null) {
			if (!StringUtils.isNullOrEmpty(tpl.getTemplateType())) {
				switch (tpl.getTemplateType()) {
				case TPL_TYPE_WIN:
					// 删除
					DynamicWindow window = winRepository.getDynamicWindowByTplId(tpl.getTemplateId());
					windowService.deleteWindow(window.getWindowId());
					tpl.remove();
					break;
				case TPL_TYPE_PART:
					// 删除
					List<DynamicTempPartRel> rels = tpRelRepository.qryTplPartRels(id);
					if (rels != null && rels.size() > 0) {
						for (DynamicTempPartRel rel : rels) {
							rel.remove();
						}
					}
					tpl.remove();
					break;
				default:
					break;
				}
			}
		}
	}
}
