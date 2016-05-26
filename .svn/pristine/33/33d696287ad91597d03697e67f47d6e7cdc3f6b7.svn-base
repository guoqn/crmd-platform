package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.idempotency.core.repository.ISysWorkItemRepository;
import com.ffcs.crmd.platform.idempotency.core.vo.SysWorkItemObjVo;

@ShardingBean
@Table(name = "SYS_WORK_ITEM")
public class SysWorkItem extends AbstractIdempotencyEntity<Long> {
    
    private static final long      serialVersionUID = -2811347047325737314L;
    
    /**
     * 主键
     */
    @Id
    @Column(name = "ITEM_ID")
    private Long                   itemId;
    
    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp              recUpdateDate;
    
    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long                   regionCd;
    
    /**
     * 分片标识
     */
    @ShardingId
    @Column(name = "SHARDING_ID")
    private Long                   shardingId;
    
    /**
     * 记录处理对象的分片规则
     */
    @Column(name = "OBJ_SHARDING_RULE_ID")
    private Long                   objShardingRuleId;
    
    /**
     * 记录首次创建的员工标识。
     */
    @Column(name = "CREATE_STAFF")
    private Long                   createStaff;
    
    /**
     * 记录每次修改的时间。
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp              updateDate;
    
    /**
     * 应用事件集模块
     */
    @Column(name = "ITEM_TYPE")
    private String                 itemType;
    
    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String                 remark;
    
    /**
     * 描述记录所属的C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long                   areaId;
    
    /**
     * 描述记录被应用程序更新的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp              statusDate;
    
    /**
     * 描述记录物理的变更时间，精确到纳秒级别
     */
    @Column(name = "DTIMESTAMP")
    private Long                   dtimestamp;
    
    /**
     * 描述记录的版本，从0开始，每更新一次版本号加1
     */
    @Column(name = "DVERSION")
    private Long                   dversion;
    
    /**
     * 记录每次修改的员工标识。
     */
    @Column(name = "UPDATE_STAFF")
    private Long                   updateStaff;
    
    /**
     * 记录状态。
     */
    @Column(name = "STATUS_CD")
    private String                 statusCd;
    
    /**
     * 记录首次创建的时间。
     */
    @Column(name = "CREATE_DATE")
    private Timestamp              createDate;
    
    /**
     * 事件集ID
     */
    @Column(name = "SHEET_ID")
    private Long                   sheetId;
    
    /**
     * 处理对象分片标识
     */
    @Column(name = "OBJ_SHARDING_ID")
    private Long                   objShardingId;
    
    /**
     * 事务事件项涉及的操作对象列表
     */
    private List<SysWorkItemObjVo> objList          = new ArrayList<SysWorkItemObjVo>();
    
    /**
     * 分片规则
     */
    private ShardingRule           rule;
    
    private SysWorkItemAttach      attach;
    
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    public Long getItemId() {
        return this.itemId;
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
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    public String getItemType() {
        return this.itemType;
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
    
    public void setObjShardingRuleId(Long objShardingRuleId) {
        this.objShardingRuleId = objShardingRuleId;
    }
    
    public Long getObjShardingRuleId() {
        return this.objShardingRuleId;
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
    
    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }
    
    public Long getSheetId() {
        return this.sheetId;
    }
    
    public void setObjShardingId(Long objShardingId) {
        this.objShardingId = objShardingId;
    }
    
    public Long getObjShardingId() {
        return this.objShardingId;
    }
    
    public Long getId() {
        return itemId;
    }
    
    public void setId(Long id) {
        this.itemId = id;
    }
    
    public SysWorkItem() {
        super();
    }
    
    public SysWorkItem(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static ISysWorkItemRepository repository() {
        return (ISysWorkItemRepository) RepositoryRegister.getInstance().getRepository(
            SysWorkItem.class);
    }
    
    public List<SysWorkItemObjVo> getObjList() {
        return objList;
    }
    
    public void setObjList(List<SysWorkItemObjVo> objList) {
        this.objList = objList;
    }
    
    public ShardingRule getRule() {
        return rule;
    }
    
    public void setRule(ShardingRule rule) {
        this.rule = rule;
    }
    
    public SysWorkItemAttach getAttach() {
        return attach;
    }
    
    public void setAttach(SysWorkItemAttach attach) {
        this.attach = attach;
    }
    
    public Timestamp getRecUpdateDate() {
        return recUpdateDate;
    }
    
    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
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
    
    @Override
    public int save() {
        if (this.getAttach() != null) {
            this.getAttach().save();
        }
        return super.save();
    }
    
    @Override
    public int update() {
        if (this.getAttach() != null) {
            if (this.getAttach().isNewEnttity() && !this.getAttach().isSaved()) {
                this.getAttach().save();
            } else {
                this.getAttach().update();
            }
        }
        return super.update();
    }
    
    @Override
    public int remove() {
        if (this.getAttach() != null) {
            this.getAttach().remove();
        }
        return super.remove();
    }
    
}
