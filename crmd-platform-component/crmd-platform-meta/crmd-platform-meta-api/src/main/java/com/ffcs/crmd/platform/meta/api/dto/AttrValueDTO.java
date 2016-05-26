package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

import java.sql.Timestamp;

/**
 * @author FFCS-CAIWL
 */
public class AttrValueDTO extends DomBaseDTO {
    private static final long serialVersionUID = 1598179584838497003L;

    /**
     * 记录属性值的主键
     */
    private Long attrValueId;

    /**
     * 描述记录所属的C4区域标识
     */
    private Long regionCd;

    /**
     * 记录属性值描述
     */
    private String attrValueDesc;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     *
     */
    private String manageGrade;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    /**
     *
     */
    private String groupCd;

    /**
     *
     */
    private Timestamp expDate;

    /**
     * 记录属性值名称
     */
    private String attrValueName;

    /**
     * 记录业务对象属性规格业务编码
     */
    private Long attrId;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    private Timestamp recUpdateDate;

    /**
     * 描述记录的分片键
     */
    private Long shardingId;

    /**
     *
     */
    private Long isTrans;

    /**
     *
     */
    private Timestamp effDate;

    /**
     *
     */
    private Long parentValueId;

    /**
     * 记录属性值。
     */
    private String attrValue;

    /**
     * 记录同个属性不同的属性值在界面展现的顺序号
     */
    private String attrValueSort;

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Long getAttrValueId() {
        return this.attrValueId;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setAttrValueDesc(String attrValueDesc) {
        this.attrValueDesc = attrValueDesc;
    }

    public String getAttrValueDesc() {
        return this.attrValueDesc;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setManageGrade(String manageGrade) {
        this.manageGrade = manageGrade;
    }

    public String getManageGrade() {
        return this.manageGrade;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public String getGroupCd() {
        return this.groupCd;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public Timestamp getExpDate() {
        return this.expDate;
    }

    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName;
    }

    public String getAttrValueName() {
        return this.attrValueName;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return this.attrId;
    }

    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setIsTrans(Long isTrans) {
        this.isTrans = isTrans;
    }

    public Long getIsTrans() {
        return this.isTrans;
    }

    public void setEffDate(Timestamp effDate) {
        this.effDate = effDate;
    }

    public Timestamp getEffDate() {
        return this.effDate;
    }

    public void setParentValueId(Long parentValueId) {
        this.parentValueId = parentValueId;
    }

    public Long getParentValueId() {
        return this.parentValueId;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getAttrValue() {
        return this.attrValue;
    }

    public void setAttrValueSort(String attrValueSort) {
        this.attrValueSort = attrValueSort;
    }

    public String getAttrValueSort() {
        return this.attrValueSort;
    }

}
