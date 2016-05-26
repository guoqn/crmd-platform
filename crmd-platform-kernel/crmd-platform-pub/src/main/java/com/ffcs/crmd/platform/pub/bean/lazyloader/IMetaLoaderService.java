package com.ffcs.crmd.platform.pub.bean.lazyloader;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public interface IMetaLoaderService {

    public String getAttrValueNameByObj(Object obj,String attrNbr,Object value);

    public String getAttrValueNameByObjNbr(String busiObjNbr,String attrNbr,Object value);

}
