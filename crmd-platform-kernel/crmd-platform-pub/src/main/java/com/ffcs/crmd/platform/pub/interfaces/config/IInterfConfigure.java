package com.ffcs.crmd.platform.pub.interfaces.config;

import com.ffcs.crmd.platform.pub.interfaces.handle.IBaseInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.log.LogLevel;
import com.ffcs.crmd.platform.pub.interfaces.thread.ThreadLevel;

/**
 * Created by linzhiqiang on 16/4/29.
 */
public interface IInterfConfigure {

    /**
     * 是否异步调用
     * @param baseHandler
     * @return
     */
    Boolean isAsync(IBaseInterfHandler baseHandler);

    /**
     * 是否模拟调用
     * @param baseHandler
     * @return
     */
    Boolean isNeedMock(IBaseInterfHandler baseHandler);

    /**
     * 超时时间配置
     * @param baseHandler
     * @return
     */
    Long getTimeOut(IBaseInterfHandler baseHandler);

    /**
     * 获取线程运行级别
     * @param baseHandler
     * @return
     */
    ThreadLevel getThreadLevel(IBaseInterfHandler baseHandler);

    /**
     * 获取线程配置分组
     * @param baseHandler
     * @return
     */
    String getThreadGroup(IBaseInterfHandler baseHandler);

    /**
     * 获取线程池名称
     * @param baseHandler
     * @return
     */
    String getThreadPoolName(IBaseInterfHandler baseHandler);

    /**
     * 获取前置日志级别
     * @param baseHandler
     * @return
     */
    LogLevel getBeforeLogLevel(IBaseInterfHandler baseHandler);

    /**
     * 获取后置日志级别
     * @param baseHandler
     * @return
     */
    LogLevel getAfterLogLevel(IBaseInterfHandler baseHandler);

    /**
     * 获取异步日志队列名
     * @param baseHandler
     * @return
     */
    String getLogThreadPoolName(IBaseInterfHandler baseHandler);

    /**
     * 获取日志记录配置
     * @param baseHandler
     * @return
     */
    String getLoggers(IBaseInterfHandler baseHandler);
}
