package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.repository.IObjTabRelRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "OBJ_TAB_REL")
public class ObjTabRel extends AbstractCrmDomBaseEntityImpl<Long> {

    /**
     * 记录对象与表关系主键
     */
    @Id
    @Column(name = "REL_ID")
    private Long relId;

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
     * 记录对象标识
     */
    @Column(name = "OBJ_ID")
    private Long objId;

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
     * 描述记录所属的C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long areaId;

    /**
     * 状态的修改时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    /**
     * 记录表标识
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
     * 记录的修改员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     * 记录对象类型，LOVB,分为业务对象、关系规格对象
     */
    @Column(name = "OBJ_TYPE")
    private String objType;

    /**
     * 记录状态。
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 记录的创建时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Long getRelId() {
        return this.relId;
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

    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public Long getObjId() {
        return this.objId;
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

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjType() {
        return this.objType;
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
        return relId;
    }

    public void setId(Long id) {
        this.relId = id;
    }

    public ObjTabRel() {
        super();
    }

    public ObjTabRel(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IObjTabRelRepository repository() {
        return (IObjTabRelRepository) RepositoryRegister.getInstance()
            .getRepository(ObjTabRel.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }

}
