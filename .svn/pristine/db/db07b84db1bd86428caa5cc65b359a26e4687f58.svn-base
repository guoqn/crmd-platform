package com.ffcs.crmd.platform.meta.repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.SysTable;

import java.util.List;

public interface ISysTableRepository extends ICrmDomBaseRepository<SysTable, Long> {

    PageInfo<SysTable> qrySysTablePage(int pageNum, int pageSize);

    /**
     * 根据业务对象id找到系统表
     * @param busiObjId
     * @return
     */
    List<SysTable> getSysTableByObjId(Long busiObjId);

    List<SysTable> getValidSysTableByObjId(Long busiObjId);
}
