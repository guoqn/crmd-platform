package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;


public class DynamicTemplateDTO extends DomBaseDTO {

	/**
	 * 模板序号
	 */
	private Long templateId;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 模板编码
	 */
	private String templateCode;

	/**
	 * 模板类型
	 */
	private String templateType;

	/**
	 * 租户标识
	 */
	private Long tenantId;

	/**
	 * 模板描述
	 */
	private String templateDesc;

	/**
	 * 事件序号
	 */
	private Long eventId;

	/**
	 * 模板名称
	 */
	private String templateName;


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

	public void setTemplateCode(String templateCode){
		this.templateCode = templateCode;
	}

	public String getTemplateCode(){
		return this.templateCode;
	}

	public void setTemplateType(String templateType){
		this.templateType = templateType;
	}

	public String getTemplateType(){
		return this.templateType;
	}

	public void setTenantId(Long tenantId){
		this.tenantId = tenantId;
	}

	public Long getTenantId(){
		return this.tenantId;
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


}
