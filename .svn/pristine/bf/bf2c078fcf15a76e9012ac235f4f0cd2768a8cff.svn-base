package com.ffcs.crmd.platform.pub.utils.rwbalance;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.utils.rwbalance.config.RwBalanceConfigureFactory;

/**
 * Created by linzhiqiang on 16/5/5.
 */
public class RwBalanceUtils {
    private static ILogger LOGGER = LoggerFactory.getLogger(RwBalanceUtils.class);

    private static boolean isOpen = false;

    private static final String FORCE_READ_HINT  = "/* !HINT({\"balance\":1})*/";
    private static final String FORCE_WRITE_HINT = "/* !HINT({\"balance\":0})*/";

    static {
        isOpen = RwBalanceConfigureFactory.getConfigure().isSwtichBalance();
    }

    public static void setIsRwBalanceOpen(boolean isOpen) {
        RwBalanceUtils.isOpen = isOpen;
    }

    public static String convertForceSql(String sql) {
        String newSql = sql;

        if (!isOpen) {
            return newSql;
        }
        if (CrmSessionContext.getContext().isOpenForceReadFlag()) {
            newSql = convertForceReadSql(sql);
        }
        return newSql;
    }

    public static String convertForceReadSql(String sql) {
        String newSql = sql;
        if (!isOpen) {
            return newSql;
        }
        //只有查询语句需要做此处理
        if (CrmStringUtils.trim(sql).toUpperCase().startsWith("SELECT")) {
            newSql = FORCE_READ_HINT + sql;
        }
        return newSql;
    }

    public static String convertForceWriteSql(String sql) {
        String newSql = sql;
        if (!isOpen) {
            return newSql;
        }
        //只有查询语句需要做此处理
        if (CrmStringUtils.trim(sql).toUpperCase().startsWith("SELECT")) {
            newSql = FORCE_WRITE_HINT + sql;
        }
        return newSql;
    }

    public static boolean isForceReadUrl(String url) {
        if (!isOpen) {
            return false;
        }
        return RwBalanceConfigureFactory.getConfigure().isForceRead(url);
    }

    public static boolean isForceWriteUrl(String url) {
        if (!isOpen) {
            return false;
        }
        return RwBalanceConfigureFactory.getConfigure().isForceWrite(url);
    }

    public static boolean isOpen() {
        return isOpen;
    }
}
