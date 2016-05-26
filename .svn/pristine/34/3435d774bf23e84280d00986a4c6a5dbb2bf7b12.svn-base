package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.BusiObj;
import com.ffcs.crmd.platform.meta.repository.IBusiObjRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("busiObjRepository")
public class BusiObjRepositoryImpl extends AbstractCrmDomBaseRepository<BusiObj, Long>
    implements IBusiObjRepository {

    public BusiObjRepositoryImpl() {
        super(BusiObj.class);
    }

    @Override
    public PageInfo<BusiObj> qryBusiObjPageByTypeId(Long typeId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(typeId);
        return this
            .jdbcFindPageInfoByName("busiObjRepository.qryBusiObjPageByTypeId", BusiObj.class,
                params, pageNum, pageSize);
    }

    @Override
    public PageInfo<BusiObj> qryBusiObjPageByAObjId(Long busiObjId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        return this
            .jdbcFindPageInfoByName("busiObjRepository.qryBusiObjPageByAObjId", BusiObj.class,
                params, pageNum, pageSize);
    }

    @Override
    public PageInfo<BusiObj> qryBusiObjPageByZObjId(Long busiObjId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        return this
            .jdbcFindPageInfoByName("busiObjRepository.qryBusiObjPageByZObjId", BusiObj.class,
                params, pageNum, pageSize);
    }

    @Override
    public PageInfo<BusiObj> qryBusiObjPageByTabId(Long tabId, String objType, int pageNum,
        int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(objType);
        params.add(tabId);
        return this.jdbcFindPageInfoByName("busiObjRepository.qryBusiObjPageByTabId", BusiObj.class,
            params, pageNum, pageSize);
    }

    @Override
    public List<BusiObj> queryBusiObjByTypeId(Long typeId) {
        List<Object> params = new ArrayList<Object>();
        params.add(typeId);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        List<BusiObj> res = this
            .jdbcFindListByName("busiObjRepository.qryBusiObjByTypeIdAndStatusCd", BusiObj.class,
                params);
        return res;
    }

    @Override
    public List<BusiObj> queryBusiObjByBusiObjNbrAndStatusCd(String busiObjNbr) {
        List<Object> params = new ArrayList<Object>();
        params.add(busiObjNbr);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        List<BusiObj> res = this
            .jdbcFindListByName("busiObjRepository.qryBusiObjByBusiObjNbrAndStatusCd",
                BusiObj.class, params);
        return res;
    }

}
