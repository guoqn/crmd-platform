package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysColumnDTO;
import com.ffcs.crmd.platform.meta.api.dto.SysTableDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysTableFacade;
import com.ffcs.crmd.platform.meta.entity.SysColumn;
import com.ffcs.crmd.platform.meta.entity.SysTable;
import com.ffcs.crmd.platform.meta.service.ISysTableService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysTableFacade")
public class SysTableFacadeImpl extends AbstractCrmDomFacade implements ISysTableFacade {
    @Autowired
    ISysTableService sysTableService;

    @Override
    public PageInfo<SysTableDTO> qrySysTablePage(int pageNum, int pageSize) {
        try {
            PageInfo sysTablePageInfo = sysTableService.qrySysTablePage(pageNum, pageSize);
            List<SysTableDTO> list = BeanUtils
                .copyList(sysTablePageInfo.getList(), SysTableDTO.class);
            sysTablePageInfo.setList(list);
            return sysTablePageInfo;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public SysTableDTO getSysTableByTabId(Long tabId, boolean allColumns) {
        try {
            SysTable tab = sysTableService.get(tabId);
            SysTableDTO dto = new SysTableDTO();
            BeanUtils.applyIf(dto, tab);
            if (allColumns) {
                List<SysColumn> sysColumns = tab.getSysColumns();
                dto.setSysColumnDTOList(BeanUtils.copyList(sysColumns, SysColumnDTO.class));
            }
            return dto;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(SysTableDTO dto) {
        try {
            SysTable table = new SysTable(true);
            BeanUtils.applyIf(table, dto, false);
            sysTableService.save(table);
            dto.setTabId(table.getTabId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(SysTableDTO dto) {
        try {
            SysTable table = sysTableService.get(dto.getTabId());
            BeanUtils.applyIf(table, dto, true);
            return sysTableService.update(table);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }
    }

    @Override
    public int delete(SysTableDTO dto) {
        try {
            SysTable table = sysTableService.get(dto.getTabId());
            return sysTableService.remove(table);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return 0;
        }
    }

    @Override
    public SysTableDTO getSysTableByObjId(Long busiObjId) {
        try {
            SysTable table = sysTableService.getSysTableByObjId(busiObjId);
            SysTableDTO rtDto = new SysTableDTO();
            BeanUtils.applyIf(table, rtDto, true);
            return rtDto;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }
}
