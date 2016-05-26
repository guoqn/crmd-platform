package com.ffcs.crmd.platform.meta.service.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.impl.AbstractCrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysTable;
import com.ffcs.crmd.platform.meta.service.ISysTableService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sysTableService")
public class SysTableServiceImpl extends AbstractCrmDomGenericService<SysTable, Long>
    implements ISysTableService {

    @Override
    public PageInfo<SysTable> qrySysTablePage(int pageNum, int pageSize) {
        return SysTable.repository().qrySysTablePage(pageNum, pageSize);
    }

    @Override
    public SysTable getSysTableByObjId(Long busiObjId) {
        List<SysTable> list = SysTable.repository().getSysTableByObjId(busiObjId);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
