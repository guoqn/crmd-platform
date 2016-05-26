package com.ffcs.crmd.platform.meta.entity;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.IAttrSpec2;
import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.repository.IBusiObjAttrRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "BUSI_OBJ_ATTR")
public class BusiObjAttr extends AbstractCrmDomBaseEntityImpl<Long> implements IBusiObjAttr {

    /**
     * 记录业务对象属性主键
     */
    @Id
    @Column(name = "BUSI_OBJ_ATTR_ID")
    private Long busiObjAttrId;

    /**
     * 记录适用区域标识
     */
    @Column(name = "APPLY_REGION_ID")
    private Long applyRegionId;

    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long regionCd;

    /**
     * 记录创建的员工
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录物理实例表字段标识
     */
    @Column(name = "COL_ID")
    private Long colId;

    /**
     * 记录修改的时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * 记录属性值在业务对象实例中唯一
     */
    @Column(name = "IS_UNIQUE")
    private String isUnique;

    /**
     * 记录属性规格取值范围之最大值
     */
    @Column(name = "VALUE_TO")
    private String valueTo;

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
     * 状态变更的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    /**
     * 记录是否可空
     */
    @Column(name = "IS_NULLABLE")
    private String isNullable;

    /**
     * 记录物理实例表标识
     */
    @Column(name = "TAB_ID")
    private Long tabId;

    /**
     * 记录属性规格取值范围之最小值
     */
    @Column(name = "VALUE_FROM")
    private String valueFrom;

    /**
     * 描述关联表对端的分片键
     */
    @Column(name = "REL_SHARDING_ID")
    private Long relShardingId;

    /**
     * 记录属性最大数量，如果值大于1，表示在同个业务对象中，同个属性规格可以实例化多条
     */
    @Column(name = "ATTR_MAX_COUNT")
    private Long attrMaxCount;

    /**
     * 记录修改的员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     * 记录业务对象属性规格业务编码
     */
    @Column(name = "ATTR_ID")
    private Long attrId;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp recUpdateDate;

    /**
     * 描述记录的分片键
     */
    @Column(name = "SHARDING_ID")
    private Long shardingId;

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
     * 记录状态
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 记录属性规格默认取值
     */
    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    /**
     * 记录创建的时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     *
     */
    @Column(name = "SEQ_NAME")
    private String seqName;

    /**
     * 记录业务对象标识
     */
    @Column(name = "BUSI_OBJ_ID")
    private Long busiObjId;

    public void setBusiObjAttrId(Long busiObjAttrId) {
        this.busiObjAttrId = busiObjAttrId;
    }

    public Long getBusiObjAttrId() {
        return this.busiObjAttrId;
    }

    public void setApplyRegionId(Long applyRegionId) {
        this.applyRegionId = applyRegionId;
    }

    public Long getApplyRegionId() {
        return this.applyRegionId;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public Long getCreateStaff() {
        return this.createStaff;
    }

    public void setColId(Long colId) {
        this.colId = colId;
    }

    public Long getColId() {
        return this.colId;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public void setIsUnique(String isUnique) {
        this.isUnique = isUnique;
    }

    public String getIsUnique() {
        return this.isUnique;
    }

    public void setValueTo(String valueTo) {
        this.valueTo = valueTo;
    }

    public String getValueTo() {
        return this.valueTo;
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

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getIsNullable() {
        return this.isNullable;
    }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
    }

    public Long getTabId() {
        return this.tabId;
    }

    @Override
    public String readProcType() {
        IAttrSpec2 attrSpec2 = readAttrSpec();
        if (attrSpec2 != null) {
            return attrSpec2.getProcType();
        }
        return "";
    }

    @Override
    public String readSeqName() {
        if (!StringUtils.isNullOrEmpty(this.getSeqName())) {
            return this.getSeqName();
        } else {
            IAttrSpec2 attrSpec2 = readAttrSpec();
            if (attrSpec2 != null) {
                return attrSpec2.getSeqName();
            }
        }
        return "";
    }

    @Override
    public boolean checkIsDanyAttr() {
        IAttrSpec2 attrSpec2 = readAttrSpec();
        if (attrSpec2 != null) {
            return MetaConstants.ATTR_SPEC_IS_DANY_ATTR.TRUE.equals(attrSpec2.getIsDanyAttr());
        }
        return false;
    }

    public void setValueFrom(String valueFrom) {
        this.valueFrom = valueFrom;
    }

    public String getValueFrom() {
        return this.valueFrom;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

    public void setAttrMaxCount(Long attrMaxCount) {
        this.attrMaxCount = attrMaxCount;
    }

    public Long getAttrMaxCount() {
        return this.attrMaxCount;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Long getUpdateStaff() {
        return this.updateStaff;
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

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusCd() {
        return this.statusCd;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public String getSeqName() {
        return this.seqName;
    }

    public void setBusiObjId(Long busiObjId) {
        this.busiObjId = busiObjId;
    }

    public Long getBusiObjId() {
        return this.busiObjId;
    }

    public Long getId() {
        return busiObjAttrId;
    }

    public void setId(Long id) {
        this.busiObjAttrId = id;
    }

    public BusiObjAttr() {
        super();
    }

    public BusiObjAttr(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IBusiObjAttrRepository repository() {
        return (IBusiObjAttrRepository) RepositoryRegister.getInstance()
            .getRepository(BusiObjAttr.class);
    }

    @Override
    public String readAttrNbr() {
        IAttrSpec2 attrSpec2 = readAttrSpec();
        if (attrSpec2 != null) {
            return attrSpec2.getAttrNbr();
        }
        return "";
    }

    public IAttrSpec2 readAttrSpec() {
        AttrSpec2 attrSpec2 = AttrSpec2.repository().getById(this.getAttrId());
        return attrSpec2;
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
