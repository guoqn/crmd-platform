package com.ffcs.crmd.platform.pub.utils.rwbalance.proxyfilter;

import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.proxy.callfilter.impl.AbstractProxyCallFilter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/5/6.
 */
@Component
public class RwBalanceProxyFilter extends AbstractProxyCallFilter {
    @Override
    public Map<String, String> getAppPropsMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(CrmSessionContext.RW_BALANCE, CrmStringUtils
            .strnull(CrmSessionContext.getContext().getValue4Thread(CrmSessionContext.RW_BALANCE)));
        return map;
    }

    @Override
    public void putAppPropsMap(Map<String, String> props) {
        if (!CrmStringUtils.isNullOrEmpty(props.get(CrmSessionContext.RW_BALANCE))) {
            CrmSessionContext.getContext().setObject2Thread(CrmSessionContext.RW_BALANCE,
                props.get(CrmSessionContext.RW_BALANCE));
        }
    }
}
