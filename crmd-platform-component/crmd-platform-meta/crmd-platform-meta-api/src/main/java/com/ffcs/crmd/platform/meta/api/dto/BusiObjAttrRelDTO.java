package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

import java.sql.Timestamp;

/**
 * @author FFCS-CAIWL
 */
public class BusiObjAttrRelDTO extends DomBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;

    /**
     * 属性关系ID
     */
    private Long attrSpecRelId;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    private Timestamp recUpdateDate;

    /**
     * 描述记录所属的C4区域标识
     */
    private Long regionCd;

    /**
     * 描述记录的分片键
     */
    private Long shardingId;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 记录业务对象属性主键
     */
    private Long busBusiObjAttrId;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     * 记录业务对象属性主键
     */
    private Long busiObjAttrId;

    public void setAttrSpecRelId(Long attrSpecRelId) {
        this.attrSpecRelId = attrSpecRelId;
    }

    public Long getAttrSpecRelId() {
        return this.attrSpecRelId;
    }

    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setBusBusiObjAttrId(Long busBusiObjAttrId) {
        this.busBusiObjAttrId = busBusiObjAttrId;
    }

    public Long getBusBusiObjAttrId() {
        return this.busBusiObjAttrId;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setBusiObjAttrId(Long busiObjAttrId) {
        this.busiObjAttrId = busiObjAttrId;
    }

    public Long getBusiObjAttrId() {
        return this.busiObjAttrId;
    }

}
