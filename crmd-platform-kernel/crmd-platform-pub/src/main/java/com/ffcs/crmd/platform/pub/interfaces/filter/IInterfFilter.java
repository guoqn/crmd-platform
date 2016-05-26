package com.ffcs.crmd.platform.pub.interfaces.filter;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;
import com.ffcs.crmd.platform.pub.interfaces.handle.IInterfHandler;

/**
 * Created by linzhiqiang on 16/5/3.
 */
public interface IInterfFilter {
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

    /**
     * 排序支持
     * @return
     */
    int getOrder();

    /**
     * filter处理
     * @param contect
     * @param handler
     * @return
     */
    FilterRetObject filter(IMsgContext contect,AbstractInterfHandler handler);
}
