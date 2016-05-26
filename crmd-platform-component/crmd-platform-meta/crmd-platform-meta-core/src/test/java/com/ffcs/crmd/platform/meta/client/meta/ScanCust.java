package com.ffcs.crmd.platform.meta.client.meta;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by linzq on 2016/1/26.
 */
@Table(name="SAVE_CUST")
//@ShardingBean
public class ScanCust extends CrmBaseMetaEntityImpl<Long> {

    @Column
    private Long custId;

    @Column
    private String custName;

    @Column
    private String statusCd;

//    @ShardingId
    @Column
    private Long shardingId;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public Long getId() {
        return getCustId();
    }

    @Override
    public void setId(Long aLong) {
        setCustId(aLong);
    }
}
