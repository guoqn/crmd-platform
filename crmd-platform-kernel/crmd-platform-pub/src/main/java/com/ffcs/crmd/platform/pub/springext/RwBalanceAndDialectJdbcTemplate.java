package com.ffcs.crmd.platform.pub.springext;

import com.ffcs.crmd.platform.pub.utils.sql.translater.SqlTranslaterUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.Collection;
import java.util.List;

/**
 * Created by linzhiqiang on 16/5/5.
 */
public class RwBalanceAndDialectJdbcTemplate extends CrmRwBalanceJdbcTemplate {

    @Override
    public void execute(String sql) throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        super.execute(sql);
    }

    @Override
    public <T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.query(sql, rse);
    }

    @Override
    public int update(String sql) throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.update(sql);
    }

    @Override
    public int[] batchUpdate(String... sql) throws DataAccessException {
        String[] sqls = sql;
        String[] newSql = new String[sqls.length];
        int i = 0;
        for (String str : sqls) {
            newSql[i] = SqlTranslaterUtil.translateSql(str);
            i++;
        }
        return super.batchUpdate(sql);
    }

    @Override
    public <T> T execute(String sql, PreparedStatementCallback<T> action)
        throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.execute(sql, action);
    }

    @Override
    public <T> T query(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse)
        throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.query(sql, pss, rse);
    }

    @Override
    public int update(String sql, PreparedStatementSetter pss) throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.update(sql, pss);
    }

    @Override
    public int[] batchUpdate(String sql, BatchPreparedStatementSetter pss)
        throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.batchUpdate(sql, pss);
    }

    @Override
    public int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes)
        throws DataAccessException {
        sql = SqlTranslaterUtil.translateSql(sql);

        return super.batchUpdate(sql, batchArgs, argTypes);
    }

    @Override
    public <T> int[][] batchUpdate(String sql, Collection<T> batchArgs, int batchSize,
        ParameterizedPreparedStatementSetter<T> pss) throws DataAccessException {
        return super.batchUpdate(sql, batchArgs, batchSize, pss);
    }

    @Override
    public <T> T execute(String callString, CallableStatementCallback<T> action)
        throws DataAccessException {
        callString = SqlTranslaterUtil.translateSql(callString);
        return super.execute(callString, action);
    }
}
