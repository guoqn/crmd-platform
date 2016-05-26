package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicTempPartRelRepository;

@ShardingBean
@Table(name = "DYNAMIC_TEMP_PART_REL")
public class DynamicTempPartRel extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 关联序号
	 */
	@Id
	@Column(name = "REL_ID")
	private Long relId;
	/**
	 * 构件序号
	 */
	@Column(name = "PART_ID")
	private Long partId;

	/**
	 * 顺序
	 */
	@Column(name = "REL_ORDER")
	private Long relOrder;

	/**
	 * 分片键
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 更新记录的员工标识
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

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
	 * 状态：1000有效1100无效
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 备注
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;

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

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public Long getPartId() {
		return this.partId;
	}

	public void setRelOrder(Long relOrder) {
		this.relOrder = relOrder;
	}

	public Long getRelOrder() {
		return this.relOrder;
	}

	public void setShardingId(Long shardingId) {
		this.shardingId = shardingId;
	}

	public Long getShardingId() {
		return this.shardingId;
	}

	public void setUpdateStaff(Long updateStaff) {
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff() {
		return this.updateStaff;
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

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
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

	public Long getId() {
		return relId;
	}

	public void setId(Long id) {
		this.relId = id;
	}

	public Long getRelId() {
		return relId;
	}

	public void setRelId(Long relId) {
		this.relId = relId;
	}

	public DynamicTempPartRel() {
		super();
	}

	public DynamicTempPartRel(boolean genId) {
		if (genId) {
			setId(genEnttId());
		}
	}

	public static IDynamicTempPartRelRepository repository() {
		return (IDynamicTempPartRelRepository) RepositoryRegister.getInstance().getRepository(DynamicTempPartRel.class);
	}

}
