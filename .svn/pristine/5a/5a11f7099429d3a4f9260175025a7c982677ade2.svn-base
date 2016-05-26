package com.ffcs.crmd.platform.data.sqlext.sqldata.build;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.base.utils.CastorUtils;
import com.ffcs.crmd.platform.data.sqlext.impl.CrmSqlRegister;
import com.ffcs.crmd.platform.data.sqlext.sqldata.constants.SqlDataConstants;
import com.ffcs.crmd.platform.data.sqlext.sqldata.dao.IComDataViewerDao;
import com.ffcs.crmd.platform.data.sqlext.sqldata.dao.entity.ComDataViewer;
import com.ffcs.crmd.platform.data.sqlext.sqldata.dao.entity.DataSqlNode;
import com.ffcs.crmd.platform.data.sqlext.sqldata.scan.SqlXmlScanner;
import com.ffcs.crmd.platform.data.sqlext.sqldata.utils.SqBuilderUtils;

/**
 *
 * SQL信息
 *
 * @author LAIYONGMIN-PC
 *
 */
public class SqlBuilder {

	private static final ILogger LOGGER = LoggerFactory.getLogger(SqlBuilder.class);

	// 数据库访问资源
	IComDataViewerDao comDataViewerDao = ApplicationContextUtil.getBean("comDataViewerRepository");

	// 字符类型SQl动态脚本
	private String sqlData;

	// 可执行脚本
	private String exeSql;

	// 动态语句
	private StringBuffer dySql = new StringBuffer();
	// 脚本执行参数
	private List<Object> exeParam = new ArrayList<Object>();
	// 查询参数
	private Map<String, Object> params = new ConcurrentHashMap<String, Object>();

	// 查找出当前的SQL所在的文件
	private Resource cResource;

	private CrmSqlRegister register = ApplicationContextUtil.getBean("sqlRegister");

	/**
	 * 动态SQL文件资源
	 */
	private Resource[] xmlResource;

	// 数据库配置
	private ComDataViewer comDataViewer;
	// SQL key
	private String key;

	// SQL XML节点
	private Node cNode;

	// 是否动态
	private Boolean isDynamic;

	private SqlXmlScanner scanner = ApplicationContextUtil.getBean("sqlXmlScanner");

	// 节点类型
	private String type;

	public SqlBuilder() {
	}

	/**
	 * @param xmlResource
	 */
	public SqlBuilder(Resource[] xmlResource) {
		this.setXmlResource(xmlResource);
	}

	/**
	 * 动态SQL KEY值
	 *
	 * @param key
	 *            SQL 标识
	 * @param param
	 *            参数
	 */
	public SqlBuilder(String name, String cacheSql, Map<String, Object> params) {
		// 校验
		if (StringUtils.isNullOrEmpty(name)) {
			throw new RtManagerException("没有获取到SQL脚本的信息的查询条件.");
		}
		this.setXmlResource(scanner.getMapperLocations());
		this.setKey(name);
		// 是否已经注册
		if (StringUtils.isNullOrEmpty(cacheSql)) {
			// 首先找数据库是否配置相应的SQL脚本
			String param = name;
			if (name.contains(".")) {
				param = name.split("\\.")[1];
			}
			List<ComDataViewer> datas = comDataViewerDao.queryListByType(param);
			// 数据库没有配置相应的SQL;
			if (datas != null && !datas.isEmpty()) {
				if (datas.size() > 1) {
					throw new RtManagerException("获取2条以上的SQL脚本的配置信息,请检查配置信息.");
				}
				// 获取配置SQL
				ComDataViewer cur = datas.get(0);
				this.setComDataViewer(cur);
				// 状态（静态、动态）
				this.setType(cur.getType());
			}
			// 当前SQL所有的文件资源
			this.setSqlData(this.getSqlData());
			if (StringUtils.isNullOrEmpty(this.getSqlData())) {
				throw new RtManagerException("没有找到可执行语句.请检查!:" + (StringUtils.isNullOrEmpty(name) ? "" : name));
			}
			// 注册-未解析的语句
			register.registerSql(name, this.getSqlData());
		} else {
			// 获取缓存sql
			this.setSqlData(cacheSql);
		}
		// 设置参数
		this.setParams(params);
		// 校验是否是动态脚本
		parseSql();
		// 格式化
		format();
		// 检查合法性
		checkSQL();
	}

