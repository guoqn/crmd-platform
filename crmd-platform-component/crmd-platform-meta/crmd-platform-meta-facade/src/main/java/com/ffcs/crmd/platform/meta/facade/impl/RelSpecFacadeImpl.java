package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.RelSpecDTO;
import com.ffcs.crmd.platform.meta.api.facade.IRelSpecFacade;
import com.ffcs.crmd.platform.meta.entity.RelSpec;
import com.ffcs.crmd.platform.meta.service.IRelSpecService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("relSpecFacade")
public class RelSpecFacadeImpl extends AbstractCrmDomFacade implements IRelSpecFacade {
    @Autowired
    IRelSpecService relSpecService;

    @Override
    public void add(RelSpecDTO dto) {
        try {
            RelSpec relSpec = new RelSpec(true);
            BeanUtils.applyIf(relSpec, dto, false);
            relSpecService.save(relSpec);
            dto.setRelSpecId(relSpec.getRelSpecId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(RelSpecDTO dto) {
        try {
            RelSpec relSpec = relSpecService.get(dto.getRelSpecId());
            BeanUtils.applyIf(dto, relSpec, true);
            return relSpecService.update(relSpec);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }

    }

    @Override
    public int delete(RelSpecDTO dto) {
        try {
            RelSpec relSpec = relSpecService.get(dto.getRelSpecId());
            return relSpecService.remove(relSpec);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }
    }

    @Override
    public PageInfo<RelSpecDTO> qryPageByAObjId(Long busiObjId, int pageNum, int pageSize) {
        try {
            PageInfo page = relSpecService.qryPageByAObjId(busiObjId, pageNum, pageSize);
            page.setList(BeanUtils.copyList(page.getList(), RelSpecDTO.class));
            return page;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public PageInfo<RelSpecDTO> qryPageByZObjId(Long busiObjId, int pageNum, int pageSize) {
        try {
            PageInfo page = relSpecService.qryPageByZObjId(busiObjId, pageNum, pageSize);
            page.setList(BeanUtils.copyList(page.getList(), RelSpecDTO.class));
            return page;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }
}
