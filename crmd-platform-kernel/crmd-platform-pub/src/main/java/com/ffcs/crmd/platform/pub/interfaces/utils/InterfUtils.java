package com.ffcs.crmd.platform.pub.interfaces.utils;

import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.interfaces.log.LogLevel;
import com.ffcs.crmd.platform.pub.interfaces.thread.ThreadLevel;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class InterfUtils {

    public static final String SPLIT = ".";

    public static final String THREAD_SPLIT = "_#_";

    /**
     * 全局默认参数后缀
     */
    public static final String GLOBAL_SUFFIX = "global";

    /**
     * 线程池级别配置
     */
    public static final String      PRE_THREAD_LEVEL               = "threadLevel";
    /**
     * 是否异步处理
     */
    public static final String      PRE_ASYNC                      = "async";
    /**
     * 默认异步配置
     */
    public static final Boolean     DEFAULT_ASYNC                  = Boolean.TRUE;
    /**
     * 是否模拟
     */
    public static final String      PRE_MOCK                       = "mock";
    /**
     * 超时配置
     */
    public static final String      PRE_TIMEOUT                    = "timeout";
    /**
     * 默认模拟开关
     */
    public static final Boolean     DEFAULT_MOCK                   = Boolean.FALSE;
    /**
     * 默认超时,30s
     */
    public static final Long        DEFAULT_TIMEOUT                = 30 * 1000L;
    public static final ThreadLevel DEFAULT_THREAD_LEVEL           = ThreadLevel.SINGLE;
    public static final String      PRE_THREAD_GROUP               = "threadGroup";
    public static final String      PRE_THREAD_POOL_NAME           = "threadPoolName";
    public static final String      DEFAULT_THREAD_GROUP           = "globalThreadGroup";
    public static final String      DEFAULT_SHARD_THREAD_POOL_NAME = "globalPool";
    public static final String      PRE_BEFORE_LOG_LEVEL           = "beforeLogLevel";
    public static final LogLevel    DEFAULT_BEFORE_LEVEL           = LogLevel.OFF;
    public static final String      PRE_AFTER_LOG_LEVEL            = "afterLogLevel";
    public static final LogLevel    DEFAULT_AFTER_LEVEL            = LogLevel.ASYNC;
    public static final String      PRE_LOG_THREAD_POOL_NAME       = "logThreadPoolName";
    public static final String      DEFAULT_LOG_THREAD_POOL_NAME   = "globalLogPool";
    public static final String      PRE_LOGGERS                    = "loggers";
    public static final String      DEFAULT_LOGGERS                = "slf4j";

    /**
     * 获取key
     * @param args
     * @return
     */
    public static String getKey(String... args) {
        return CrmStringUtils.join(args, SPLIT);
    }

    /**
     * 获取key
     * @param args
     * @return
     */
    public static String getThreadKey(String... args) {
        return CrmStringUtils.join(args, THREAD_SPLIT);
    }
}
