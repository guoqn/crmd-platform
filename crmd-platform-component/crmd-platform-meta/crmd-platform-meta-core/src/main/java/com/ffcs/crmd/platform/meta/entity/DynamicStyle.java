package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicStyleRepository;

@ShardingBean
@Table(name = "DYNAMIC_STYLE")
public class DynamicStyle extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 样式序号
	 */
	@Id
	@Column(name = "STYLE_ID")
	private Long styleId;

	/**
	 * 样式属性
	 */
	@Column(name = "STYLE_ATTR")
	private String styleAttr;

	/**
	 * 关联样式序号
	 */
	@Column(name = "RELA_STYLE_ID")
	private Long relaStyleId;

	/**
	 * 样式名称
	 */
	@Column(name = "STYLE_NAME")
	private String styleName;

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
	 * 上级样式序号
	 */
	@Column(name = "P_STYLE_ID")
	private Long pStyleId;

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
	 * 样式属性值
	 */
	@Column(name = "STYLE_ATTR_VALUE")
	private String styleAttrValue;

	/**
	 * 更新记录的员工标识
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 组件序号
	 */
	@Column(name = "COMPONENT_ID")
	private Long componentId;

	/**
	 * 状态：1000有效1100无效
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 样式类型
	 */
	@Column(name = "STYLE_TYPE")
	private String styleType;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

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

	public void setCreateStaff(Long createStaff) {
		this.createStaff = createStaff;
	}

	public Long getCreateStaff() {
		return this.createStaff;
	}

	public void setpStyleId(Long pStyleId) {
		this.pStyleId = pStyleId;
	}

	public Long getpStyleId() {
		return this.pStyleId;
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

	public void setStyleAttrValue(String styleAttrValue) {
		this.styleAttrValue = styleAttrValue;
	}

	public String getStyleAttrValue() {
		return this.styleAttrValue;
	}

	public void setUpdateStaff(Long updateStaff) {
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff() {
		return this.updateStaff;
	}

	public Long getComponentId() {
		return componentId;
	}

	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}

	public String getStyleType() {
		return this.styleType;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public Long getId() {
		return styleId;
	}

	public void setId(Long id) {
		this.styleId = id;
	}

	public DynamicStyle() {
		super();
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public Long getRelaStyleId() {
		return relaStyleId;
	}

	public void setRelaStyleId(Long relaStyleId) {
		this.relaStyleId = relaStyleId;
	}

	public DynamicStyle(boolean genId) {
		if (genId) {
			setId(genEnttId());
		}
	}

	public static IDynamicStyleRepository repository() {
		return (IDynamicStyleRepository) RepositoryRegister.getInstance().getRepository(DynamicStyle.class);
	}

}
