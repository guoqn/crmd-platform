package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.idempotency.core.repository.IShardingRuleRepository;

@Table(name = "SHARDING_RULE")
public class ShardingRule extends AbstractIdempotencyEntity<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 分片规则ID
     */
    @Id
    @Column(name = "SHARDING_RULE_ID")
    private Long              shardingRuleId;
    
    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp         recUpdateDate;
    
    /**
     * 事件响应表名
     */
    @Column(name = "ACTION_TABLE_NAME")
    private String            actionTableName;
    
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
     * 分片方式：取模、HASH、范围
     */
    @Column(name = "SHARDING_METHOD")
    private Long              shardingMethod;
    
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
     * 分片键数据类型:Long、Timestamp、String
     */
    @Column(name = "SHARDING_ID_TYPE")
    private String            shardingIdType;
    
    /**
     * 数据节点数量
     */
    @Column(name = "SHARDING_NUM")
    private Long              shardingNum;
    
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
     * 分片类型：单库、全局、分片
     */
    @Column(name = "SHARDING_TYPE")
    private String            shardingType;
    
    /**
     * 数据节点
     */
    @Column(name = "DATA_NODE")
    private String            dataNode;
    
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
     * 分片规则编码
     */
    @Column(name = "SHARDING_RULE_CD")
    private String            shardingRuleCd;
    
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
    
    /**
     * 分片规则名称
     */
    @Column(name = "SHARDING_RULE_NAME")
    private String            shardingRuleName;
    
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
    
    public void setShardingMethod(Long shardingMethod) {
        this.shardingMethod = shardingMethod;
    }
    
    public Long getShardingMethod() {
        return this.shardingMethod;
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
    
    public void setShardingNum(Long shardingNum) {
        this.shardingNum = shardingNum;
    }
    
    public Long getShardingNum() {
        return this.shardingNum;
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
    
    public void setShardingType(String shardingType) {
        this.shardingType = shardingType;
    }
    
    public String getShardingType() {
        return this.shardingType;
    }
    
    public void setDataNode(String dataNode) {
        this.dataNode = dataNode;
    }
    
    public String getDataNode() {
        return this.dataNode;
    }
    
    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }
    
    public Long getUpdateStaff() {
        return this.updateStaff;
    }
    
    public void setShardingRuleCd(String shardingRuleCd) {
        this.shardingRuleCd = shardingRuleCd;
    }
    
    public String getShardingRuleCd() {
        return this.shardingRuleCd;
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
    
    public void setShardingRuleName(String shardingRuleName) {
        this.shardingRuleName = shardingRuleName;
    }
    
    public String getShardingRuleName() {
        return this.shardingRuleName;
    }
    
    public Long getId() {
        return shardingRuleId;
    }
    
    public void setId(Long id) {
        this.shardingRuleId = id;
    }
    
    public ShardingRule() {
        super();
    }
    
    public ShardingRule(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static IShardingRuleRepository repository() {
        return (IShardingRuleRepository) RepositoryRegister.getInstance().getRepository(
            ShardingRule.class);
    }
    
    public String getActionTableName() {
        return actionTableName;
    }
    
    public void setActionTableName(String actionTableName) {
        this.actionTableName = actionTableName;
    }
    
    public String getShardingIdType() {
        return shardingIdType;
    }
    
    public void setShardingIdType(String shardingIdType) {
        this.shardingIdType = shardingIdType;
    }
    
    public Timestamp getRecUpdateDate() {
        return recUpdateDate;
    }
    
    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }
    
    public Long getShardingId() {
        return shardingId;
    }
    
    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }
    
    public Long getDtimestamp() {
        return dtimestamp;
    }
    
    public void setDtimestamp(Long dtimestamp) {
        this.dtimestamp = dtimestamp;
    }
    
    public Long getDversion() {
        return dversion;
    }
    
    public void setDversion(Long dversion) {
        this.dversion = dversion;
    }
    
}
