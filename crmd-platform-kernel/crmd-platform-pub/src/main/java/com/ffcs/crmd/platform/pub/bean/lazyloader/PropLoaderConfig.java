package com.ffcs.crmd.platform.pub.bean.lazyloader;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public class PropLoaderConfig extends AbstractLoaderConfig {
    private List<String> paths = new ArrayList<String>();

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public void setPath(String path) {
        String[] ps = StringUtils.split(path, ".");
        for (String p : ps) {
            if (!StringUtils.isNullOrEmpty(p)) {
                paths.add(p);
            }
        }
    }

    @Override
    public Object getPropFromSrc(Object srcObj, Object destObj) {
        Object obj = srcObj;
        for (String str : paths) {
            try {
                if (obj != null) {
                    Object value = PropertyUtils.getNestedProperty(obj, str);
                    obj = value;
                }
            } catch (Exception e) {
                logger.error("get value error.");
                ExceptionUtils.throwEx(new RtManagerException("get value error.", e));
            }
        }
        return obj;
    }

    @Override
    public String toString() {
        return "PropLoaderConfig{" +
            "paths=" + paths +
            '}';
    }
}
