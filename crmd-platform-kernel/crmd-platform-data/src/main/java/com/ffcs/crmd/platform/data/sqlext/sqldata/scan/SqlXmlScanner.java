package com.ffcs.crmd.platform.data.sqlext.sqldata.scan;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;

/**
 * SQL语句 扫描
 * 
 * @author LAIYONGMIN-PC
 *
 */
@Lazy(false)
public class SqlXmlScanner implements InitializingBean {

	// SQL 文件资源
	private Resource[] mapperLocations;

	public Resource[] getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(Resource[] mapperLocations) {
		this.mapperLocations = mapperLocations;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 加载配置
		// new Configuration(mapperLocations);
	}

}
