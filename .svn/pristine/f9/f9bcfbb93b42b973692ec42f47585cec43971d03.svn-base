package com.ffcs.crmd.platform.pub.proxy.callframework;

import com.ctg.itrdc.platform.pub.bean.ReqResult;

/**
 * Created by linzhiqiang on 16/3/7.
 */
public interface ICallContext {

    /**
     * 重置状态
     */
    public void reset();

    /**
     * 开始批量调用标记
     */
    public void startBatch();

    /**
     * 结束批量调用,发出实际调用
     */
    public void commitBatch() throws InterruptedException;

    /**
     * 开始数据获取.
     */
    public void startData();

    /**
     * 结束数据获取.
     */
    public void endData();

    /**
     * 保存调用对象
     * @param entity
     */
    public void addCallEntity(CallEntity entity);

    /**
     * 获取返回对象
     * @param entity
     */
    public ReqResult getReqResult(CallEntity entity);
}
