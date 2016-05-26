package com.ffcs.crmd.platform.meta.facade.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.core.ddd.facade.impl.AbstractCrmDomFacade;
import com.ffcs.crmd.platform.meta.api.dto.SysDomainDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysDomainFacade;
import com.ffcs.crmd.platform.meta.entity.SysDomain;
import com.ffcs.crmd.platform.meta.service.ISysDomainService;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDomainFacade")
public class SysDomainFacadeImpl extends AbstractCrmDomFacade implements ISysDomainFacade {
    @Autowired
    ISysDomainService sysDomainService;

    @Override
    public void add(SysDomainDTO dto) {
        try {
            SysDomain SysDomain = new SysDomain(true);
            BeanUtils.applyIf(SysDomain, dto, false);
            sysDomainService.save(SysDomain);
            dto.setDomainId(SysDomain.getDomainId());
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
    }

    @Override
    public int update(SysDomainDTO dto) {
        try {
            SysDomain sysDomain = sysDomainService.get(dto.getDomainId());
            BeanUtils.applyIf(sysDomain, dto, true);
            return sysDomainService.update(sysDomain);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public int delete(SysDomainDTO dto) {
        try {
            SysDomain sysDomain = sysDomainService.get(dto.getDomainId());
            return sysDomainService.remove(sysDomain);
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return 0;
    }

    @Override
    public PageInfo<SysDomainDTO> qrySysDomainPage(int pageNum, int pageSize) {
        try {
            PageInfo sysTablePageInfo = sysDomainService.qrySysTablePage(pageNum, pageSize);
            List<SysDomainDTO> list = BeanUtils
                .copyList(sysTablePageInfo.getList(), SysDomainDTO.class);
            sysTablePageInfo.setList(list);
            return sysTablePageInfo;
        } catch (Exception e) {
            ExceptionUtils.transEx(e);
        }
        return null;
    }
}
