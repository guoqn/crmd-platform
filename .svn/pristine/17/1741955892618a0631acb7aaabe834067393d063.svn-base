package com.ffcs.crmd.platform.meta.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.entity.SysConfig;
import com.ffcs.crmd.platform.meta.repository.ISysConfigRepository;

@Repository("sysConfigRepository")
public class SysConfigRepositoryImpl extends AbstractCrmDomBaseRepository<SysConfig, Long>
        implements ISysConfigRepository {

    /**
     * 默认构造函数
     */
    public SysConfigRepositoryImpl() {
        super(SysConfig.class);
    }

    @Override
    public PageInfo<SysConfig> qrySysConfig(int pageNumber,int pageSize) {
        PageInfo<SysConfig> pageInfo = new PageInfo<SysConfig>();
        pageInfo = this.jdbcFindPageInfoByName("sysConfigRepository.qrySysConfigAll", SysConfig.class, pageNumber, pageSize);
        return pageInfo;
    }

    @Override
    public List<SysConfig> getNodeByCode(String code) {
        List<SysConfig> list = new ArrayList<SysConfig>();
        List<Object> listParams = new ArrayList<Object>();
        listParams.add(code);
        list = this.jdbcFindListByName("sysConfigRepository.getNodeByCode", SysConfig.class, listParams);
        return list;
    }

	@Override
	public List<SysConfig> getChildCode(Long parentId) {
        List<SysConfig> list = new ArrayList<SysConfig>();
        List<Object> listParams = new ArrayList<Object>();
        listParams.add(parentId);
        list = this.jdbcFindListByName("sysConfigRepository.qrySysConfigByParentId", SysConfig.class, listParams);
        if (list != null && list.size() >0) {
            return list;
        }
        return null;
	}

}
