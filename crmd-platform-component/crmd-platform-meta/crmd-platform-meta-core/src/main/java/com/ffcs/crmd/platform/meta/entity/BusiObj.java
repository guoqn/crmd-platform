package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IBusiType;
import com.ffcs.crmd.platform.meta.repository.IBusiObjRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;

@Table(name = "BUSI_OBJ")
public class BusiObj extends AbstractCrmDomBaseEntityImpl<Long> implements IBusiObj {

    /**
     * 记录业务对象主键
     */
    @Id
    @Column(name = "BUSI_OBJ_ID")
    private Long busiObjId;

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
     * 记录业务大类主键
     */
    @Column(name = "BUSI_TYPE_ID")
    private Long busiTypeId;

    /**
     * 记录业务对象描述
     */
    @Column(name = "BUSI_OBJ_DESC")
    private String busiObjDesc;

    /**
     * 记录的创建员工。
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录的修改时间。
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
     * 记录业务对象编码
     */
    @Column(name = "BUSI_OBJ_NBR")
    private String busiObjNbr;

    /**
     * 记录业务对象名称
     */
    @Column(name = "BUSI_OBJ_NAME")
    private String busiObjName;

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
     * 记录的修改员工。
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     * 记录父级业务对象标识
     */
    @Column(name = "PAR_BUSI_OBJ_ID")
    private Long parBusiObjId;

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

    public void setParBusiObjId(Long parBusiObjId) {
        this.parBusiObjId = parBusiObjId;
    }

    public Long getParBusiObjId() {
        return this.parBusiObjId;
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
        return busiObjId;
    }



    public void setId(Long id) {
        this.busiObjId = id;
    }

    public BusiObj() {
        super();
    }

    public BusiObj(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IBusiObjRepository repository() {
        return (IBusiObjRepository) RepositoryRegister.getInstance().getRepository(BusiObj.class);
    }

    @Override
    public IBusiType readBusiType() {
        return BusiType.repository().getById(busiTypeId);
    }

    @Override
    public String readChangeLogLevel() {
        IBusiType busiType = readBusiType();
        if (busiType != null) {
            return busiType.getChangeLogLevel();
        }
        return "";
    }

    @Override
    public String readDeleteLogLevel() {
        IBusiType busiType = readBusiType();
        if (busiType != null) {
            return busiType.getDeleteLogLevel();
        }
        return "";
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }

}
