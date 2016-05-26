package com.ffcs.crmd.platform.idempotency.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.idempotency.core.repository.ICustRepository;

@ShardingBean
@Table(name = "CUST")
public class Cust extends AbstractCrmDomBaseEntityImpl<Long> {
    
    private static final long serialVersionUID = -2811347047325737314L;
    
    /**
     * 主键
     */
    @Id
    @Column(name = "CUST_ID")
    private Long              custId;
    
    /**
     * 记录客户重要级别。
     */
    @Column(name = "IMPORTANT_LEVEL")
    private String            importantLevel;
    
    /**
     * 县局区域标识
     */
    @Column(name = "REGION_CD")
    private Long              regionCd;
    
    /**
     * 记录参与人唯一标识，作为主键。
     */
    @Column(name = "PARTY_ID")
    private Long              partyId;
    
    /**
     * 行业类型CD
     */
    @Column(name = "INDUSTRY_CD")
    private String            industryCd;
    
    /**
     * 创建员工
     */
    @Column(name = "CREATE_STAFF")
    private Long              createStaff;
    
    /**
     * 最后修改时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp         updateDate;
    
    /**
     * 记录客户战略下属分群
     */
    @Column(name = "CUST_SUB_TYPE")
    private String            custSubType;
    
    /**
     * C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long              areaId;
    
    /**
     * 状态变更的时间。
     */
    @Column(name = "STATUS_DATE")
    private Timestamp         statusDate;
    
    /**
     * 记录客户地址。
     */
    @Column(name = "CUST_ADDRESS")
    private String            custAddress;
    
    /**
     * 更新员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long              updateStaff;
    
    /**
     * 记录客户归属区域级别，包括集团客户、跨省客户、省内客户。
     */
    @Column(name = "CUST_AREA_GRADE")
    private String            custAreaGrade;
    
    /**
     * 记录统一编码。
     */
    @Column(name = "CUST_NUMBER")
    private String            custNumber;
    
    /**
     * 记录集团客户序号
     */
    @Column(name = "GROUP_CUST_SEQ")
    private String            groupCustSeq;
    
    /**
     * 客户地址标识
     */
    @Column(name = "CUST_ADDRESS_ID")
    private String            custAddressId;
    
    /**
     * 记录变更时间
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp         recUpdateDate;
    
    /**
     * 分片键
     */
    @ShardingId
    @Column(name = "SHARDING_ID")
    private Long              shardingId;
    
    /**
     * 本年度客户类型
     */
    @Column(name = "CUR_YEAR_TYPE")
    private String            curYearType;
    
    /**
     * 处理流水
     */
    @Column(name = "PROC_SERIAL")
    private String            procSerial;
    
    /**
     * 记录客户战略分群，如：政企、家庭、个人
     */
    @Column(name = "CUST_TYPE")
    private String            custType;
    
    /**
     * 记录区域标识。
     */
    @Column(name = "COMMON_REGION_ID")
    private Long              commonRegionId;
    
    /**
     * 外部客户标识
     */
    @Column(name = "EXT_CUST_ID")
    private String            extCustId;
    
    /**
     * 操作用户
     */
    @Column(name = "STAFF_ID")
    private Long              staffId;
    
    /**
     * 合作商标识
     */
    @Column(name = "DISTRIBUTOR_ID")
    private String            distributorId;
    
    /**
     * 记录客户生命周期状态，如潜在、在网、离网。
     */
    @Column(name = "STATUS_CD")
    private String            statusCd;
    
    /**
     * 修改时间
     */
    @Column(name = "MOD_DATE")
    private Timestamp         modDate;
    
    /**
     * 记录入网时间。
     */
    @Column(name = "ENTER_DATE")
    private Timestamp         enterDate;
    
    /**
     * 记录创建时间。
     */
    @Column(name = "CREATE_DATE")
    private Timestamp         createDate;
    
    public void setCustId(Long custId) {
        this.custId = custId;
    }
    
    public Long getCustId() {
        return this.custId;
    }
    
    public void setImportantLevel(String importantLevel) {
        this.importantLevel = importantLevel;
    }
    
    public String getImportantLevel() {
        return this.importantLevel;
    }
    
    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }
    
    public Long getRegionCd() {
        return this.regionCd;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setIndustryCd(String industryCd) {
        this.industryCd = industryCd;
    }
    
    public String getIndustryCd() {
        return this.industryCd;
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
    
    public void setCustSubType(String custSubType) {
        this.custSubType = custSubType;
    }
    
    public String getCustSubType() {
        return this.custSubType;
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
    
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
    public String getCustAddress() {
        return this.custAddress;
    }
    
    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }
    
    public Long getUpdateStaff() {
        return this.updateStaff;
    }
    
    public void setCustAreaGrade(String custAreaGrade) {
        this.custAreaGrade = custAreaGrade;
    }
    
    public String getCustAreaGrade() {
        return this.custAreaGrade;
    }
    
    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }
    
    public String getCustNumber() {
        return this.custNumber;
    }
    
    public void setGroupCustSeq(String groupCustSeq) {
        this.groupCustSeq = groupCustSeq;
    }
    
    public String getGroupCustSeq() {
        return this.groupCustSeq;
    }
    
    public void setCustAddressId(String custAddressId) {
        this.custAddressId = custAddressId;
    }
    
    public String getCustAddressId() {
        return this.custAddressId;
    }
    
    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }
    
    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }
    
    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }
    
    public Long getShardingId() {
        return this.shardingId;
    }
    
    public void setCurYearType(String curYearType) {
        this.curYearType = curYearType;
    }
    
    public String getCurYearType() {
        return this.curYearType;
    }
    
    public void setProcSerial(String procSerial) {
        this.procSerial = procSerial;
    }
    
    public String getProcSerial() {
        return this.procSerial;
    }
    
    public void setCustType(String custType) {
        this.custType = custType;
    }
    
    public String getCustType() {
        return this.custType;
    }
    
    public void setCommonRegionId(Long commonRegionId) {
        this.commonRegionId = commonRegionId;
    }
    
    public Long getCommonRegionId() {
        return this.commonRegionId;
    }
    
    public void setExtCustId(String extCustId) {
        this.extCustId = extCustId;
    }
    
    public String getExtCustId() {
        return this.extCustId;
    }
    
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
    
    public Long getStaffId() {
        return this.staffId;
    }
    
    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }
    
    public String getDistributorId() {
        return this.distributorId;
    }
    
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }
    
    public String getStatusCd() {
        return this.statusCd;
    }
    
    public void setModDate(Timestamp modDate) {
        this.modDate = modDate;
    }
    
    public Timestamp getModDate() {
        return this.modDate;
    }
    
    public void setEnterDate(Timestamp enterDate) {
        this.enterDate = enterDate;
    }
    
    public Timestamp getEnterDate() {
        return this.enterDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public Long getId() {
        return custId;
    }
    
    public void setId(Long id) {
        this.custId = id;
    }
    
    public Cust() {
        super();
    }
    
    public Cust(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }
    
    public static ICustRepository repository() {
        return (ICustRepository) RepositoryRegister.getInstance().getRepository(Cust.class);
    }
    
}
