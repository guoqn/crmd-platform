package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

public class DynamicPartDTO extends DomBaseDTO {

	/**
	 * 构件序号
	 */
	private Long partId;

	/**
	 * 构件描述
	 */
	private String partDesc;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 构件类型
	 */
	private String partType;

	// 类型名称
	private String partTypeName;

	/**
	 * 构件名称
	 */
	private String partName;

	/**
	 * 构件编码
	 */
	private String partCode;

	/**
	 * 租户标识
	 */
	private Long tenantId;

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public Long getPartId() {
		return this.partId;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	public String getPartDesc() {
		return this.partDesc;
	}

	public void setShardingId(Long shardingId) {
		this.shardingId = shardingId;
	}

	public Long getShardingId() {
		return this.shardingId;
	}

	public void setPartType(String partType) {
		this.partType = partType;
		if (partType != null) {
			if (this.partType.equals("base")) {
				this.partTypeName = "基础构件";
			} else if (this.partType.equals("busi")) {
				this.partTypeName = "业务构件";
			}
		}
	}

	public String getPartType() {
		return this.partType;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartName() {
		return this.partName;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartCode() {
		return this.partCode;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return this.tenantId;
	}

	public String getPartTypeName() {
		return partTypeName;
	}

	public void setPartTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
	}
}
