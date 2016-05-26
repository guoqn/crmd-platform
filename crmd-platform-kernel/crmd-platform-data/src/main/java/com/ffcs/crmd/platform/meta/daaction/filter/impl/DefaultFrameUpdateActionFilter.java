package com.ffcs.crmd.platform.meta.daaction.filter.impl;

import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.stereotype.Component;

/**
 * Created by linzhiqiang on 16/2/24.
 */
@Component("defaultFrameUpdateActionFilter")
public class DefaultFrameUpdateActionFilter extends AbstractDaActionFilter {

    @Override
    public void beforeAction(DaActionContext context, Object entity, ActionType actionType) {

    }

    @Override
    public void afterAction(DaActionContext context, Object entity, ActionType actionType) {

    }
}
