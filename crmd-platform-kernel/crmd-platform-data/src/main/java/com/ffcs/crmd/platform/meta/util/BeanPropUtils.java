package com.ffcs.crmd.platform.meta.util;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzq on 2016/1/19.
 */
public class BeanPropUtils {

    private static ConcurrentMap<String, Boolean> isWriteable = new ConcurrentHashMap<String, Boolean>();

    private static ConcurrentMap<String, Boolean> isReadable = new ConcurrentHashMap<String, Boolean>();

    private static final String SPLIT = "_$_";

    private static String createKey(Class clazz, String propName) {
        return clazz.getName() + SPLIT + propName;
    }

    public static boolean isReadable(Class clazz, String propName) {
        String key = createKey(clazz, propName);
        if (!isReadable.containsKey(key)) {
            boolean check = checkRW(clazz, propName, true);
            isReadable.putIfAbsent(key, check);
        }
        return isReadable.get(key);
    }

    public static boolean isWriteable(Class clazz, String propName) {
        String key = createKey(clazz, propName);
        if (!isWriteable.containsKey(key)) {
            boolean check = checkRW(clazz, propName, false);
            isWriteable.putIfAbsent(key, check);
        }
        return isWriteable.get(key);
    }

    private static boolean checkRW(Class clazz, String propName, boolean isRead) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        Class<?> superclass = clazz.getSuperclass();
        while (superclass != null) {
            classes.add(superclass);
            superclass = superclass.getSuperclass();
        }
        if (classes == null) {
            classes = new ArrayList<Class<?>>();
        }
        classes.add(clazz);
        if (classes != null && classes.size() > 0) {
            for (Class<?> tempClazz : classes) {
                Field[] fields = tempClazz.getDeclaredFields();

                if (fields != null && fields.length > 0) {
                    for (int i = 0; i < fields.length; i++) {
                        String name = fields[i].getName();
                        if (propName.equals(name)) {
                            try {
                                Method method = null;
                                if (isRead) {
                                    method = tempClazz.getDeclaredMethod(
                                        "get" + StringUtils.firstCharUpCase(propName),
                                        new Class[0]);
                                } else {
                                    Method[] methods = tempClazz.getDeclaredMethods();
                                    for (Method m : methods) {
                                        if (m.getName().equals(
                                            "set" + StringUtils.firstCharUpCase(propName))) {
                                            method = m;
                                            break;
                                        }
                                    }
                                }
                                if (method != null) {
                                    return true;
                                }
                            } catch (Exception e) {
                                return false;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }
}
