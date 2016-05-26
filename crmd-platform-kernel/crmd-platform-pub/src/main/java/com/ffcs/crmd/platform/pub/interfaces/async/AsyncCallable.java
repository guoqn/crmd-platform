package com.ffcs.crmd.platform.pub.interfaces.async;

import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;

import java.util.concurrent.Callable;

/**
 * Created by linzhiqiang on 16/4/29.
 */
public class AsyncCallable implements Callable<String> {

    private AbstractInterfHandler handler;

    private IMsgContext context;

    public AsyncCallable(final AbstractInterfHandler handler,
        IMsgContext context) {
        this.handler = handler;
        this.context = context;
    }

    @Override
    public String call() throws Exception {
        return handler.actualCall(context);
    }
}
