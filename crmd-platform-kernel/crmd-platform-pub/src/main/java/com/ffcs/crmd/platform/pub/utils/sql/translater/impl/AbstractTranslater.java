package com.ffcs.crmd.platform.pub.utils.sql.translater.impl;

import com.ffcs.crmd.platform.pub.utils.sql.DialectUtils;
import com.ffcs.crmd.platform.pub.utils.sql.translater.ITranslater;
import com.ffcs.crmd.platform.pub.utils.sql.translater.SqlTranslaterUtil;
import com.ffcs.crmd.platform.pub.utils.sql.translater.TranslateConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/3/1.
 */
public abstract class AbstractTranslater implements ITranslater {
    protected Map<String, String> configMap = null;

    public List<String> getAllTransFlag() {
        List<String> transFlags = new ArrayList<String>();

        Map<String, String> map = getConfigMap();
        for (String key : map.keySet()) {
            if (key.equals(DialectUtils.DIALECT_KEY)) {
                continue;
            }
            if (key.endsWith(TranslateConstants.LEFT_PARENTHESS)) {
                transFlags.add(key.replace(TranslateConstants.LEFT_PARENTHESS,
                    "\\" + TranslateConstants.LEFT_PARENTHESS));
            } else if (key.indexOf(TranslateConstants.LEFT_PARENTHESS) > 0) {
                transFlags.add(key.substring(0, key.indexOf(TranslateConstants.LEFT_PARENTHESS) + 1)
                    .replace(TranslateConstants.LEFT_PARENTHESS,
                        "\\" + TranslateConstants.LEFT_PARENTHESS));
            } else {
                transFlags.add(key + "\\" + TranslateConstants.LEFT_PARENTHESS);
            }
        }
        return transFlags;
    }

    @Override
    public String translate(String orign) {
        Map<String, String> configMap = getConfigMap();
        if (configMap.size() > 0) {
            String orignKeyWords = SqlTranslaterUtil.getKeyWords(orign);
            String mapKey = "";
            String mapValue = "";
            for (String key : configMap.keySet()) {
                String keyWords = SqlTranslaterUtil.getKeyWords(key);
                if (orignKeyWords.equalsIgnoreCase(keyWords)) {
                    mapKey = key;
                    mapValue = configMap.get(key);
                    break;
                }
            }

            //不包含括号的,认为是简单的替换
            if (mapKey.indexOf(TranslateConstants.LEFT_PARENTHESS) < 0) {
                orign = orign.replace(orignKeyWords, mapValue);
            } else {
                //复杂函数处理
                List<String> params = SqlTranslaterUtil.decodeParamsList(orign);
                int i = 0;
                String newFunc = mapValue;
                for (String str : params) {
                    newFunc = newFunc
                        .replaceAll("(\\" + TranslateConstants.PARAM_FLAG + (i + 1) + ")", str);
                    i++;
                }
                orign = newFunc;
            }
        }
        return orign;
    }

    @Override
    public Map<String, String> getConfigMap() {
        if (configMap == null) {
            synchronized (this) {
                if (configMap == null) {
                    Map<String, String> tmp = loadMap();
                    if (tmp == null) {
                        configMap = new HashMap<String, String>();
                    } else {
                        configMap = tmp;
                    }

                }
            }
        }
        return configMap;
    }

    protected abstract Map<String, String> loadMap();
}
