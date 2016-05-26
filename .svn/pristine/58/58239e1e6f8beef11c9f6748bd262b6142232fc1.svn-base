package com.ffcs.crmd.platform.pub.utils.rwbalance.config.impl;

import com.ffcs.crmd.platform.base.utils.CrmPropertiesUtil;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.utils.rwbalance.config.IRwBalanceConfigure;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/5/5.
 */
//@Component("propRwBalanceConfigure")
public class PropRwBalanceConfigure implements IRwBalanceConfigure {

    private Map<String,String> config = new HashMap<String,String>();
    private static final String RW_BALANCE_CONFIG = "rwbalance.properties";
    private static final String OPEN_KEY          = "open";

    public PropRwBalanceConfigure() {
        config = CrmPropertiesUtil.getProperties(RW_BALANCE_CONFIG,false);
    }

    @Override
    public boolean isSwtichBalance() {
        boolean isOpen = Boolean.valueOf(config.get(OPEN_KEY));
        return isOpen;
    }

    @Override
    public boolean isForceRead(String key) {
        return CrmSessionContext.RW_BALANCE_READ.equals(config.get(key));
    }

    @Override
    public boolean isForceWrite(String key) {
        return CrmSessionContext.RW_BALANCE_WRITE.equals(config.get(key));
    }
}
