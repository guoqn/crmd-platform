package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiTypeDTO;
import com.ffcs.crmd.platform.meta.api.facade.IBusiTypeFacade;
import com.ffcs.crmd.platform.meta.entity.BusiType;
import com.ffcs.crmd.platform.meta.service.IBusiTypeService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiTypeFacade")
public class BusiTypeFacadeImpl extends AbstractCrmDomFacade implements IBusiTypeFacade {
    @Autowired
    IBusiTypeService busiTypeService;

    @Override
    public PageInfo<BusiTypeDTO> qrySysTypesPageByDomainId(Long domainId, int pageNum,
        int pageSize) {
        try {
            PageInfo info = busiTypeService.qrySysTypesPageByDomainId(domainId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiTypeDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }

    }

    @Override
    public void add(BusiTypeDTO dto) {
        try {
            BusiType busiType = new BusiType(true);
            BeanUtils.applyIf(busiType, dto, false);
            busiTypeService.save(busiType);
            dto.setDomainId(busiType.getDomainId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(BusiTypeDTO dto) {
        try {
            BusiType busiType = busiTypeService.get(dto.getDomainId());
            BeanUtils.applyIf(busiType, dto, true);
            return busiTypeService.update(busiType);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(BusiTypeDTO dto) {
        try {
            BusiType busiType = busiTypeService.get(dto.getDomainId());
            return busiTypeService.remove(busiType);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
