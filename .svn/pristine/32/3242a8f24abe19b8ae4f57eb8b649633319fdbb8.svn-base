package com.ffcs.crmd.platform.pub.interfaces.thread;

import com.ffcs.crmd.lmax.base.Producers;
import com.ffcs.crmd.lmax.base.TransEventProducer;
import com.ffcs.crmd.lmax.pool.CommandPoolUtils;
import com.ffcs.crmd.lmax.pool.CommandPools;
import com.ffcs.crmd.platform.pub.interfaces.config.IInterfConfigure;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.handle.IBaseInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.handle.ILogHandler;
import com.ffcs.crmd.platform.pub.interfaces.log.lmax.AsyncLogCommand;
import com.ffcs.crmd.platform.pub.interfaces.utils.InterfUtils;

import java.util.concurrent.FutureTask;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class ThreadPoolFactory {
    public static void commitThread(IInterfConfigure configure, IBaseInterfHandler baseHandler,
        ThreadLevel level, FutureTask task) {
        String threadGroup = configure.getThreadGroup(baseHandler);
        if (ThreadLevel.SINGLE.equals(level)) {
            TransEventProducer producer = Producers
                .getProducer(threadGroup, configure.getThreadPoolName(baseHandler));
            producer.produce(task);
        } else if (ThreadLevel.SHARED.equals(level)) {
            TransEventProducer producer = Producers
                .getProducer(threadGroup, InterfUtils.DEFAULT_SHARD_THREAD_POOL_NAME);
            producer.produce(task);
        }
    }

    public static void commitAsyncLog(IInterfConfigure configure, IBaseInterfHandler baseHandler,
        ILogHandler logHandler, IMsgContext context, String beforeOrAfter) {
        String threadGroup = configure.getThreadGroup(baseHandler);

        AsyncLogCommand command = CommandPoolUtils.getCommand(AsyncLogCommand.class);
        command.setHandler(logHandler);
        command.setContext(context);
        command.setBeforeOrAfter(beforeOrAfter);
        TransEventProducer producer = Producers
            .getProducer(threadGroup, configure.getLogThreadPoolName(baseHandler));
        producer.produce(command);

    }
}
