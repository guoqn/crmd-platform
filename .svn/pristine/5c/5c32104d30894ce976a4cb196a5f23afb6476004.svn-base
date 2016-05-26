package com.ffcs.crmd.platform.pub.springext;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by linzhiqiang on 16/3/3.
 */
public class ContextConfig {

    private ContextConfig() {

    }

    private static final String SPRING_EXT_FILE = "springext.properties";

    private static Properties properties = null;

    private static final ILogger LOGGER = LoggerFactory.getLogger(ContextConfig.class);

    public static final String SKIP_FILE = "skip-file";
    public static final String SKIP_BEAN = "skip-bean";

    static {
        try {
            ClassPathResource resource = new ClassPathResource(SPRING_EXT_FILE);
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e) {
            LOGGER.error("Could Not Load " + SPRING_EXT_FILE);
        }
    }

    public static Set<String> getSkipFiles() {
        Set<String> fileSet = new HashSet<String>();
        if (properties != null) {
            String prop = properties.getProperty(SKIP_FILE);
            if (StringUtils.hasLength(prop)) {
                String[] files = StringUtils.split(prop,",");
                for (String file : files) {
                    fileSet.add(StringUtils.trim(file));
                }
            }
        }
        return fileSet;
    }

    /**
     * 是否是配置的需要忽略的文件
     * @param fileName
     * @return
     */
    public static boolean isSkipFile(String fileName) {
        Set<String> fileSet = getSkipFiles();
        if (fileSet != null && !fileSet.isEmpty()) {
            return fileSet.contains(fileName);
        }
        return false;
    }


    public static Set<String> getSkipBeans() {
        Set<String> beanSet = new HashSet<String>();
        if (properties != null) {
            String prop = properties.getProperty(SKIP_BEAN);
            if (StringUtils.hasLength(prop)) {
                String[] files = StringUtils.split(prop,",");
                for (String file : files) {
                    beanSet.add(StringUtils.trim(file));
                }
            }
        }
        return beanSet;
    }

    /**
     * 是否是配置的需要忽略的Bean
     * @param 
     * @return
     */
    public static boolean isSkipBean(String id,String name,String className) {
        Set<String> beanSet = getSkipBeans();
        String key = getKey(id,name,className);
        if (StringUtils.hasLength(key) && beanSet != null && !beanSet.isEmpty()) {
            return beanSet.contains(key);
        }
        return false;
    }

    private static String getKey(String id, String name, String className) {
        StringBuilder builder = new StringBuilder();
        if (!StringUtils.isNullOrEmpty(id)) {
            builder.append(id);
        }
        if (!StringUtils.isNullOrEmpty(name)) {
            if (builder.length() > 0) {
                builder.append("&&");
            }
            builder.append(name);
        }
        if (!StringUtils.isNullOrEmpty(className)) {
            if (builder.length() > 0) {
                builder.append("&&");
            }
            builder.append(className);
        }
        return builder.toString();
    }
}
