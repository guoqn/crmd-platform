package com.ffcs.crmd.platform.pub.proxy.callfilter.impl;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/4/27.
 */
@Component("defaultCompProxyCallFilter")
public class DefaultCompProxyCallFilter extends AbstractCompProxyCallFilter {

    public DefaultCompProxyCallFilter() {
        super();
    }

    @Override
    public Map<String, String> getAppPropsMap() {
        Map<String,String> map = new HashMap<String,String>();

        //填充员工信息、岗位信息等。
        map.put(CrmSessionContext.STAFF_ID,
            StringUtils.strnull(CrmSessionContext.getContext().getStaffId()));
        map.put(CrmSessionContext.ORG_ID,
            StringUtils.strnull(CrmSessionContext.getContext().getOrgId()));
        map.put(CrmSessionContext.REGION_ID,
            StringUtils.strnull(CrmSessionContext.getContext().getRegionId()));
        return map;
    }

    @Override
    public void putAppPropsMap(Map<String, String> props)  {
        if (props.containsKey(CrmSessionContext.STAFF_ID)) {
            if (StringUtils.isNullOrEmpty(props.get(CrmSessionContext.STAFF_ID))) {
                CrmSessionContext.getContext().setStaffId(null);

            } else {
                CrmSessionContext.getContext().setStaffId(NumberUtils.nullToLongZero(props.get(CrmSessionContext.STAFF_ID)));
            }
        }

        if (props.containsKey(CrmSessionContext.ORG_ID)) {
            if (StringUtils.isNullOrEmpty(props.get(CrmSessionContext.ORG_ID))) {
                CrmSessionContext.getContext().setOrgId(null);

            } else {
                CrmSessionContext.getContext().setOrgId(NumberUtils.nullToLongZero(props.get(CrmSessionContext.ORG_ID)));
            }
        }

        if (props.containsKey(CrmSessionContext.REGION_ID)) {
            if (StringUtils.isNullOrEmpty(props.get(CrmSessionContext.REGION_ID))) {
                CrmSessionContext.getContext().setRegionId(null);

            } else {
                CrmSessionContext.getContext().setRegionId(NumberUtils.nullToLongZero(props.get(CrmSessionContext.REGION_ID)));
            }
        }

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
