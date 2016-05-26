package com.ffcs.crmd.platform.meta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.DynamicPart;
import com.ffcs.crmd.platform.meta.entity.DynamicPartWinRel;
import com.ffcs.crmd.platform.meta.entity.DynamicWindow;
import com.ffcs.crmd.platform.meta.repository.IDynamicPartRepository;
import com.ffcs.crmd.platform.meta.repository.IDynamicPartWinRelRepository;
import com.ffcs.crmd.platform.meta.service.IDynamicPartService;
import com.ffcs.crmd.platform.meta.service.IDynamicWindowService;

@Service("dynamicPartService")
public class DynamicPartServiceImpl extends AbstractCrmDomGenericService<DynamicPart, Long>
		implements IDynamicPartService {

	@Autowired
	IDynamicPartRepository dynamicPartRepository;

	@Autowired
	IDynamicWindowService windowService;

	@Autowired
	IDynamicPartWinRelRepository winRelReponsitory;

	@Override
	public List<DynamicPart> qryParts() {
		return dynamicPartRepository.qryParts();
	}

	@Override
	public PageInfo<DynamicPart> qryPageInfoPart(DynamicPart part, int page, int pageSize) {
		return dynamicPartRepository.qryPageInfoPart(part, page, pageSize);
	}

	@Override
	public void savePart(DynamicPart part) {
		DynamicWindow window = windowService.saveTypeWindow(0L, "part");
		if (window != null) {
			// 构件保存
			part.save();
			DynamicPartWinRel rel = new DynamicPartWinRel(true);
			rel.setPartId(part.getPartId());
			rel.setWindowId(window.getWindowId());
			rel.setShardingId(part.getPartId());
			rel.setStatusCd("1000");
			// 关联保存
			rel.save();
		}

	}

	@Override
	public void deletePart(Long partId) {
		List<DynamicPartWinRel> rels = winRelReponsitory.qryRelsByPartId(partId);
		if (rels != null && rels.size() > 0) {
			for (DynamicPartWinRel rel : rels) {
				// 关联
				rel.remove();
				// 窗体
				windowService.deleteWindow(rel.getWindowId());
			}
			DynamicPart p = dynamicPartRepository.getById(partId);
			if (p != null) {
				// 构件
				p.remove();
			}
		}

	}

	@Override
	public List<DynamicWindow> qryWindowByPartId(Long partId) {
		List<DynamicWindow> windows = null;
		List<DynamicPartWinRel> rels = winRelReponsitory.qryRelsByPartId(partId);
		if (rels != null && rels.size() > 0) {
			// 实例化
			windows = new ArrayList<DynamicWindow>();
			for (DynamicPartWinRel rel : rels) {
				DynamicWindow win = windowService.getSimpleWindow(rel.getWindowId());
				if (win != null) {
					windows.add(win);
				}
			}
		}
		return windows;
	}
}
