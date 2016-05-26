/**
 * 
 */
package com.ffcs.crmd.platform.pub.ex;

/**
 * crmd基础异常类,应用无法
 * .
 * @author hehuang
 * @since 1.0.0
 *
 */
public class BaseAppException extends RuntimeException {

	private static final long serialVersionUID = 1;
	
	/**
	 * 业务提示,面向用户的友好的错误提示,一般通过配置指定
	 * .
	 */
	private String businessHint;
	
	/**
	 * 错误编码,由应用指定,建议每种异常使用一种错误编码
	 * .
	 */
	private String errorCode;
	
	/**
	 * 异常类型:提示、交互、异常
	 * .
	 */
	private ExType exType; 

	public String getBusinessHint() {
		return businessHint;
	}

	public void setBusinessHint(String businessHint) {
		this.businessHint = businessHint;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public ExType getExType() {
		return exType;
	}

	public void setExType(ExType exType) {
		this.exType = exType;
	}

	/**
	 * 默认构造函数，不推荐使用
	 * .
	 */
	public BaseAppException() {
		super();
	}
	
	public BaseAppException(String businessHint) {
		super(businessHint);
		this.businessHint = businessHint;
		this.errorCode = ExConstants.DEFAULT_ERROR_CODE; // 若未设置错误编码，则为默认错误
	}
	
	public BaseAppException(Throwable e) {
		super(e);
		this.businessHint = e.getMessage();
		this.errorCode = ExConstants.DEFAULT_ERROR_CODE;
	}
	
	public BaseAppException(String businessHint, Throwable e) {
		this(e);
		this.businessHint = businessHint;
	}
	
	public BaseAppException(String businessHint, String errorCode) {
		this(businessHint);
		this.errorCode = errorCode;
	}
	
	public BaseAppException(String businessHint, String errorCode, Throwable e) {
		super(businessHint, e);
		this.businessHint = businessHint;
		this.errorCode = errorCode;
	}
	
	@Override
	public String getMessage() {
		
		return "【" + errorCode + "】" + businessHint;
	}
	

}
