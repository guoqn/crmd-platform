package com.ffcs.crmd.platform.pub.utils.rwbalance.config;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

/**
 * Created by linzhiqiang on 16/5/5.
 */
public class RwBalanceConfigureFactory {

    private static final String CONFIGURE_BEAN = "rwBalanceConfigure";

    private static final String APP_CONFIGURE_BEAN = "appRwBalanceConfigure";

    private static final String PROP_CONFIGURE_BEAN = "propRwBalanceConfigure";

    private static final IRwBalanceConfigure EMPTY_CONFIGURE = new IRwBalanceConfigure() {
        @Override
        public boolean isSwtichBalance() {
            return false;
        }

        @Override
        public boolean isForceRead(String key) {
            return false;
        }

        @Override
        public boolean isForceWrite(String key) {
            return false;
        }
    };

    public static IRwBalanceConfigure getConfigure() {
        if (ApplicationContextUtil.containsBean(CONFIGURE_BEAN)) {
            return ApplicationContextUtil.getBean(CONFIGURE_BEAN);
        } else if (ApplicationContextUtil.containsBean(APP_CONFIGURE_BEAN)) {
            return ApplicationContextUtil.getBean(APP_CONFIGURE_BEAN);
        } else if (ApplicationContextUtil.containsBean(PROP_CONFIGURE_BEAN)) {
            return ApplicationContextUtil.getBean(PROP_CONFIGURE_BEAN);
        } else {
            return EMPTY_CONFIGURE;
        }
    }
}
