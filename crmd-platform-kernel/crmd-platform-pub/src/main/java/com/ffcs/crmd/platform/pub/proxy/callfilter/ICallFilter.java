package com.ffcs.crmd.platform.pub.proxy.callfilter;

import org.springframework.core.Ordered;

import java.util.Map;

/**
 * Created by linzhiqiang on 16/2/16.
 */
public interface ICallFilter extends Ordered {

    /**
     * 获取map信息
     * @return
     */
    Map<String,String> getPropsMap();

    /**
     * 回填属性信息
     */
    void putPropsMap(Map<String,String> map);


}
