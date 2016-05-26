package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.repository.IBusiTypeRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;

@Table(name = "BUSI_TYPE")
public class BusiType extends AbstractCrmDomBaseEntityImpl<Long> implements IBusiType {

    /**
     * 记录业务大类主键
     */
    @Id
    @Column(name = "BUSI_TYPE_ID")
    private Long busiTypeId;

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
     * 记录的创建员工
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录删除的时候是否记录历史表
     */
    @Column(name = "DELETE_LOG_LEVEL")
    private String deleteLogLevel;

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
     * 记录状态修改的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    /**
     * 记录业务大类编码
     */
    @Column(name = "BUSI_TYPE_NBR")
    private String busiTypeNbr;

    /**
     *
     */
    @Column(name = "MANAGER_GRADE")
    private String managerGrade;

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
     * 多种选择
     */
    @Column(name = "CACHE_LEVEL")
    private String cacheLevel;

    /**
     * 记录变更的时候是否记录历史
     */
    @Column(name = "CHANGE_LOG_LEVEL")
    private String changeLogLevel;

    /**
     * 记录业务大类名称
     */
    @Column(name = "BUSI_TYPE_NAME")
    private String busiTypeName;

    /**
     * 记录业务大类与业务对象之间的关系
     */
    @Column(name = "META_TYPE")
    private String metaType;

    /**
     * 状态。
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 记录业务大类描述
     */
    @Column(name = "BUSI_TYPE_DESC")
    private String busiTypeDesc;

    /**
     * 记录创建的时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     * 记录主题域主键
     */
    @Column(name = "DOMAIN_ID")
    private Long domainId;

    public void setBusiTypeId(Long busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    public Long getBusiTypeId() {
        return this.busiTypeId;
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

    public void setDeleteLogLevel(String deleteLogLevel) {
        this.deleteLogLevel = deleteLogLevel;
    }

    public String getDeleteLogLevel() {
        return this.deleteLogLevel;
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

    public void setBusiTypeNbr(String busiTypeNbr) {
        this.busiTypeNbr = busiTypeNbr;
    }

    public String getBusiTypeNbr() {
        return this.busiTypeNbr;
    }

    public void setManagerGrade(String managerGrade) {
        this.managerGrade = managerGrade;
    }

    public String getManagerGrade() {
        return this.managerGrade;
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

    public void setCacheLevel(String cacheLevel) {
        this.cacheLevel = cacheLevel;
    }

    public String getCacheLevel() {
        return this.cacheLevel;
    }

    public void setChangeLogLevel(String changeLogLevel) {
        this.changeLogLevel = changeLogLevel;
    }

    public String getChangeLogLevel() {
        return this.changeLogLevel;
    }

    public void setBusiTypeName(String busiTypeName) {
        this.busiTypeName = busiTypeName;
    }

    public String getBusiTypeName() {
        return this.busiTypeName;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public String getMetaType() {
        return this.metaType;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusCd() {
        return this.statusCd;
    }

    public void setBusiTypeDesc(String busiTypeDesc) {
        this.busiTypeDesc = busiTypeDesc;
    }

    public String getBusiTypeDesc() {
        return this.busiTypeDesc;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public Long getDomainId() {
        return this.domainId;
    }

    public Long getId() {
        return busiTypeId;
    }

    public void setId(Long id) {
        this.busiTypeId = id;
    }

    public BusiType() {
        super();
    }

    public BusiType(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IBusiTypeRepository repository() {
        return (IBusiTypeRepository) RepositoryRegister.getInstance().getRepository(BusiType.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }

}
