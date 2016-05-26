package com.ffcs.crmd.platform.data.sqlext.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegister;
import com.ctg.itrdc.platform.pub.sqlext.impl.DefaultSqlRegister;
import com.ffcs.crmd.platform.data.sqlext.sqldata.build.SqlBuilder;

@Component("sqlRegister")
public class CrmSqlRegister extends DefaultSqlRegister implements SqlRegister {

	private static final ILogger LOGGER = LoggerFactory.getLogger(CrmSqlRegister.class);

	@Override
	public String getSql(String key) {
		// 构建
		SqlBuilder builder = new SqlBuilder(key, super.getSql(key), null);
		// 打印缓存语句
		LOGGER.debug("缓存:" + super.getSql(key));
		// 获取可执行的SQL
		return builder.getExeSql();
	}

	/**
	 * 动态语句扩展
	 * 
	 * @param key
	 * @param params
	 * @return
	 * @author LAIYONGMIN-PC
	 */
	public Object[] getSql(String key, Map<String, Object> params) {
		// 构建
		SqlBuilder builder = new SqlBuilder(key, super.getSql(key), params);
		// 打印缓存语句
		LOGGER.debug("缓存:" + super.getSql(key));
		// 获取可执行的SQL
		return new Object[] { builder.getExeSql(), builder.getExeParam() };
	}

	@Override
	public void registerSql(String key, String sql) {
		super.registerSql(key, sql);
	}

}
