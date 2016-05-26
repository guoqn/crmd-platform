package com.ffcs.crmd.platform.pub.bean.provider;

import java.util.List;

public interface IBeanConvert {
    public Class<?> getSourceClass();
    
    public Class<?> getDestClass();
    
    public <T> List<T> copyList(List sourceList, Class<T> destClazz);
    
    public <T> List<T> copyList(List sourceList, Class<T> destClazz, boolean isOnlyCopyNotNull);
    
    public Object applyIf(Object dest, Object source);
    
    public Object applyIf(Object dest, Object source, boolean isOnlyCopyNotNull);
    
}
