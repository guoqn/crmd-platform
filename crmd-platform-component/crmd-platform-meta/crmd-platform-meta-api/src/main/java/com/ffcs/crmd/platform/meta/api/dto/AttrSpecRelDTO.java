package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

import java.sql.Timestamp;

/**
 * @author FFCS-CAIWL
 */
public class AttrSpecRelDTO extends DomBaseDTO {
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
     * 业务对象属性规格业务编码
     */
    private Long attAttrId;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     * 描述属性规格与属性规则之间依赖、互斥、上下级关系
     */
    private String relationTypeCd;

    /**
     * 业务对象属性规格业务编码
     */
    private Long attrId;

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

    public void setAttAttrId(Long attAttrId) {
        this.attAttrId = attAttrId;
    }

    public Long getAttAttrId() {
        return this.attAttrId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setRelationTypeCd(String relationTypeCd) {
        this.relationTypeCd = relationTypeCd;
    }

    public String getRelationTypeCd() {
        return this.relationTypeCd;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return this.attrId;
    }

}
