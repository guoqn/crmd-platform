package com.ffcs.crmd.platform.data.sqlext.sqldata.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ffcs.crmd.platform.data.dao.impl.CrmBaseDaoImpl;
import com.ffcs.crmd.platform.data.sqlext.sqldata.dao.IComDataViewerDao;
import com.ffcs.crmd.platform.data.sqlext.sqldata.dao.entity.ComDataViewer;

@Repository("comDataViewerRepository")
public class ComDataViewerRepositoryImpl extends CrmBaseDaoImpl implements IComDataViewerDao {

	private final static String STATUS_CD = "1000";

	@Override
	public List<ComDataViewer> queryAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("select id,name,type,seq,remark,data_sql,STATUS_CD from com_data_viewer where STATUS_CD= ? ");
		List<Object> params = new ArrayList<Object>();
		params.add(STATUS_CD);
		return this.jdbcFindList(sql.toString(), ComDataViewer.class, params);
	}

	@Override
	public List<ComDataViewer> queryListByType(String name) {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select id,name,type,seq,remark,data_sql,STATUS_CD from com_data_viewer where name=? and STATUS_CD= ? ");
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(STATUS_CD);
		return this.jdbcFindList(sql.toString(), ComDataViewer.class, params);
	}
}
