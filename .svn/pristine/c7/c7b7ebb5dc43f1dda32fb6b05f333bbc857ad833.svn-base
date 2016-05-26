package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.idempotency.core.repository.ISysWorkItemAttachRepository;

@ShardingBean
@Table(name = "SYS_WORK_ITEM_ATTACH")
public class SysWorkItemAttach extends AbstractIdempotencyEntity<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 主键
     */
    @Id
    @Column(name = "ITEM_ID")
    private Long              itemId;
    
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
     * 存储事件项关联对象ID
     */
    @Column(name = "CONTENT")
    private String            content;
    
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
    
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    public Long getItemId() {
        return this.itemId;
    }
    
    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }
    
    public Long getShardingId() {
        return this.shardingId;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
    
    public Timestamp getUpdateDate() {
        return this.updateDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public Long getId() {
        return itemId;
    }
    
    public void setId(Long id) {
        this.itemId = id;
    }
    
    public SysWorkItemAttach() {
        super();
    }
    
    public SysWorkItemAttach(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static ISysWorkItemAttachRepository repository() {
        return (ISysWorkItemAttachRepository) RepositoryRegister.getInstance().getRepository(
            SysWorkItemAttach.class);
    }
    
    public Timestamp getRecUpdateDate() {
        return recUpdateDate;
    }
    
    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }
    
    public Long getRegionCd() {
        return regionCd;
    }
    
    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }
    
    public Long getCreateStaff() {
        return createStaff;
    }
    
    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Long getAreaId() {
        return areaId;
    }
    
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    
    public Timestamp getStatusDate() {
        return statusDate;
    }
    
    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
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
    
    public Long getUpdateStaff() {
        return updateStaff;
    }
    
    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }
    
    public String getStatusCd() {
        return statusCd;
    }
    
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }
    
}
