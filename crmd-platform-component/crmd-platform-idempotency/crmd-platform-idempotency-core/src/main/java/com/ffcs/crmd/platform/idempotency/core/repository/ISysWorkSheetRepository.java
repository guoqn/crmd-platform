package com.ffcs.crmd.platform.idempotency.core.repository;

import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.idempotency.core.entity.SysWorkSheet;

public interface ISysWorkSheetRepository extends ICrmDomBaseRepository<SysWorkSheet, Long> {
    
    /**
     * 
     * 根据事务事件集编码获取事务事件集.
     * 
     * @param sheetCd
     * @return
     * @author chenye
     */
    public SysWorkSheet getSysWorkSheetBySheetCd(String sheetCd);
    
}
