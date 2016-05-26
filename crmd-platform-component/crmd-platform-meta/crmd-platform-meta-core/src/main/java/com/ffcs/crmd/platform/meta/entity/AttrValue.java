package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.repository.IAttrValueRepository;


@Table(name = "ATTR_VALUE")
public class AttrValue extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 
	 */
	@Id
	@Column(name = "ATTR_VALUE_ID")
	private Long attrValueId;

	/**
	 * 
	 */
	@Column(name = "ATTR_VALUE_SEQ")
	private Short attrValueSeq;

	/**
	 * 
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 
	 */
	@Column(name = "ATTR_DESC")
	private String attrDesc;

	/**
	 * 
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 
	 */
	@Column(name = "ATTR_FORMAT")
	private String attrFormat;

	/**
	 * 
	 */
	@Column(name = "MANAGE_GRADE")
	private String manageGrade;

	/**
	 * 
	 */
	@Column(name = "GROUP_CD")
	private String groupCd;

	/**
	 * 
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * ʧЧʱ
	 */
	@Column(name = "EXP_DATE")
	private Timestamp expDate;

	/**
	 * 
	 */
	@Column(name = "MAX_VALUE")
	private String maxValue;

	/**
	 * 
	 */
	@Column(name = "ATTR_VALUE_NAME")
	private String attrValueName;

	/**
	 * ҵ
	 */
	@Column(name = "ATTR_ID")
	private Long attrId;

	/**
	 * 
	 */
	@Column(name = "IS_TRANS")
	private String isTrans;

	/**
	 * 
	 */
	@Column(name = "EFF_DATE")
	private Timestamp effDate;

	/**
	 * 
	 */
	@Column(name = "PARENT_VALUE_ID")
	private Long parentValueId;

	/**
	 * 
	 */
	@Column(name = "ATTR_VALUE")
	private String attrValue;

	/**
	 * 
	 */
	@Column(name = "ATTR_LENGTH")
	private Long attrLength;

	/**
	 * 
	 */
	@Column(name = "ATTR_VALUE_TYPE")
	private String attrValueType;

	/**
	 * ״̬
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 
	 */
	@Column(name = "MIN_VALUE")
	private String minValue;


	public void setAttrValueId(Long attrValueId){
		this.attrValueId = attrValueId;
	}

	public Long getAttrValueId(){
		return this.attrValueId;
	}

	public void setAttrValueSeq(Short attrValueSeq){
		this.attrValueSeq = attrValueSeq;
	}

	public Short getAttrValueSeq(){
		return this.attrValueSeq;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setAttrDesc(String attrDesc){
		this.attrDesc = attrDesc;
	}

	public String getAttrDesc(){
		return this.attrDesc;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setAreaId(Long areaId){
		this.areaId = areaId;
	}

	public Long getAreaId(){
		return this.areaId;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setAttrFormat(String attrFormat){
		this.attrFormat = attrFormat;
	}

	public String getAttrFormat(){
		return this.attrFormat;
	}

	public void setManageGrade(String manageGrade){
		this.manageGrade = manageGrade;
	}

	public String getManageGrade(){
		return this.manageGrade;
	}

	public void setGroupCd(String groupCd){
		this.groupCd = groupCd;
	}

	public String getGroupCd(){
		return this.groupCd;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setExpDate(Timestamp expDate){
		this.expDate = expDate;
	}

	public Timestamp getExpDate(){
		return this.expDate;
	}

	public void setMaxValue(String maxValue){
		this.maxValue = maxValue;
	}

	public String getMaxValue(){
		return this.maxValue;
	}

	public void setAttrValueName(String attrValueName){
		this.attrValueName = attrValueName;
	}

	public String getAttrValueName(){
		return this.attrValueName;
	}

	public void setAttrId(Long attrId){
		this.attrId = attrId;
	}

	public Long getAttrId(){
		return this.attrId;
	}

	public void setIsTrans(String isTrans){
		this.isTrans = isTrans;
	}

	public String getIsTrans(){
		return this.isTrans;
	}

	public void setEffDate(Timestamp effDate){
		this.effDate = effDate;
	}

	public Timestamp getEffDate(){
		return this.effDate;
	}

	public void setParentValueId(Long parentValueId){
		this.parentValueId = parentValueId;
	}

	public Long getParentValueId(){
		return this.parentValueId;
	}

	public void setAttrValue(String attrValue){
		this.attrValue = attrValue;
	}

	public String getAttrValue(){
		return this.attrValue;
	}

	public void setAttrLength(Long attrLength){
		this.attrLength = attrLength;
	}

	public Long getAttrLength(){
		return this.attrLength;
	}

	public void setAttrValueType(String attrValueType){
		this.attrValueType = attrValueType;
	}

	public String getAttrValueType(){
		return this.attrValueType;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}

	public void setMinValue(String minValue){
		this.minValue = minValue;
	}

	public String getMinValue(){
		return this.minValue;
	}


	public Long getId() {
		return attrValueId;
	}

	public void setId(Long id) {
		this.attrValueId = id;
	}
	
	public AttrValue() {
		super();
    }

    public AttrValue(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IAttrValueRepository repository() {
		return (IAttrValueRepository) RepositoryRegister.getInstance()
				.getRepository(AttrValue.class);
	}

	@Override
	public boolean isUseMeta() {
		return false;
	}
}
