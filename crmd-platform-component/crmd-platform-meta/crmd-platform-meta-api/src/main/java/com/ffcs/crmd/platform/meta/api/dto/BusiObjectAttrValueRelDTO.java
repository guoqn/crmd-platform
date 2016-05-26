package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

import java.sql.Timestamp;

/**
 * @author FFCS-CAIWL
 */
public class BusiObjectAttrValueRelDTO extends DomBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;

    /**
     * 属性值关系ID
     */
    private Long valueRelaId;

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
     * A端属性值ID
     */
    private Long relaAttrValueId;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     * 属性值之间互斥、依赖关系。
     */
    private String attrRelaType;

    /**
     * Z端属性值ID
     */
    private Long relatedAttrValueId;

    public void setValueRelaId(Long valueRelaId) {
        this.valueRelaId = valueRelaId;
    }

    public Long getValueRelaId() {
        return this.valueRelaId;
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

    public void setRelaAttrValueId(Long relaAttrValueId) {
        this.relaAttrValueId = relaAttrValueId;
    }

    public Long getRelaAttrValueId() {
        return this.relaAttrValueId;
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

    public void setAttrRelaType(String attrRelaType) {
        this.attrRelaType = attrRelaType;
    }

    public String getAttrRelaType() {
        return this.attrRelaType;
    }

    public void setRelatedAttrValueId(Long relatedAttrValueId) {
        this.relatedAttrValueId = relatedAttrValueId;
    }

    public Long getRelatedAttrValueId() {
        return this.relatedAttrValueId;
    }

}
