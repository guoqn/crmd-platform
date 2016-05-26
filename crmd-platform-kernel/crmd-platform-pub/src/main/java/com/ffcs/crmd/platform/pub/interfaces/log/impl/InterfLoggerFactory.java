package com.ffcs.crmd.platform.pub.interfaces.log.impl;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.interfaces.config.IInterfConfigure;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.handle.IBaseInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLoggerAppender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class InterfLoggerFactory {

    private static final ILogger LOGGER = LoggerFactory.getLogger(InterfLoggerFactory.class);

    private static ConcurrentMap<IBaseInterfHandler, List<IInterfLoggerAppender>> cacheMap = new ConcurrentHashMap<IBaseInterfHandler, List<IInterfLoggerAppender>>();

    public static List<IInterfLoggerAppender> getLoggers(IInterfConfigure configure,
        IBaseInterfHandler handler) {
        if (!cacheMap.containsKey(handler)) {

            List<IInterfLoggerAppender> appenders = new ArrayList<IInterfLoggerAppender>();
            String loggers = configure.getLoggers(handler);
            String[] logArray = CrmStringUtils.split(loggers, ",");
            for (String logger : logArray) {
                IInterfLoggerAppender appender = InterfLoggerAppenderManager.getInstance()
                    .getAppender(CrmStringUtils.trim(logger));
                if (appender != null) {
                    appenders.add(appender);
                } else {
                    LOGGER.warn("logger Appender  {} not define.", logger);
                }
            }
            cacheMap.putIfAbsent(handler, appenders);
        }
        return cacheMap.get(handler);
    }

    public static void saveLog(IInterfConfigure configure, IBaseInterfHandler handler,
        IInterfLog log, IMsgContext context) {
        List<IInterfLoggerAppender> appenders = getLoggers(configure, handler);
        if (appenders == null || appenders.size() <= 0) {
            LOGGER.warn("reqester:{},responder:{},extraKey:{} ,logger Appender  not define.",
                handler.getRequester(), handler.getResponder(), handler.getExtraKey());
            ExceptionUtils.throwEx(new RtManagerException("logger Appender  not define."));
        }
        for (IInterfLoggerAppender appender : appenders) {
            appender.saveLog(log, context);
        }
    }
}

