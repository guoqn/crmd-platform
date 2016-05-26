package com.ffcs.crmd.platform.pub.bean.lazyloader;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.bean.lazyloader.annotation.MetaLoader;
import com.ffcs.crmd.platform.pub.bean.lazyloader.annotation.PropLoader;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public class LoaderProvider {

    private static ConcurrentMap<Class<?>, List<AbstractLoaderConfig>> loaderConfigsMap = new ConcurrentHashMap<Class<?>, List<AbstractLoaderConfig>>();

    private static final ILogger LOGGER = LoggerFactory.getLogger(LoaderProvider.class);

    public static List<AbstractLoaderConfig> getLoaderConfigs(Class<?> clazz) {
        List<AbstractLoaderConfig> loaderConfigs = new ArrayList<AbstractLoaderConfig>();
        if (!loaderConfigsMap.containsKey(clazz)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                MetaLoader metaLoader = f.getAnnotation(MetaLoader.class);
                if (metaLoader != null) {
                    MetaLoaderConfig config = new MetaLoaderConfig();
                    config.setBusiObjNbr(metaLoader.busiObjNbr());
                    config.setAttrNbr(metaLoader.attrNbr());
                    config.setSourceField(metaLoader.sourceField());
                    Method[] methods = clazz.getMethods();
                    String setMeName = "set" + StringUtils.firstCharUpCase(f.getName());
                    for (Method method : methods) {
                        if (method.getName().equals(setMeName)) {
                            config.setSetter(method);
                        }
                    }
                    if (config.getSetter() == null) {
                        LOGGER.error("this field {} not set method.",f.getName());
                        ExceptionUtils.throwEx(new RtManagerException("this field " + f.getName() + " not set method."));
                    }
                    loaderConfigs.add(config);
                }
                PropLoader propLoader = f.getAnnotation(PropLoader.class);
                if (propLoader != null) {
                    PropLoaderConfig config = new PropLoaderConfig();
                    config.setPath(propLoader.path());
                    Method[] methods = clazz.getMethods();
                    String setMeName = "set" + StringUtils.firstCharUpCase(f.getName());
                    for (Method method : methods) {
                        if (method.getName().equals(setMeName)) {
                            config.setSetter(method);
                        }
                    }
                    if (config.getSetter() == null) {
                        LOGGER.error("this field {} not set method.",f.getName());
                        ExceptionUtils.throwEx(new RtManagerException("this field " + f.getName() + " not set method."));
                    }
                    loaderConfigs.add(config);
                }
            }
            loaderConfigsMap.putIfAbsent(clazz,loaderConfigs);
        } return loaderConfigsMap.get(clazz);
    }
}
