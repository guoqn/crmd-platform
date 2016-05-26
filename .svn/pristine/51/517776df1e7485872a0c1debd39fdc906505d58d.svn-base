package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.BusiObjAttrValue;
import com.ffcs.crmd.platform.meta.repository.IBusiObjAttrValueRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("busiObjAttrValueRepository")
public class BusiObjAttrValueRepositoryImpl
    extends AbstractCrmDomBaseRepository<BusiObjAttrValue, Long>
    implements IBusiObjAttrValueRepository {

    public BusiObjAttrValueRepositoryImpl() {
        super(BusiObjAttrValue.class);
    }

    @Override
    public PageInfo<BusiObjAttrValue> qryBusiObjAttrValPageByBusiObjAttrId(Long busiObjAttrId,
        int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjAttrId);
        return this.jdbcFindPageInfoByName(
            "busiObjAttrValueRepository.qryBusiObjAttrValPageByBusiObjAttrId",
            BusiObjAttrValue.class, params, pageNum, pageSize);
    }

    @Override
    public List<BusiObjAttrValue> qryBusiObjAttrValuesByBusiObjAttrId(Long busiObjAttrId) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjAttrId);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        return this
            .jdbcFindListByName("busiObjAttrValueRepository.qryBusiObjAttrValByBusiObjAttrIdAndStatusCd",
                BusiObjAttrValue.class, params);
    }
}
