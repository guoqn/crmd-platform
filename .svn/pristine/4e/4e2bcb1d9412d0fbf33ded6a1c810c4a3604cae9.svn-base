package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjAttrDTO;
import com.ffcs.crmd.platform.meta.api.facade.IBusiObjAttrFacade;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttr;
import com.ffcs.crmd.platform.meta.service.IBusiObjAttrService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjAttrFacade")
public class BusiObjAttrFacadeImpl extends AbstractCrmDomFacade implements IBusiObjAttrFacade {

    @Autowired
    IBusiObjAttrService busiObjAttrService;

    @Override
    public PageInfo<BusiObjAttrDTO> qryBusiObjAttrPageByObjId(Long busiObjId, int pageNum,
        int pageSize) {
        try {
            PageInfo info = busiObjAttrService
                .qryBusiObjAttrPageByObjId(busiObjId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiObjAttrDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(BusiObjAttrDTO dto) {
        try {
            BusiObjAttr busiObjAttr = new BusiObjAttr(true);
            BeanUtils.applyIf(busiObjAttr, dto, false);
            busiObjAttrService.save(busiObjAttr);
            dto.setBusiObjAttrId(busiObjAttr.getBusiObjAttrId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(BusiObjAttrDTO dto) {
        try {
            BusiObjAttr busiObjAttr = busiObjAttrService.get(dto.getBusiObjAttrId());
            BeanUtils.applyIf(busiObjAttr, dto, true);
            return busiObjAttrService.update(busiObjAttr);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(BusiObjAttrDTO dto) {
        try {
            BusiObjAttr busiObjAttr = busiObjAttrService.get(dto.getBusiObjAttrId());
            return busiObjAttrService.remove(busiObjAttr);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
