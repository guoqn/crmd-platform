package com.ffcs.crmd.platform.pub.bean.lazyloader;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Method;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public class MetaLoaderConfig extends AbstractLoaderConfig {

    private String busiObjNbr;

    private String attrNbr;

    private String sourceField;

    public String getBusiObjNbr() {
        return busiObjNbr;
    }

    public void setBusiObjNbr(String busiObjNbr) {
        this.busiObjNbr = busiObjNbr;
    }

    public String getAttrNbr() {
        return attrNbr;
    }

    public void setAttrNbr(String attrNbr) {
        this.attrNbr = attrNbr;
    }

    public String getSourceField() {
        return sourceField;
    }

    public void setSourceField(String sourceField) {
        this.sourceField = sourceField;
    }

    @Override
    public Object getPropFromSrc(Object srcObj, Object destObj) {
        if (ApplicationContextUtil.containsBean("metaLoaderService")) {
            IMetaLoaderService loaderService = ApplicationContextUtil.getBean("metaLoaderService");
            try {
                String attrValueName = "";
                if (!StringUtils.isNullOrEmpty(getBusiObjNbr())) {
                    attrValueName = loaderService
                        .getAttrValueNameByObjNbr(getBusiObjNbr(), getAttrNbr(),
                            PropertyUtils.getNestedProperty(srcObj, getSourceField()));
                } else {
                    attrValueName = loaderService.getAttrValueNameByObj(srcObj, getAttrNbr(),
                        PropertyUtils.getNestedProperty(srcObj, getSourceField()));
                }
                return attrValueName;
            } catch (Exception e) {
                logger.error("could not get props,sourceField:{}", getSourceField());
                ExceptionUtils.throwEx(e);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MetaLoaderConfig{" +
            "busiObjNbr='" + busiObjNbr + '\'' +
            ", attrNbr='" + attrNbr + '\'' +
            ", sourceField='" + sourceField + '\'' +
            '}';
    }
}
