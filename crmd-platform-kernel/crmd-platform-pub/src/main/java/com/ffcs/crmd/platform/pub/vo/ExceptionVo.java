package com.ffcs.crmd.platform.pub.vo;

import com.ctg.itrdc.platform.common.utils.json.JSONUtils;

public class ExceptionVo {

	/**
	 * 异常编码，在baseAppException中使用，不使用可不传递
	 * .
	 */
	private String errorCode;
	
	/**
	 * 异常信息
	 * .
	 */
	private String message;
	
	/**
	 * 异常堆栈信息
	 * .
	 */
	private String traceInfo;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTraceInfo() {
		return traceInfo;
	}

	public void setTraceInfo(String traceInfo) {
		this.traceInfo = traceInfo;
	}
	
	public ExceptionVo() {
	}
	
	public ExceptionVo(String errorCode, String msg, String traceInfo) {
		this.errorCode = errorCode;
		this.message = msg;
		this.traceInfo = traceInfo;
	}
	
	public ExceptionVo(String msg, String traceInfo) {
		this.message = msg;
		this.traceInfo = traceInfo;
	}
	
	public static String toString(String msg) {
		ExceptionVo exceptionVo = new ExceptionVo();
		exceptionVo.setMessage(msg);
		
		return JSONUtils.toJsonString(exceptionVo);
	}
	
	public static String toString(String msg, String traceInfo) {
		ExceptionVo exceptionVo = new ExceptionVo();
		exceptionVo.setMessage(msg);
		exceptionVo.setTraceInfo(traceInfo);
		
		return JSONUtils.toJsonString(exceptionVo);
	}
	
}
