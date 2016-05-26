package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.repository.IBusiObjectAttrValueRelRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "BUSI_OBJECT_ATTR_VALUE_REL")
public class BusiObjectAttrValueRel extends AbstractCrmDomBaseEntityImpl<Long> {

    /**
     * 属性值关系ID
     */
    @Id
    @Column(name = "VALUE_RELA_ID")
    private Long valueRelaId;

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
     * A端属性值ID
     */
    @Column(name = "RELA_ATTR_VALUE_ID")
    private Long relaAttrValueId;

    /**
     * 创建人
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * 描述记录所属的C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long areaId;

    /**
     * 状态时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

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
     * 修改人
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     * 属性值之间互斥、依赖关系。
     */
    @Column(name = "ATTR_RELA_TYPE")
    private String attrRelaType;

    /**
     * 状态
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * Z端属性值ID
     */
    @Column(name = "RELATED_ATTR_VALUE_ID")
    private Long relatedAttrValueId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    public void setValueRelaId(Long valueRelaId) {
        this.valueRelaId = valueRelaId;
    }

    public Long getValueRelaId() {
        return this.valueRelaId;
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

    public void setRelaAttrValueId(Long relaAttrValueId) {
        this.relaAttrValueId = relaAttrValueId;
    }

    public Long getRelaAttrValueId() {
        return this.relaAttrValueId;
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

    public void setAttrRelaType(String attrRelaType) {
        this.attrRelaType = attrRelaType;
    }

    public String getAttrRelaType() {
        return this.attrRelaType;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusCd() {
        return this.statusCd;
    }

    public void setRelatedAttrValueId(Long relatedAttrValueId) {
        this.relatedAttrValueId = relatedAttrValueId;
    }

    public Long getRelatedAttrValueId() {
        return this.relatedAttrValueId;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public Long getId() {
        return valueRelaId;
    }

    public void setId(Long id) {
        this.valueRelaId = id;
    }

    public BusiObjectAttrValueRel() {
        super();
    }

    public BusiObjectAttrValueRel(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IBusiObjectAttrValueRelRepository repository() {
        return (IBusiObjectAttrValueRelRepository) RepositoryRegister.getInstance()
            .getRepository(BusiObjectAttrValueRel.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
