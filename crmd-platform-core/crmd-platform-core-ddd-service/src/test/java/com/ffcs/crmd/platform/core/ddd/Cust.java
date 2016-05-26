package com.ffcs.crmd.platform.core.ddd;

import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by linzhiqiang on 16/2/17.
 */
@Table(name = "CUST")
public class Cust extends AbstractCrmDomBaseEntityImpl<Long> {

    @Id
    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "CUST_NAME")
    private String custName;

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

    public static ICustRepository repository() {
        return (ICustRepository) RepositoryRegister.getInstance()
            .getRepository(Cust.class);
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
