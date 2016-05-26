package com.ffcs.crmd.platform.idempotency.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkSheet;
import com.ffcs.crmd.platform.idempotency.core.repository.ISysWorkSheetRepository;

@Repository("sysWorkSheetRepository")
public class SysWorkSheetRepositoryImpl extends AbstractCrmDomBaseRepository<SysWorkSheet, Long>
    implements ISysWorkSheetRepository {
    
    public SysWorkSheetRepositoryImpl() {
        super(SysWorkSheet.class);
    }
    
    @Override
    public SysWorkSheet getSysWorkSheetBySheetCd(String sheetCd) {
        List<Object> params = new ArrayList<Object>();
        params.add(sheetCd);
        List<SysWorkSheet> list = this.jdbcFindListByName(
            "sysWorkSheetRepository.getWorkSheetBySheetCd", SysWorkSheet.class, params);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
}
