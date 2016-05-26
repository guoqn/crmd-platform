package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysColumnDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysColumnFacade;
import com.ffcs.crmd.platform.meta.entity.SysColumn;
import com.ffcs.crmd.platform.meta.service.ISysColumnService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysColumnFacade")
public class SysColumnFacadeImpl extends AbstractCrmDomFacade implements ISysColumnFacade {

    @Autowired
    ISysColumnService sysColumnService;

    @Override
    public List<SysColumnDTO> qrySysColumnsListByTabId(Long tabId) {
        try {
            List<SysColumnDTO> list = BeanUtils
                .copyList(sysColumnService.qrySysColumnsListByTabId(tabId), SysColumnDTO.class);
            return list;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public PageInfo<SysColumnDTO> qrySysColumnsPageByTabId(Long tabId, int pageNum, int pageSize) {
        try {
            PageInfo info = sysColumnService.qrySysColumnsPageByTabId(tabId, pageNum, pageSize);
            info.setList(BeanUtils.copyList(info.getList(), SysColumnDTO.class));
            return info;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
            return null;
        }
    }

    @Override
    public void add(SysColumnDTO dto) {
        try {
            SysColumn sysColumn = new SysColumn(true);
            BeanUtils.applyIf(sysColumn, dto, false);
            sysColumnService.save(sysColumn);
            dto.setColId(sysColumn.getColId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(SysColumnDTO dto) {
        try {
            SysColumn sysColumn = sysColumnService.get(dto.getColId());
            BeanUtils.applyIf(sysColumn, dto, true);
            return sysColumnService.update(sysColumn);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(SysColumnDTO dto) {
        try {
            SysColumn sysColumn = sysColumnService.get(dto.getColId());
            return sysColumnService.remove(sysColumn);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

}
