package com.ffcs.crmd.platform.meta.api.vo;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

import java.sql.Timestamp;

public class BusiObjVo extends ConditionVo {

    /**
     * 记录业务对象主键
     */
    private Long busiObjId;

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
     * 记录业务大类主键
     */
    private Long busiTypeId;

    /**
     * 记录业务对象描述
     */
    private String busiObjDesc;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 记录业务对象编码
     */
    private String busiObjNbr;

    /**
     * 记录业务对象名称
     */
    private String busiObjName;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     * 记录父级业务对象标识
     */
    private Long parBusiObjId;

    public void setBusiObjId(Long busiObjId) {
        this.busiObjId = busiObjId;
    }

    public Long getBusiObjId() {
        return this.busiObjId;
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

    public void setBusiTypeId(Long busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    public Long getBusiTypeId() {
        return this.busiTypeId;
    }

    public void setBusiObjDesc(String busiObjDesc) {
        this.busiObjDesc = busiObjDesc;
    }

    public String getBusiObjDesc() {
        return this.busiObjDesc;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setBusiObjNbr(String busiObjNbr) {
        this.busiObjNbr = busiObjNbr;
    }

    public String getBusiObjNbr() {
        return this.busiObjNbr;
    }

    public void setBusiObjName(String busiObjName) {
        this.busiObjName = busiObjName;
    }

    public String getBusiObjName() {
        return this.busiObjName;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setParBusiObjId(Long parBusiObjId) {
        this.parBusiObjId = parBusiObjId;
    }

    public Long getParBusiObjId() {
        return this.parBusiObjId;
    }

}
