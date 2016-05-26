package com.ffcs.crmd.platform.pub.interfaces.handle;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public interface IBaseInterfHandler {
    /**
     * 调用方标志
     * @return
     */
    String getRequester();

    /**
     * 被调用方标志
     * @return
     */
    String getResponder();

    /**
     * 扩展标志
     * @return
     */
    String getExtraKey();

}
