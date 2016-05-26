package com.ffcs.crmd.platform.meta.api.vo;

import java.io.Serializable;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

public class SysConfigVo extends ConditionVo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7066848235652378642L;
    private Long confId;
    private String name;
    private Long parentId;
    private String nodeValue;
    private String code;
    private String sysConfDesc;
    private Integer pageNumber;
    private Integer pageSize;
    private String sortOrder;
    private String cachePath;
    private String switchPath;
    private String samplingPath;

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getConfId() {
        return confId;
    }

    public void setConfId(Long confId) {
        this.confId = confId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSysConfDesc() {
        return sysConfDesc;
    }

    public void setSysConfDesc(String sysConfDesc) {
        this.sysConfDesc = sysConfDesc;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCachePath() {
        return cachePath;
    }

    public void setCachePath(String cachePath) {
        this.cachePath = cachePath;
    }

    public String getSwitchPath() {
        return switchPath;
    }

    public void setSwitchPath(String switchPath) {
        this.switchPath = switchPath;
    }

    public String getSamplingPath() {
        return samplingPath;
    }

    public void setSamplingPath(String samplingPath) {
        this.samplingPath = samplingPath;
    }
}
