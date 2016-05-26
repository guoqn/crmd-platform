package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.SysColumn;
import com.ffcs.crmd.platform.meta.repository.ISysColumnRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("sysColumnRepository")
public class SysColumnRepositoryImpl extends AbstractCrmDomBaseRepository<SysColumn, Long>
    implements ISysColumnRepository {

    public SysColumnRepositoryImpl() {
        super(SysColumn.class);
    }

    @Override
    public List<SysColumn> qrySysColumnsListByTabId(Long tabId) {
        List<Object> params = new ArrayList<>();
        params.add(tabId);
        return this.jdbcFindListByName("sysColumnRepository.qrySysColumnPageByTabId", SysColumn.class, params);
    }

    @Override
    public PageInfo<SysColumn> qrySysColumnsPageByTabId(Long tabId, int pageNum, int pageSize) {
        List<Object> params = new ArrayList<>();
        params.add(tabId);
        return this.jdbcFindPageInfoByName("sysColumnRepository.qrySysColumnPageByTabId", SysColumn.class, params, pageNum, pageSize);
    }

    @Override
    public List<SysColumn> qrySysColumnsListByTabIdAndStatusCd(Long tabId) {
        List<Object> params = new ArrayList<>();
        params.add(tabId);
        params.add(MetaConstants.STATUS.META_STATUS_VALID);
        return this.jdbcFindListByName("sysColumnRepository.qrySysColumnsByTabIdAndStatusCd", SysColumn.class, params);
    }
}
