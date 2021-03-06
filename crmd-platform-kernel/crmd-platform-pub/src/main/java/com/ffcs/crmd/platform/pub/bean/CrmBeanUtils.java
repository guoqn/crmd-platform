package com.ffcs.crmd.platform.pub.bean;

import java.util.ArrayList;
import java.util.List;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.bean.BeanUtils;
import com.ffcs.crmd.platform.pub.bean.lazyloader.LazyLoaderWrap;
import com.ffcs.crmd.platform.pub.bean.provider.BeanConvertProvider;
import com.ffcs.crmd.platform.pub.bean.provider.IBeanConvert;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;

public class CrmBeanUtils {

    private static final ILogger LOG = LoggerFactory.getLogger(CrmBeanUtils.class);

    /**
     * 复制列表
     *
     * @param sourceList
     * @param destClass
     * @return
     * @throws Exception
     */
    public static <T> List<T> copyList(List sourceList, Class<T> destClass) {
        if (sourceList == null || sourceList.size() <= 0) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        Class sourceClazz = sourceList.get(0).getClass();
        Class destClazz = destClass;
        IBeanConvert convert = BeanConvertProvider.getConvert(sourceClazz, destClazz);
        if (convert != null) {
            LOG.debug("use convert " + convert.getClass().getName());
            list = convert.copyList(sourceList, destClazz);
        } else {
            LOG.debug("use Default BeanUtil");
            try {
                list = BeanUtils.copyList(sourceList, destClass);
                int i = 0;
                for (Object dest : list) {
                    LazyLoaderWrap.wrap(sourceList.get(i), dest);
                    i++;
                }
            } catch (Exception e) {
                LOG.error("copy fail", e);
                //                throw new RtManagerException(e);
                ExceptionUtils.throwEx(e);
            }

        }
        return list;

    }

    /**
     * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
     *
     * @param dest
     *            目标对象，标准的JavaBean
     * @param orig
     *            源对象，可为Map、标准的JavaBean
     * @throws BusinessException
     */
    @SuppressWarnings("rawtypes")
    public static void applyIf(Object dest, Object orig) {
        applyIf(dest, orig, true);
    }

    /**
     * 拷贝对象
     * @param dest
     * @param orig
     * @param isOnlyCopyNotNull  是否只拷贝非空属性
     * @throws Exception
     */
    public static void applyIf(Object dest, Object orig, boolean isOnlyCopyNotNull) {
        Class sourceClazz = orig.getClass();
        Class destClazz = dest.getClass();
        IBeanConvert convert = BeanConvertProvider.getConvert(sourceClazz, destClazz);
        if (convert != null) {
            LOG.debug("use convert " + convert.getClass().getName());
            convert.applyIf(dest, orig, isOnlyCopyNotNull);
        } else {
            LOG.debug("use Default BeanUtil");
            try {
                BeanUtils.applyIf(dest, orig, isOnlyCopyNotNull);
                LazyLoaderWrap.wrap(orig, dest);
            } catch (Exception e) {
                LOG.error("copy fail", e);
                //                throw new RtManagerException(e);
                ExceptionUtils.throwEx(e);
            }
        }
    }
}
