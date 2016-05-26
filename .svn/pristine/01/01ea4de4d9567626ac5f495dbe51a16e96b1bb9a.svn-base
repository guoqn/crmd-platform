package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjAttrValueDTO;
import com.ffcs.crmd.platform.meta.api.facade.IBusiObjAttrValueFacade;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttrValue;
import com.ffcs.crmd.platform.meta.service.IBusiObjAttrValueService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjAttrValueFacade")
public class BusiObjAttrValueFacadeImpl extends AbstractCrmDomFacade
    implements IBusiObjAttrValueFacade {

    @Autowired
    IBusiObjAttrValueService busiObjAttrValueService;

    @Override
    public PageInfo<BusiObjAttrValueDTO> qryBusiObjAttrValPageByBusiObjAttrId(Long busiObjAttrId,
        int pageNum, int pageSize) {
        try {
            PageInfo info = busiObjAttrValueService
                .qryBusiObjAttrValPageByBusiObjAttrId(busiObjAttrId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiObjAttrValueDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(BusiObjAttrValueDTO dto) {
        try {
            BusiObjAttrValue busiObjAttrValue = new BusiObjAttrValue(true);
            BeanUtils.applyIf(busiObjAttrValue, dto, false);
            busiObjAttrValueService.save(busiObjAttrValue);
            dto.setBusiObjAttrId(busiObjAttrValue.getBusiObjAttrId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(BusiObjAttrValueDTO dto) {
        try {
            BusiObjAttrValue busiObjAttrValue = busiObjAttrValueService.get(dto.getBusiObjAttrId());
            BeanUtils.applyIf(busiObjAttrValue, dto, true);
            return busiObjAttrValueService.update(busiObjAttrValue);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(BusiObjAttrValueDTO dto) {
        try {
            BusiObjAttrValue busiObjAttrValue = busiObjAttrValueService.get(dto.getBusiObjAttrId());
            return busiObjAttrValueService.remove(busiObjAttrValue);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
