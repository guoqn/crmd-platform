package com.ffcs.crmd.platform.data.sqlext.sqldata.constants;

/**
 * 
 * 常量类
 * 
 * @author LAIYONGMIN-PC
 *
 */
public enum SqlDataConstants {

	SQL_TYPE_SQLTEXT("sqltext", "sql静态文本"),

	SQL_TYPE_PARAM("param", "sql条件参数"),

	SQL_TYPE_PARAM_LIKE("like", "sql模糊查询语句"),

	SQL_TYPE_PARAM_LIKE_LEFT("likeleft", "sql模糊查询语句"),

	SQL_TYPE_PARAM_LIKE_RIGHT("likeright", "sql模糊查询语句"),

	SQL_DY_INDEX("<dataSqlNode>", "动态标识"),

	SQL_TYPE_SQL("sql", "静态"),

	SQL_TYPE_XML("xml", "动态"),

	SQL_OPEN_TOKEN("#{", "开始位置字符"), SQL_CLOSE_TOKEN("}", "结束位置字符");

	// key
	private String value;
	// name
	private String name;

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	private SqlDataConstants(String value) {
		this.value = value;
	}

	private SqlDataConstants(String value, String name) {
		this.value = value;
		this.name = name;
	}

}
