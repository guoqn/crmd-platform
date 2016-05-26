package com.ffcs.crmd.platform.pub.lazy;

import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ctg.itrdc.platform.common.utils.reflect.ReflectUtil;
import com.ffcs.crmd.platform.pub.bean.lazyloader.LoaderProvider;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by linzhiqiang on 16/4/1.
 */
public class TestLazy {

    @Test
    public void testLazy()
        throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println(LoaderProvider.getLoaderConfigs(CustDTO2.class));
    }
}
