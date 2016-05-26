package com.ffcs.crmd.platform.meta.client;

import com.ffcs.crmd.platform.meta.client.meta.Cust;
import com.ffcs.crmd.platform.meta.entity.impl.CrmBaseMetaEntityImpl;
import com.ffcs.crmd.platform.meta.util.BeanPropUtils;

public class JsonTest {
    public static void main(String[] args) {
//        System.out.println(JSONUtils.toJsonString(new TestEntity()));
//        System.out.println(JSON.toJSONString(new TestEntity(), SerializerFeature.DisableCircularReferenceDetect,
//            SerializerFeature.PrettyFormat,SerializerFeature.SkipTransientField));
//        System.out.println(JSON.toJSONString(new TestEntity(), SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.PrettyFormat,SerializerFeature.UseSingleQuotes));
//        System.out.println(MetaProvider.PUBLIC_ATTRS);
//        System.out.println(MetaProvider.PUBLIC_COLUMNS);
        System.out.println(BeanPropUtils.isReadable(CrmBaseMetaEntityImpl.class,"statusCd"));
        System.out.println(BeanPropUtils.isWriteable(CrmBaseMetaEntityImpl.class,"statusCd"));
        System.out.println(Cust.class.getName() + Cust.class.getSimpleName());
    }
}
