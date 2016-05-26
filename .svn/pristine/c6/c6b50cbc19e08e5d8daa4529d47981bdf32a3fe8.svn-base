package com.ffcs.crmd.platform.pub.interfaces.log.impl;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import org.springframework.stereotype.Component;

/**
 * Created by linzhiqiang on 16/4/30.
 */
@Component
public class Slf4jInterfLoggerAppender extends AbstractInterfLoggerAppender {
    private ILogger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getAppenderType() {
        return "slf4j";
    }

    @Override
    public void saveLog(IInterfLog log, IMsgContext context) {
        logger.info(log.toString());
    }
}
