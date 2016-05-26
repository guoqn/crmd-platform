package com.ffcs.crmd.platform.pub.interfaces.filter.impl.server;

import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.interfaces.filter.IAfterFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IBeforeFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IInterfFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IPostFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.IPreFilter;
import com.ffcs.crmd.platform.pub.interfaces.utils.InterfUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public class ServerInterfFilterManager {

    private ConcurrentMap<String, List<IPreFilter>> preFilterRegisterMap = new ConcurrentHashMap<String, List<IPreFilter>>();

    private List<IPreFilter> currencyPreFilters = new ArrayList<IPreFilter>();

    private ConcurrentMap<String, List<IPreFilter>> preFiltersMap = new ConcurrentHashMap<String, List<IPreFilter>>();

    private ConcurrentMap<String, List<IBeforeFilter>> beforeFilterRegisterMap = new ConcurrentHashMap<String, List<IBeforeFilter>>();

    private List<IBeforeFilter> currencyBeforeFilters = new ArrayList<IBeforeFilter>();

    private ConcurrentMap<String, List<IBeforeFilter>> beforeFiltersMap = new ConcurrentHashMap<String, List<IBeforeFilter>>();

    private ConcurrentMap<String, List<IAfterFilter>> afterFilterRegisterMap = new ConcurrentHashMap<String, List<IAfterFilter>>();

    private List<IAfterFilter> currencyAfterFilters = new ArrayList<IAfterFilter>();

    private ConcurrentMap<String, List<IAfterFilter>> afterFiltersMap = new ConcurrentHashMap<String, List<IAfterFilter>>();

    private ConcurrentMap<String, List<IPostFilter>> postFilterRegisterMap = new ConcurrentHashMap<String, List<IPostFilter>>();

    private List<IPostFilter> currencyPostFilters = new ArrayList<IPostFilter>();

    private ConcurrentMap<String, List<IPostFilter>> postFiltersMap = new ConcurrentHashMap<String, List<IPostFilter>>();

    private Comparator<IInterfFilter> comparator = new Comparator<IInterfFilter>() {
        @Override
        public int compare(IInterfFilter o1, IInterfFilter o2) {
            return o1.getOrder() - o2.getOrder();
        }
    };

    private static class ServerInterfFilterManagerHolder {
        static ServerInterfFilterManager INSTANCE = new ServerInterfFilterManager();
    }

    private ServerInterfFilterManager() {

    }

    public static ServerInterfFilterManager getInstance() {
        return ServerInterfFilterManagerHolder.INSTANCE;
    }

    /**
     * 注册filter,如果request,responder,extraKey都为空,则注册为通用filter
     * @param requester
     * @param responder
     * @param extraKey
     * @param filter
     */
    public void registerPreFilter(String requester, String responder, String extraKey,
        IPreFilter filter) {
        if (CrmStringUtils.isNullOrEmpty(requester) && CrmStringUtils.isNullOrEmpty(responder)
            && CrmStringUtils.isNullOrEmpty(extraKey)) {
            currencyPreFilters.add(filter);
        } else {
            String key = InterfUtils.getKey(requester, responder, extraKey);
            if (!preFilterRegisterMap.containsKey(key)) {
                preFilterRegisterMap.putIfAbsent(key, new ArrayList<IPreFilter>());
            }
            preFilterRegisterMap.get(key).add(filter);
        }
    }

    public List<IPreFilter> getPreFilters(String requester, String responder, String extraKey) {
        String key = InterfUtils.getKey(requester, responder, extraKey);
        if (!preFiltersMap.containsKey(key)) {
            List<IPreFilter> filters = new ArrayList<IPreFilter>();
            filters.addAll(currencyPreFilters);
            if (preFilterRegisterMap.containsKey(key)) {
                filters.addAll(preFilterRegisterMap.get(key));
            }
            Collections.sort(filters, comparator);
            preFiltersMap.putIfAbsent(key, filters);
        }
        return preFiltersMap.get(key);
    }

    /**
     * 注册filter,如果request,responder,extraKey都为空,则注册为通用filter
     * @param requester
     * @param responder
     * @param extraKey
     * @param filter
     */
    public void registerBeforeFilter(String requester, String responder, String extraKey,
        IBeforeFilter filter) {
        if (CrmStringUtils.isNullOrEmpty(requester) && CrmStringUtils.isNullOrEmpty(responder)
            && CrmStringUtils.isNullOrEmpty(extraKey)) {
            currencyBeforeFilters.add(filter);
        } else {
            String key = InterfUtils.getKey(requester, responder, extraKey);
            if (!beforeFilterRegisterMap.containsKey(key)) {
                beforeFilterRegisterMap.putIfAbsent(key, new ArrayList<IBeforeFilter>());
            }
            beforeFilterRegisterMap.get(key).add(filter);
        }
    }

    public List<IBeforeFilter> getBeforeFilters(String requester, String responder, String extraKey) {
        String key = InterfUtils.getKey(requester, responder, extraKey);
        if (!beforeFiltersMap.containsKey(key)) {
            List<IBeforeFilter> filters = new ArrayList<IBeforeFilter>();
            filters.addAll(currencyBeforeFilters);
            if (afterFilterRegisterMap.containsKey(key)) {
                filters.addAll(beforeFilterRegisterMap.get(key));
            }
            Collections.sort(filters, comparator);
            beforeFiltersMap.putIfAbsent(key, filters);
        }
        return beforeFiltersMap.get(key);
    }

    /**
     * 注册filter,如果request,responder,extraKey都为空,则注册为通用filter
     * @param requester
     * @param responder
     * @param extraKey
     * @param filter
     */
    public void registerAfterFilter(String requester, String responder, String extraKey,
        IAfterFilter filter) {
        if (CrmStringUtils.isNullOrEmpty(requester) && CrmStringUtils.isNullOrEmpty(responder)
            && CrmStringUtils.isNullOrEmpty(extraKey)) {
            currencyAfterFilters.add(filter);
        } else {
            String key = InterfUtils.getKey(requester, responder, extraKey);
            if (!afterFilterRegisterMap.containsKey(key)) {
                afterFilterRegisterMap.putIfAbsent(key, new ArrayList<IAfterFilter>());
            }
            afterFilterRegisterMap.get(key).add(filter);
        }
    }

    public List<IAfterFilter> getAfterFilters(String requester, String responder, String extraKey) {
        String key = InterfUtils.getKey(requester, responder, extraKey);
        if (!afterFiltersMap.containsKey(key)) {
            List<IAfterFilter> filters = new ArrayList<IAfterFilter>();
            filters.addAll(currencyAfterFilters);
            if (afterFilterRegisterMap.containsKey(key)) {
                filters.addAll(afterFilterRegisterMap.get(key));
            }
            Collections.sort(filters, comparator);
            afterFiltersMap.putIfAbsent(key, filters);
        }
        return afterFiltersMap.get(key);
    }

    /**
     * 注册filter,如果request,responder,extraKey都为空,则注册为通用filter
     * @param requester
     * @param responder
     * @param extraKey
     * @param filter
     */
    public void registerPostFilter(String requester, String responder, String extraKey,
        IPostFilter filter) {
        if (CrmStringUtils.isNullOrEmpty(requester) && CrmStringUtils.isNullOrEmpty(responder)
            && CrmStringUtils.isNullOrEmpty(extraKey)) {
            currencyPostFilters.add(filter);
        } else {
            String key = InterfUtils.getKey(requester, responder, extraKey);
            if (!postFilterRegisterMap.containsKey(key)) {
                postFilterRegisterMap.putIfAbsent(key, new ArrayList<IPostFilter>());
            }
            postFilterRegisterMap.get(key).add(filter);
        }
    }

    public List<IPostFilter> getPostFilters(String requester, String responder, String extraKey) {
        String key = InterfUtils.getKey(requester, responder, extraKey);
        if (!postFiltersMap.containsKey(key)) {
            List<IPostFilter> filters = new ArrayList<IPostFilter>();
            filters.addAll(currencyPostFilters);
            if (postFilterRegisterMap.containsKey(key)) {
                filters.addAll(postFilterRegisterMap.get(key));
            }
            Collections.sort(filters, comparator);
            postFiltersMap.putIfAbsent(key, filters);
        }
        return postFiltersMap.get(key);
    }
}
