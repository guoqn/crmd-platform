package com.ffcs.crmd.platform.meta.provider;

import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;

import java.util.List;

/**
 * Created by linzq on 2016/1/25.
 */
public interface IOpMetaInfo {

    public String getSql();

    public void setSql(String sql);

    public List<String> getAttrs();

    public void setAttrs(List<String> attrs);

    public IBusiObjAttr getPkAttr();

    public void setPkAttr(IBusiObjAttr pkAttr);

    public List<Object> buildParamsList(IMetaEntity entity,List<String> attrs);
}
