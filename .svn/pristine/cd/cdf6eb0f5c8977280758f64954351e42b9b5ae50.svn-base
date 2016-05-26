package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicComponentRepository;

@ShardingBean
@Table(name = "DYNAMIC_COMPONENT")
public class DynamicComponent extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 组件序号
	 */
	@Id
	@Column(name = "COMPONENT_ID")
	private Long componentId;

	/**
	 * 组合组件(窗体、构件)
	 */
	@Column(name = "GROUP_CODE")
	private String groupCode;

	/**
	 * 组件编码
	 */
	@Column(name = "COMPONENT_CODE")
	private String componentCode;

	/**
	 * 分片键
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 业务属性序号
	 */
	@Column(name = "BUS_ATTR_ID")
	private Long busAttrId;

	/**
	 * 创建记录的员工标识
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

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
	 * 组件名称
	 */
	@Column(name = "COMPONENT_NAME")
	private String componentName;

	/**
	 * 父级组件序号
	 */
	@Column(name = "P_COMPONENT_ID")
	private Long pComponentId;

	// 子集组件
	private List<DynamicComponent> childComponents = new ArrayList<DynamicComponent>();

	/**
	 * 更新记录的员工标识
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 业务属性名称
	 */
	@Column(name = "BUS_ATTR_NAME")
	private String busAttrName;

	/**
	 * 窗体序号
	 */
	@Column(name = "WINDOW_ID")
	private Long windowId;

	/**
	 * 业务属性类型
	 */
	@Column(name = "BUS_ATTR_TYPE")
	private String busAttrType;

	/**
	 * 状态：1000有效1100无效
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 业务属性编码
	 */
	@Column(name = "BUS_ATTR_CODE")
	private String busAttrCode;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 组件类型
	 */
	@Column(name = "COMPONENT_TYPE")
	private String componentType;

	/**
	 * 组件提示
	 */
	@Column(name = "COMPONENT_TIP")
	private String componentTip;

	/**
	 * 组件描述
	 */
	@Column(name = "COMPONENT_DESC")
	private String componentDesc;

	/**
	 * 表达式
	 */
	@Column(name = "COMPONENT_EXP")
	private String componentExp;

	/**
	 * 组件行
	 */
	@Column(name = "COMPONENT_ROWS")
	private Long componentRows;

	/**
	 * 组件宽(可表达为列)
	 */
	@Column(name = "COMPONENT_CLOS")
	private Long componentClos;

	// 样式
	private List<DynamicStyle> dynamicStyles = new ArrayList<DynamicStyle>();

	// attrSpec

	private AttrSpec2 attrSpec2;

	// attrValue2
	private List<AttrValue2> attrValue2s = new ArrayList<AttrValue2>();

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

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setStatusDate(Timestamp statusDate) {
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate() {
		return this.statusDate;
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

	public void setUpdateStaff(Long updateStaff) {
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff() {
		return this.updateStaff;
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

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setBusAttrCode(String busAttrCode) {
		this.busAttrCode = busAttrCode;
	}

	public String getBusAttrCode() {
		return this.busAttrCode;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentType() {
		return this.componentType;
	}

	public Long getId() {
		return componentId;
	}

	public void setId(Long id) {
		this.componentId = id;
	}

	public DynamicComponent() {
		super();
	}

	public DynamicComponent(boolean genId) {
		if (genId) {
			setId(genEnttId());
		}
	}

	public List<DynamicComponent> getChildComponents() {
		return childComponents;
	}

	public void setChildComponents(List<DynamicComponent> childComponents) {
		this.childComponents = childComponents;
	}

	public List<DynamicStyle> getDynamicStyles() {
		return dynamicStyles;
	}

	public void setDynamicStyles(List<DynamicStyle> dynamicStyles) {
		this.dynamicStyles = dynamicStyles;
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

	public static IDynamicComponentRepository repository() {
		return (IDynamicComponentRepository) RepositoryRegister.getInstance().getRepository(DynamicComponent.class);
	}

	public AttrSpec2 getAttrSpec2() {
		return attrSpec2;
	}

	public void setAttrSpec2(AttrSpec2 attrSpec2) {
		this.attrSpec2 = attrSpec2;
	}

	public List<AttrValue2> getAttrValue2s() {
		return attrValue2s;
	}

	public void setAttrValue2s(List<AttrValue2> attrValue2s) {
		this.attrValue2s = attrValue2s;
	}

	public String getComponentExp() {
		return componentExp;
	}

	public void setComponentExp(String componentExp) {
		this.componentExp = componentExp;
	}

	public Long getComponentRows() {
		return componentRows;
	}

	public void setComponentRows(Long componentRows) {
		this.componentRows = componentRows;
	}

	public Long getComponentClos() {
		return componentClos;
	}

	public void setComponentClos(Long componentClos) {
		this.componentClos = componentClos;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

}
