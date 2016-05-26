package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.repository.IAttrSpecRelRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "ATTR_SPEC_REL")
public class AttrSpecRel extends AbstractCrmDomBaseEntityImpl<Long> {

    /**
     * 属性关系ID
     */
    @Id
    @Column(name = "ATTR_SPEC_REL_ID")
    private Long attrSpecRelId;

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
     * 业务对象属性规格业务编码
     */
    @Column(name = "ATT_ATTR_ID")
    private Long attAttrId;

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
     * 描述属性规格与属性规则之间依赖、互斥、上下级关系
     */
    @Column(name = "RELATION_TYPE_CD")
    private String relationTypeCd;

    /**
     * 状态
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     * 业务对象属性规格业务编码
     */
    @Column(name = "ATTR_ID")
    private Long attrId;

    public void setAttrSpecRelId(Long attrSpecRelId) {
        this.attrSpecRelId = attrSpecRelId;
    }

    public Long getAttrSpecRelId() {
        return this.attrSpecRelId;
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

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public void setAttAttrId(Long attAttrId) {
        this.attAttrId = attAttrId;
    }

    public Long getAttAttrId() {
        return this.attAttrId;
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

    public void setRelationTypeCd(String relationTypeCd) {
        this.relationTypeCd = relationTypeCd;
    }

    public String getRelationTypeCd() {
        return this.relationTypeCd;
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
        return attrSpecRelId;
    }

    public void setId(Long id) {
        this.attrSpecRelId = id;
    }

    public AttrSpecRel() {
        super();
    }

    public AttrSpecRel(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IAttrSpecRelRepository repository() {
        return (IAttrSpecRelRepository) RepositoryRegister.getInstance()
            .getRepository(AttrSpecRel.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
