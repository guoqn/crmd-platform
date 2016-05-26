package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.entity.ObjTabRel;
import com.ffcs.crmd.platform.meta.repository.IBusiObjRepository;
import com.ffcs.crmd.platform.meta.service.IBusiObjService;
import com.ffcs.crmd.platform.meta.service.IObjTabRelService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("busiObjService")
public class BusiObjServiceImpl extends AbstractCrmDomGenericService<BusiObj, Long>
    implements IBusiObjService {

    @Autowired
    IBusiObjRepository busiObjRepository;

    @Autowired
    IObjTabRelService objTabRelService;

    @Override
    public PageInfo<BusiObj> qryBusiObjPageByTypeId(Long typeId, int pageNum, int pageSize) {
        return BusiObj.repository().qryBusiObjPageByTypeId(typeId, pageNum, pageSize);
    }

    @Override
    public PageInfo qryBusiObjPageByAObjId(Long busiObjId, int pageNum, int pageSize) {
        return BusiObj.repository().qryBusiObjPageByAObjId(busiObjId, pageNum, pageSize);
    }

    @Override
    public PageInfo qryBusiObjPageByZObjId(Long busiObjId, int pageNum, int pageSize) {
        return BusiObj.repository().qryBusiObjPageByZObjId(busiObjId, pageNum, pageSize);
    }

    @Override
    public void addBusiObj(BusiObj busiObj, Long tabId, String objType) {
        try {
            this.save(busiObj);
            //添加系统表和业务对象的关系
            ObjTabRel objTabRel = new ObjTabRel(true);
            objTabRel.setObjId(busiObj.getBusiObjId());
            objTabRel.setTabId(tabId);
            objTabRel.setObjType(objType);
            objTabRelService.save(objTabRel);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }

    }

    @Override
    public PageInfo<BusiObj> qryBusiObjPageByTabId(Long tabId, String objType, int pageNum,
        int pageSize) {
        return BusiObj.repository().qryBusiObjPageByTabId(tabId, objType, pageNum, pageSize);
    }
}
