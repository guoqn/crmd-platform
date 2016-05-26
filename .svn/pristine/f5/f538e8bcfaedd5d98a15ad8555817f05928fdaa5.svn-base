package com.ffcs.crmd.platform.pub.interfaces.context;

import com.ffcs.crmd.platform.pub.interfaces.entity.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public class AbstractMsgContext implements IMsgContext {

    protected String requestMsg;

    protected Object requestObj;

    protected String respondMsg;

    protected Object respondObj;

    protected boolean isTimeOut;

    protected RequestParam param;

    protected List<Throwable> exceptions = new ArrayList<Throwable>();

    @Override
    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    @Override
    public String getRequestMsg() {
        return requestMsg;
    }

    @Override
    public <T> T getRequestObj() {
        if (requestObj != null) {
            return (T) requestObj;
        }
        return null;
    }

    @Override
    public void setRequestObj(Object obj) {
        this.requestObj = obj;
    }

    @Override
    public void setRespondMsg(String respondMsg) {
        this.respondMsg = respondMsg;
    }

    @Override
    public String getRespondMsg() {
        return respondMsg;
    }

    @Override
    public <T> T getRespondObj() {
        if (respondObj != null) {
            return (T) respondObj;
        }
        return null;
    }

    @Override
    public void setRespondObj(Object obj) {
        this.respondObj = obj;
    }

    @Override
    public void addException(Throwable e) {
        exceptions.add(e);
    }

    @Override
    public List<Throwable> getExceptions() {
        return exceptions;
    }

    public boolean isTimeOut() {
        return isTimeOut;
    }

    public void setTimeOut(boolean timeOut) {
        isTimeOut = timeOut;
    }

    @Override
    public void setRequestParam(RequestParam param) {
        this.param = param;
    }

    @Override
    public RequestParam getRequestParam() {
        return this.param;
    }
}
