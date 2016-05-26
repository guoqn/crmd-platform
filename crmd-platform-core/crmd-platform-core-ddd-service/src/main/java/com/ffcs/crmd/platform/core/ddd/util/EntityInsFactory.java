package com.ffcs.crmd.platform.core.ddd.util;

import com.ctg.itrdc.platform.common.exception.RtManagerException;

public class EntityInsFactory {

	private EntityInsFactory() {

	}

	public static <T> T getInstance(Class<T> clazz) {
		try {
			Object entity = null;
			entity = clazz.newInstance();
			return clazz.cast(entity);
		} catch (Exception e) {
			throw new RtManagerException("初始化失败", e);
		}
	}
}
