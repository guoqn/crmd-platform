package com.ffcs.crmd.platform.meta.client.meta;

import com.ffcs.crmd.platform.pub.bean.lazyloader.annotation.MetaLoader;
import com.ffcs.crmd.platform.pub.bean.lazyloader.annotation.PropLoader;

/**
 * Created by linzhiqiang on 16/4/1.
 */
public class CustDTO {

    @PropLoader(path = "custName")
    private String custNewName;

    private String statusCd;

    @MetaLoader(busiObjNbr = "cust2",attrNbr = "statusCd",sourceField = "statusCd")
    private String statusCdName;

    public String getCustNewName() {
        return custNewName;
    }

    public void setCustNewName(String custNewName) {
        this.custNewName = custNewName;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusCdName() {
        return statusCdName;
    }

    public void setStatusCdName(String statusCdName) {
        this.statusCdName = statusCdName;
    }

    @Override
    public String toString() {
        return "CustDTO{" +
            "custNewName='" + custNewName + '\'' +
            ", statusCd='" + statusCd + '\'' +
            ", statusCdName='" + statusCdName + '\'' +
            '}';
    }
}
