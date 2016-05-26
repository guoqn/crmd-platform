package com.ffcs.crmd.platform.meta.api.vo;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

import java.sql.Timestamp;

public class RelSpecAttrVo extends ConditionVo {

    /**
     * 记录关系规格属性主键
     */
    private Long relSpecAttrId;

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
     * 记录物理的实例字段名标识
     */
    private Long colId;

    /**
     * 记录关系规格主键
     */
    private Long relSpecId;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 记录物理的实例表名标识
     */
    private Long tabId;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     * 记录业务对象属性规格业务编码
     */
    private Long attrId;

    public void setRelSpecAttrId(Long relSpecAttrId) {
        this.relSpecAttrId = relSpecAttrId;
    }

    public Long getRelSpecAttrId() {
        return this.relSpecAttrId;
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

    public void setColId(Long colId) {
        this.colId = colId;
    }

    public Long getColId() {
        return this.colId;
    }

    public void setRelSpecId(Long relSpecId) {
        this.relSpecId = relSpecId;
    }

    public Long getRelSpecId() {
        return this.relSpecId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
    }

    public Long getTabId() {
        return this.tabId;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return this.attrId;
    }

}
