package com.ffcs.crmd.platform.pub.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.exception.ExceptionUtil;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;

public class RetVo implements Serializable {

	private boolean result = false;

	private List<String> retCode = new ArrayList<String>();

	private List<String> msgTitle = new ArrayList<String>();

	private List<String> detailMsg = new ArrayList<String>();

	private List<Throwable> exceptions = new ArrayList<Throwable>();

	private Object object;

	private Collection dataList;

	private PageInfo pageInfo;

	private String exceptionPath = null;

	private transient static Map<Class<?>, Long> codeMap = new HashMap<Class<?>, Long>();

	private transient static final String OTHER_ERR_CODE = "-99";
	private transient static final String SUCCESS_CODE = "0";

	static {
	}

	public RetVo() {
		super();
	}

	public RetVo(boolean result) {
		super();
		this.result = result;
		if (result) {
			setRetCode(SUCCESS_CODE);
		}

	}

	public RetVo(boolean result, Object object) {
		super();
		this.result = result;
		if (result) {
			setRetCode(SUCCESS_CODE);
		}
		if (object instanceof Collection) {
			this.dataList = (Collection) object;
		} else if (object instanceof PageInfo) {
			this.pageInfo = pageInfo;
		} else {
			this.object = object;
		}
	}

	public RetVo(boolean result, Throwable exception) {
		super();
		this.result = result;
		if (result) {
			setRetCode(SUCCESS_CODE);
		}
		this.exceptions.add(exception);
		this.msgTitle.add(exception.getMessage());
		this.detailMsg.add(ExceptionUtil.getTraceInfo(exception));
		if (!codeMap.containsKey(exception.getClass())) {
			this.retCode.add(OTHER_ERR_CODE);
		}
		if (exceptionPath == null && exception != null) {
			StringBuffer sb = new StringBuffer();
			StackTraceElement ste = exception.getStackTrace()[0];
			sb.append("ClassName=");
			sb.append(ste.getClassName());
			sb.append(";MethodName=");
			sb.append(ste.getMethodName());
			sb.append(";LineNumber=");
			sb.append(ste.getLineNumber());
			exceptionPath = sb.toString();
			sb.setLength(0);
		}
	}

	public static RetVo newInstance(boolean result, BaseAppException exception) {
		RetVo retVo = new RetVo();

		retVo.result = result;
		if (result) {
			retVo.setRetCode(SUCCESS_CODE);
		} else {
			retVo.setRetCode(exception.getErrorCode());
		}
		retVo.exceptions.add(exception);
		retVo.msgTitle.add(exception.getBusinessHint()); // set hint
		retVo.detailMsg.add(ExceptionUtil.getTraceInfo(exception));
		// if (!codeMap.containsKey(exception.getClass())) {
		// retVo.retCode.add(OTHER_ERR_CODE);
		// }
		if (retVo.exceptionPath == null && exception != null) {
			StringBuffer sb = new StringBuffer();
			StackTraceElement ste = exception.getStackTrace()[0];
			sb.append("ClassName=");
			sb.append(ste.getClassName());
			sb.append(";MethodName=");
			sb.append(ste.getMethodName());
			sb.append(";LineNumber=");
			sb.append(ste.getLineNumber());
			retVo.exceptionPath = sb.toString();
			sb.setLength(0);
		}

		return retVo;
	}

	public RetVo(boolean result, String retCode, String msgTitle, String detailMsg, Throwable exceptions) {
		super();
		this.result = result;
		if (result) {
			setRetCode(SUCCESS_CODE);
		}
		this.retCode.add(retCode);
		this.msgTitle.add(msgTitle);
		this.detailMsg.add(detailMsg);
		this.exceptions.add(exceptions);
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getRetCode() {
		if (retCode.size() < 1) {
			return null;
		}
		return retCode.get(0);
	}

	public void setRetCode(String retCode) {
		if (this.retCode.size() < 1) {
			this.retCode.add(retCode);
		}
		this.retCode.set(0, retCode);
	}

	public String getMsgTitle() {
		if (msgTitle.size() < 1) {
			return "";
		}
		return msgTitle.get(0);
	}

	public void setMsgTitle(String msgTitle) {
		if (this.msgTitle.size() < 1) {
			this.msgTitle.add(msgTitle);
		}
		this.msgTitle.set(0, msgTitle);
	}

	public String getDetailMsg() {
		if (this.detailMsg.size() < 1) {
			return "";
		}
		return this.detailMsg.get(0);
	}

	public void setDetailMsg(String detailMsg) {
		if (this.detailMsg.size() < 1) {
			this.detailMsg.add(detailMsg);
		}
		this.detailMsg.set(0, detailMsg);
	}

	public Throwable getException() {
		if (this.exceptions.size() < 1) {
			return null;
		}
		return exceptions.get(0);
	}

	public void setExceptions(Throwable exception) {
		if (this.exceptions.size() < 1) {
			this.exceptions.add(exception);
		}
		this.exceptions.set(0, exception);
	}

	public void addRetCode(String retCode) {
		this.retCode.add(retCode);
	}

	public void addMsgTitle(String msgTitle) {
		this.msgTitle.add(msgTitle);
	}

	public void addMsgDetail(String msgDetail) {
		this.msgTitle.add(msgDetail);
	}

	public void addException(Throwable exceptions) {
		this.exceptions.add(exceptions);
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Collection getDataList() {
		return dataList;
	}

	public void setDataList(Collection dataList) {
		this.dataList = dataList;
	}

	public List<Throwable> getExceptions() {
		return exceptions;
	}

	public List<String> getAllRetCode() {
		return retCode;
	}

	public List<String> getAllMsgTitle() {
		return msgTitle;
	}

	public List<String> getAllDetailMsg() {
		return detailMsg;
	}

	public String getExceptionPath() {
		return exceptionPath;
	}

	public void setExceptionPath(String exceptionPath) {
		this.exceptionPath = exceptionPath;
	}
}
