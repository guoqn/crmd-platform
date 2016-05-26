package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;


public class DynamicTempPartRelDTO extends DomBaseDTO {

	/**
	 * 构件序号
	 */
	private Long partId;

	/**
	 * 顺序
	 */
	private Long relOrder;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 模板序号
	 */
	private Long templateId;

	/**
	 * 租户标识
	 */
	private Long tenantId;


	public void setPartId(Long partId){
		this.partId = partId;
	}

	public Long getPartId(){
		return this.partId;
	}

	public void setRelOrder(Long relOrder){
		this.relOrder = relOrder;
	}

	public Long getRelOrder(){
		return this.relOrder;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setTemplateId(Long templateId){
		this.templateId = templateId;
	}

	public Long getTemplateId(){
		return this.templateId;
	}

	public void setTenantId(Long tenantId){
		this.tenantId = tenantId;
	}

	public Long getTenantId(){
		return this.tenantId;
	}


}
