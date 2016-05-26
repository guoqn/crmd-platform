package com.ffcs.crmd.platform.pub.interfaces.handle;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.entity.RequestParam;
import com.ffcs.crmd.platform.pub.interfaces.entity.RetObject;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public interface IProcessHandler extends IBaseInterfHandler {

    /**
     * 获取上下文对象
     * @param request
     * @param param
     * @return
     */
    IMsgContext initContext(String request, RequestParam param);

    /**
     * 预处理,用于处理调用之前的预处理信息，如线程变量，登录信息等的处理
     * @param context
     */
    RetObject preHandle(IMsgContext context);

    /**
     * 实际调用前准备
     * @param context
     */
    RetObject beforeHandle(IMsgContext context);

    /**
     * 实际调用后处理
     * @param context
     */
    RetObject afterHandle(IMsgContext context);

    /**
     * 调用完成处理,现场清理
     * @param context
     */
    RetObject postHandle(IMsgContext context);

    /**
     * 实际调用
     * @param context
     * @return
     */
    String doHandle(IMsgContext context);

    /**
     * 模拟调用,用于接口异常处理
     * @param context
     * @return
     */
    String doMockHandle(IMsgContext context);
}
