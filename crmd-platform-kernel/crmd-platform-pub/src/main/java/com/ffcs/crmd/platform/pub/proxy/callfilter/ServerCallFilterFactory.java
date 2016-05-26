package com.ffcs.crmd.platform.pub.proxy.callfilter;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.pub.proxy.callfilter.impl.AbstractCompProxyCallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.impl.AbstractProxyCallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.serverimpl.AbstractCompServerCallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.serverimpl.AbstractServerCallFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/2/16.
 */
public class ServerCallFilterFactory {

    public static final String DEFAULT_PREFIX = "default";

    public static final String CALL_FILTER_SUFFIX = "ServerCallFilter";

    private static ConcurrentMap<String, List<ICallFilter>> listMap = new ConcurrentHashMap<String, List<ICallFilter>>();

    private static final ICallFilter EMPTY = new AbstractServerCallFilter() {
        @Override
        public Map<String, String> getAppPropsMap() {
            return new HashMap<String, String>();
        }

        @Override
        public void putAppPropsMap(Map<String, String> props) {

        }
    };

    public static ICallFilter getServerCallFilter(String serviceName,
        String methodName) {
        if (ApplicationContextUtil
            .containsBean(StringUtils.first2Lower(serviceName) + CALL_FILTER_SUFFIX)) {
            return ApplicationContextUtil
                .getBean(StringUtils.first2Lower(serviceName) + CALL_FILTER_SUFFIX);
        } else if (ApplicationContextUtil.containsBean(DEFAULT_PREFIX + CALL_FILTER_SUFFIX)) {
            return ApplicationContextUtil.getBean(DEFAULT_PREFIX + CALL_FILTER_SUFFIX);
        } else {
            return EMPTY;
        }
    }

    public static List<ICallFilter> getServerCallFilters(String serviceName,
        String methodName) {
        String key = StringUtils.join(new String[] { serviceName, methodName }, "_#_");
        if (!listMap.containsKey(key)) {
            ICallFilter appCallFilter = getServerCallFilter(serviceName, methodName);
            List<AbstractCompServerCallFilter> compServerCallFilter = CallFilterManager
                .getInstance().getCompServerList();
            List<ICallFilter> filters = new ArrayList<ICallFilter>();
            filters.addAll(compServerCallFilter);
            filters.add(appCallFilter);
            Collections.sort(filters, new Comparator<ICallFilter>() {
                @Override
                public int compare(ICallFilter o1, ICallFilter o2) {
                    return o1.getOrder() - o2.getOrder();
                }
            });
            listMap.putIfAbsent(key, filters);
        }
        return listMap.get(key);
    }
}
