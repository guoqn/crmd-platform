package com.ffcs.crmd.platform.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.data.entity.CRUDOperation;
import com.ctg.itrdc.platform.data.entity.ClassInfoUtils;
import com.ctg.itrdc.platform.data.entity.EntityInfo;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.data.cache.ICrmCacheEntityService;
import com.ffcs.crmd.platform.pub.utils.sql.translater.PageSqlEntity;
import com.ffcs.crmd.platform.pub.utils.sql.translater.SqlTranslaterUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.data.dao.impl.BaseDaoImpl;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegister;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegisterFactory;
import com.ffcs.crmd.platform.data.dao.ICrmBaseCacheDao;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.data.sqlext.impl.CrmSqlRegister;
import com.ffcs.crmd.platform.idempotency.api.factory.IdempotencyDataServiceFactory;
import com.ffcs.crmd.platform.idempotency.api.service.IIdempotencyDataService;
import com.ffcs.crmd.platform.meta.daaction.DaActionSupport;
import com.ffcs.crmd.platform.meta.exception.MetaException;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.IExampleQuery;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

@Service("crmBaseDao")
public class CrmBaseDaoImpl extends BaseDaoImpl implements ICrmBaseCacheDao, ICrmBaseDao {

    protected ILogger log = LoggerFactory.getLogger(CrmBaseDaoImpl.class);

    protected SqlRegister sqlRegister = SqlRegisterFactory.getSqlRegister();

    private IIdempotencyDataService dataService = IdempotencyDataServiceFactory
        .getIdempotencyDataService();

    private ICrmCacheEntityService crmCacheEntityService = ApplicationContextUtil
        .getBean("crmCacheEnttService");

    public CrmBaseDaoImpl() {
    }

    /**
     * 向仓库注册SQL语句。
     *
     * @param sqlName
     *            SQL语句名称
     * @param sql
     *            SQL语句
     */
    protected void registerSql(String sqlName, String sql) {
        sqlRegister.registerSql(sqlName, sql);
    }

    protected String getSqlByName(String sqlName) {
        String hql = sqlRegister.getSql(sqlName);
        if (hql == null) {
            throw new RtManagerException("无法根据名称：@sqlName，查找sql定义", this.getClass(), "getSqlByName",
                "sqlNull", "@sqlName", sqlName);
        }
        return hql;
    }

    @Override
    public int jdbcQueryForIntByName(String name, Object... args) {
        String sql = this.getSqlByName(name);
        return jdbcQueryForInt(sql, args);
    }

    @Override
    public int jdbcQueryForIntByName(String name, Object[] args, int[] argTypes) {
        String sql = this.getSqlByName(name);
        return jdbcQueryForInt(sql, args, argTypes);
    }

    @Override
    public int jdbcQueryForIntByName(String name) {
        String sql = this.getSqlByName(name);
        return jdbcQueryForInt(sql);
    }

    @Override
    public <E> List<E> jdbcFindListByName(String name, Class<E> elementType) {
        String sql = this.getSqlByName(name);
        return jdbcFindList(sql, elementType, new ArrayList<Object>());
    }