	/**
	 * 解析动态SQL
	 */
	public void parseDynamicSql() {
		String sql = this.getSqlData();
		if (!StringUtils.isNullOrEmpty(sql)) {
			Object node = CastorUtils.serialToObject(sql, DataSqlNode.class);
			if (node != null) {
				DataSqlNode sqlNode = (DataSqlNode) node;
				parseXMLNode(sqlNode);
			}
			this.setExeSql(dySql.toString());
		}
	}

	/**
	 * 校验SQL合法性
	 *
	 */
	public void checkSQL() {
		// 执行脚本
		if (!StringUtils.isNullOrEmpty(this.getExeSql())) {
			// 转小写
			String sql = this.getExeSql();
			// 已处理为小写
			if (sql.contains("where and")) {
				sql = sql.replace("where and", "where");
			}
			this.setExeSql(sql);
		}

	}

	/**
	 * 解析XML
	 *
	 * @param node
	 */
	public void parseXMLNode(DataSqlNode node) {
		// 脚本语句
		if (SqlDataConstants.SQL_TYPE_SQLTEXT.getValue().equals(node.getType())) {
			String sqlText = node.getSqltext();

			if (isWhereIndex(sqlText)) { // 无条件的情况下，去除 where/WHERE
				if ((node.getDataSqlNode() == null || node.getDataSqlNode().length <= 0)
						|| !isHaveParam(node.getDataSqlNode())) {
					int where = getWhereIndex(sqlText);
					if (where != -1) { // 是否存在条件语句
						if (!(checkAfterWhereIsCondition(sqlText) || isSqlConditionKey(node))) {
							sqlText = sqlText.substring(0, where);
						}
					}
				}
			}
			dySql.append(" " + sqlText + " ");
			// 条件语句,
		} else if (isWhereSql(node)) {
			// 设置参数
			setExeParamValue(node);
		}
		// 选择处理
		if (node.getDataSqlNode() != null && node.getDataSqlNode().length > 0) {
			switchByNodeType(node);
		}
	}

	/**
	 * 校验是否是sql条件关键
	 * 
	 * @param node
	 * @return
	 */
	private boolean isSqlConditionKey(DataSqlNode node) {
		if (checkContainsIndex(node.getDataSqlNode(), "exists")
				|| checkContainsIndex(node.getDataSqlNode(), "exists".toUpperCase())
				|| checkContainsIndex(node.getDataSqlNode(), "between")
				|| checkContainsIndex(node.getDataSqlNode(), "between".toUpperCase())) {
			return true;
		}
		return false;
	}

	/**
	 * 区分处理
	 *
	 * @param node
	 */
	public void switchByNodeType(DataSqlNode node) {
		if (SqlDataConstants.SQL_TYPE_SQLTEXT.getValue().equals(node.getType())) {
			for (DataSqlNode childNode : node.getDataSqlNode()) {
				parseXMLNode(childNode);
			}
		} else if (SqlDataConstants.SQL_TYPE_PARAM.getValue().equals(node.getType())) {
			// 是否存在参数值，不存在，不处理内部嵌套节点
			if (isHaveParam(node.getDataSqlNode())) {
				for (DataSqlNode childNode : node.getDataSqlNode()) {
					parseXMLNode(childNode);
				}
			}
		}

	}

	/**
	 * @param sqlText
	 * @param index
	 *            (小写)
	 * @return
	 */
	public int getIndex(String sqlText, String index) {
		int a = -1;
		if (!StringUtils.isNullOrEmpty(sqlText)) {
			if (sqlText.contains(index) || sqlText.contains(index.toUpperCase())) {
				int upperIndex = -1;
				a = sqlText.lastIndexOf(index);
				upperIndex = sqlText.lastIndexOf(index.toUpperCase());
				if (a == -1) {
					a = upperIndex;
				}
				if (a != -1) {
					return a;

				}
			}
		}
		return a;
	}

	/**
	 * 获取WHERE位置
	 *
	 * @param sqlText
	 * @return
	 */
	public int getWhereIndex(String sqlText) {
		return getIndex(sqlText, "where");
	}

	/**
	 * 获取and 位置
	 *
	 * @param sqlText
	 * @return
	 */
	public int getAndIndex(String sqlText) {
		return getIndex(sqlText, "and");
	}

	/**
	 * 获取exists位置
	 *
	 * @param sqlText
	 * @return
	 */
	public int getExists(String sqlText) {
		return getIndex(sqlText, "exists");
	}

