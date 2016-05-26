package com.ffcs.crmd.platform.pub.bean.lazyloader.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by linzhiqiang on 16/3/31.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MetaLoader {

    String busiObjNbr() default "";

    String attrNbr();

    String sourceField();
}
