package com.ffcs.crmd.platform.meta.daaction.filter;

import com.ffcs.crmd.platform.meta.daaction.DaActionContext;
import com.ffcs.crmd.platform.meta.daaction.impl.ActionType;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * Created by linzq on 2016/1/18.
 */
public interface IDaActionFilter {

    RetVo doBeforeAction(DaActionContext context, Object entity, ActionType actionType);

    RetVo doAfterAction(DaActionContext context, Object entity, ActionType actionType);
}
