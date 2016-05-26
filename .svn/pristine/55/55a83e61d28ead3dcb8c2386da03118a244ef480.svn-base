package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.idempotency.core.repository.IProdInstRepository;

//@ShardingBean
@Table(name = "PROD_INST")
public class ProdInst extends AbstractCrmDomBaseEntityImpl<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 产品实例ID的标识，主键
     */
    @Id
    @Column(name = "PROD_INST_ID")
    private Long              prodInstId;
    
    /**
     * 记录地址标识
     */
    @Column(name = "ADDRESS_ID")
    private Long              addressId;
    
    /**
     * 记录重要级别。
     */
    @Column(name = "IMPORTANT_LEVEL")
    private String            importantLevel;
    
    /**
     * 记录功能产品实例对应的接入产品实例ID
     */
    @Column(name = "ACC_PROD_INST_ID")
    private Long              accProdInstId;
    
    /**
     * 产品ID的标识，主键
     */
    @Column(name = "PRODUCT_ID")
    private Long              productId;
    
    /**
     * 
     */
    @Column(name = "CREATE_STAFF")
    private Long              createStaff;
    
    /**
     * 最后修改时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp         updateDate;
    
    /**
     * 区号
     */
    @Column(name = "AREA_CODE")
    private String            areaCode;
    
    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String            remark;
    
    /**
     * 
     */
    @Column(name = "AREA_ID")
    private Long              areaId;
    
    /**
     * 记录竣工时间。
     */
    @Column(name = "FINISH_TIME")
    private Timestamp         finishTime;
    
    /**
     * 记录起租时间。
     */
    @Column(name = "BEGIN_RENT_TIME")
    private Timestamp         beginRentTime;
    
    /**
     * 冗余帐号
     */
    @Column(name = "ACCOUNT")
    private String            account;
    
    /**
     * 状态时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp         statusDate;
    
    /**
     * 
     */
    @Column(name = "UPDATE_STAFF")
    private Long              updateStaff;
    
    /**
     * 记录产品密码。
     */
    @Column(name = "PRODUCT_PASSWORD")
    private String            productPassword;
    
    /**
     * 版本
     */
    @Column(name = "VERSION")
    private Long              version;
    
    /**
     * 记录停租时间。
     */
    @Column(name = "STOP_RENT_TIME")
    private Timestamp         stopRentTime;
    
    /**
     * 付费周期
     */
    @Column(name = "PAY_CYCLE")
    private String            payCycle;
    
    /**
     * 局向标识
     */
    @Column(name = "EXCH_ID")
    private String            exchId;
    
    /**
     * 记录变更时间
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp         recUpdateDate;
    
    /**
     * 冗余字段
     */
    @Column(name = "ACC_NBR")
    private String            accNbr;
    
    /**
     * 分片键
     */
    //@ShardingId
    @Column(name = "SHARDING_ID")
    private Long              shardingId;
    
    /**
     * 地址描述信息
     */
    @Column(name = "ADDRESS_DESC")
    private String            addressDesc;
    
    /**
     * 处理流水
     */
    @Column(name = "PROC_SERIAL")
    private String            procSerial;
    
    /**
     * 
     */
    @Column(name = "COMMUNITY_ID")
    private Long              communityId;
    
    /**
     * 外部接入产品实例ID
     */
    @Column(name = "EXT_ACC_PROD_INST_ID")
    private String            extAccProdInstId;
    
    /**
     * 记录区域标识。
     */
    @Column(name = "COMMON_REGION_ID")
    private Long              commonRegionId;
    
    /**
     * 停机状态
     */
    @Column(name = "STOP_STATUS")
    private String            stopStatus;
    
    /**
     * 主键
     */
    @Column(name = "OWNER_CUST_ID")
    private Long              ownerCustId;
    
    /**
     * 使用客户标识
     */
    @Column(name = "USE_CUST_ID")
    private Long              useCustId;
    
    /**
     * 合作商标识
     */
    @Column(name = "DISTRIBUTOR_ID")
    private String            distributorId;
    
    /**
     * 外部产品实例标识
     */
    @Column(name = "EXT_PROD_INST_ID")
    private String            extProdInstId;
    
    /**
     * 付费模式CD：11=预付费；10=后付费
     */
    @Column(name = "PAYMENT_MODE_CD")
    private String            paymentModeCd;
    
    /**
     * 状态CD
     */
    @Column(name = "STATUS_CD")
    private String            statusCd;
    
    /**
     * 记录创建时间。
     */
    @Column(name = "CREATE_DATE")
    private Timestamp         createDate;
    
    public void setProdInstId(Long prodInstId) {
        this.prodInstId = prodInstId;
    }
    
    public Long getProdInstId() {
        return this.prodInstId;
    }
    
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    
    public Long getAddressId() {
        return this.addressId;
    }
    
    public void setImportantLevel(String importantLevel) {
        this.importantLevel = importantLevel;
    }
    
    public String getImportantLevel() {
        return this.importantLevel;
    }
    
    public void setAccProdInstId(Long accProdInstId) {
        this.accProdInstId = accProdInstId;
    }
    
    public Long getAccProdInstId() {
        return this.accProdInstId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public Long getProductId() {
        return this.productId;
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
    
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    
    public String getAreaCode() {
        return this.areaCode;
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
    
    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }
    
    public Timestamp getFinishTime() {
        return this.finishTime;
    }
    
    public void setBeginRentTime(Timestamp beginRentTime) {
        this.beginRentTime = beginRentTime;
    }
    
    public Timestamp getBeginRentTime() {
        return this.beginRentTime;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getAccount() {
        return this.account;
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
    
    public void setProductPassword(String productPassword) {
        this.productPassword = productPassword;
    }
    
    public String getProductPassword() {
        return this.productPassword;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public Long getVersion() {
        return this.version;
    }
    
    public void setStopRentTime(Timestamp stopRentTime) {
        this.stopRentTime = stopRentTime;
    }
    
    public Timestamp getStopRentTime() {
        return this.stopRentTime;
    }
    
    public void setPayCycle(String payCycle) {
        this.payCycle = payCycle;
    }
    
    public String getPayCycle() {
        return this.payCycle;
    }
    
    public void setExchId(String exchId) {
        this.exchId = exchId;
    }
    
    public String getExchId() {
        return this.exchId;
    }
    
    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }
    
    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }
    
    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
    }
    
    public String getAccNbr() {
        return this.accNbr;
    }
    
    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }
    
    public Long getShardingId() {
        return this.shardingId;
    }
    
    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }
    
    public String getAddressDesc() {
        return this.addressDesc;
    }
    
    public void setProcSerial(String procSerial) {
        this.procSerial = procSerial;
    }
    
    public String getProcSerial() {
        return this.procSerial;
    }
    
    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }
    
    public Long getCommunityId() {
        return this.communityId;
    }
    
    public void setExtAccProdInstId(String extAccProdInstId) {
        this.extAccProdInstId = extAccProdInstId;
    }
    
    public String getExtAccProdInstId() {
        return this.extAccProdInstId;
    }
    
    public void setCommonRegionId(Long commonRegionId) {
        this.commonRegionId = commonRegionId;
    }
    
    public Long getCommonRegionId() {
        return this.commonRegionId;
    }
    
    public void setStopStatus(String stopStatus) {
        this.stopStatus = stopStatus;
    }
    
    public String getStopStatus() {
        return this.stopStatus;
    }
    
    public void setOwnerCustId(Long ownerCustId) {
        this.ownerCustId = ownerCustId;
    }
    
    public Long getOwnerCustId() {
        return this.ownerCustId;
    }
    
    public void setUseCustId(Long useCustId) {
        this.useCustId = useCustId;
    }
    
    public Long getUseCustId() {
        return this.useCustId;
    }
    
    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }
    
    public String getDistributorId() {
        return this.distributorId;
    }
    
    public void setExtProdInstId(String extProdInstId) {
        this.extProdInstId = extProdInstId;
    }
    
    public String getExtProdInstId() {
        return this.extProdInstId;
    }
    
    public void setPaymentModeCd(String paymentModeCd) {
        this.paymentModeCd = paymentModeCd;
    }
    
    public String getPaymentModeCd() {
        return this.paymentModeCd;
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
        return prodInstId;
    }
    
    public void setId(Long id) {
        this.prodInstId = id;
    }
    
    public ProdInst() {
        super();
    }
    
    public ProdInst(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static IProdInstRepository repository() {
        return (IProdInstRepository) RepositoryRegister.getInstance().getRepository(ProdInst.class);
    }
    
}
