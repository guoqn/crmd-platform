package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.ISysColumn;
import com.ffcs.crmd.platform.meta.repository.ISysColumnRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "SYS_COLUMN")
public class SysColumn extends AbstractCrmDomBaseEntityImpl<Long> implements ISysColumn {

    /**
     * 记录字段主键
     */
    @Id
    @Column(name = "COL_ID")
    private Long colId;

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
     * 约束类型
     */
    @Column(name = "CNS_TYPE")
    private String cnsType;

    /**
     * LOVB,记录字段类型
     */
    @Column(name = "COL_TYPE")
    private String colType;

    @Column(name = "SHARDING_LEVEL")
    private Long shardingLevel;

    /**
     * 描述记录的分片键
     */
    @Column(name = "SHARDING_ID")
    private Long shardingId;

    /**
     * 记录字段名称
     */
    @Column(name = "COL_NAME")
    private String colName;

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
     * 记录物理表字段是否外键
     */
    @Column(name = "COL_FOREIGN_KEY")
    private Long colForeignKey;

    /**
     * 记录状态修改的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    /**
     * 记录表的主键
     */
    @Column(name = "TAB_ID")
    private Long tabId;

    /**
     * 记录字段描述
     */
    @Column(name = "COL_DESC")
    private String colDesc;

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
     * 记录物理表字段是否可空
     */
    @Column(name = "COL_NULLABLE")
    private Long colNullable;

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

    /**
     * 记录物理表字段的长度
     */
    @Column(name = "COL_LENGHT")
    private Long colLenght;

    public void setColId(Long colId) {
        this.colId = colId;
    }

    public Long getColId() {
        return this.colId;
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

    public void setCnsType(String cnsType) {
        this.cnsType = cnsType;
    }

    public String getCnsType() {
        return this.cnsType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getColType() {
        return this.colType;
    }

    public Long getShardingLevel() {
        return shardingLevel;
    }

    public void setShardingLevel(Long shardingLevel) {
        this.shardingLevel = shardingLevel;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColName() {
        return this.colName;
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

    public void setColForeignKey(Long colForeignKey) {
        this.colForeignKey = colForeignKey;
    }

    public Long getColForeignKey() {
        return this.colForeignKey;
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

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc;
    }

    public String getColDesc() {
        return this.colDesc;
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

    public void setColNullable(Long colNullable) {
        this.colNullable = colNullable;
    }

    public Long getColNullable() {
        return this.colNullable;
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

    public void setColLenght(Long colLenght) {
        this.colLenght = colLenght;
    }

    public Long getColLenght() {
        return this.colLenght;
    }

    public Long getId() {
        return colId;
    }

    public void setId(Long id) {
        this.colId = id;
    }

    public SysColumn() {
        super();
    }

    public SysColumn(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static ISysColumnRepository repository() {
        return (ISysColumnRepository) RepositoryRegister.getInstance()
            .getRepository(SysColumn.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }

}
