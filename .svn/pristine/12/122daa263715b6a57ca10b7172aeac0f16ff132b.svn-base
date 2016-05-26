package com.ffcs.crmd.platform.meta.repository;


import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.SysConfig;

import java.util.List;

public interface ISysConfigRepository extends ICrmDomBaseRepository<SysConfig, Long> {
    /**
     * 开关表
     *
     * @return
     */
    public PageInfo<SysConfig> qrySysConfig(int pageNumber,int pageSize);

    /**
     * 根据code获取节点
     *
     * @param code
     * @return
     */
    public List<SysConfig> getNodeByCode(String code);

    /**
     * 根据parentId 获取子节点列表
     */
    public List<SysConfig> getChildCode(Long parentId);

}
