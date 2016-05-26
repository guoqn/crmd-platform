package com.ffcs.crmd.platform.meta.entity.impl;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

/**
 * Created by linzq on 2016/1/20.
 */
public enum AttrOpType {
    ADD("add"), UPDATE("update"), DEL("del");

    private String op = "";

    AttrOpType(String op) {
        this.op = op;
    }

    public String op() {
        return op;
    }

    public static AttrOpType getOp(String op) {
        if ("add".equals(op)) {
            return ADD;
        } else if ("update".equals(op)) {
            return UPDATE;
        } else if ("del".equals(op)) {
            return DEL;
        } else {
            return null;
        }
    }

    public static AttrOpType getOp(String op, String oldOp) {
        //原来是修改-> 新增=修改
        if ("add".equals(op) && "update".equals(oldOp)) {
            return UPDATE;
        } else if ("add".equals(op) && "del".equals(oldOp)) {
            //删除->新增=修改
            return UPDATE;
        } else if ("add".equals(op) && "add".equals(oldOp)) {
            //新增->新增=新增
            return ADD;
        } else if ("add".equals(op) && StringUtils.isNullOrEmpty(oldOp)) {
            //null->新增=新增
            return ADD;
        } else if ("update".equals(op) && "del".equals(oldOp)) {
            //删除->修改=修改
            return UPDATE;
        } else if ("update".equals(op) && "update".equals(oldOp)) {
            //修改->修改=修改
            return UPDATE;
        } else if ("update".equals(op) && "add".equals(oldOp)) {
            //新增->修改=新增
            return ADD;
        } else if ("update".equals(op) && StringUtils.isNullOrEmpty(oldOp)) {
            //null->修改=修改
            return UPDATE;
        } else if ("del".equals(op) && "del".equals(oldOp)) {
            //删除->删除=删除
            return DEL;
        } else if ("del".equals(op) && "update".equals(oldOp)) {
            //修改->删除=删除
            return DEL;
        } else if ("del".equals(op) && "add".equals(oldOp)) {
            //新增->删除=删除
            return DEL;
        } else if ("del".equals(op) && StringUtils.isNullOrEmpty(oldOp)) {
            //null->删除=删除
            return DEL;
        } else {
            return null;
        }
    }
}
