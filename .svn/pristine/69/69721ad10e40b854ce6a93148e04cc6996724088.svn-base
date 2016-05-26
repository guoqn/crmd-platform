package com.ffcs.crmd.platform.pub.springext;

import com.ffcs.crmd.platform.pub.utils.rwbalance.RwBalanceUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.Collection;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/3.
 */
public class CrmRwBalanceJdbcTemplate extends JdbcTemplate {

    @Override
    public void execute(String sql) throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        super.execute(sql);
    }

    @Override
    public <T> T query(String sql, ResultSetExtractor<T> rse) throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.query(sql, rse);
    }

    @Override
    public int update(String sql) throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.update(sql);
    }

    @Override
    public int[] batchUpdate(String... sql) throws DataAccessException {
        String[] sqls = sql;
        String[] newSql = new String[sqls.length];
        int i = 0;
        for (String str : sqls) {
            newSql[i] = RwBalanceUtils.convertForceSql(str);
            i++;
        }
        return super.batchUpdate(newSql);
    }

    @Override
    public <T> T execute(String sql, PreparedStatementCallback<T> action)
        throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.execute(sql, action);
    }

    @Override
    public <T> T query(String sql, PreparedStatementSetter pss, ResultSetExtractor<T> rse)
        throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.query(sql, pss, rse);
    }

    @Override
    public int update(String sql, PreparedStatementSetter pss) throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.update(sql, pss);
    }

    @Override
    public int[] batchUpdate(String sql, BatchPreparedStatementSetter pss)
        throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.batchUpdate(sql, pss);
    }

    @Override
    public int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes)
        throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.batchUpdate(sql, batchArgs, argTypes);
    }

    @Override
    public <T> int[][] batchUpdate(String sql, Collection<T> batchArgs, int batchSize,
        ParameterizedPreparedStatementSetter<T> pss) throws DataAccessException {
        sql = RwBalanceUtils.convertForceSql(sql);
        return super.batchUpdate(sql, batchArgs, batchSize, pss);
    }

    @Override
    public <T> T execute(String callString, CallableStatementCallback<T> action)
        throws DataAccessException {
        callString = RwBalanceUtils.convertForceSql(callString);
        return super.execute(callString, action);
    }

}
