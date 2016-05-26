package com.ffcs.crmd.platform.meta.api.facade;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysTableDTO;

public interface ISysTableFacade extends ICrmBaseFacade {

    /**
     * 分页查询系统表
     * @param pageNum 当前页面
     * @param pageSize 最大值
     * @return
     */
    PageInfo<SysTableDTO> qrySysTablePage(int pageNum, int pageSize);

    /**
     * 得到系统表详细信息
     * @param tabId
     * @return
     */
    SysTableDTO getSysTableByTabId(Long tabId, boolean getSysTableByTabId);

    /**
     * 新增
     * @param dto
     */
    void add(SysTableDTO dto);

    /**
     * 修改
     * @param dto
     * @return
     */
    int update(SysTableDTO dto);

    /**
     * 删除
     * @param dto
     * @return
     */
    int delete(SysTableDTO dto);

    /**
     * 根据业务对象id找到系统表
     * @param busiObjId
     * @return
     */
    SysTableDTO getSysTableByObjId(Long busiObjId);
}
