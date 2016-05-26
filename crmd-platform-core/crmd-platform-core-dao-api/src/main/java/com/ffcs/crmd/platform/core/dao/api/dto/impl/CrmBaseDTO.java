package com.ffcs.crmd.platform.core.dao.api.dto.impl;

import com.ffcs.crmd.platform.core.dao.api.dto.ICrmBaseDTO;

import java.io.Serializable;
import java.sql.Timestamp;

public class CrmBaseDTO implements ICrmBaseDTO,Serializable {
    // 当前页
    private int pageNumber;
    // 分页大小
    private int pageSize;

    // 备注
    private String    remark;
    // 状态
    private String    statusCd;
    // 状态时间
    private Timestamp statusDate;
    // 创建时间
    private Timestamp createDate;
    // 更新时间
    private Timestamp updateDate;
    // 创建人
    private Long      createStaff;
    // 更新人
    private Long      updateStaff;
    //C4区域标识
    private Long      regionCd;
    //C3区域标识
    private Long      areaId;
    //删除到历史表的时间,档案表必须有，其他可选
    private Timestamp recUpdateDate;
    //分片键标识
    private Long      shardingId;
    //关联表对端的分片键,关联表必须有，其他可选
    private Long      relShardingId;
    //版本号
    private Long      dversion;
    //物理变更的时间,精确到纳秒级别
    private Long dtimestamp;

    private int page;

    private int rows;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Timestamp getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public Long getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Long getRegionCd() {
        return regionCd;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Timestamp getRecUpdateDate() {
        return recUpdateDate;
    }

    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    public Long getShardingId() {
        return shardingId;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getRelShardingId() {
        return relShardingId;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getDversion() {
        return dversion;
    }

    public void setDversion(Long dversion) {
        this.dversion = dversion;
    }

    public Long getDtimestamp() {
        return dtimestamp;
    }

    public void setDtimestamp(Long dtimestamp) {
        this.dtimestamp = dtimestamp;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
