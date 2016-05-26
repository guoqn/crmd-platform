package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.SysTable;
import com.ffcs.crmd.platform.meta.repository.ISysTableRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("sysTableRepository")
public class SysTableRepositoryImpl extends AbstractCrmDomBaseRepository<SysTable, Long>
    implements ISysTableRepository {

    public SysTableRepositoryImpl() {
        super(SysTable.class);
    }

    @Override
    public PageInfo<SysTable> qrySysTablePage(int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        return this
            .jdbcFindPageInfoByName("sysTableRepository.qrySysTablePage", SysTable.class, params,
                pageNum, pageSize);
    }

    @Override
    public List<SysTable> getSysTableByObjId(Long busiObjId) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        return this
            .jdbcFindListByName("sysTableRepository.getSysTableByObjId", SysTable.class, params);
    }

    @Override
    public List<SysTable> getValidSysTableByObjId(Long busiObjId) {
        List<Object> params = new ArrayList<>();
        params.add(busiObjId);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        return this
            .jdbcFindListByName("sysTableRepository.getSysTableByObjIdAndStatusCd", SysTable.class, params);
    }
}