    @Override
    public <E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params) {
        String sql = this.getSqlByName(name);
        return jdbcFindList(sql, elementType, params);
    }

    @Override
    public int jdbcGetSizeByName(String name, List<Object> params) {
        String sql = this.getSqlByName(name);
        return jdbcGetSize(sql, params);
    }

    @Override
    public <E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, int currentPage,
        int perPageNum) {
        String sql = this.getSqlByName(name);
        return jdbcFindPageInfo(sql, elementType, new ArrayList<Object>(), currentPage, perPageNum);
    }

    @Override
    public <E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType,
        List<Object> params, int currentPage, int perPageNum) {
        String sql = this.getSqlByName(name);
        return jdbcFindPageInfo(sql, elementType, params, currentPage, perPageNum);
    }

    @Override
    public long jdbcQueryForLongByName(String name, Object... args) {
        String sql = this.getSqlByName(name);
        return jdbcQueryForLong(sql, args);
    }

    @Override
    public long jdbcQueryForLongByName(String name, Object[] args, int[] argTypes) {
        String sql = this.getSqlByName(name);
        return jdbcQueryForLong(sql, args, argTypes);
    }

    @Override
    public long jdbcQueryForLongByName(String name) {
        String sql = this.getSqlByName(name);
        return jdbcQueryForLong(sql);
    }

    @Override
    public <E> List<E> jdbcFindListByName(String name, Class<E> elementType, boolean isCache) {
        String sql = this.getSqlByName(name);
        return jdbcFindList(sql, elementType, new ArrayList<Object>(), isCache);
    }

    @Override
    public <E> List<E> jdbcFindListByName(String name, Class<E> elementType, List<Object> params,
        boolean isCache) {
        String sql = this.getSqlByName(name);
        return jdbcFindList(sql, elementType, params, isCache);
    }

    @Override
    public <E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType, int currentPage,
        int perPageNum, boolean isCache) {
        String sql = this.getSqlByName(name);
        return jdbcFindPageInfo(sql, elementType, new ArrayList<Object>(), currentPage, perPageNum,
            isCache);
    }

    @Override
    public <E> PageInfo jdbcFindPageInfoByName(String name, Class<E> elementType,
        List<Object> params, int currentPage, int perPageNum, boolean isCache) {
        String sql = this.getSqlByName(name);
        return jdbcFindPageInfo(sql, elementType, params, currentPage, perPageNum, isCache);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public <T extends BaseEntity> int insert(T entity) {
        // 正在执行分布式事务
        if (dataService.isSysWorkRunning()) {
            return dataService.insert(entity);
        } else {
            RetVo vo = DaActionSupport.doSaveAction(entity);
            return NumberUtils.nullToIntegerZero(vo.getObject());
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public <T extends BaseEntity> int updateByPrimaryKey(T entity) {
        // 正在执行分布式事务
        if (dataService.isSysWorkRunning()) {
            return dataService.updateByPrimaryKey(entity);
        } else {
            RetVo vo = DaActionSupport.doUpdateAction(entity);
            return NumberUtils.nullToIntegerZero(vo.getObject());
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public <T extends BaseEntity> int deleteByPrimaryKey(T entity) {
        // 正在执行分布式事务
        if (dataService.isSysWorkRunning()) {
            return dataService.deleteByPrimaryKey(entity);
        } else {
            RetVo vo = DaActionSupport.doDeleteAction(entity);
            return NumberUtils.nullToIntegerZero(vo.getObject());
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public <T extends BaseEntity> int updateSelectiveByPrimaryKey(T entity) {
        // 正在执行分布式事务
        if (dataService.isSysWorkRunning()) {
            return dataService.updateSelectiveByPrimaryKey(entity);
        } else {
            String sql = ClassInfoUtils.getUpdateSelectiveByPrimaryKeySql(entity);

            Object[] selectiveColumnsValueArrayExcludeIdAndShardingId = ClassInfoUtils
                .getSelectiveColumnsValueArrayExcludeIdAndShardingId(entity);
            Object[] idAndShardingIdColumnsValueArray = ClassInfoUtils
                .getIdAndShardingIdColumnValueArray(entity,
                    CRUDOperation.UPDATE_SELECTIVE_BY_PRIMARY_KEY.getName());
            Object[] columnsValueArray = new Object[
                selectiveColumnsValueArrayExcludeIdAndShardingId.length
                    + idAndShardingIdColumnsValueArray.length];

            System.arraycopy(selectiveColumnsValueArrayExcludeIdAndShardingId, 0, columnsValueArray,
                0, selectiveColumnsValueArrayExcludeIdAndShardingId.length);
            System.arraycopy(idAndShardingIdColumnsValueArray, 0, columnsValueArray,
                selectiveColumnsValueArrayExcludeIdAndShardingId.length,
                idAndShardingIdColumnsValueArray.length);

            int i = 0;
            //shardingId不能update，必须由业务系统开发人员先删除后再插入
            //update语句中没有shardingId字段
            log.debug(sql);
            i = getJdbcTemplate().update(sql, columnsValueArray);
            crmCacheEntityService
                .removeObject(entity.getId(), entity.getClass());// 是否缓存处理由该方法里面自己处理
            return i;
        }
    }

    @Override
    public <E> List<E> queryListByName(String name, Class<E> elementType,
        Map<String, Object> params) {
        if (sqlRegister instanceof CrmSqlRegister) {
            // CrmSqlRegister 才支持
            Object[] obj = ((CrmSqlRegister) sqlRegister).getSql(name, params);
            if (obj != null && obj.length == 2) {
                return this.jdbcFindList(obj[0].toString(), elementType, (List<Object>) obj[1]);
            }
        }
        return null;
    }

    @Override
    public <E> PageInfo<E> queryPageInfoByName(String name, Class<E> elementType,
        Map<String, Object> params, int page, int pageSize) {
        if (sqlRegister instanceof CrmSqlRegister) {
            // CrmSqlRegister 才支持
            Object[] obj = ((CrmSqlRegister) sqlRegister).getSql(name, params);
            if (obj != null && obj.length == 2) {
                return this
                    .jdbcFindPageInfo(obj[0].toString(), elementType, (List<Object>) obj[1], page,
                        pageSize);
            }
        }
        return null;
    }

    @Override
    public <E> List<E> queryListByName(String name, Class<E> elementType,
        Map<String, Object> params, boolean isCache) {
        if (sqlRegister instanceof CrmSqlRegister) {
            // CrmSqlRegister 才支持
            Object[] obj = ((CrmSqlRegister) sqlRegister).getSql(name, params);
            if (obj != null && obj.length == 2) {
                return this
                    .jdbcFindList(obj[0].toString(), elementType, (List<Object>) obj[1], isCache);
            }
        }
        return null;
    }

    @Override
    public <E> PageInfo<E> queryPageInfoByName(String name, Class<E> elementType,
        Map<String, Object> params, int page, int pageSize, boolean isCache) {
        if (sqlRegister instanceof CrmSqlRegister) {
            // CrmSqlRegister 才支持
            Object[] obj = ((CrmSqlRegister) sqlRegister).getSql(name, params);
            if (obj != null && obj.length == 2) {
                return this
                    .jdbcFindPageInfo(obj[0].toString(), elementType, (List<Object>) obj[1], page,
                        pageSize, isCache);
            }
        }
        return null;
    }

    @Override
    public int queryForIntByName(String name, Map<String, Object> params) {
        if (sqlRegister instanceof CrmSqlRegister) {
            // CrmSqlRegister 才支持
            Object[] obj = ((CrmSqlRegister) sqlRegister).getSql(name, params);
            if (obj != null && obj.length == 2) {
                List<Object> pList = (List<Object>) obj[1];
                Object[] array = null;
                if (pList != null && pList.size() > 0) {
                    array = new Object[pList.size()];
                    pList.toArray(array);
                }
                return this.jdbcQueryForInt(obj[0].toString(), array);
            }
        }
        return 0;
    }

    @Override
    public long queryForLongByName(String name, Map<String, Object> params) {
        if (sqlRegister instanceof CrmSqlRegister) {
            // CrmSqlRegister 才支持
            Object[] obj = ((CrmSqlRegister) sqlRegister).getSql(name, params);
            if (obj != null && obj.length == 2) {
                List<Object> pList = (List<Object>) obj[1];
                Object[] array = null;
                if (pList != null && pList.size() > 0) {
                    array = new Object[pList.size()];
                    pList.toArray(array);
                }
                return this.jdbcQueryForLong(obj[0].toString(), array);
            }
        }
        return 0L;
    }

    @Override
    public <T extends BaseEntity> void jdbcBatchInsert(List<T> entitys) {
        ExceptionUtils.throwEx("not support this method");
        // super.jdbcBatchInsert(entitys);
    }

    @Override
    public <T extends BaseEntity> int[] jdbcBatchUpdateByPrimaryKey(List<T> entitys) {
        ExceptionUtils.throwEx("not support this method");
        return null;
        // return super.jdbcBatchUpdateByPrimaryKey(entitys);
    }

    @Override
    public <T extends BaseEntity> void jdbcBatchDeleteByPrimary(List<T> entitys) {
        ExceptionUtils.throwEx("not support this method");
        // super.jdbcBatchDeleteByPrimary(entitys);
    }

    @Override
    public <T extends BaseEntity> T selectByPrimaryKey(T entity, boolean isCache) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            T t = null;
            if (isCache) {
                t = (T) crmCacheEntityService.getObject(entity.getId(), entity.getClass());
                if (t != null) {
                    return t;
                }
            }
            ITableMetaData tableMetaData = ((IMetaEntity) entity).readTableMeta();
            if (tableMetaData == null) {
                ExceptionUtils.throwEx(new MetaException("table Meta is not exists"));
            }
            IExampleQuery query = tableMetaData.getExampleQuery((IMetaEntity) entity);
            String sql = query.getSql();
            Object[] idAndShardingIdColumnsValueArray = query.getParams().toArray();
            log.debug(sql);
            // t = (T) jdbcTemplate.queryForObject(sql,
            // idAndShardingIdColumnsValueArray,
            // BeanPropertyRowMapper.newInstance(entity.getClass()));
            List<T> list = (List<T>) getJdbcTemplate().query(sql, idAndShardingIdColumnsValueArray,
                BeanPropertyRowMapper.newInstance(entity.getClass()));
            if (list == null || list.size() <= 0) {
                log.warn("query:{},args:{},expected {}, actual {}", sql,
                    idAndShardingIdColumnsValueArray, 1, 0);
            } else if (list.size() >= 1) {
                if (list.size() > 1) {
                    log.warn("query:{},args:{},expected {}, actual {}", sql,
                        idAndShardingIdColumnsValueArray, 1, list.size());
                }
                t = list.get(0);
            }

            if (isCache && t != null) {
                crmCacheEntityService.putObject(t.getId(), t);
            }
            return t;
        } else {
            try {
                T t = null;
                if (isCache) {
                    t = (T) crmCacheEntityService.getObject(entity.getId(), entity.getClass());
                    if (t != null) {
                        return t;
                    }
                }
                EntityInfo entityInfo = ClassInfoUtils.getEntityMap().get(entity.getClass());
                String sql = entityInfo.getSelectByPrimaryKeySql();
                Object[] idAndShardingIdColumnsValueArray = ClassInfoUtils
                    .getIdAndShardingIdColumnValueArray(entity,
                        CRUDOperation.SELECT_BY_PRIMARY_KEY.getName());
                log.debug(sql);
                //            t = (T) jdbcTemplate.queryForObject(sql, idAndShardingIdColumnsValueArray, BeanPropertyRowMapper.newInstance(entity.getClass()));
                List<T> list = (List<T>) getJdbcTemplate()
                    .query(sql, idAndShardingIdColumnsValueArray,
                        BeanPropertyRowMapper.newInstance(entity.getClass()));
                if (list == null || list.size() <= 0) {
                    log.warn("query:{},args:{},expected {}, actual {}", sql,
                        idAndShardingIdColumnsValueArray, 1, 0);
                } else if (list.size() >= 1) {
                    if (list.size() > 1) {
                        log.warn("query:{},args:{},expected {}, actual {}", sql,
                            idAndShardingIdColumnsValueArray, 1, list.size());
                    }
                    t = list.get(0);
                }

                if (isCache && t != null) {
                    crmCacheEntityService.putObject(t.getId(), t);
                }
                return t;
            } catch (EmptyResultDataAccessException e) {
                log.error(e.getMessage(), e);
                return null;
            }
        }

    }

    @Override
    public <T extends BaseEntity> List<T> selectByExample(T entity, boolean isCache) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            ITableMetaData tableMetaData = ((IMetaEntity) entity).readTableMeta();
            if (tableMetaData == null) {
                ExceptionUtils.throwEx(new MetaException("table Meta is not exists"));
            }
            IExampleQuery query = tableMetaData.getExampleQuery((IMetaEntity) entity);
            String sql = query.getSql();
            Object[] params = query.getParams().toArray();
            log.debug(sql);
            List<T> list = null;
            if (isCache) {
                list = (List<T>) crmCacheEntityService
                    .getObjectList(entity.getClass(), sql, Arrays.asList(params), this);
            }
            if (list == null) {
                list = (List<T>) getJdbcTemplate()
                    .query(sql, params, BeanPropertyRowMapper.newInstance(entity.getClass()));
                if (isCache) {
                    crmCacheEntityService
                        .putObjectList(entity.getClass(), sql, Arrays.asList(params), list);
                }
            }
            return list;
        } else {
            String sql = ClassInfoUtils.getSelectByExampleSql(entity);
            Object[] columnsValue = ClassInfoUtils.getSelectiveColumnsValueArray(entity);

            log.debug(sql);
            try {
                List<T> list = null;
                if (isCache) {
                    list = (List<T>) crmCacheEntityService
                        .getObjectList(entity.getClass(), sql, Arrays.asList(columnsValue), this);
                }
                if (list == null) {
                    list = (List<T>) getJdbcTemplate().query(sql, columnsValue,
                        BeanPropertyRowMapper.newInstance(entity.getClass()));
                }
                if (isCache) {
                    crmCacheEntityService
                        .putObjectList(entity.getClass(), sql, Arrays.asList(columnsValue), list);
                }
                return list;
            } catch (EmptyResultDataAccessException e) {
                //			e.printStackTrace();
                log.error(e.getMessage(), e);
                return null;
            }
        }
    }

    @Override
    public <T extends BaseEntity> T jdbcSelectFirstRow(T entity, boolean isCache) {
        if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
            ITableMetaData tableMetaData = ((IMetaEntity) entity).readTableMeta();
            if (tableMetaData == null) {
                ExceptionUtils.throwEx(new MetaException("table Meta is not exists"));
            }
            IExampleQuery query = tableMetaData.getExampleQuery((IMetaEntity) entity);
            String sql = query.getSql();
            List<Object> params = query.getParams();
            log.debug(sql);
            List<T> rs = null;
            if (isCache) {
                rs = (List<T>) crmCacheEntityService
                    .getObjectList(entity.getClass(), sql, params, this);
            }
            if (rs == null) {
                rs = (List<T>) getJdbcTemplate().query(sql, params.toArray(),
                    BeanPropertyRowMapper.newInstance(entity.getClass()));
                if (isCache) {
                    crmCacheEntityService.putObjectList(entity.getClass(), sql, params, rs);
                }
            }
            if (rs != null && rs.size() > 0) {
                return rs.get(0);
            }
            return null;
        } else {
            String sql = ClassInfoUtils.getSelectByExampleSql(entity);
            Object[] columnsValue = ClassInfoUtils.getSelectiveColumnsValueArray(entity);
            List<T> rs = null;
            if (isCache) {
                rs = (List<T>) crmCacheEntityService
                    .getObjectList(entity.getClass(), sql, Arrays.asList(columnsValue), this);
            }
            if (rs == null) {
                rs = (List<T>) getJdbcTemplate()
                    .query(sql, columnsValue, BeanPropertyRowMapper.newInstance(entity.getClass()));
                if (isCache) {
                    crmCacheEntityService
                        .putObjectList(entity.getClass(), sql, Arrays.asList(columnsValue), rs);
                }
            }
            if (rs != null && rs.size() > 0) {
                return rs.get(0);
            }
            return null;
        }
    }

    @Override
    public <T> PageInfo<T> jdbcFindPageInfo(String sql, Class<T> elementType, List<Object> params,
        int currentPage, int perPageNum, boolean isCache) {
        int pageSize = perPageNum;
        int page = currentPage;
        if (pageSize == 0) {
            pageSize = PageInfo.DEFAULT_PAGE_SIZE;
        }
        if (currentPage == 0) {
            page = 1;
        }
        int first = (page - 1) * pageSize;

        //        Object[] array = null;
        //        // 构建分页
        //        String pageSql = PARSE.getPageSql(sql);
        //        List<Object> pageParams = null;
        //        if (params != null) {
        //            pageParams = new ArrayList<Object>(params);
        //        } else {
        //            pageParams = new ArrayList<Object>();
        //        }
        //        pageParams.addAll(PARSE.getPageParam(page, pageSize));
        //        if (pageParams != null) {
        //            array = new Object[pageParams.size()];
        //            pageParams.toArray(array);
        //        }
        //
        //        List<Object> paramArray = new ArrayList<Object>();
        //        for (Object pa : array) {
        //            paramArray.add(pa);
        //        }
        //        String pageSql = PagerUtils.limit(sql, DialectUtils.getDialect().dialect(),first,pageSize);

        PageSqlEntity pageSqlEntity = SqlTranslaterUtil.getPageSql(sql, first, pageSize);

        if (pageSqlEntity.getPageParams().length > 0) {
            for (Object obj : pageSqlEntity.getPageParams()) {
                params.add(obj);
            }
        }

        List<T> list = this.jdbcFindList(pageSqlEntity.getPageSql(), elementType, params, isCache);

        // 查询总量
        final int totalCounts = this.jdbcGetSize(sql, params);
        int totalPages = totalCounts / pageSize;
        if ((totalCounts % pageSize) > 0) {
            totalPages += 1;
        }

        final PageInfo<T> pageInfo = new PageInfo<T>(list);
        pageInfo.setTotal(totalCounts);
        pageInfo.setPages(totalPages);
        pageInfo.setNavigatePages(totalPages);
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(pageSize);
        // 由于结果是>startRow的，所以实际的需要+1
        if (list.size() == 0) {
            pageInfo.setStartRow(0);
            pageInfo.setEndRow(0);
        } else {
            pageInfo.setStartRow(first + 1);
            pageInfo.setEndRow(first + list.size());
        }
        pageInfo.setList(list);
        pageInfo.calcAndJudge();

        return pageInfo;
    }

    @Override
    public int jdbcGetSize(String sql, List<Object> params) {
        final String totalCountSql = SqlTranslaterUtil.getCountSql(sql);

        Object[] array = null;
        if (params != null) {
            array = new Object[params.size()];
            params.toArray(array);
        }
        return this.jdbcQueryForInt(totalCountSql, array);
    }

    @Override
    public <T> List<T> jdbcFindList(String sql, Class<T> elementType, List<Object> params,
        boolean isCache) {
        Object[] array = null;
        if (params != null) {
            array = new Object[params.size()];
            params.toArray(array);
        }

        List<T> rs = null;
        if (isCache) {
            rs = (List<T>) crmCacheEntityService.getObjectList(elementType, sql, params, this);
        }
        if (rs == null) {
            rs = (List<T>) this.getJdbcTemplate()
                .query(sql, params.toArray(), BeanPropertyRowMapper.newInstance(elementType));
            if (isCache) {
                crmCacheEntityService.putObjectList(elementType, sql, params, rs);
            }
        }

        return rs;
    }
}
