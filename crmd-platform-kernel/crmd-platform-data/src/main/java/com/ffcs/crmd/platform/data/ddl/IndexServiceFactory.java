package com.ffcs.crmd.platform.data.ddl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.ddl.api.DdlConstants;
import com.ffcs.crmd.platform.ddl.api.ICrmIndexService;

public class IndexServiceFactory {
	private static ICrmIndexService emptyService = new ICrmIndexService() {

		@Override
		public List<String> getIndexList(String table, List<String> indexColumn, String beIndexColumn,
				Serializable key) {
			return new ArrayList<String>();
		}

		@Override
		public List<String> getIndexList(String table, String indexColumn, String beIndexColumn, Serializable key) {
			return new ArrayList<String>();
		}

		@Override
		public List<String> getIndexList(String schema, String table, List<String> indexColumn, String beIndexColumn,
				Serializable key) {
			// TODO Auto-generated method stub
			return new ArrayList<String>();
		}

		@Override
		public List<String> getIndexList(String schema, String table, String indexColumn, String beIndexColumn,
				Serializable key) {
			// TODO Auto-generated method stub
			return new ArrayList<String>();
		}

		@Override
		public String getIndex(String table, List<String> indexColumn, String beIndexColumn, Serializable key) {
			return "";
		}

		@Override
		public String getIndex(String table, String indexColumn, String beIndexColumn, Serializable key) {
			return "";
		}

		@Override
		public String getIndex(String schema, String table, List<String> indexColumn, String beIndexColumn,
				Serializable key) {
			return "";
		}

		@Override
		public String getIndex(String schema, String table, String indexColumn, String beIndexColumn,
				Serializable key) {
			return "";
		}
	};

	public static ICrmIndexService getIndexService() {
		if (ApplicationContextUtil.containsBean(DdlConstants.INDEX_SERVICE)) {
			return ApplicationContextUtil.getBean(DdlConstants.INDEX_SERVICE);
		} else if (ApplicationContextUtil.containsBean(DdlConstants.DEFAULT_INDEX_SERVICE)) {
			return ApplicationContextUtil.getBean(DdlConstants.DEFAULT_INDEX_SERVICE);
		} else {
			return emptyService;
		}
	}
}
