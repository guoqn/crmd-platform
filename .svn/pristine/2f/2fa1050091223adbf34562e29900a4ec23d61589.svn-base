package com.ffcs.crmd.platform.meta.client.meta.service.impl;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.meta.client.meta.Cust;
import com.ffcs.crmd.platform.meta.client.meta.service.ICustService;
import org.springframework.stereotype.Service;

/**
 * Created by linzq on 2016/1/21.
 */
@Service("custService")
public class CustServiceImpl implements ICustService {
    private ICrmBaseDao dao = ApplicationContextUtil.getBean("crmBaseDao");
    @Override
    public void saveCust(Cust cust) {
        dao.insert(cust);
    }

    @Override
    public void updateCust(Cust cust) {
        dao.updateByPrimaryKey(cust);
    }

    @Override
    public void removeCust(Cust cust) {
        dao.deleteByPrimaryKey(cust);
    }
}
