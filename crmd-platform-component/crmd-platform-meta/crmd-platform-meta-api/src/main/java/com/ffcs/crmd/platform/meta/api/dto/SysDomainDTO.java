package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

import java.sql.Timestamp;

/**
 * @author FFCS-CAIWL
 */
public class SysDomainDTO extends DomBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;

    /**
     * 记录主题域主键
     */
    private Long domainId;

    /**
     * 记录主题域名称
     */
    private String domainName;

    /**
     * 记录主题域编码
     */
    private String domainNbr;

    /**
     * 记录主题域描述
     */
    private String domainDesc;

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Long getDomainId() {
        return this.domainId;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainNbr(String domainNbr) {
        this.domainNbr = domainNbr;
    }

    public String getDomainNbr() {
        return this.domainNbr;
    }

    public void setDomainDesc(String domainDesc) {
        this.domainDesc = domainDesc;
    }

    public String getDomainDesc() {
        return this.domainDesc;
    }

}
