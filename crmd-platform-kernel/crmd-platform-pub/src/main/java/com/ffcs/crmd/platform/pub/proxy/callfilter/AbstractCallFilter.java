package com.ffcs.crmd.platform.pub.proxy.callfilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public abstract class AbstractCallFilter implements ICallFilter {
    @Override
    public Map<String, String> getPropsMap() {
        Map<String,String> map = new HashMap<String,String>();

        Map<String,String> tmpMap = getAppPropsMap();
        if (tmpMap != null) {
            map.putAll(tmpMap);
        }

        return map;
    }

    @Override
    public void putPropsMap(Map<String, String> map) {
        putAppPropsMap(map);
    }

    public abstract Map<String, String> getAppPropsMap();

    public abstract void putAppPropsMap(Map<String, String> props);


}
