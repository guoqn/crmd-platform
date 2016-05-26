package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicWindowRepository;

@ShardingBean
@Table(name = "DYNAMIC_WINDOW")
public class DynamicWindow extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 事件序号
	 */
	@Column(name = "EVENT_ID")
	private Long eventId;

	/**
	 * 窗体类型：模板、组合组件
	 */
	@Column(name = "WINDOW_TYPE")
	private String windowType;

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
	 * 窗体编码
	 */
	@Column(name = "WINDOW_CODE")
	private String windowCode;

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
	 * 模板序号
	 */
	@Column(name = "TEMPLATE_ID")
	private Long templateId;

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
	 * 窗体序号
	 */
	@Id
	@Column(name = "WINDOW_ID")
	private Long windowId;

	/**
	 * 状态：1000有效1100无效
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 窗体名称
	 */
	@Column(name = "WINDOW_NAME")
	private String windowName;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

	/**
	 * 窗体描述
	 */
	@Column(name = "WINDOW_DESC")
	private String windowDesc;

	// 组件
	private DynamicComponent component;

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setWindowType(String windowType) {
		this.windowType = windowType;
	}

	public String getWindowType() {
		return this.windowType;
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

	public void setWindowCode(String windowCode) {
		this.windowCode = windowCode;
	}

	public String getWindowCode() {
		return this.windowCode;
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

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return this.templateId;
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

	public void setUpdateStaff(Long updateStaff) {
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff() {
		return this.updateStaff;
	}

	public void setWindowId(Long windowId) {
		this.windowId = windowId;
	}

	public Long getWindowId() {
		return this.windowId;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public String getWindowName() {
		return this.windowName;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public Long getId() {
		return windowId;
	}

	public void setId(Long id) {
		this.windowId = id;
	}

	public DynamicWindow() {
		super();
	}

	public DynamicWindow(boolean genId) {
		if (genId) {
			setId(genEnttId());
		}
	}

	public DynamicComponent getComponent() {
		return component;
	}

	public void setComponent(DynamicComponent component) {
		this.component = component;
	}

	public String getWindowDesc() {
		return windowDesc;
	}

	public void setWindowDesc(String windowDesc) {
		this.windowDesc = windowDesc;
	}

	public static IDynamicWindowRepository repository() {
		return (IDynamicWindowRepository) RepositoryRegister.getInstance().getRepository(DynamicWindow.class);
	}

}
