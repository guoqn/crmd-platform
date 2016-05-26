package com.ffcs.crmd.platform.meta.daaction.impl;

/**
 * Created by linzhiqiang on 16/2/24.
 */
public enum ActionType {

    SAVE("save"),UPDATE("update"),DELETE("delete");

    private String actionName;

    ActionType(String action) {
        this.actionName = action;
    }

    public String action() {
        return actionName;
    }
}
