package com.ffcs.crmd.platform.pub.interfaces.log.impl;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLoggerAppender;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public abstract class AbstractInterfLoggerAppender implements IInterfLoggerAppender {

    public AbstractInterfLoggerAppender() {
        InterfLoggerAppenderManager.getInstance().registerAppender(this.getAppenderType(), this);
    }

    @Override
    public abstract String getAppenderType();

    @Override
    public abstract void saveLog(IInterfLog log, IMsgContext context);
}
