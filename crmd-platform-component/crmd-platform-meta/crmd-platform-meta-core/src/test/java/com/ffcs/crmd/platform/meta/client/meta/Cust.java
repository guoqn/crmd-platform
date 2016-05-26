package com.ffcs.crmd.platform.meta.client.meta;

import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;

/**
 * Created by linzq on 2016/1/21.
 */
public class Cust extends CrmBaseMetaEntityImpl<Long> {
    private Long custId;

    private String custName;

    private String statusCd;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    @Override
    public boolean isUseMeta() {
        return true;
    }

    @Override
    public Long getId() {
        return getCustId();
    }

    @Override
    public void setId(Long aLong) {
        setCustId(aLong);
    }

    public String getStatusCd() {
        return "1000";
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }
}
