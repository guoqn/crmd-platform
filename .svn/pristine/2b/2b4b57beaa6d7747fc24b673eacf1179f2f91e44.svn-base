package com.ffcs.crmd.platform.data.sqlext.sqldata.utils;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;

/**
 * 工具类
 * 
 * @author LAIYONGMIN-PC
 *
 */
public class SqBuilderUtils {

	/**
	 * 获取#{}，之间字符
	 * 
	 * @param openToken
	 * @param closeToken
	 * @param sqlText
	 * @return
	 */
	public static String getPlaceholder(String openToken, String closeToken, String sqlText) {
		if (!StringUtils.isNullOrEmpty(openToken) && !StringUtils.isNullOrEmpty(closeToken)
				&& !StringUtils.isNullOrEmpty(sqlText)) {
			int openTokenIndex = sqlText.indexOf(openToken);
			int closeTokenIndex = sqlText.indexOf(closeToken);
			if (closeTokenIndex + openToken.length() > openTokenIndex) {
				return sqlText.substring(openTokenIndex + openToken.length(), closeTokenIndex);
			}
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(SqBuilderUtils.getPlaceholder("#{", "}", "attr=#{attr}"));
	}

}
