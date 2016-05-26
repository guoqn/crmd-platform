package com.ffcs.crmd.platform.meta.util;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 获取节点值 返回数组工具类
 * Created by qn_guo on 2016/1/6.
 */
public class SamplingUtil {
    public static final String PATH_SAMPLING = "/sampling";

    /**
     * 将nodeValue 根据 ","分割
     *
     * @param path
     * @return int[]
     */
    public static int[] getArrayNodeValue(String path) {
        int array[] = new int[0];
        String nodeValue = SysConfigUtil.getNodeValue(path);
        if (!StringUtils.isNullOrEmpty(nodeValue)) {
            String[] splitAddress = nodeValue.split(",");
            array = new int[splitAddress.length];
            for (int i = 0; i < splitAddress.length; i++) {
                array[i] = Integer.parseInt(splitAddress[i]);
            }
        }
        return array;
    }

    /**
     * 根据路径清除抽样缓存
     *
     * @param samplingPath
     * @return
     */
    public static RetVo clearSamplingByPath(String path) {
    	SysConfigUtil.validatePath(path);
        String saPath = PATH_SAMPLING + path;
        return SysConfigUtil.cleanCacheByNode(saPath);
    }

    /**
     * 清理所有抽样路径下的子节点缓存
     *
     * @param path
     * @return
     */
    public static RetVo clearChildSamplingByPath(String path) {
    	SysConfigUtil.validatePath(path);
        String samplingPath = PATH_SAMPLING + path;
        return SysConfigUtil.clearChildByPath(samplingPath);
    }

    /**
     * 清理所有抽样缓存
     *
     * @return
     */
    public static RetVo clearAllSampling() {
        return SysConfigUtil.clearChildByPath(PATH_SAMPLING);
    }
}
