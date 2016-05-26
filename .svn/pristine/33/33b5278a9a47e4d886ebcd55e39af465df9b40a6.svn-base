package com.ffcs.crmd.platform.meta.provider;

import com.ffcs.crmd.platform.meta.intf.IBusiObjAttr;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzq on 2016/1/15.
 */
public class OpMetaInfo implements IOpMetaInfo {
    private String sql = "";

    private List<String> attrs = new ArrayList<String>();

    private IBusiObjAttr pkAttr;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<String> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<String> attrs) {
        this.attrs = attrs;
    }

    public IBusiObjAttr getPkAttr() {
        return pkAttr;
    }

    public void setPkAttr(IBusiObjAttr pkAttr) {
        this.pkAttr = pkAttr;
    }

    public List<Object> buildParamsList(IMetaEntity entity,List<String> attrs) {
        List<Object> params = new ArrayList<Object>();
        for (String attrNbr : attrs) {
            params.add(entity.readAttr(attrNbr));
        }
        return params;
    }
}
