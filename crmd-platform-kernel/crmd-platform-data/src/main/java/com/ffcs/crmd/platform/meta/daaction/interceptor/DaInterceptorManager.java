package com.ffcs.crmd.platform.meta.daaction.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzq on 2016/1/17.
 */
public class DaInterceptorManager {

    private static class InterceptorManagerHolder {
        static DaInterceptorManager INSTANCE = new DaInterceptorManager();
    }

    private List<DaInterceptor> interceptorList = new ArrayList<DaInterceptor>();

    private DaInterceptorManager() {

    }

    public static DaInterceptorManager getInstance() {
        return InterceptorManagerHolder.INSTANCE;
    }

    public List<DaInterceptor> getInterceptorList() {
        return interceptorList;
    }

    public void registerInterceptor(DaInterceptor interceptor) {
        interceptorList.add(interceptor);
    }
}
