package com.ffcs.crmd.platform.pub.utils.sql;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.file.PropertiesUtil;
import com.ffcs.crmd.platform.base.utils.CrmPropertiesUtil;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.utils.sql.translater.SqlTranslaterUtil;

/**
 * Created by linzhiqiang on 16/2/23.
 */
public class DialectUtils {

    private static final ILogger LOG                     = LoggerFactory
        .getLogger(DialectUtils.class);
    public static final  String  DIALECT_PROPERTIES_FILE = "dialect.properties";

    public static final String DIALECT_KEY = "dialect";

    public static final String SOURCE_DIALECT_KEY = "source_dialect";

    private static Runnable CLEAR_THREAD = new Runnable() {
        @Override
        public void run() {
            //先休眠4s,保证方言切换完成,所有的sql都使用新的方言转换
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                //不做处理
            }
            SqlTranslaterUtil.clearAllMap();
        }
    };

    private static Dialect dialect;

    private static Dialect sourceDialect;

    static {
        Dialect defaultDialect = null;
        try {
            String dialectProperties = CrmPropertiesUtil
                .getConfigValueCache(DIALECT_PROPERTIES_FILE, DIALECT_KEY);
            defaultDialect = Dialect.getDialect(dialectProperties);
        } catch (Exception e) {
            LOG.warn("getDialectError",e);
        }
        if (defaultDialect == null) {
            defaultDialect = Dialect.MYSQL;
        }
        dialect = defaultDialect;

        Dialect sourceDefaultDialect = null;
        try {
            String sourceDialectProperties = CrmPropertiesUtil
                .getConfigValueCache(DIALECT_PROPERTIES_FILE, SOURCE_DIALECT_KEY);
            defaultDialect = Dialect.getDialect(sourceDialectProperties);
        } catch (Exception e) {
            LOG.warn("getDialectError",e);
        }
        if (sourceDefaultDialect == null) {
            sourceDefaultDialect = Dialect.MYSQL;
        }
        sourceDialect = sourceDefaultDialect;
    }

    public static void setDialect(String dialect) {
        Dialect eDa = Dialect.getDialect(dialect);
        setDialect(eDa);
    }

    public static void setDialect(Dialect dialect) {
        if (dialect == null) {
            ExceptionUtils.throwEx(new RtManagerException("dialect could not null"));
        }
        DialectUtils.dialect = dialect;
        new Thread(CLEAR_THREAD).start();
    }

    public static Dialect getDialect() {
        return dialect;
    }

    public static Dialect getSourceDialect() {
        return sourceDialect;
    }

    public static void setSourceDialect(Dialect sourceDialect) {
        if (sourceDialect == null) {
            ExceptionUtils.throwEx(new RtManagerException("sourceDialect could not null"));
        }
        DialectUtils.sourceDialect = sourceDialect;
    }

}
