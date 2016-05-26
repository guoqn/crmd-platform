package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.repository.IAttrValue2Repository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "ATTR_VALUE")
public class AttrValue2 extends AbstractCrmDomBaseEntityImpl<Long> {

    private static final long serialVersionUID = -2811347047325737314L;

    /**
     * 记录属性值的主键
     */
    @Id
    @Column(name = "ATTR_VALUE_ID")
    private Long attrValueId;

    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long regionCd;

    /**
     * 记录的创建员工
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录的修改时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * 记录备注信息。
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 记录属性值描述
     */
    @Column(name = "ATTR_VALUE_DESC")
    private String attrValueDesc;

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
     *
     */
    @Column(name = "MANAGE_GRADE")
    private String manageGrade;

    /**
     * 描述关联表对端的分片键
     */
    @Column(name = "REL_SHARDING_ID")
    private Long relShardingId;

    /**
     *
     */
    @Column(name = "GROUP_CD")
    private String groupCd;

    /**
     * 记录的修改员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     *
     */
    @Column(name = "EXP_DATE")
    private Timestamp expDate;

    /**
     * 记录属性值名称
     */
    @Column(name = "ATTR_VALUE_NAME")
    private String attrValueName;

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
     *
     */
    @Column(name = "IS_TRANS")
    private Long isTrans;

    /**
     *
     */
    @Column(name = "EFF_DATE")
    private Timestamp effDate;

    /**
     *
     */
    @Column(name = "PARENT_VALUE_ID")
    private Long parentValueId;

    /**
     * 记录属性值。
     */
    @Column(name = "ATTR_VALUE")
    private String attrValue;

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
     * 记录同个属性不同的属性值在界面展现的顺序号
     */
    @Column(name = "ATTR_VALUE_SORT")
    private String attrValueSort;

    /**
     * 记录状态
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 记录的创建时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

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

    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }

    public Timestamp getStatusDate() {
        return this.statusDate;
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

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Long getUpdateStaff() {
        return this.updateStaff;
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

    public void setAttrValueSort(String attrValueSort) {
        this.attrValueSort = attrValueSort;
    }

    public String getAttrValueSort() {
        return this.attrValueSort;
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

    public Long getId() {
        return attrValueId;
    }

    public void setId(Long id) {
        this.attrValueId = id;
    }

    public AttrValue2() {
        super();
    }

    public AttrValue2(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IAttrValue2Repository repository() {
        return (IAttrValue2Repository) RepositoryRegister.getInstance()
            .getRepository(AttrValue2.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
