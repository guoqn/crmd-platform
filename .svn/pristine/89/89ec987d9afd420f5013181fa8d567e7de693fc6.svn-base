package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicTemplateRepository;


@ShardingBean
@Table(name = "DYNAMIC_TEMPLATE")
public class DynamicTemplate extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 模板序号
	 */
	@Id
	@Column(name = "TEMPLATE_ID")
	private Long templateId;

	/**
	 * 分片键
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 创建记录的员工标识
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 模板编码
	 */
	@Column(name = "TEMPLATE_CODE")
	private String templateCode;

	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 备注
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 模板类型
	 */
	@Column(name = "TEMPLATE_TYPE")
	private String templateType;

	/**
	 * 被应用程序更新的时间
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 租户标识
	 */
	@Column(name = "TENANT_ID")
	private Long tenantId;

	/**
	 * 更新记录的员工标识
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 模板描述
	 */
	@Column(name = "TEMPLATE_DESC")
	private String templateDesc;

	/**
	 * 事件序号
	 */
	@Column(name = "EVENT_ID")
	private Long eventId;

	/**
	 * 模板名称
	 */
	@Column(name = "TEMPLATE_NAME")
	private String templateName;

	/**
	 * 状态：1000有效1100无效
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;


	public void setTemplateId(Long templateId){
		this.templateId = templateId;
	}

	public Long getTemplateId(){
		return this.templateId;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setTemplateCode(String templateCode){
		this.templateCode = templateCode;
	}

	public String getTemplateCode(){
		return this.templateCode;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setTemplateType(String templateType){
		this.templateType = templateType;
	}

	public String getTemplateType(){
		return this.templateType;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setTenantId(Long tenantId){
		this.tenantId = tenantId;
	}

	public Long getTenantId(){
		return this.tenantId;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setTemplateDesc(String templateDesc){
		this.templateDesc = templateDesc;
	}

	public String getTemplateDesc(){
		return this.templateDesc;
	}

	public void setEventId(Long eventId){
		this.eventId = eventId;
	}

	public Long getEventId(){
		return this.eventId;
	}

	public void setTemplateName(String templateName){
		this.templateName = templateName;
	}

	public String getTemplateName(){
		return this.templateName;
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


	public Long getId() {
		return templateId;
	}

	public void setId(Long id) {
		this.templateId = id;
	}
	
	public DynamicTemplate() {
		super();
    }

    public DynamicTemplate(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IDynamicTemplateRepository repository() {
		return (IDynamicTemplateRepository) RepositoryRegister.getInstance()
				.getRepository(DynamicTemplate.class);
	}
	
}
