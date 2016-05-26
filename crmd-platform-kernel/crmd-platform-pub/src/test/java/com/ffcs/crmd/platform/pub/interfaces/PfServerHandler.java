package com.ffcs.crmd.platform.pub.interfaces;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.handle.impl.AbstractServerInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import org.springframework.stereotype.Service;

/**
 * Created by linzhiqiang on 16/4/30.
 */
@Service
public class PfServerHandler extends AbstractServerInterfHandler {
    @Override
    public String getExtraKey() {
        return "";
    }

    @Override
    public String getResponder() {
        return "PF";
    }

    @Override
    public String getRequester() {
        return "CRM";
    }

    @Override
    protected String doCreateOtherExcetionRespon(Exception e, IMsgContext context) {
        return "respond:" + "Other3:" + context.getRequestMsg();
    }

    @Override
    protected String doCreateTimeOutExcetionRespon(Exception e, IMsgContext context) {
        return "respond:" + "TimeOut3:" + context.getRequestMsg();
    }

    @Override
    public String doHandle(IMsgContext context) {
        return "respond:" + "normal3:" + context.getRequestMsg();
    }

    @Override
    public String doMockHandle(IMsgContext context) {
        return "respond:" + "mock3:" + context.getRequestMsg();
    }

    @Override
    public IInterfLog createBeforeLog(IMsgContext context) {
        return new TestInterfLog(context.getRequestMsg() + "3");
    }

    @Override
    public IInterfLog createAfterLog(IMsgContext context) {
        return new TestInterfLog(context.getRequestMsg() + ",respond3");
    }


}
