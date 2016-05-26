package com.ffcs.crmd.platform.meta.util;

import com.ctg.itrdc.platform.common.utils.file.PropertiesUtil;

/**
 * Created by linzq on 2016/1/25.
 */
public class MetaConfig {
    private static final String META_USE_FILE = "meta.properties";
    private static final String IS_USE_KEY    = "isUseMeta";

    public static boolean isUseMeta() {
        try {
            return Boolean.valueOf(PropertiesUtil.getConfigValue(META_USE_FILE, IS_USE_KEY));
        } catch (Exception e) {

        }
        return false;
    }
}
