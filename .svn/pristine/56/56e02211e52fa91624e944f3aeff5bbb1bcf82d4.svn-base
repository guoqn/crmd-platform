package com.ffcs.crmd.platform.cache.api.utils;

import com.ffcs.crmd.platform.cache.api.constants.CacheConstants;

/**
 * Created by linzhiqiang on 16/3/28.
 */
public class CacheUtils {

    public static String generateKey(Object ... keyWords) {
        StringBuilder builder = new StringBuilder();
        for (Object keyWord : keyWords) {
            if (builder.length() > 0) {
                builder.append(CacheConstants.KEY_SPLIT);
            }
            builder.append(keyWord);
        }
        return builder.toString();
    }
}
