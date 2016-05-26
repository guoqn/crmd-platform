package com.ffcs.crmd.platform.data.sqlext.sqldata.dao.entity;

import java.io.Serializable;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

/**
 * 节点
 * 
 * @author LAIYONGMIN-PC
 *
 */
public class DataSqlNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6422753341396158380L;

	/**
	 * 节点类型.
	 */

	private String type;

	/**
	 * 节点内容.
	 */

	private String sqltext;

	/**
	 * 判断参数符号.
	 */

	private String[] checkParams;

	/**
	 * 参数符号.
	 */

	private String paramTag;

	/**
	 * .
	 */

	private DataSqlNode[] dataSqlNode;

	/**
	 * .
	 */

	private ArgRule[] argRule;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSqltext() {
		return StringUtils.isNullOrEmpty(sqltext) ? "" : sqltext.trim();
	}

	public void setSqltext(String sqltext) {
		this.sqltext = sqltext;
	}

	public String[] getCheckParams() {
		return checkParams;
	}

	public void setCheckParams(String[] checkParams) {
		this.checkParams = checkParams;
	}

	public String getParamTag() {
		return paramTag;
	}

	public void setParamTag(String paramTag) {
		this.paramTag = paramTag;
	}

	public DataSqlNode[] getDataSqlNode() {
		return dataSqlNode;
	}

	public void setDataSqlNode(DataSqlNode[] dataSqlNode) {
		this.dataSqlNode = dataSqlNode;
	}

	public ArgRule[] getArgRule() {
		return argRule;
	}

	public void setArgRule(ArgRule[] argRule) {
		this.argRule = argRule;
	}

}
