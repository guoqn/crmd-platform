package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjDTO;
import com.ffcs.crmd.platform.meta.api.facade.IBusiObjFacade;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.service.IBusiObjService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjFacade")
public class BusiObjFacadeImpl extends AbstractCrmDomFacade implements IBusiObjFacade {

    @Autowired
    IBusiObjService busiObjService;

    @Override
    public PageInfo<BusiObjDTO> qryBusiObjPageByTypeId(Long typeId, int pageNum, int pageSize) {
        try {
            PageInfo info = busiObjService.qryBusiObjPageByTypeId(typeId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiObjDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public PageInfo<BusiObjDTO> qryBusiObjPageByAObjId(Long busiObjId, int pageNum, int pageSize) {
        try {
            PageInfo info = busiObjService.qryBusiObjPageByAObjId(busiObjId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiObjDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public PageInfo<BusiObjDTO> qryBusiObjPageByZObjId(Long busiObjId, int pageNum, int pageSize) {
        try {
            PageInfo info = busiObjService.qryBusiObjPageByZObjId(busiObjId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiObjDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public PageInfo<BusiObjDTO> qryBusiObjPageByTabId(Long tabId, String objType, int pageNum,
        int pageSize) {
        try {
            PageInfo info = busiObjService.qryBusiObjPageByTabId(tabId, objType, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), BusiObjDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(BusiObjDTO dto) {
        try {
            BusiObj busiObj = new BusiObj(true);
            BeanUtils.applyIf(busiObj, dto, false);
            //添加一个业务对象，要添加业务对象与表的关系表
            if (NumberUtils.nullToLongZero(dto.getTabId()) != 0) {
                busiObjService.addBusiObj(busiObj, dto.getTabId(), MetaConstants.OBJ_TYPE.BUSY_OBJ);
            } else {
                busiObjService.save(busiObj);
            }

            dto.setBusiObjId(busiObj.getBusiObjId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(BusiObjDTO dto) {
        try {
            BusiObj busiObj = busiObjService.get(dto.getBusiObjId());
            BeanUtils.applyIf(busiObj, dto, true);
            return busiObjService.update(busiObj);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(BusiObjDTO dto) {
        try {
            BusiObj busiObj = busiObjService.get(dto.getBusiObjId());
            return busiObjService.remove(busiObj);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
