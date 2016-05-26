package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.RelSpecAttrDTO;
import com.ffcs.crmd.platform.meta.api.facade.IRelSpecAttrFacade;
import com.ffcs.crmd.platform.meta.entity.RelSpecAttr;
import com.ffcs.crmd.platform.meta.service.IRelSpecAttrService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("relSpecAttrFacade")
public class RelSpecAttrFacadeImpl extends AbstractCrmDomFacade implements IRelSpecAttrFacade {
    @Autowired
    IRelSpecAttrService relSpecAttrService;

    @Override
    public void add(RelSpecAttrDTO dto) {
        try {
            RelSpecAttr relSpecAttr = new RelSpecAttr(true);
            BeanUtils.applyIf(relSpecAttr, dto, false);
            relSpecAttrService.save(relSpecAttr);
            dto.setRelSpecAttrId(relSpecAttr.getRelSpecAttrId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(RelSpecAttrDTO dto) {
        try {
            RelSpecAttr relSpecAttr = relSpecAttrService.get(dto.getRelSpecAttrId());
            BeanUtils.applyIf(dto, relSpecAttr, true);
            return relSpecAttrService.update(relSpecAttr);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }

    }

    @Override
    public int delete(RelSpecAttrDTO dto) {
        try {
            RelSpecAttr relSpecAttr = relSpecAttrService.get(dto.getRelSpecAttrId());
            return relSpecAttrService.remove(relSpecAttr);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }
    }

    @Override
    public PageInfo qryPageByRelSpecId(Long relSpecId, int pageNum, int pageSize) {
        try {
            PageInfo page = relSpecAttrService.qryPageByRelSpecId(relSpecId, pageNum, pageSize);
            page.setList(BeanUtils.copyList(page.getList(), RelSpecAttrDTO.class));
            return page;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public PageInfo qryPageByAttrId(Long attrId, int pageNum, int pageSize) {
        try {
            PageInfo page = relSpecAttrService.qryPageByAttrId(attrId, pageNum, pageSize);
            page.setList(BeanUtils.copyList(page.getList(), RelSpecAttrDTO.class));
            return page;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }
}
