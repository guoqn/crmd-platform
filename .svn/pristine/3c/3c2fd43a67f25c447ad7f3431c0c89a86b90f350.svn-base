package com.ffcs.crmd.platform.pub.interfaces.context;

import com.ffcs.crmd.platform.pub.interfaces.entity.RequestParam;

import java.util.List;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public interface IMsgContext {
    /**
     * 请求内容
     * @param requestMsg
     */
    void setRequestMsg(String requestMsg);

    /**
     * 读取请求内容
     * @return
     */
    String getRequestMsg();

    /**
     * 获取请求对象
     * @param <T>
     * @return
     */
    <T> T getRequestObj();

    /**
     * 设置请求对象
     * @param obj
     */
    void setRequestObj(Object obj);

    /**
     * 响应内容
     * @param respondMsg
     */
    void setRespondMsg(String respondMsg);

    /**
     * 读取响应内容
     * @return
     */
    String getRespondMsg();

    /**
     * 获取返回对象
     * @param <T>
     * @return
     */
    <T> T getRespondObj();

    /**
     * 设置响应对象
     * @param obj
     */
    void setRespondObj(Object obj);

    /**
     * 保存异常
     * @param e
     */
    void addException(Throwable e);

    /**
     * 获取异常列表
     * @return
     */
    List<Throwable> getExceptions();

    boolean isTimeOut();

    void setTimeOut(boolean timeOut);

    void setRequestParam(RequestParam param);

    RequestParam getRequestParam();
}
