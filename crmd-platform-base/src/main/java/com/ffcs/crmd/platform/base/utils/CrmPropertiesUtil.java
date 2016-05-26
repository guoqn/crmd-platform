package com.ffcs.crmd.platform.base.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ctg.itrdc.platform.common.exception.ExceptionUtil;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.file.PropertiesUtil;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;

public class CrmPropertiesUtil {

    private static final ILogger LOG = LoggerFactory.getLogger(CrmPropertiesUtil.class);

    /**
     * 构造函数.
     */
    protected CrmPropertiesUtil() {

    }

    public static void clearCache() {
        PropertiesUtil.clearCache();
    }

    public static String getConfigValueCache(final String fileName, final String key) {
        return PropertiesUtil.getConfigValueCache(fileName, key);
    }

    public static String getConfigValue(final String fileName, final String key) {
        return PropertiesUtil.getConfigValue(fileName, key);
    }

    public static Map<String, String> getProperties(final String fileName, boolean throwEx) {
        InputStream dataIn = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            final Properties properties = new Properties();
            if (fileName.endsWith(".properties")) {
                dataIn = PropertiesUtil.class.getResourceAsStream("/" + fileName);
            } else {
                dataIn = PropertiesUtil.class.getResourceAsStream("/" + fileName + ".properties");
            }
            properties.load(dataIn);
            dataIn.close();
            for (Object key : properties.keySet()) {
                map.put(StringUtils.strnull(key), properties.getProperty(StringUtils.strnull(key)));
            }
            return map;
        } catch (final Exception e) {
            LOG.error("Load file excetion,fileName:" + fileName, e);
            if (throwEx) {
                throw new RtManagerException(e);
            } else {
                return map;
            }
        } finally {
            try {
                if (dataIn != null) {
                    dataIn.close();
                }
            } catch (Exception e) {
                LOG.error(PropertiesUtil.class.getName(), e);
            }
        }
    }
}
