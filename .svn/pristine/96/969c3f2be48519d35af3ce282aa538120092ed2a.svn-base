package com.ffcs.crmd.platform.pub.interfaces.log.lmax;

import com.ffcs.crmd.lmax.base.AbstractCommand;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.handle.ILogHandler;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class AsyncLogCommand extends AbstractCommand {

    private ILogHandler handler       = null;
    private IMsgContext context       = null;
    private String      beforeOrAfter = "";

    public AsyncLogCommand() {
    }

    public ILogHandler getHandler() {
        return handler;
    }

    public void setHandler(ILogHandler handler) {
        this.handler = handler;
    }

    public IMsgContext getContext() {
        return context;
    }

    public void setContext(IMsgContext context) {
        this.context = context;
    }

    public String getBeforeOrAfter() {
        return beforeOrAfter;
    }

    public void setBeforeOrAfter(String beforeOrAfter) {
        this.beforeOrAfter = beforeOrAfter;
    }

    @Override
    public void execute(long sequence, boolean endOfBatch) throws Exception {
        if ("before".equals(beforeOrAfter)) {
            handler.actualBeforeLog(context);
        } else if ("after".equals(beforeOrAfter)) {
            handler.actualAfterLog(context);
        }
    }

    @Override
    public void clear() {
        this.context = null;
        this.handler = null;
        this.beforeOrAfter = "";
    }
}
