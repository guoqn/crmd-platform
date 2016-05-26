package com.ffcs.crmd.platform.ddl.api;

import java.util.List;

public interface ICrmSeqService {
    /**
     * 
     * 方法功能:
     * 获取全局序列值 .
     * @param seqName
     * @return
     * @author: linzq
     * @修改记录： 
     * ==============================================================<br>
     * 日期:2015年10月23日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public Long getSeq(String seqName);
    
    /**
     * 
     * 方法功能:
     *  获取多个序列值.
     * @param seqName
     * @param size
     * @return
     * @author: linzq
     * @修改记录： 
     * ==============================================================<br>
     * 日期:2015年10月23日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public List<Long> getSeqBatch(String seqName,int size);
}
