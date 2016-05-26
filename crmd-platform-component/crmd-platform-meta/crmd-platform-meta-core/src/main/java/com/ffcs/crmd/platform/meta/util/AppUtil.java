package com.ffcs.crmd.platform.meta.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取服务器地址和端口 工具类
 * Created by qn_guo on 2016/1/6.
 */
public class AppUtil {

    /**
     * 获取服务器地址+端口
     * example 111.111.111.111:8080
     * @return
     */
    public static String getAppAddr() {
        String address= "";
//        InetAddress myIPaddress = null;
//        try {
//            myIPaddress = InetAddress.getLocalHost();
//            address = myIPaddress.getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
        return address;
    }
}
