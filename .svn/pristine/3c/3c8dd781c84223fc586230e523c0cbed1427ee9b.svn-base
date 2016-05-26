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
import com.ffcs.crmd.platform.idempotency.core.repository.ISysWorkSheetRepository;

@ShardingBean
@Table(name = "SYS_WORK_SHEET")
public class SysWorkSheet extends AbstractIdempotencyEntity<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 主键
     */
    @Id
    @Column(name = "SHEET_ID")
    private Long              sheetId;
    
    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp         recUpdateDate;
    
    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long              regionCd;
    
    /**
     * 分片标识
     */
    @ShardingId
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
    
    /**
     * 事件大类
     */
    @Column(name = "SHEET_TYPE")
    private String            sheetType;
    
    /**
     * 根据一定规则生成的事件集编码
     */
    @Column(name = "SHEET_CD")
    private String            sheetCd;
    
    /**
     * 事务事件项列表
     */
    private List<SysWorkItem> sysWorkItemList  = new ArrayList<SysWorkItem>();
    
    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }
    
    public Long getSheetId() {
        return this.sheetId;
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
    
    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
    }
    
    public String getSheetType() {
        return this.sheetType;
    }
    
    public void setSheetCd(String sheetCd) {
        this.sheetCd = sheetCd;
    }
    
    public String getSheetCd() {
        return this.sheetCd;
    }
    
    public Long getId() {
        return sheetId;
    }
    
    public void setId(Long id) {
        this.sheetId = id;
    }
    
    public SysWorkSheet() {
        super();
    }
    
    public SysWorkSheet(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static ISysWorkSheetRepository repository() {
        return (ISysWorkSheetRepository) RepositoryRegister.getInstance().getRepository(
            SysWorkSheet.class);
    }
    
    public List<SysWorkItem> getSysWorkItemList() {
        if (!this.isNewEnttity() && !this.isLoaded("sysWorkItemList")) {
            List<SysWorkItem> list = SysWorkItem.repository().querySysWorkItemBySheetId(
                this.getId());
            if (list != null && list.size() > 0) {
                this.sysWorkItemList.addAll(list);
            }
            this.Loaded("sysWorkItemList");
        }
        return sysWorkItemList;
    }
    
    public void setSysWorkItemList(List<SysWorkItem> sysWorkItemList) {
        this.sysWorkItemList = sysWorkItemList;
    }
    
    public void addSysWorkItem(SysWorkItem sysWorkItem) {
        if (this.getSysWorkItemList().contains(sysWorkItem)) {
            this.getSysWorkItemList().add(sysWorkItem);
        }
    }
    
    @Override
    public int save() {
        for (SysWorkItem item : this.getSysWorkItemList()) {
            item.save();
        }
        return super.save();
    }
    
    @Override
    public int update() {
        for (SysWorkItem item : this.getSysWorkItemList()) {
            if (item.isNewEnttity() && !item.isSaved()) {
                item.save();
            } else {
                item.update();
            }
        }
        return super.update();
    }
    
    @Override
    public int remove() {
        for (SysWorkItem item : this.getSysWorkItemList()) {
            item.remove();
        }
        return super.remove();
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
    
}
