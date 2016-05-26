package com.ffcs.crmd.platform.pub.interfaces.handle;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.interfaces.utils.InterfUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public class InterfHandleManager {

    private ConcurrentMap<String, IInterfHandler> handleMap = new ConcurrentHashMap<String, IInterfHandler>();

    private static class InterfHandleManagerHolder {
        static InterfHandleManager INSTANCE = new InterfHandleManager();
    }

    private InterfHandleManager() {

    }

    public static InterfHandleManager getInstance() {
        return InterfHandleManagerHolder.INSTANCE;
    }

    public void registerHandler(String requester, String responder, String extraKey,
        IInterfHandler handler) {
        String key = InterfUtils.getKey(requester, responder, extraKey);
        handleMap.putIfAbsent(key, handler);
    }

    public IInterfHandler getHandler(String requester, String responder, String extraKey) {
        String key = InterfUtils.getKey(requester, responder, extraKey);
        IInterfHandler handler = handleMap.get(key);
        if (handler == null) {
            ExceptionUtils.throwEx(new RtManagerException(
                "no define the Handler,requester:" + requester + ",responder:" + responder
                    + ",extraKey:" + extraKey));
        }
        return handler;
    }
}
