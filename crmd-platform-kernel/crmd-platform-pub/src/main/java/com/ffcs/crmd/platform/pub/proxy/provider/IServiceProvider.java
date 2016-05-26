package com.ffcs.crmd.platform.pub.proxy.provider;

import java.util.Map;

/**
 * 服务获取方式
 * .
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author linzq
 * @version Revision 1.0.0
 * @see:
 * @创建日期： 2015年10月22日
 * @功能说明：
 */
public interface IServiceProvider {
    public String getServiceName(String serviceName, String mod, Map<String, Object> params);
    
    public String getServiceName(String serviceName, String mod);
}
