package com.ffcs.crmd.platform.data.dao;

import java.util.Map;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegister;
import com.ctg.itrdc.platform.pub.sqlext.SqlRegisterFactory;

public class DaoUtils {
	protected static SqlRegister SQLREGISTER = SqlRegisterFactory.getSqlRegister();

	public static void registerSql(Map<String, String> map, String key, String sql) {
		map.put(key, sql);
		SQLREGISTER.registerSql(key, sql);
	}

	public static String getSqlByName(Map<String, String> map, String sqlName, Class<?> clazz) {
		String hql = map.get(sqlName);
		if (StringUtils.isNullOrEmpty(hql)) {
			hql = SQLREGISTER.getSql(sqlName);
			if (hql == null) {
				throw new RtManagerException("无法根据名称：@sqlName，查找sql定义", clazz, "getSqlByName", "sqlNull", "@sqlName",
						sqlName);
			}
		}
		return hql;
	}
}
