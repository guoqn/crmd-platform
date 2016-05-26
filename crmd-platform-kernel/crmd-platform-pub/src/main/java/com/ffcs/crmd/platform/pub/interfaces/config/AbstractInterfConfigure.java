package com.ffcs.crmd.platform.pub.interfaces.config;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.base.utils.type.CrmNumberUtils;
import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.interfaces.handle.IBaseInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.log.LogLevel;
import com.ffcs.crmd.platform.pub.interfaces.thread.ThreadLevel;
import com.ffcs.crmd.platform.pub.interfaces.utils.InterfUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public abstract class AbstractInterfConfigure implements IInterfConfigure {

    protected ILogger logger = LoggerFactory.getLogger(this.getClass());

    protected ConcurrentMap<String, String> configureCacheMap = new ConcurrentHashMap<String, String>();

    protected ConcurrentMap<String, String> cacheFlag = new ConcurrentHashMap<String, String>();

    @Override
    public Boolean isAsync(IBaseInterfHandler baseHandler) {
        String asyncStr = getCustomValue(InterfUtils.PRE_ASYNC, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(asyncStr)) {
            logger.debug("reqester:{},responder:{},extraKey:{},could not get the customer async",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());
            asyncStr = getGlobalValue(InterfUtils.PRE_ASYNC, baseHandler);
        }
        Boolean async = Boolean.FALSE;
        if (CrmStringUtils.isNullOrEmpty(asyncStr)) {
            async = InterfUtils.DEFAULT_ASYNC;
        } else {
            async = Boolean.valueOf(asyncStr);
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, async:{}", baseHandler.getRequester(),
            baseHandler.getResponder(), baseHandler.getExtraKey(), async);
        return async;
    }

    @Override
    public Boolean isNeedMock(IBaseInterfHandler baseHandler) {
        String mockStr = getCustomValue(InterfUtils.PRE_MOCK, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(mockStr)) {
            logger.debug("reqester:{},responder:{},extraKey:{},could not get the customer mock",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());

            mockStr = getGlobalValue(InterfUtils.PRE_MOCK, baseHandler);
        }
        Boolean mock = Boolean.FALSE;
        if (CrmStringUtils.isNullOrEmpty(mockStr)) {
            mock = InterfUtils.DEFAULT_MOCK;
        } else {
            mock = Boolean.valueOf(mockStr);
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, mock:{}", baseHandler.getRequester(),
            baseHandler.getResponder(), baseHandler.getExtraKey(), mock);
        return mock;
    }

    @Override
    public Long getTimeOut(IBaseInterfHandler baseHandler) {
        String timeOutStr = getCustomValue(InterfUtils.PRE_TIMEOUT, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(timeOutStr)) {
            logger.debug("reqester:{},responder:{},extraKey:{},could not get the customer timeout",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());

            timeOutStr = getGlobalValue(InterfUtils.PRE_TIMEOUT, baseHandler);
        }

        Long timeOut = CrmNumberUtils.nullToLongZero(timeOutStr);
        //为0 的话,采用默认值,-1表示不超时.
        if (timeOut == 0) {
            timeOut = InterfUtils.DEFAULT_TIMEOUT;
        } else {
            timeOut = CrmNumberUtils.nullToLongZero(timeOut);
        }

        logger.debug("reqester:{},responder:{},extraKey:{}, timeout:{}", baseHandler.getRequester(),
            baseHandler.getResponder(), baseHandler.getExtraKey(), timeOut);
        return timeOut;
    }

    @Override
    public ThreadLevel getThreadLevel(IBaseInterfHandler baseHandler) {
        String threadLevelStr = getCustomValue(InterfUtils.PRE_THREAD_LEVEL, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(threadLevelStr)) {
            logger.debug(
                "reqester:{},responder:{},extraKey:{},could not get the customer thread level",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());

            threadLevelStr = getGlobalValue(InterfUtils.PRE_THREAD_LEVEL, baseHandler);
        }

        ThreadLevel level = ThreadLevel.getLevel(threadLevelStr);
        if (level == null) {
            level = InterfUtils.DEFAULT_THREAD_LEVEL;
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, threadLevel:{}",
            baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey(),
            level.level());

        return level;
    }

    protected String getValue(String key) {
        if (!cacheFlag.containsKey(key)) {
            String actualValue = getActualValue(key);
            if (!CrmStringUtils.isNullOrEmpty(actualValue)) {
                configureCacheMap.putIfAbsent(key, actualValue);
            }
            cacheFlag.putIfAbsent(key, "1");
        }
        return configureCacheMap.get(key);
    }

    protected abstract String getActualValue(String key);

    /**
     * 去接口自定义配置
     * @param preFix
     * @param baseHandler
     * @return
     */
    protected String getCustomValue(String preFix, IBaseInterfHandler baseHandler) {
        String key = InterfUtils
            .getKey(preFix, baseHandler.getRequester(), baseHandler.getResponder(),
                baseHandler.getExtraKey());
        String customValue = getValue(key);
        return customValue;
    }

    /**
     * 取全局配置
     * @param preFix
     * @param baseInterfHandler
     * @return
     */
    protected String getGlobalValue(String preFix, IBaseInterfHandler baseInterfHandler) {
        String global = getGlobalRequesterValue(preFix, baseInterfHandler.getRequester());
        if (!CrmStringUtils.isNullOrEmpty(global)) {
            return global;
        }
        global = getGlobalResponderValue(preFix, baseInterfHandler.getResponder());
        if (!CrmStringUtils.isNullOrEmpty(global)) {
            return global;
        }
        String key = InterfUtils.getKey(preFix, InterfUtils.GLOBAL_SUFFIX);
        global = getValue(key);
        return global;
    }

    protected String getGlobalRequesterValue(String preFix, String requester) {
        String key = InterfUtils.getKey(preFix, InterfUtils.GLOBAL_SUFFIX, requester);
        String global = getValue(key);
        return global;
    }

    protected String getGlobalResponderValue(String preFix, String responder) {
        String key = InterfUtils.getKey(preFix, InterfUtils.GLOBAL_SUFFIX, responder);
        String global = getValue(key);
        return global;
    }

    @Override
    public String getThreadGroup(IBaseInterfHandler baseHandler) {
        String threadGroupStr = getCustomValue(InterfUtils.PRE_THREAD_GROUP, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(threadGroupStr)) {

            logger.debug(
                "reqester:{},responder:{},extraKey:{},could not get the customer threadGroup",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());
            threadGroupStr = getGlobalValue(InterfUtils.PRE_THREAD_GROUP, baseHandler);
        }

        if (CrmStringUtils.isNullOrEmpty(threadGroupStr)) {
            threadGroupStr = InterfUtils.DEFAULT_THREAD_GROUP;
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, threadGroup:{}",
            baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey(),
            threadGroupStr);
        return threadGroupStr;
    }

    @Override
    public String getThreadPoolName(IBaseInterfHandler baseHandler) {
        String threadPoolStr = getCustomValue(InterfUtils.PRE_THREAD_POOL_NAME, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(threadPoolStr)) {
            logger.debug(
                "reqester:{},responder:{},extraKey:{},could not get the customer threadPoolName",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());
            return InterfUtils.getThreadKey(baseHandler.getRequester(), baseHandler.getResponder(),
                baseHandler.getExtraKey());
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, threadPoolName:{}",
            baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey(),
            threadPoolStr);
        return threadPoolStr;
    }

    @Override
    public LogLevel getBeforeLogLevel(IBaseInterfHandler baseHandler) {
        String logLevelStr = getCustomValue(InterfUtils.PRE_BEFORE_LOG_LEVEL, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(logLevelStr)) {
            logger.debug(
                "reqester:{},responder:{},extraKey:{},could not get the customer before log level",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());

            logLevelStr = getGlobalValue(InterfUtils.PRE_BEFORE_LOG_LEVEL, baseHandler);
        }

        LogLevel level = LogLevel.getLevel(logLevelStr);
        if (level == null) {
            level = InterfUtils.DEFAULT_BEFORE_LEVEL;
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, beforeLevel:{}",
            baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey(),
            level.level());

        return level;
    }

    @Override
    public LogLevel getAfterLogLevel(IBaseInterfHandler baseHandler) {
        String logLevelStr = getCustomValue(InterfUtils.PRE_AFTER_LOG_LEVEL, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(logLevelStr)) {
            logger.debug(
                "reqester:{},responder:{},extraKey:{},could not get the customer after log level",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());

            logLevelStr = getGlobalValue(InterfUtils.PRE_AFTER_LOG_LEVEL, baseHandler);
        }

        LogLevel level = LogLevel.getLevel(logLevelStr);
        if (level == null) {
            level = InterfUtils.DEFAULT_AFTER_LEVEL;
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, afterLevel:{}",
            baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey(),
            level.level());
        return level;
    }

    @Override
    public String getLogThreadPoolName(IBaseInterfHandler baseHandler) {
        String threadPoolStr = getCustomValue(InterfUtils.PRE_LOG_THREAD_POOL_NAME, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(threadPoolStr)) {
            logger.debug(
                "reqester:{},responder:{},extraKey:{},could not get the customer logThreadPoolName",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());
            threadPoolStr = InterfUtils.DEFAULT_LOG_THREAD_POOL_NAME;
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, logThreadPoolName:{}",
            baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey(),
            threadPoolStr);
        return threadPoolStr;
    }

    @Override
    public String getLoggers(IBaseInterfHandler baseHandler) {
        String loggers = getCustomValue(InterfUtils.PRE_LOGGERS, baseHandler);
        if (CrmStringUtils.isNullOrEmpty(loggers)) {
            logger.debug("reqester:{},responder:{},extraKey:{},could not get the customer loggers",
                baseHandler.getRequester(), baseHandler.getResponder(), baseHandler.getExtraKey());

            loggers = getGlobalValue(InterfUtils.PRE_LOGGERS, baseHandler);
        }

        if (CrmStringUtils.isNullOrEmpty(loggers)) {
            loggers = InterfUtils.DEFAULT_LOGGERS;
        }
        logger.debug("reqester:{},responder:{},extraKey:{}, loggers:{}", baseHandler.getRequester(),
            baseHandler.getResponder(), baseHandler.getExtraKey(), loggers);
        return loggers;
    }
}
