package com.ffcs.crmd.platform.base.utils.type;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class CrmStringUtils {

    /**
     * 方法功能:
     * 判断一个对象或者是字符串是否为空
     *
     * @param
     * @return
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(final Object str) {
        return StringUtils.isNullOrEmpty(str);
    }

    /**
     * <p>
     * Joins the elements of the provided array into a single String containing
     * the provided list of elements.
     * </p>
     *
     * <p>
     * No delimiter is added before or after the list. A <code>null</code>
     * separator is the same as an empty String (""). Null objects or empty
     * strings within the array are represented by empty strings.
     * </p>
     *
     * <pre>
     * StringUtils.join(null, *)                = null
     * StringUtils.join([], *)                  = ""
     * StringUtils.join([null], *)              = ""
     * StringUtils.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtils.join(["a", "b", "c"], null)  = "abc"
     * StringUtils.join(["a", "b", "c"], "")    = "abc"
     * StringUtils.join([null, "", "a"], ',')   = ",,a"
     * </pre>
     *
     * @param array
     *            the array of values to join together, may be null
     * @param separator
     *            the separator character to use, null treated as ""
     * @return the joined String, <code>null</code> if null array input
     */
    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        return StringUtils.join(array, separator, 0, array.length);
    }

    public static String[] split(String toSplit, String delimiter) {
        return StringUtils.split(toSplit, delimiter);
    }

    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    public static String strnull(Object value) {
        return StringUtils.strnull(value);
    }
}
