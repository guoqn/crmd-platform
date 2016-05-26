package com.ffcs.crmd.platform.meta.api.vo;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

import java.sql.Timestamp;

public class BusiObjAttrValueVo extends ConditionVo {

    /**
     * 记录业务对象属性值主键
     */
    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    private Timestamp recUpdateDate;

    /**
     * 描述记录所属的C4区域标识
     */
    private Long regionCd;

    /**
     * 记录适用区域标识
     */
    private Long applyRegionId;

    /**
     * 描述记录的分片键
     */
    private Long shardingId;

    /**
     * 记录属性值标识
     */
    private Long attrValueId;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 属性值关系ID
     */
    private Long valueRelaId;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     * 属性值关系ID
     */
    private Long busValueRelaId;

    /**
     * 记录业务对象属性标识
     */
    private Long busiObjAttrId;

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

    public void setApplyRegionId(Long applyRegionId) {
        this.applyRegionId = applyRegionId;
    }

    public Long getApplyRegionId() {
        return this.applyRegionId;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Long getAttrValueId() {
        return this.attrValueId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setValueRelaId(Long valueRelaId) {
        this.valueRelaId = valueRelaId;
    }

    public Long getValueRelaId() {
        return this.valueRelaId;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setBusValueRelaId(Long busValueRelaId) {
        this.busValueRelaId = busValueRelaId;
    }

    public Long getBusValueRelaId() {
        return this.busValueRelaId;
    }

    public void setBusiObjAttrId(Long busiObjAttrId) {
        this.busiObjAttrId = busiObjAttrId;
    }

    public Long getBusiObjAttrId() {
        return this.busiObjAttrId;
    }

}
