package com.ffcs.crmd.platform.mq.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 功能说明:配置文件工具类
 *
 * @author ZHONGFUHUA
 * 
 * @Date 2016年1月19日 下午3:22:20
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class PropertiesUtil {
    /**
     * 
     */
    private static PropertiesUtil propertiesUtil = new PropertiesUtil();
    
    /**
     * 默认配置文件路径
     */
    private String                defaultPath    = "mq.properties";
    
    protected PropertiesUtil() {
        
    }
    
    /**
     * 
     * 功能说明:获取工具类实例
     * 
     * @author ZHONGFUHUA
     *
     * @Date 2016年2月2日
     *
     */
    public static PropertiesUtil getInstance() {
        return propertiesUtil;
    }
    
    /**
     * 
     * 功能说明:加载指定配置文件
     * 
     * @param path
     *      配置文件路径，默认路径为classpath
     * @author ZHONGFUHUA
     *
     * @Date 2016年1月19日
     *
     */
    public Properties load(String path) throws IOException {
        Properties properties = new Properties();
        if (StringUtils.isBlank(path)) {
            path = defaultPath;
        }
        InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
}
