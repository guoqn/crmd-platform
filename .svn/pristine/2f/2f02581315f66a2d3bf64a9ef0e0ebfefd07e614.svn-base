package com.ffcs.crmd.platform.pub.bean.provider;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.ILoggerFactory;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;

public class BeanConvertProvider {
    private static final String                        CLASS_SPLIT_CHAR = "_#_";
    
    private static ConcurrentMap<String, IBeanConvert> convertMap       = new ConcurrentHashMap<String, IBeanConvert>();
    
    private static final ILogger                       LOG              = LoggerFactory
                                                                            .getLogger(BeanConvertProvider.class);
    
    private static String getKey(Class<?> clazzA, Class<?> clazzB) {
        return clazzA.getName() + CLASS_SPLIT_CHAR + clazzB;
    }
    
    /**
     * 
     * 方法功能:
     *  注册转换器.
     * @param clazzA
     * @param clazzB
     * @param convert
     * @author: linzq
     * @修改记录： 
     * ==============================================================<br>
     * 日期:2016年1月12日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public static void putConvert(Class<?> clazzA, Class<?> clazzB, IBeanConvert convert) {
        String key1 = getKey(clazzA, clazzB);
        IBeanConvert old = convertMap.put(key1, convert);
        if (old != null) {
            LOG.warn(key1 + " beanConvert has Exists");
        }
        String key2 = getKey(clazzB, clazzA);
        old = convertMap.put(key2, convert);
        if (old != null) {
            LOG.warn(key2 + " beanConvert has Exists");
        }
    }
    
    /**
     * 
     * 方法功能:
     *  获取转换器.
     * @param clazzA
     * @param clazzB
     * @return
     * @author: linzq
     * @修改记录： 
     * ==============================================================<br>
     * 日期:2016年1月12日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public static IBeanConvert getConvert(Class<?> clazzA, Class<?> clazzB) {
        String key1 = getKey(clazzA, clazzB);
        IBeanConvert convert = convertMap.get(key1);
        if (convert == null) {
            String key2 = getKey(clazzB, clazzA);
            convert = convertMap.get(key2);
        }
        return convert;
    }
}
