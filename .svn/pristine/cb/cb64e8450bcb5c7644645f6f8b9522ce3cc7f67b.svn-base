package com.ffcs.crmd.platform.meta.daaction.filter;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.filter.impl.AbstractDaActionFilter;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

/**
 * Created by linzq on 2016/1/18.
 */
public class DaActionFilterFactory {

    private static final String DEFAULT_ACTION_PREFIX = "default";

    private static final String DEFAULT_FRAME_ACTION = "defaultFrame";

    private static final String SAVE_ACTION_SUFFIX = "SaveActionFilter";

    private static final String UPDATE_ACTION_SUFFIX = "UpdateActionFilter";

    private static final String DELETE_ACTION_SUFFIX = "DeleteActionFilter";

    private static final String DEFAULT_ACTION_SUFFIX = "ActionFilter";

    private static final IDaActionFilter EMPTY_DA_ACTION_FILTER = new AbstractDaActionFilter() {

        @Override
        public void beforeAction(DaActionContext context, Object entity, ActionType actionType) {

        }

        @Override
        public void afterAction(DaActionContext context, Object entity, ActionType actionType) {

        }
    };

    private static String getBeanNamePreFix(Object entity) {
        String entityName = "";
        if (entity instanceof IMetaEntity) {
            entityName = ((IMetaEntity) entity).getEntityName();
        } else {
            entityName = entity.getClass().getSimpleName();
        }
        return StringUtils.firstCharLowCase(entityName);
    }

    private static IDaActionFilter getFilter(Object entity, String suffix) {
        if (ApplicationContextUtil.containsBean(getBeanNamePreFix(entity) + suffix)) {
            return ApplicationContextUtil.getBean(getBeanNamePreFix(entity) + suffix);
        } else if (ApplicationContextUtil
            .containsBean(getBeanNamePreFix(entity) + DEFAULT_ACTION_SUFFIX)) {
            return ApplicationContextUtil
                .getBean(getBeanNamePreFix(entity) + DEFAULT_ACTION_SUFFIX);
        } else if (ApplicationContextUtil
            .containsBean(getBeanNamePreFix(entity) + DEFAULT_ACTION_SUFFIX)) {
            return ApplicationContextUtil
                .getBean(getBeanNamePreFix(entity) + DEFAULT_ACTION_SUFFIX);
        } else if (ApplicationContextUtil.containsBean(DEFAULT_ACTION_PREFIX + suffix)) {
            return ApplicationContextUtil.getBean(DEFAULT_ACTION_PREFIX + suffix);
        } else if (ApplicationContextUtil
            .containsBean(DEFAULT_ACTION_PREFIX + DEFAULT_ACTION_SUFFIX)) {
            return ApplicationContextUtil.getBean(DEFAULT_ACTION_PREFIX + DEFAULT_ACTION_SUFFIX);
        } else if (ApplicationContextUtil
            .containsBean(DEFAULT_FRAME_ACTION + suffix)) {
            return ApplicationContextUtil.getBean(DEFAULT_FRAME_ACTION + suffix);
        } else if (ApplicationContextUtil
            .containsBean(DEFAULT_FRAME_ACTION + DEFAULT_ACTION_SUFFIX)) {
            return ApplicationContextUtil.getBean(DEFAULT_FRAME_ACTION + DEFAULT_ACTION_SUFFIX);
        } else {
            return EMPTY_DA_ACTION_FILTER;
        }
    }

    public static IDaActionFilter getSaveActionFilter(Object entity) {
        return getFilter(entity, SAVE_ACTION_SUFFIX);
    }

    public static IDaActionFilter getUpdateActionFilter(Object entity) {
        return getFilter(entity, UPDATE_ACTION_SUFFIX);
    }

    public static IDaActionFilter getDeleteActionFilter(Object entity) {
        return getFilter(entity, DELETE_ACTION_SUFFIX);
    }
}
