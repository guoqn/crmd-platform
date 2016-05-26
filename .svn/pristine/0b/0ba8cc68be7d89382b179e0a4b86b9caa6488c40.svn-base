package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysColumn;
import com.ffcs.crmd.platform.meta.repository.ISysColumnRepository;
import com.ffcs.crmd.platform.meta.service.ISysColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sysColumnService")
public class SysColumnServiceImpl extends AbstractCrmDomGenericService<SysColumn, Long>
    implements ISysColumnService {

    @Autowired
    private ISysColumnRepository sysColumnRepository;

    @Override
    public List<SysColumn> qrySysColumnsListByTabId(Long tabId) {
        List<SysColumn> list = SysColumn.repository().qrySysColumnsListByTabId(tabId);
        if (list == null) {
            list = new ArrayList<SysColumn>();
        }
        return list;
    }

    @Override
    public PageInfo<SysColumn> qrySysColumnsPageByTabId(Long tabId, int pageNum, int pageSize) {
        return SysColumn.repository().qrySysColumnsPageByTabId(tabId, pageNum, pageSize);
    }

}
