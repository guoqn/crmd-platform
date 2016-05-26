package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.idempotency.core.repository.ITableShardingRuleRelRepository;

@Table(name = "SYS_CLASS_SHARDING_RULE_REL")
public class TableShardingRuleRel extends AbstractIdempotencyEntity<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 主键ID
     */
    @Id
    @Column(name = "TABLE_SHARDING_RULE_REL_ID")
    private Long              tableShardingRuleRelId;
    
    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp         recUpdateDate;
    
    /**
     * 分片规则ID
     */
    @Column(name = "SHARDING_RULE_ID")
    private Long              shardingRuleId;
    
    /**
     * 表名
     */
    @Column(name = "TABLE_NAME")
    private String            tableName;
    
    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long              regionCd;
    
    /**
     * 分片标识
     */
    @Column(name = "SHARDING_ID")
    private Long              shardingId;
    
    /**
     * 记录首次创建的员工标识。
     */
    @Column(name = "CREATE_STAFF")
    private Long              createStaff;
    
    /**
     * 记录每次修改的时间。
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp         updateDate;
    
    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String            remark;
    
    /**
     * 描述记录所属的C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long              areaId;
    
    /**
     * 描述记录被应用程序更新的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp         statusDate;
    
    /**
     * 描述记录物理的变更时间，精确到纳秒级别
     */
    @Column(name = "DTIMESTAMP")
    private Long              dtimestamp;
    
    /**
     * 描述记录的版本，从0开始，每更新一次版本号加1
     */
    @Column(name = "DVERSION")
    private Long              dversion;
    
    /**
     * 记录每次修改的员工标识。
     */
    @Column(name = "UPDATE_STAFF")
    private Long              updateStaff;
    
    /**
     * 记录状态。
     */
    @Column(name = "STATUS_CD")
    private String            statusCd;
    
    /**
     * 记录首次创建的时间。
     */
    @Column(name = "CREATE_DATE")
    private Timestamp         createDate;
    
    public void setSysClassShardingRuleRelId(Long sysClassShardingRuleRelId) {
        this.tableShardingRuleRelId = sysClassShardingRuleRelId;
    }
    
    public Long getSysClassShardingRuleRelId() {
        return this.tableShardingRuleRelId;
    }
    
    public void setShardingRuleId(Long shardingRuleId) {
        this.shardingRuleId = shardingRuleId;
    }
    
    public Long getShardingRuleId() {
        return this.shardingRuleId;
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
    
    public Long getId() {
        return tableShardingRuleRelId;
    }
    
    public void setId(Long id) {
        this.tableShardingRuleRelId = id;
    }
    
    public TableShardingRuleRel() {
        super();
    }
    
    public TableShardingRuleRel(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static ITableShardingRuleRelRepository repository() {
        return (ITableShardingRuleRelRepository) RepositoryRegister.getInstance().getRepository(
            TableShardingRuleRel.class);
    }
    
}
