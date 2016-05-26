package com.ffcs.crmd.platform.pub.interfaces.log.impl;

import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLoggerAppender;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class InterfLoggerAppenderManager {

    private ConcurrentMap<String, IInterfLoggerAppender> appenderMap = new ConcurrentHashMap<String, IInterfLoggerAppender>();

    private static class InterfLoggerAppenderManagerHolder {
        static InterfLoggerAppenderManager INSTANCE = new InterfLoggerAppenderManager();
    }

    private InterfLoggerAppenderManager() {

    }

    public static InterfLoggerAppenderManager getInstance() {
        return InterfLoggerAppenderManagerHolder.INSTANCE;
    }

    public void registerAppender(String appenderType,
        IInterfLoggerAppender loggerAppender) {
        appenderMap.putIfAbsent(appenderType, loggerAppender);
    }

    public IInterfLoggerAppender getAppender(String appenderType) {
        return appenderMap.get(appenderType);
    }
}
