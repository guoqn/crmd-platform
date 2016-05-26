package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.idempotency.core.repository.IMktResourceRepository;

@ShardingBean
@Table(name = "MKT_RESOURCE")
public class MktResource extends AbstractCrmDomBaseEntityImpl<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 营销资源ID
     */
    @Id
    @Column(name = "MKT_RESO_ID")
    private Long              mktResoId;
    
    /**
     * 新旧实物
     */
    @Column(name = "STORE_TYPE")
    private String            storeType;
    
    /**
     * 状态zbfl='MKT_RESO_STATE'
     */
    @Column(name = "STATE")
    private String            state;
    
    /**
     * 
     */
    @Column(name = "REMARKS")
    private String            remarks;
    
    /**
     * 外部营销资源实例ID
     */
    @Column(name = "EXT_MKT_RES_INST_ID")
    private String            extMktResInstId;
    
    /**
     * 
     */
    @Column(name = "ICCS_EXT")
    private String            iccsExt;
    
    /**
     * 回收状态：70I回收中
     */
    @Column(name = "BACK_STATE")
    private String            backState;
    
    /**
     * 
     */
    @Column(name = "REAL_MODIFY_DATE")
    private Timestamp         realModifyDate;
    
    /**
     * 
     */
    @Column(name = "STATE_REMARK")
    private String            stateRemark;
    
    /**
     * 仓库标识
     */
    @Column(name = "STORAGE_ID")
    private Long              storageId;
    
    /**
     * 实物标识码
     */
    @Column(name = "MKT_RESO_KEY")
    private String            mktResoKey;
    
    /**
     * 
     */
    @Column(name = "ICCS")
    private String            iccs;
    
    /**
     * 创建时间
     */
    @Column(name = "CREA_TIME")
    private Timestamp         creaTime;
    
    /**
     * 
     */
    @Column(name = "BACK_TYPE")
    private String            backType;
    
    /**
     * 
     */
    @Column(name = "TO_STAFF_ID")
    private String            toStaffId;
    
    /**
     * 修改时间
     */
    @Column(name = "MODI_TIME")
    private Timestamp         modiTime;
    
    /**
     * 分片键
     */
    @ShardingId
    @Column(name = "SHARDING_ID")
    private Long              shardingId;
    
    /**
     * 实物大类
     */
    @Column(name = "MKT_RESO_SPEC_TYPE")
    private Long              mktResoSpecType;
    
    /**
     * 实例来源：MSS
     */
    @Column(name = "MKT_SOURCE")
    private String            mktSource;
    
    /**
     * 缴费方式：1普通调拨、2结算调拨、3押金调拨
     */
    @Column(name = "ORDER_PAY")
    private String            orderPay;
    
    /**
     * 营销资源规格标识
     */
    @Column(name = "MKT_RESO_SPEC_ID")
    private Long              mktResoSpecId;
    
    /**
     * 
     */
    @Column(name = "TO_STAFF_DATE")
    private Timestamp         toStaffDate;
    
    /**
     * 
     */
    @Column(name = "SALESTATE")
    private String            salestate;
    
    /**
     * 合作商标识
     */
    @Column(name = "DISTRIBUTOR_ID")
    private String            distributorId;
    
    /**
     * 实物批次
     */
    @Column(name = "BATCH_ID")
    private String            batchId;
    
    public void setMktResoId(Long mktResoId) {
        this.mktResoId = mktResoId;
    }
    
    public Long getMktResoId() {
        return this.mktResoId;
    }
    
    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }
    
    public String getStoreType() {
        return this.storeType;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setExtMktResInstId(String extMktResInstId) {
        this.extMktResInstId = extMktResInstId;
    }
    
    public String getExtMktResInstId() {
        return this.extMktResInstId;
    }
    
    public void setIccsExt(String iccsExt) {
        this.iccsExt = iccsExt;
    }
    
    public String getIccsExt() {
        return this.iccsExt;
    }
    
    public void setBackState(String backState) {
        this.backState = backState;
    }
    
    public String getBackState() {
        return this.backState;
    }
    
    public void setRealModifyDate(Timestamp realModifyDate) {
        this.realModifyDate = realModifyDate;
    }
    
    public Timestamp getRealModifyDate() {
        return this.realModifyDate;
    }
    
    public void setStateRemark(String stateRemark) {
        this.stateRemark = stateRemark;
    }
    
    public String getStateRemark() {
        return this.stateRemark;
    }
    
    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    
    public Long getStorageId() {
        return this.storageId;
    }
    
    public void setMktResoKey(String mktResoKey) {
        this.mktResoKey = mktResoKey;
    }
    
    public String getMktResoKey() {
        return this.mktResoKey;
    }
    
    public void setIccs(String iccs) {
        this.iccs = iccs;
    }
    
    public String getIccs() {
        return this.iccs;
    }
    
    public void setCreaTime(Timestamp creaTime) {
        this.creaTime = creaTime;
    }
    
    public Timestamp getCreaTime() {
        return this.creaTime;
    }
    
    public void setBackType(String backType) {
        this.backType = backType;
    }
    
    public String getBackType() {
        return this.backType;
    }
    
    public void setToStaffId(String toStaffId) {
        this.toStaffId = toStaffId;
    }
    
    public String getToStaffId() {
        return this.toStaffId;
    }
    
    public void setModiTime(Timestamp modiTime) {
        this.modiTime = modiTime;
    }
    
    public Timestamp getModiTime() {
        return this.modiTime;
    }
    
    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }
    
    public Long getShardingId() {
        return this.shardingId;
    }
    
    public void setMktResoSpecType(Long mktResoSpecType) {
        this.mktResoSpecType = mktResoSpecType;
    }
    
    public Long getMktResoSpecType() {
        return this.mktResoSpecType;
    }
    
    public void setMktSource(String mktSource) {
        this.mktSource = mktSource;
    }
    
    public String getMktSource() {
        return this.mktSource;
    }
    
    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }
    
    public String getOrderPay() {
        return this.orderPay;
    }
    
    public void setMktResoSpecId(Long mktResoSpecId) {
        this.mktResoSpecId = mktResoSpecId;
    }
    
    public Long getMktResoSpecId() {
        return this.mktResoSpecId;
    }
    
    public void setToStaffDate(Timestamp toStaffDate) {
        this.toStaffDate = toStaffDate;
    }
    
    public Timestamp getToStaffDate() {
        return this.toStaffDate;
    }
    
    public void setSalestate(String salestate) {
        this.salestate = salestate;
    }
    
    public String getSalestate() {
        return this.salestate;
    }
    
    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }
    
    public String getDistributorId() {
        return this.distributorId;
    }
    
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    
    public String getBatchId() {
        return this.batchId;
    }
    
    public Long getId() {
        return mktResoId;
    }
    
    public void setId(Long id) {
        this.mktResoId = id;
    }
    
    public MktResource() {
        super();
    }
    
    public MktResource(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static IMktResourceRepository repository() {
        return (IMktResourceRepository) RepositoryRegister.getInstance().getRepository(
            MktResource.class);
    }
    
}
