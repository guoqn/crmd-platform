package com.ffcs.crmd.platform.pub.interfaces.thread;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public enum ThreadLevel {

    SINGLE("single"),SHARED("shared"),DIRECT("direct");

    private String level;

    ThreadLevel(String level) {
        this.level = level;
    }

    public String level() {
        return this.level;
    }

    public static ThreadLevel getLevel(String level) {
        if ("single".equals(level)) {
            return SINGLE;
        } else if ("shared".equals(level)) {
            return SHARED;
        } else if ("direct".equals(level)) {
            return DIRECT;
        } else {
            return null;
        }
    }
}
