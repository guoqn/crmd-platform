package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.AttrValueDTO;
import com.ffcs.crmd.platform.meta.api.facade.IAttrValueFacade;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;
import com.ffcs.crmd.platform.meta.service.IAttrValueService2;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attrValueFacade")
public class AttrValueFacadeImpl extends AbstractCrmDomFacade implements IAttrValueFacade {

    @Autowired
    IAttrValueService2 attrValueService2;

    @Override
    public PageInfo<AttrValueDTO> qryAttrValuePageByAttrId(Long attrId, Long parentValueId, int pageNum,
        int pageSize) {
        try {
            PageInfo info = attrValueService2
                .qryAttrValuePageByAttrId(attrId, parentValueId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), AttrValueDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(AttrValueDTO dto) {
        try {
            AttrValue2 attrValue = new AttrValue2(true);
            BeanUtils.applyIf(attrValue, dto, false);
            attrValueService2.save(attrValue);
            dto.setAttrId(attrValue.getAttrId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(AttrValueDTO dto) {
        try {
            AttrValue2 attrValue = attrValueService2.get(dto.getAttrValueId());
            BeanUtils.applyIf(attrValue, dto, true);
            return attrValueService2.update(attrValue);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(AttrValueDTO dto) {
        try {
            AttrValue2 attrValue = attrValueService2.get(dto.getAttrValueId());
            return attrValueService2.remove(attrValue);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
