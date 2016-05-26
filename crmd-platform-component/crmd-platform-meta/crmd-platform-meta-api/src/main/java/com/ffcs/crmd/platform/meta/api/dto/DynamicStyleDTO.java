package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

/**
 * 样式
 * 
 * @author LAIYONGMIN-PC
 *
 */
public class DynamicStyleDTO extends DomBaseDTO {

	/**
	 * 样式序号
	 */
	private Long styleId;

	private Long id;

	/**
	 * 样式属性
	 */
	private String styleAttr;

	/**
	 * 样式名称
	 */
	private String styleName;

	private String name;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 上级样式序号
	 */
	private Long pStyleId;

	private Long pId;

	/**
	 * 租户标识
	 */
	private Long tenantId;

	/**
	 * 样式属性值
	 */
	private String styleAttrValue;

	/**
	 * 组件序号
	 */
	private Long componentId;

	/**
	 * 样式类型
	 */
	private String styleType;

	// 是否父节点
	private Boolean isParent;

	// 关联样式编码
	private Long relaStyleId;

	/**
	 * 操作类型
	 */
	private String opType;

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Long getStyleId() {
		return this.styleId;
	}

	public void setStyleAttr(String styleAttr) {
		this.styleAttr = styleAttr;
	}

	public String getStyleAttr() {
		return this.styleAttr;
	}

	public void setShardingId(Long shardingId) {
		this.shardingId = shardingId;
	}

	public Long getShardingId() {
		return this.shardingId;
	}

	public void setpStyleId(Long pStyleId) {
		this.pStyleId = pStyleId;
	}

	public Long getpStyleId() {
		return this.pStyleId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return this.tenantId;
	}

	public void setStyleAttrValue(String styleAttrValue) {
		this.styleAttrValue = styleAttrValue;
	}

	public String getStyleAttrValue() {
		return this.styleAttrValue;
	}

	public Long getComponentId() {
		return componentId;
	}

	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}

	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}

	public String getStyleType() {
		return this.styleType;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Long getpId() {
		return this.pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRelaStyleId() {
		return relaStyleId;
	}

	public void setRelaStyleId(Long relaStyleId) {
		this.relaStyleId = relaStyleId;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

}
