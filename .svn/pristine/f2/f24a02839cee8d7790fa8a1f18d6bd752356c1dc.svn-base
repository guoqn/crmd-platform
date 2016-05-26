package com.ffcs.crmd.platform.meta.service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;
import com.ffcs.crmd.platform.meta.entity.SysTable;

public interface ISysTableService extends ICrmDomGenericService<SysTable, Long> {

    /**
     * 分页查询系统表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SysTable> qrySysTablePage(int pageNum, int pageSize);

    /**
     * 根据业务对象id找到表
     * @param busiObjId
     * @return
     */
    SysTable getSysTableByObjId(Long busiObjId);
}
