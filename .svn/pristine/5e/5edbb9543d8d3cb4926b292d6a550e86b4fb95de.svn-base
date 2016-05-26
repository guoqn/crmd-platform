package com.ffcs.crmd.platform.meta.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

/**
 * 组件
 * 
 * @author LAIYONGMIN-PC
 *
 */
public class DynamicComponentDTO extends DomBaseDTO {

	/**
	 * 组件序号
	 */
	private Long componentId;

	/**
	 * 组合组件(窗体、构件)
	 */
	private String groupCode;

	/**
	 * 组件编码
	 */
	private String componentCode;

	/**
	 * 分片键
	 */
	private Long shardingId;

	/**
	 * 业务属性序号
	 */
	private Long busAttrId;

	/**
	 * 租户标识
	 */
	private Long tenantId;

	/**
	 * 组件名称
	 */
	private String componentName;

	/**
	 * 父级组件序号
	 */
	private Long pComponentId;

	/**
	 * 业务属性名称
	 */
	private String busAttrName;

	/**
	 * 窗体序号
	 */
	private Long windowId;

	/**
	 * 业务属性类型
	 */
	private String busAttrType;

	/**
	 * 业务属性编码
	 */
	private String busAttrCode;

	/**
	 * 组件类型
	 */
	private String componentType;

	/**
	 * 组件提示
	 */
	private String componentTip;

	/**
	 * 组件描述
	 */
	private String componentDesc;

	/**
	 * 组件行
	 */
	private Long componentRows;

	/**
	 * 表达式
	 */
	private String componentExp;

	/**
	 * 组件宽(可表达为列)
	 */
	private Long componentClos;

	private Long id;

	private String name;

	private Long pId;

	/**
	 * 操作类型
	 */
	private String opType;

	// 孩子组件
	private List<DynamicComponentDTO> children = new ArrayList<DynamicComponentDTO>();

	// 样式
	private List<DynamicStyleDTO> dynamicStyleDtos = new ArrayList<DynamicStyleDTO>();

	// 需要删除的节点信息
	private List<DynamicComponentDTO> delCompents = new ArrayList<DynamicComponentDTO>();

	// 属性对象
	private AttrSpecDTO attrSpecDto;
	// 属性值对象
	private List<AttrValueDTO> attrValueDtos = new ArrayList<AttrValueDTO>();

	// 参数使用-事件
	private Long eventId;

	// 对象ID；-参数
	private Long objId;
	// 对象类型-参数（事件ID，窗体ID）
	private String objType;
	// 模版对象
	private DynamicWindowDTO tpl;
	// 构件
	private DynamicWindowDTO part;

	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}

	public Long getComponentId() {
		return this.componentId;
	}

	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	public String getComponentCode() {
		return this.componentCode;
	}

	public void setShardingId(Long shardingId) {
		this.shardingId = shardingId;
	}

	public Long getShardingId() {
		return this.shardingId;
	}

	public void setBusAttrId(Long busAttrId) {
		this.busAttrId = busAttrId;
	}

	public Long getBusAttrId() {
		return this.busAttrId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getTenantId() {
		return this.tenantId;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentName() {
		return this.componentName;
	}

	public void setpComponentId(Long pComponentId) {
		this.pComponentId = pComponentId;
	}

	public Long getpComponentId() {
		return this.pComponentId;
	}

	public void setBusAttrName(String busAttrName) {
		this.busAttrName = busAttrName;
	}

	public String getBusAttrName() {
		return this.busAttrName;
	}

	public void setWindowId(Long windowId) {
		this.windowId = windowId;
	}

	public Long getWindowId() {
		return this.windowId;
	}

	public void setBusAttrType(String busAttrType) {
		this.busAttrType = busAttrType;
	}

	public String getBusAttrType() {
		return this.busAttrType;
	}

	public void setBusAttrCode(String busAttrCode) {
		this.busAttrCode = busAttrCode;
	}

	public String getBusAttrCode() {
		return this.busAttrCode;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentType() {
		return this.componentType;
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

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public List<DynamicComponentDTO> getChildren() {
		return children;
	}

	public void setChildren(List<DynamicComponentDTO> children) {
		this.children = children;
	}

	public List<DynamicStyleDTO> getDynamicStyleDtos() {
		return dynamicStyleDtos;
	}

	public void setDynamicStyleDtos(List<DynamicStyleDTO> dynamicStyleDtos) {
		this.dynamicStyleDtos = dynamicStyleDtos;
	}

	public String getComponentTip() {
		return componentTip;
	}

	public void setComponentTip(String componentTip) {
		this.componentTip = componentTip;
	}

	public String getComponentDesc() {
		return componentDesc;
	}

	public void setComponentDesc(String componentDesc) {
		this.componentDesc = componentDesc;
	}

	public AttrSpecDTO getAttrSpecDto() {
		return attrSpecDto;
	}

	public void setAttrSpecDto(AttrSpecDTO attrSpecDto) {
		this.attrSpecDto = attrSpecDto;
	}

	public List<AttrValueDTO> getAttrValueDtos() {
		return attrValueDtos;
	}

	public void setAttrValueDtos(List<AttrValueDTO> attrValueDtos) {
		this.attrValueDtos = attrValueDtos;
	}

	public Long getComponentRows() {
		return componentRows;
	}

	public void setComponentRows(Long componentRows) {
		this.componentRows = componentRows;
	}

	public String getComponentExp() {
		return componentExp;
	}

	public void setComponentExp(String componentExp) {
		this.componentExp = componentExp;
	}

	public Long getComponentClos() {
		return componentClos;
	}

	public void setComponentClos(Long componentClos) {
		this.componentClos = componentClos;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public List<DynamicComponentDTO> getDelCompents() {
		return delCompents;
	}

	public void setDelCompents(List<DynamicComponentDTO> delCompents) {
		this.delCompents = delCompents;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public DynamicWindowDTO getTpl() {
		return tpl;
	}

	public void setTpl(DynamicWindowDTO tpl) {
		this.tpl = tpl;
	}

	public DynamicWindowDTO getPart() {
		return part;
	}

	public void setPart(DynamicWindowDTO part) {
		this.part = part;
	}

}
