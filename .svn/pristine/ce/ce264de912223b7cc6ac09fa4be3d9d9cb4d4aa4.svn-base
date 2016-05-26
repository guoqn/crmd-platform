package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicPartRepository;

@ShardingBean
@Table(name = "DYNAMIC_PART")
public class DynamicPart extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;

	/**
	 * 构件序号
	 */
	@Id
	@Column(name = "PART_ID")
	private Long partId;

	/**
	 * 构件描述
	 */
	@Column(name = "PART_DESC")
	private String partDesc;

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
	 * 构件类型
	 */
	@Column(name = "PART_TYPE")
	private String partType;

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
	 * 构件名称
	 */
	@Column(name = "PART_NAME")
	private String partName;

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
	 * 构件编码
	 */
	@Column(name = "PART_CODE")
	private String partCode;

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

	public void setUpdateStaff(Long updateStaff) {
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff() {
		return this.updateStaff;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartType() {
		return this.partType;
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

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartName() {
		return this.partName;
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

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartCode() {
		return this.partCode;
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
		return partId;
	}

	public void setId(Long id) {
		this.partId = id;
	}

	public DynamicPart() {
		super();
	}

	public DynamicPart(boolean genId) {
		if (genId) {
			setId(genEnttId());
		}
	}

	public static IDynamicPartRepository repository() {
		return (IDynamicPartRepository) RepositoryRegister.getInstance().getRepository(DynamicPart.class);
	}

}
