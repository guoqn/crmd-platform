package com.ffcs.crmd.platform.meta.util;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * 开关工具类
 * Created by qn_guo on 2016/1/6.
 */
public class SwitchUtil {

    public static final String PATH_SWITCH = "/switch";

    /**
     * 根据路径获取开关路径是否正确
     *
     * @param path
     * @return
     */
    public static boolean getSwitch(String path) {
        String sRoot = PATH_SWITCH + path;
        String nodeValue = SysConfigUtil.getNodeValue(sRoot);
        if (!StringUtils.isNullOrEmpty(nodeValue)) {
            return true;
        }
        return false;
    }

    /**
     * 根据开关路径清理开关缓存
     *
     * @param switchPath
     * @return
     */
    public static RetVo clearSwtichByPath(String switchPath) {
        SysConfigUtil.validatePath(switchPath);
        String sPath = PATH_SWITCH + switchPath;
        return SysConfigUtil.cleanCacheByNode(sPath);
    }

    /**
     * 清理当前路径下的所有子节点
     *
     * @param path
     * @return
     */
    public static RetVo clearChildByPath(String path) {
        SysConfigUtil.validatePath(path);
        String switchPath = PATH_SWITCH + path;
        return SysConfigUtil.clearChildByPath(switchPath);
    }

    /**
     * 清理所有开关缓存
     *
     * @return
     */
    public static RetVo clearAllSwtich() {
        return SysConfigUtil.clearChildByPath(PATH_SWITCH);
    }
}
