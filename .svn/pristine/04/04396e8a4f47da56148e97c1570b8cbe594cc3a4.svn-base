package com.ffcs.crmd.platform.pub.interfaces;

import com.ffcs.crmd.platform.pub.interfaces.config.IInterfConfigure;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.entity.RequestParam;
import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.handle.impl.AbstractServerInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import org.springframework.stereotype.Service;

/**
 * Created by linzhiqiang on 16/4/30.
 */
@Service
public class PfCompleteOraderServerHandler extends AbstractServerInterfHandler {
    @Override
    public String getExtraKey() {
        return "completeOrder";
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
        return "respond:" + "Other:" + context.getRequestMsg();
    }

    @Override
    protected String doCreateTimeOutExcetionRespon(Exception e, IMsgContext context) {
        return "respond:" + "TimeOut:" + context.getRequestMsg();
    }

    @Override
    public String doHandle(IMsgContext context) {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "respond:" + "normal:" + context.getRequestMsg();
    }

    @Override
    public String doMockHandle(IMsgContext context) {
        return "respond:" + "mock:" + context.getRequestMsg();
    }

    @Override
    public IInterfLog createBeforeLog(IMsgContext context) {
        return new TestInterfLog(context.getRequestMsg());
    }

    @Override
    public IInterfLog createAfterLog(IMsgContext context) {
        return new TestInterfLog(context.getRequestMsg() + ",respond");
    }

    @Override
    protected IMsgContext buildeContext(String request, RequestParam param) {
        return super.buildeContext(request, param);
    }

    @Override
    protected IMsgContext fillRequest(String request, RequestParam param, IMsgContext context) {
        return super.fillRequest(request, param, context);
    }

    @Override
    protected IMsgContext fillRespond(String respond, IMsgContext context) {
        return super.fillRespond(respond, context);
    }
}
