package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.AttrSpecDTO;
import com.ffcs.crmd.platform.meta.api.facade.IAttrSpecFacade;
import com.ffcs.crmd.platform.meta.entity.AttrSpec2;
import com.ffcs.crmd.platform.meta.service.IAttrSpecService2;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attrSpecFacade")
public class AttrSpecFacadeImpl extends AbstractCrmDomFacade implements IAttrSpecFacade {
    @Autowired
    IAttrSpecService2 attrSpecService2;

    @Override
    public PageInfo<AttrSpecDTO> qryAttrSpecPageByTypeId(Long busiTypeId, Long parAttrId,
        int pageNum, int pageSize) {
        try {
            PageInfo info = attrSpecService2
                .qryAttrSpecPageByTypeId(busiTypeId, parAttrId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), AttrSpecDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(AttrSpecDTO dto) {
        try {
            AttrSpec2 attrSpec = new AttrSpec2(true);
            BeanUtils.applyIf(attrSpec, dto, false);
            attrSpecService2.save(attrSpec);
            dto.setAttrId(attrSpec.getAttrId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(AttrSpecDTO dto) {
        try {
            AttrSpec2 attrSpec = attrSpecService2.get(dto.getAttrId());
            BeanUtils.applyIf(attrSpec, dto, true);
            return attrSpecService2.update(attrSpec);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(AttrSpecDTO dto) {
        try {
            AttrSpec2 attrSpec = attrSpecService2.get(dto.getAttrId());
            return attrSpecService2.remove(attrSpec);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
