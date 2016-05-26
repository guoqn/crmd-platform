package com.ffcs.crmd.platform.pub.proxy.callframework;

import com.ffcs.crmd.platform.pub.proxy.callframework.pool.CallContextPool;
import com.ffcs.crmd.platform.pub.proxy.callframework.pool.CallContextPoolObjectFactory;

/**
 * Created by linzhiqiang on 16/3/7.
 */
public class CallContextFactory {

    private static CallContextPool pool = new CallContextPool(new CallContextPoolObjectFactory());

    private CallContextFactory() {

    }

    public static ICallContext getContext() {
        return pool.getResource();
    }

    public static void returnRetrun(ICallContext context) {
        context.reset();
        pool.returnResource(context);
    }
}