	/**
	 * 第一节点是否为参数
	 *
	 * @param first
	 * @return
	 */
	public boolean checkFirstTypeIsParam(DataSqlNode first) {
		if (first != null) {
			if (isWhereSql(first)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含关键字
	 *
	 * @param nodes
	 * @param index
	 * @return
	 */
	public boolean checkContainsIndex(DataSqlNode[] nodes, String index) {
		for (DataSqlNode node : nodes) {
			if (!isWhereSql(node)) {
				if (node.getSqltext().contains(index) || node.getSqltext().contains(index.toUpperCase())) {
					String sqlText = " " + node.getSqltext() + " ";
					int lowerIndex = -1;
					int upperIndex = -1;
					// 没有找出所有，目前处理方式
					lowerIndex = sqlText.lastIndexOf(index);
					upperIndex = sqlText.lastIndexOf(index.toUpperCase());
					if (lowerIndex == -1) {
						lowerIndex = upperIndex;
					}
					char[] sqlc = sqlText.toCharArray();
					if (sqlc[lowerIndex - 1] == ' ' || sqlc[lowerIndex - 1] == '\t') {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 存在返回true
	 *
	 * @param sqlText
	 * @param index
	 * @return
	 */
	public boolean checkContainsIndex(String sqlText, String index) {
		if (!StringUtils.isNullOrEmpty(sqlText)) {
			sqlText = " " + sqlText + " ";
			char[] sqlc = sqlText.toCharArray();
			if (sqlText.contains(index) || sqlText.contains(index.toUpperCase())) {
				int lowerIndex = -1;
				int upperIndex = -1;
				// 没有找出所有，目前处理方式
				lowerIndex = sqlText.lastIndexOf(index);
				upperIndex = sqlText.lastIndexOf(index.toUpperCase());
				if (lowerIndex == -1) {
					lowerIndex = upperIndex;
				}
				if (lowerIndex != -1) {
					try {
						// tab符号，空格' '
						if (sqlc[lowerIndex - 1] == ' ' || sqlc[lowerIndex - 1] == '\t') {
							return true;
						}
					} catch (Exception e) {
						// 不处理
						LOGGER.error("动态SQL异常", e);
					}

				}
			}
		}
		return false;
	}

	/**
	 * 是否是where标识
	 *
	 * @param sqlText
	 * @return
	 */
	public boolean isWhereIndex(String sqlText) {
		return checkContainsIndex(sqlText, "where");
	}

	/**
	 * 校验where语句后是否存在条件语句,针对SQL片段
	 *
	 * @param sql
	 * @return
	 */
	public boolean checkAfterWhereIsCondition(String sql) {
		if (!StringUtils.isNullOrEmpty(sql) && isWhereIndex(sql)) {
			String afterWhere = sql.substring(getWhereIndex(sql) + 5, sql.length());
			if (!StringUtils.isNullOrEmpty(afterWhere.trim())) {
				// 存在语句条件，则不做去除AND操作
				if (afterWhere.contains("=")) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 当前param存在条件
	 *
	 * @param nodes
	 * @return
	 */
	public boolean isHaveParam(DataSqlNode[] nodes) {
		Boolean ret = false;
		if ((nodes != null && nodes.length > 0) && (this.getParams() != null && this.getParams().size() > 0)) {
			for (DataSqlNode node : nodes) {
				if (this.getParams().containsKey(node.getParamTag())) {
					// 并且存在可用参数
					if (this.getParams().get(node.getParamTag()) != null) {
						ret = true;
					}
				} else {
					// 孩子节点判断
					if (node.getDataSqlNode() != null && node.getDataSqlNode().length > 0) {
						ret = isHaveParam(node.getDataSqlNode());
					}
				}
				// 存在，则不往下校验
				if (ret) {
					return ret;
				}
			}
		}
		return ret;
	}

	/**
	 * 检测集合（）内是否存在可用参数，如果没有则，直接去掉整个查询条件
	 */
	public void checkAfterEndBracket() {

	}

	/**
	 * 设置执行参数
	 *
	 * @param node
	 * @param params
	 */
	public void setExeParamValue(DataSqlNode node) {
		// 校验数据类型
		Object value = null;
		if (params.containsKey(node.getParamTag())) {
			value = params.get(node.getParamTag());
			if (value instanceof Integer || value instanceof Long || value instanceof Date
					|| value instanceof java.util.Date) {
				dySql.append(" " + node.getSqltext());
				exeParam.add(value);
			} else if (value instanceof String) {
				dySql.append(" " + node.getSqltext());
				if (SqlDataConstants.SQL_TYPE_PARAM_LIKE.getValue().equals(node.getType())) {
					exeParam.add("%" + value + "%");
				} else if (SqlDataConstants.SQL_TYPE_PARAM_LIKE_LEFT.getValue().equals(node.getType())) {
					exeParam.add("%" + value + "");
				} else if (SqlDataConstants.SQL_TYPE_PARAM_LIKE_RIGHT.getValue().equals(node.getType())) {
					exeParam.add("" + value + "%");
				} else {
					exeParam.add(value);
				}
			} else if (value instanceof ArrayList || value instanceof List) {
				@SuppressWarnings("unchecked")
				List<Object> list = (List<Object>) value;
				if (list != null && !list.isEmpty()) {
					// 存在in，按in方式处理
					int j = 0;
					if (checkContainsIndex(node.getSqltext(), "in")) {
						dySql.append(" " + node.getSqltext() + " (");
						// 参数
						for (Object obj : list) {
							if (j == 0) {
								dySql.append("?");
							} else {
								dySql.append(",?");
							}
							exeParam.add(obj);
							j++;
						}
						dySql.append(") ");

					} else {
						// 类between and
						dySql.append(node.getSqltext());
						for (Object obj : list) {
							exeParam.add(obj);
						}
					}
				}
			} else {
				throw new RtManagerException(
						"传入不支持的参数类型。请检查：" + (StringUtils.isNullOrEmpty(this.getKey()) ? "" : this.getKey()));
			}
		} else {
			if (node.getDataSqlNode() != null && node.getDataSqlNode().length > 0) {
				// 存在孩子节点，则认为是组合查询
				if (isHaveParam(node.getDataSqlNode())) {
					dySql.append(" " + node.getSqltext());
				}
			}
		}
	}

	/**
	 * 解析
	 */
	public void parseSql() {
		// 校验是否是动态脚本
		if (isDynamic()) {
			// 一定为动态SQL
			parseDynamicSql();
		} else {
			parseStaticSql();
		}
	}

	/**
	 * 解析静态SQL
	 */
	public void parseStaticSql() {
		this.setExeSql(this.getSqlData());
	}

	/**
	 * SQL格式化
	 *
	 */
	public void format() {
		StringBuffer dy = null;
		StringBuffer sql = new StringBuffer();
		// 开始
		int dyOpen = 0;
		// 结束
		int dyClose = 0;
		if (!StringUtils.isNullOrEmpty(this.getExeSql())) {
			int offset = 0;
			int sqm = 0;
			char[] chars = this.getExeSql().toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				// 单引号特殊处理
				if (c == '\'') {
					sqm++;
					if (sqm != 1) {
						// 二次碰到为结束
						sqm = 0;
					}
				}
				if (offset == 0 && (c == ' ' || c == '\t') && !StringUtils.isNullOrEmpty(sql.toString())) {
					// 前一个不为“,”才需要加空格
					if (!sql.substring(sql.length() - 1).equals(",")) {
						// 转空格
						if (c == '\t') {
							c = ' ';
						}
						sql.append(c);
					}
				} else {
					// 拼接非(换行和回车);
					if (!(c == ' ' || c == '\t') && !(c == '\n' || c == '\r')) {
						// sqm==0说明没有还没碰到或者结束单引号
						if (sqm == 0 && (c >= 'A' && c <= 'Z')) {
							sql.append((char) (c + 32));
						} else {
							// 不特殊处理
							sql.append(c);
						}
						// 找到一个非空字符;
						offset = 0;
					}
				}
				if (c == ' ' || c == '\t') {
					// 统计空格
					offset++;
				}
				if (c == '#') {
					dy = new StringBuffer();
					dyOpen = 1;
				}
				if (c == '}') {
					dyClose = 1;
				}
				if (dyOpen == 1) {
					dy.append(c);
					sql.setLength(sql.length() - 1);
				}
				if (dyClose == 1) {
					dyOpen = 0;
					dyClose = 0;
					String pkey = SqBuilderUtils.getPlaceholder("#{", "}", dy.toString());
					if (StringUtils.isNullOrEmpty(pkey) || StringUtils.isNullOrEmpty(this.getParams().get(pkey))) {
						throw new RtManagerException("解析动态语句#{}、参数异常！请检查："
								+ (StringUtils.isNullOrEmpty(this.getKey()) ? "" : this.getKey()));
					}
					// 拼接动态参数语句
					sql.append(this.getParams().get(pkey));
					// 清除
					dy = null;
				}
			}
			this.setExeSql(sql.toString());
			LOGGER.debug("执行脚本:" + this.getExeSql());
		}
	}

	/**
	 * 动态校验
	 *
	 * 先按Type配置进行校验，没配置根据内容校验
	 *
	 * @return
	 */
	public boolean isDynamic() {
		Boolean ret = false;
		if (!StringUtils.isNullOrEmpty(this.getType())) {
			if (SqlDataConstants.SQL_TYPE_XML.getValue().equals(this.getType())) {
				ret = true;
			}
		} else {
			if (!StringUtils.isNullOrEmpty(this.getSqlData())) {
				// 起始字符为<dataSqlNode>,则为动态语句
				if (this.getSqlData().startsWith(SqlDataConstants.SQL_DY_INDEX.getValue())) {
					ret = true;
				}
			}
		}
		this.setIsDynamic(ret);
		return ret;
	}

	/**
	 * 是否是条件语句
	 *
	 * @param node
	 * @return
	 */
	public boolean isWhereSql(DataSqlNode node) {
		if (SqlDataConstants.SQL_TYPE_PARAM.getValue().equals(node.getType())
				|| SqlDataConstants.SQL_TYPE_PARAM_LIKE.getValue().equals(node.getType())
				|| SqlDataConstants.SQL_TYPE_PARAM_LIKE_LEFT.getValue().equals(node.getType())
				|| SqlDataConstants.SQL_TYPE_PARAM_LIKE_RIGHT.getValue().equals(node.getType())) {
			return true;
		}
		return false;
	}

	public Resource[] getXmlResource() {
		return xmlResource;
	}

	public void setXmlResource(Resource[] xmlResource) {
		this.xmlResource = xmlResource;
	}

	public ComDataViewer getComDataViewer() {
		return comDataViewer;
	}

	public void setComDataViewer(ComDataViewer comDataViewer) {
		this.comDataViewer = comDataViewer;
	}

	public String getExeSql() {
		return exeSql;
	}

	public void setExeSql(String exeSql) {
		this.exeSql = exeSql;
	}

	public void setSqlData(String sqlData) {
		this.sqlData = sqlData;
	}

	public String getSqlData() {
		if (StringUtils.isNullOrEmpty(sqlData)) {
			if (this.getComDataViewer() != null) {
				// 数据库中取
				sqlData = this.getComDataViewer().getDataSql();
			} else {
				if (this.getcNode() != null) {
					sqlData = this.getcNode().getTextContent();
				}
			}
		}
		sqlData = StringUtils.isNullOrEmpty(sqlData) ? "" : sqlData.trim();
		return sqlData;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Resource getcResource() {
		// 是否已解析过
		if (cResource == null && getXmlResource() != null && getXmlResource().length > 0
				&& !StringUtils.isNullOrEmpty(this.getKey())) {
			if (!this.getKey().contains(".")) {
				throw new RtManagerException("传入name不合法，请检查.");
			}
			for (Resource resource : getXmlResource()) {
				if (key.split("\\.")[0].equals(resource.getFilename().split("\\.")[0])) {
					// 查找语句所在的文件资源里面
					cResource = resource;
					break;
				}
			}
		}
		return cResource;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Node getcNode() {
		// 没有解析过，则从头开始解析
		if (cNode == null) {
			Resource resource = this.getcResource();
			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.parse(resource.getInputStream());
				NodeList nodes = (NodeList) XPathFactory.newInstance().newXPath().evaluate("/mapper/*[name()='sql']",
						doc, XPathConstants.NODESET);
				if (nodes != null && nodes.getLength() > 0) {
					for (int i = 0; i < nodes.getLength(); i++) {
						String id = nodes.item(i).getAttributes().getNamedItem("id").getNodeValue();
						if (id.equals(key.split("\\.")[1])) {
							cNode = nodes.item(i);
							// 设置语句类型
							String type = "";
							try {
								type = cNode.getAttributes().getNamedItem("type").getNodeValue();
							} catch (NullPointerException e) {
								LOGGER.debug("脚本中未发现配置type类型!");
							}
							if (!StringUtils.isNullOrEmpty(type)) {
								this.setType(type);
							}
							break;
						}
					}
				} else {
					throw new RtManagerException("XML文件在解析成SQL时异常");
				}
			} catch (Exception e) {
				throw new RtManagerException("XML文件在解析成SQL时异常.cause:" + e);
			}
		}

		return cNode;
	}

	public void setcNode(Node cNode) {
		this.cNode = cNode;
	}

	public Boolean getIsDynamic() {
		return isDynamic;
	}

	public void setIsDynamic(Boolean isDynamic) {
		this.isDynamic = isDynamic;
	}

	public List<Object> getExeParam() {
		return exeParam;
	}

	public void setExeParam(List<Object> exeParam) {
		this.exeParam = exeParam;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
