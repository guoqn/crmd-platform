package com.ffcs.crmd.platform.pub.proxy.callfilter;

import com.ffcs.crmd.platform.pub.proxy.callfilter.impl.AbstractCompProxyCallFilter;
import com.ffcs.crmd.platform.pub.proxy.callfilter.serverimpl.AbstractCompServerCallFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public class CallFilterManager {

    private static class CallFilterManagerHolder {
        static CallFilterManager INSTANCE = new CallFilterManager();
    }

    private List<AbstractCompProxyCallFilter> proxyFilterList = new ArrayList<AbstractCompProxyCallFilter>();

    private List<AbstractCompServerCallFilter> serverFilterList = new ArrayList<AbstractCompServerCallFilter>();

    private CallFilterManager() {

    }

    public static CallFilterManager getInstance() {
        return CallFilterManagerHolder.INSTANCE;
    }

    public List<AbstractCompProxyCallFilter> getCompProxyList() {
        return proxyFilterList;
    }

    public void registerProxyCallFilter(AbstractCompProxyCallFilter filter) {
        proxyFilterList.add(filter);
        Collections.sort(proxyFilterList, new Comparator<ICallFilter>() {
            @Override
            public int compare(ICallFilter o1, ICallFilter o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
    }

    public List<AbstractCompServerCallFilter> getCompServerList() {
        return serverFilterList;
    }

    public void registerServerCallFilter(AbstractCompServerCallFilter filter) {
        serverFilterList.add(filter);
        Collections.sort(serverFilterList, new Comparator<ICallFilter>() {
            @Override
            public int compare(ICallFilter o1, ICallFilter o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
    }

}

