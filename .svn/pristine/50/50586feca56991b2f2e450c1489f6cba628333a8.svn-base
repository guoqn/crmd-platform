package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttrValue;
import com.ffcs.crmd.platform.meta.repository.IBusiObjAttrValueRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "BUSI_OBJ_ATTR_VALUE")
public class BusiObjAttrValue extends AbstractCrmDomBaseEntityImpl<Long> implements
    IBusiObjAttrValue {

    /**
     * 记录业务对象属性值主键
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp recUpdateDate;

    /**
     * 描述业务对象属性值之间依赖、互斥 、上下级关系
     */
    @Column(name = "RELATION_TYPE_CD")
    private String relationTypeCd;

    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long regionCd;

    /**
     * 记录适用区域标识
     */
    @Column(name = "APPLY_REGION_ID")
    private Long applyRegionId;

    /**
     * 描述记录的分片键
     */
    @Column(name = "SHARDING_ID")
    private Long shardingId;

    /**
     * 记录属性值标识
     */
    @Column(name = "ATTR_VALUE_ID")
    private Long attrValueId;

    /**
     * 记录创建的员工
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录修改的时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * 记录备注信息。
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 描述记录所属的C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long areaId;

    /**
     * 状态修改的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    /**
     * 属性值关系ID
     */
    @Column(name = "VALUE_RELA_ID")
    private Long valueRelaId;

    /**
     * 描述关联表对端的分片键
     */
    @Column(name = "REL_SHARDING_ID")
    private Long relShardingId;

    /**
     * 描述记录物理的变更时间，精确到纳秒级别
     */
    @Column(name = "DTIMESTAMP")
    private Long dtimestamp;

    /**
     * 描述记录的版本，从0开始，每更新一次版本号加1
     */
    @Column(name = "DVERSION")
    private Long dversion;

    /**
     * 记录修改的员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     * 属性值关系ID
     */
    @Column(name = "BUS_VALUE_RELA_ID")
    private Long busValueRelaId;

    /**
     * 记录状态。
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 记录创建的时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     * 记录业务对象属性标识
     */
    @Column(name = "BUSI_OBJ_ATTR_ID")
    private Long busiObjAttrId;

    public String getRelationTypeCd() {
        return relationTypeCd;
    }

    public void setRelationTypeCd(String relationTypeCd) {
        this.relationTypeCd = relationTypeCd;
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

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Long getAttrValueId() {
        return this.attrValueId;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public Long getCreateStaff() {
        return this.createStaff;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }

    public Timestamp getStatusDate() {
        return this.statusDate;
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

    public void setDtimestamp(Long dtimestamp) {
        this.dtimestamp = dtimestamp;
    }

    public Long getDtimestamp() {
        return this.dtimestamp;
    }

    public void setDversion(Long dversion) {
        this.dversion = dversion;
    }

    public Long getDversion() {
        return this.dversion;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Long getUpdateStaff() {
        return this.updateStaff;
    }

    public void setBusValueRelaId(Long busValueRelaId) {
        this.busValueRelaId = busValueRelaId;
    }

    public Long getBusValueRelaId() {
        return this.busValueRelaId;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusCd() {
        return this.statusCd;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setBusiObjAttrId(Long busiObjAttrId) {
        this.busiObjAttrId = busiObjAttrId;
    }

    public Long getBusiObjAttrId() {
        return this.busiObjAttrId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusiObjAttrValue() {
        super();
    }

    public BusiObjAttrValue(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IBusiObjAttrValueRepository repository() {
        return (IBusiObjAttrValueRepository) RepositoryRegister.getInstance()
            .getRepository(BusiObjAttrValue.class);
    }

    public AttrValue2 getAttrValue() {
        AttrValue2 value = AttrValue2.repository().getById(this.getAttrValueId());
        return value;
    }
    @Override
    public String readAttrValue() {
        AttrValue2 attrValue2 = getAttrValue();
        if (attrValue2 != null) {
            return attrValue2.getAttrValue();
        }
        return "";
    }

    @Override
    public String readAttrValueName() {
        AttrValue2 attrValue2 = getAttrValue();
        if (attrValue2 != null) {
            return attrValue2.getAttrValueName();
        }
        return "";
    }
    @Override
    public boolean isUseMeta() {
        return false;
    }
}
