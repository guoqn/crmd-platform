package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.ISysTable;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.repository.ISysTableRepository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "SYS_TABLE")
public class SysTable extends AbstractCrmDomBaseEntityImpl<Long> implements ISysTable {

    /**
     * 记录物理库表的主键
     */
    @Id
    @Column(name = "TAB_ID")
    private Long tabId;

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
     *
     */
    @Column(name = "HIS_TABLE_NAME")
    private String hisTableName;

    /**
     * 描述记录的分片键
     */
    @Column(name = "SHARDING_ID")
    private Long shardingId;

    /**
     * 记录表主键字段名，类似prod_inst_attr.prod_inst_attr_id
     */
    @Column(name = "TAB_KEY_COL_NAME")
    private String tabKeyColName;

    /**
     * 记录物理库表的名称
     */
    @Column(name = "TAB_NAME")
    private String tabName;

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
     * 记录纵表属性字段名，类似prod_inst_attr.attr_id
     */
    @Column(name = "SLA_TAB_ATTR_COL_NAME")
    private String slaTabAttrColName;

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
     * 记录纵表属性值字段名，类似prod_inst_attr.attr_value
     */
    @Column(name = "SLA_TAB_ATTR_VAL_COL_NAME")
    private String slaTabAttrValColName;

    /**
     * 记录物理库表的类型，LOVB,分为横表、纵表
     */
    @Column(name = "TAB_TYPE")
    private String tabType;

    /**
     * 状态的修改时间
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
     * 记录的修改员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     *
     */
    @Column(name = "HIS_SEQ_NAME")
    private String hisSeqName;

    /**
     * 记录归属主表标识
     */
    @Column(name = "MSTR_TAB_ID")
    private Long mstrTabId;

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
     * 记录纵表实例字段名，类似prod_inst_attr.prod_inst_id
     */
    @Column(name = "SLA_TAB_INST_COL_NAME")
    private String slaTabInstColName;

    /**
     * 得到
     * @return
     */
    public List<SysColumn> getSysColumns() {
        return SysColumn.repository().qrySysColumnsListByTabId(this.tabId);
    }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
    }

    public Long getTabId() {
        return this.tabId;
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

    public void setHisTableName(String hisTableName) {
        this.hisTableName = hisTableName;
    }

    public String getHisTableName() {
        return this.hisTableName;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setTabKeyColName(String tabKeyColName) {
        this.tabKeyColName = tabKeyColName;
    }

    public String getTabKeyColName() {
        return this.tabKeyColName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return this.tabName;
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

    public void setSlaTabAttrColName(String slaTabAttrColName) {
        this.slaTabAttrColName = slaTabAttrColName;
    }

    public String getSlaTabAttrColName() {
        return this.slaTabAttrColName;
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

    public void setSlaTabAttrValColName(String slaTabAttrValColName) {
        this.slaTabAttrValColName = slaTabAttrValColName;
    }

    public String getSlaTabAttrValColName() {
        return this.slaTabAttrValColName;
    }

    public void setTabType(String tabType) {
        this.tabType = tabType;
    }

    public String getTabType() {
        return this.tabType;
    }

    @Override
    public boolean isDanyTable() {
        return MetaConstants.SYS_TABLE_TYPE.TABLE_TYPE_VERTICAL_TABLE.equals(this.getTabType());
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
        return updateStaff;
    }

    public void setHisSeqName(String hisSeqName) {
        this.hisSeqName = hisSeqName;
    }

    public String getHisSeqName() {
        return this.hisSeqName;
    }

    public void setMstrTabId(Long mstrTabId) {
        this.mstrTabId = mstrTabId;
    }

    public Long getMstrTabId() {
        return this.mstrTabId;
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

    public void setSlaTabInstColName(String slaTabInstColName) {
        this.slaTabInstColName = slaTabInstColName;
    }

    public String getSlaTabInstColName() {
        return this.slaTabInstColName;
    }

    public Long getId() {
        return tabId;
    }

    public void setId(Long id) {
        this.tabId = id;
    }

    public SysTable() {
        super();
    }

    public SysTable(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static ISysTableRepository repository() {
        return (ISysTableRepository) RepositoryRegister.getInstance().getRepository(SysTable.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
