package com.ffcs.crmd.platform.pub.utils.sql.translater;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/3/1.
 */
public class TranslaterFactory {

    private static final ITranslater EMPTY_TRANSLATER = new ITranslater() {
        private List<String> list = new ArrayList<String>();

        private Map<String,String> map = new HashMap<String,String>();
        @Override
        public List<String> getAllTransFlag() {
            return list;
        }

        @Override
        public String translate(String orign) {
            return orign;
        }

        @Override
        public Map<String, String> getConfigMap() {
            return map;
        }
    };

    private static final String DB_TRANSLATER      = "dbTranslater";
    private static final String APP_DB_TRANSLATER  = "appDbTranslater";
    private static final String PROP_TANSLATER     = "propTranslater";
    private static final String APP_PROP_TANSLATER = "appPropTranslater";

    public static ITranslater getTranslater() {
        if (ApplicationContextUtil.containsBean(APP_DB_TRANSLATER)) {
            return ApplicationContextUtil.getBean(APP_DB_TRANSLATER);
        } else if (ApplicationContextUtil.containsBean(DB_TRANSLATER)) {
            return ApplicationContextUtil.getBean(DB_TRANSLATER);
        } else if (ApplicationContextUtil.containsBean(APP_PROP_TANSLATER)) {
            return ApplicationContextUtil.getBean(APP_PROP_TANSLATER);
        } else if (ApplicationContextUtil.containsBean(PROP_TANSLATER)) {
            return ApplicationContextUtil.getBean(PROP_TANSLATER);
        } else {
            return EMPTY_TRANSLATER;
        }
    }
}
