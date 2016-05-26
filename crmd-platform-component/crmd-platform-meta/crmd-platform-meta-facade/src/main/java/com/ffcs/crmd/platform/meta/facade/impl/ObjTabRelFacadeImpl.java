package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.ObjTabRelDTO;
import com.ffcs.crmd.platform.meta.api.facade.IObjTabRelFacade;
import com.ffcs.crmd.platform.meta.entity.ObjTabRel;
import com.ffcs.crmd.platform.meta.service.IObjTabRelService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("objTabRelFacade")
public class ObjTabRelFacadeImpl extends AbstractCrmDomFacade implements IObjTabRelFacade {
    @Autowired
    IObjTabRelService objTabRelService;

    @Override
    public void add(ObjTabRelDTO dto) {
        try {
            ObjTabRel objTabRel = new ObjTabRel(true);
            BeanUtils.applyIf(objTabRel, dto, false);
            objTabRelService.save(objTabRel);
            dto.setRelId(objTabRel.getRelId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(ObjTabRelDTO dto) {
        try {
            ObjTabRel objTabRel = objTabRelService.get(dto.getRelId());
            BeanUtils.applyIf(objTabRel, dto, true);
            return objTabRelService.update(objTabRel);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }
    }

    @Override
    public int delete(ObjTabRelDTO dto) {
        try {
            ObjTabRel objTabRel = objTabRelService.get(dto.getRelId());
            return objTabRelService.remove(objTabRel);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }
    }

    @Override
    public PageInfo<ObjTabRelDTO> qryPageByTabId(Long tabId, int pageNum, int pageSize) {
        try {
            PageInfo info = objTabRelService.qryPageByTabId(tabId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), ObjTabRelDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }
}
