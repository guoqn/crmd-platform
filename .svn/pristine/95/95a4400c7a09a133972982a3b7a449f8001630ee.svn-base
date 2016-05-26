package com.ffcs.crmd.platform.pub.bean.lazyloader;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;

import java.util.List;

/**
 * Created by linzhiqiang on 16/4/1.
 */
public class LazyLoaderWrap {

    private static final ILogger LOGGER = LoggerFactory.getLogger(LazyLoaderWrap.class);

    public static void wrap(Object srcObj, Object destObj) {
        List<AbstractLoaderConfig> loaderConfigList = LoaderProvider
            .getLoaderConfigs(destObj.getClass());
        LOGGER.debug("wrap deal.configList:" + loaderConfigList);
        if (loaderConfigList != null && !loaderConfigList.isEmpty()) {
            for (AbstractLoaderConfig config : loaderConfigList) {
                config.fillProps(srcObj, destObj);
            }
        }
    }
}
