package com.ffcs.crmd.platform.pub.interfaces.config.impl;

import com.ffcs.crmd.platform.base.utils.CrmPropertiesUtil;
import com.ffcs.crmd.platform.pub.interfaces.config.AbstractInterfConfigure;

import java.util.Map;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class PropInterfConfigure extends AbstractInterfConfigure {

    protected Map<String, String> properties = null;

    public PropInterfConfigure(String fileName) {
        properties = CrmPropertiesUtil.getProperties(fileName, true);
    }

    @Override
    protected String getActualValue(String key) {
        if (properties != null) {
            return properties.get(key);
        }
        return null;
    }
}
