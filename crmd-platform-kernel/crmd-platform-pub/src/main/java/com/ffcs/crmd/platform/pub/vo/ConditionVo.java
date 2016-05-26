package com.ffcs.crmd.platform.pub.vo;

import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

import java.io.Serializable;

public class ConditionVo implements Serializable {

	private Long staffId;

	private Long orgId;

	private Long regionId;

	public ConditionVo() {
		super();
		staffId = CrmSessionContext.getContext().getStaffId();
		orgId = CrmSessionContext.getContext().getOrgId();
		regionId = CrmSessionContext.getContext().getRegionId();
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

}
