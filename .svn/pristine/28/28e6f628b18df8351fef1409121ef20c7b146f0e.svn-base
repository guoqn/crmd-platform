package com.ffcs.crmd.platform.meta.entity;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IRelSpecAttrRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "REL_SPEC_ATTR")
public class RelSpecAttr extends AbstractCrmDomBaseEntityImpl<Long> {

    /**
     * 记录关系规格属性主键
     */
    @Id
    @Column(name = "REL_SPEC_ATTR_ID")
    private Long relSpecAttrId;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp recUpdateDate;

    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long regionCd;

    /**
     * 描述记录的分片键
     */
    @Column(name = "SHARDING_ID")
    private Long shardingId;

    /**
     * 记录创建的员工
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录物理的实例字段名标识
     */
    @Column(name = "COL_ID")
    private Long colId;

    /**
     * 记录修改的时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * 记录关系规格主键
     */
    @Column(name = "REL_SPEC_ID")
    private Long relSpecId;

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
     * 记录物理的实例表名标识
     */
    @Column(name = "TAB_ID")
    private Long tabId;

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
     * 记录状态
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 记录创建的时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     * 记录业务对象属性规格业务编码
     */
    @Column(name = "ATTR_ID")
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

    public void setRelSpecId(Long relSpecId) {
        this.relSpecId = relSpecId;
    }

    public Long getRelSpecId() {
        return this.relSpecId;
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

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return this.attrId;
    }

    public Long getId() {
        return relSpecAttrId;
    }

    public void setId(Long id) {
        this.relSpecAttrId = id;
    }

    public RelSpecAttr() {
        super();
    }

    public RelSpecAttr(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IRelSpecAttrRepository repository() {
        return (IRelSpecAttrRepository) RepositoryRegister.getInstance()
            .getRepository(RelSpecAttr.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
