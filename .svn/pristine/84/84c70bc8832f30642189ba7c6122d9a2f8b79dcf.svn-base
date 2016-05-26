package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.repository.ISysConfigRepository;


@Table(name = "SYS_CONFIG")
public class SysConfig extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 主键序列
	 */
	@Id
	@Column(name = "CONF_ID")
	private Long confId;

	/**
	 * 归属区域标识
	 */
	@Column(name = "REGION_CD")
	private Long regionCd;

	/**
	 * 节点名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 记录创建人
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 节点值
	 */
	@Column(name = "NODEVALUE")
	private String nodeValue;

	/**
	 * 记录更新时间
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 区域标识
	 */
	@Column(name = "AREA_ID")
	private Long areaId;

	/**
	 * 记录状态变动时间。
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 记录修改人
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 状态
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 记录创建时间。
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 上级Id
	 */
	@Column(name = "PARENT_ID")
	private Long parentId;

	/**
	 * 编码
	 */
	@Column(name = "CODE")
	private String code;

	/**
	 * 配置描述
	 */
	@Column(name = "SYS_CONF_DESC")
	private String sysConfDesc;


	public void setConfId(Long confId){
		this.confId = confId;
	}

	public Long getConfId(){
		return this.confId;
	}

	public void setRegionCd(Long regionCd){
		this.regionCd = regionCd;
	}

	public Long getRegionCd(){
		return this.regionCd;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public String getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(String nodeValue) {
		this.nodeValue = nodeValue;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
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

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
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

	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	public Long getParentId(){
		return this.parentId;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return this.code;
	}

	public void setSysConfDesc(String sysConfDesc){
		this.sysConfDesc = sysConfDesc;
	}

	public String getSysConfDesc(){
		return this.sysConfDesc;
	}


	public Long getId() {
		return confId;
	}

	public void setId(Long id) {
		this.confId = id;
	}
	
	public SysConfig() {
		super();
    }

    public SysConfig(boolean genId) {
        super(genId);
    }

	public static ISysConfigRepository repository() {
		return (ISysConfigRepository) RepositoryRegister.getInstance()
				.getRepository(SysConfig.class);
	}
	@Override
	public boolean isUseMeta() {
		return false;
	}
	
}
