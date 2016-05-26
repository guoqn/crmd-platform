package com.ffcs.crmd.platform.pub.interfaces.log;

/**
 * Created by linzhiqiang on 16/4/30.
 */
public enum LogLevel {
    OFF("off"), SYNC("sync"), ASYNC("async");
    private String level;

    LogLevel(String level) {
        this.level = level;
    }

    public String level() {
        return this.level;
    }

    public static LogLevel getLevel(String level) {
        if ("off".equals(level)) {
            return OFF;
        } else if ("sync".equals(level)) {
            return SYNC;
        } else if ("async".equals(level)) {
            return ASYNC;
        } else {
            return null;
        }
    }
}
