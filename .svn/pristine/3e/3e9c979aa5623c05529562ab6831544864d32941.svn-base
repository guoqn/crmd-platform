package com.ffcs.crmd.platform.pub.lazy;

import com.ffcs.crmd.platform.pub.bean.lazyloader.annotation.MetaLoader;
import com.ffcs.crmd.platform.pub.bean.lazyloader.annotation.PropLoader;

public class CustDTO2 {

    @PropLoader(path = "cust.party.partyName")
    private String custName;

    @MetaLoader(busiObjNbr = "cust",attrNbr = "custNbr",sourceField = "custName")
    private String custNbr;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNbr() {
        return custNbr;
    }

    public void setCustNbr(String custNbr) {
        this.custNbr = custNbr;
    }
    
    
}
