package com.ffcs.crmd.platform.idempotency.core.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

import com.ffcs.crmd.platform.idempotency.core.annotation.Distributed;

public class AnnotationTest {
    
    @Distributed(index = 3)
    public void method(int arg1, String arg2) {
        
    }
    
    @Test
    public void test1() {
        Method[] methods = AnnotationTest.class.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Distributed.class) != null) {
                System.out.println(method.getAnnotation(Distributed.class).index());
            }
        }
    }
}
