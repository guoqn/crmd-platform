package com.ffcs.crmd.platform.pub.interfaces.async;

import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.config.IInterfConfigure;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.thread.ThreadLevel;
import com.ffcs.crmd.platform.pub.interfaces.thread.ThreadPoolFactory;

import java.util.concurrent.FutureTask;

/**
 * Created by linzhiqiang on 16/4/29.
 */
public class AsyncTaskFactory {

    /**
     * 提交异步任务
     * @param handler
     * @param context
     * @return
     */
    public static FutureTask<String> commitAsyncTask(IInterfConfigure configure,
        AbstractInterfHandler handler, IMsgContext context) {
        FutureTask<String> task = new FutureTask<String>(new AsyncCallable(handler, context));

        ThreadLevel level = configure
            .getThreadLevel(handler);

        if (ThreadLevel.SINGLE.equals(level) || ThreadLevel.SHARED.equals(level)) {
            ThreadPoolFactory
                .commitThread(configure, handler, level, task);
        } else if (ThreadLevel.DIRECT.equals(level)) {
            Thread t = new Thread(task);
            t.start();
        }

        return task;
    }

}
