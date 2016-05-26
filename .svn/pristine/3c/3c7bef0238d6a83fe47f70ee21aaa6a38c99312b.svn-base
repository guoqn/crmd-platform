package com.ffcs.crmd.platform.pub.interfaces.handle;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;

/**
 * Created by linzhiqiang on 16/4/29.
 */
public interface ILogHandler extends IBaseInterfHandler {

    /**
     * 创建前置日志对象
     * @param context
     * @return
     */
    IInterfLog createBeforeLog(IMsgContext context);

    /**
     * 创建后置日志对象
     * @param context
     * @return
     */
    IInterfLog createAfterLog(IMsgContext context);

    void actualBeforeLog(IMsgContext context);

    void actualAfterLog(IMsgContext context);

}
