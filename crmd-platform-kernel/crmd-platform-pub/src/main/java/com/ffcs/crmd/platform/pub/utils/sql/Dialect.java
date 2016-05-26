package com.ffcs.crmd.platform.pub.utils.sql;

/**
 * Created by linzhiqiang on 16/2/23.
 */
public enum Dialect {
    MYSQL("mysql"),ORACLE("oracle");

    private String dialect;

    Dialect(String dialect) {
        this.dialect = dialect;
    }

    public String dialect() {
        return this.dialect;
    }

    public static Dialect getDialect(String dialect) {
        if ("mysql".equals(dialect)) {
            return MYSQL;
        } else if ("oracle".equals(dialect)) {
            return ORACLE;
        } else {
            return null;
        }
    }

}
