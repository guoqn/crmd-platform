package com.ffcs.crmd.platform.ui.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * JSP 常量
 * 
 * @author LAIYONGMIN
 *
 */
public class JspUtil {

	/**
	 * 项目名
	 * 
	 * @param request
	 * @return
	 */
	public static String path(HttpServletRequest request) {
		return request.getContextPath();
	}

	/**
	 * 项目地址
	 * 
	 * @param request
	 * @return
	 */
	public static String contextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ JspUtil.path(request);
	}

	/**
	 * 版本
	 * 
	 * @return
	 */
	public static String version() {
		return "1";
	}

}
