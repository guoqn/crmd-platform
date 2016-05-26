package com.ffcs.crmd.platform.pub.utils.sql.translater.impl;

import com.ffcs.crmd.platform.base.utils.CrmPropertiesUtil;
import com.ffcs.crmd.platform.pub.utils.sql.DialectUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by linzhiqiang on 16/3/1.
 */
@Component("propTranslater")
public class PropTranslater extends AbstractTranslater {

    public PropTranslater() {

    }

    @Override
    protected Map<String, String> loadMap() {
        Map<String, String> map = CrmPropertiesUtil.getProperties(DialectUtils.DIALECT_PROPERTIES_FILE, false);
        return map;
    }
}
