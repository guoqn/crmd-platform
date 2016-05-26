/**
 * 
 */
package com.ffcs.crmd.platform.pub.ex;

import java.text.MessageFormat;
import java.util.List;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.bean.HeadInfo;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ffcs.crmd.platform.pub.ex.config.ConfigLoaderFactory;
import com.ffcs.crmd.platform.pub.ex.config.IConfigLoader;
import com.ffcs.crmd.platform.pub.ex.text.ExceptionFormat;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;

/**
 * 异常工具类，用于统一的异常抛出和基础的异常处理.
 * throw**为异常抛出方法;
 * warn**为添加警告方法;
 * trans**为异常转义方法，用于将非BaseAppException异常转换成BaseAppException
 * .
 * 
 * @author hehuang
 * @since 1.0.0
 */
public class ExceptionUtils {
	
	protected static ILogger logger = LoggerFactory.getLogger(ExceptionUtils.class);
	
	private static IConfigLoader configLoader = ConfigLoaderFactory.getDefaultConfigLoader();
	
	static void doThrowEx(String businessHint, String errorCode, Throwable e) {
		Throwable t = e;
		BaseAppException ex;
		if (e != null) {
			ex = new BaseAppException(businessHint, errorCode, e);
			t = ex;
		} else {
			ex = new BaseAppException(businessHint, errorCode);
			t = ex;
		}
		
		ex.setExType(ExType.ERROR);
		
		logger.error(businessHint, t);
		throw ex;
	}
	
	/**
	 * 添加提示类异常，保存在线程变量中
	 * .
	 * @param bussinessHint 异常提示
	 * @param errorCode 异常编码
	 * @param e 异常
	 */
	static void doWarn(String bussinessHint, String errorCode, Throwable e) {
		// 1.生成异常
		Throwable t = e;
		BaseAppException ex;
		if (e != null) {
			ex = new BaseAppException(bussinessHint, errorCode, e);
			t = ex;
		} else {
			ex = new BaseAppException(bussinessHint, errorCode);
			t = ex;
		}
		
		ex.setExType(ExType.WARNING);
		// 2.记录异常
		logger.warn(bussinessHint, t);
		
		// 3.保存异常到本地线程变量中
		CrmSessionContext.addWarning(ex);		
	}
	
	
	/**
	 * 指定错误编码和cause，生成异常。
	 * 本方法会根据错误编码和错误编码配置获取配置的错误提示信息，如果错误编码对应的错误提示不存在，方法不会报错，错误提示会被设置为空字符串
	 * .
	 * @param errorCode 错误编码
	 * @param e 异常
	 * @param params 匹配参数
	 */
	public static void throwEx(Throwable e, String errorCode, Object...params) {
		// 先简单实现，作为第一轮迭代的结果，支持基于java格式化输出，基于占位符
		String bussinessHintTemplate = configLoader.loadConfig(errorCode + "");
		
		// 暂时先使用占位符方式
		String businessHint = bussinessHintTemplate;
		try {
			businessHint = MessageFormat.format(bussinessHintTemplate, params);
		} catch (Exception te) {
			// do nothings
		}
		
		ExceptionUtils.doThrowEx(businessHint, errorCode, e);
	}
	
	/**
	 * 指定异常提示信息、异常和异常编码，生成异常。
	 * 将按传入的异常信息设置异常提示，不再根据异常编码获取异常提示配置
	 * .
	 * @param businessHint 用户指定的异常提示信息
	 * @param e 异常
	 * @param errorCode 异常编码
	 */
	public static void throwExHint(String businessHint, Throwable e, String errorCode) {
		ExceptionUtils.doThrowEx(businessHint, errorCode, e);
	}
	
	/**
	 * 指定异常编码，生成异常.
	 * 本方法根据异常编码获取对应的异常信息配置，如果获取不到异常信息配置，不会报错，异常信息会被设置为空字符串
	 * 
	 * @param errorcode 异常编码
	 * @param params 匹配参数
	 */
	public static void throwEx(String errorcode, Object...params) {
		ExceptionUtils.throwEx((Throwable) null, errorcode, params);
	}
	
	/**
	 * 异常转译。
	 * 用户将传入的checked异常，转译成unchecked异常
	 * .
	 * 将传入的异常
	 * @param e
	 * @param params
	 */
	public static void throwEx(Throwable e) {
		ExceptionUtils.throwExHint(e.getMessage(), e, ExConstants.DEFAULT_ERROR_CODE);
	}
	
	/**
	 * 异常转义，但是不抛出异常
	 * .
	 */
	public static BaseAppException transEx(Throwable e) {
		if (e instanceof BaseAppException) {
			return (BaseAppException) e;
		}
		
		return new BaseAppException(e);
	}
	
	/**
	 * 异常转义，但是不抛出异常
	 * .
	 */
	public static BaseAppException transEx(Throwable e, String errorCode) {
		return new BaseAppException(e.getMessage(), errorCode, e);
	}
	
	/**
	 * 异常转义，但是不抛出异常.如果e就是BaseAppException则直接返回，被
	 * .
	 */
	public static BaseAppException transEx(Throwable e, String errorCode, String bussinessHint) {
		return new BaseAppException(bussinessHint, errorCode, e);
	}
	
	/**
	 * 指定异常提示信息，添加提示类异常
	 * .
	 * @param warningMsg 异常提示信息
	 */
	public static void warnMsg(String warningMsg) {
		ExceptionUtils.doWarn(warningMsg, ExConstants.DEFAULT_ERROR_CODE, null);;
	}
	
	/**
	 * 制定异常提示信息和异常编码，添加提示类异常
	 * .
	 * @param warningMsg 异常提示
	 * @param errorCode 异常编码
	 * 
	 */
	public static void warnMsg(String warningMsg, String errorCode) {
		ExceptionUtils.doWarn(warningMsg, errorCode, null);
	}
	
	/**
	 * 指定异常编码，添加提示类异常。根据异常编码获取异常提示配置，如果获取不到异常提示配置，异常提示会被设置成空字符串
	 * .
	 * 
	 * @param errorCode 异常编码
	 * @param params 匹配参数
	 */
	public static void warn(String errorCode, Object...params) {
		ExceptionUtils.warn((Throwable) null, errorCode, params);
	}
	
	/**
	 * 根据异常提示和异常，添加提示类异常
	 * .
	 * @param warningMsg
	 * @param e
	 */
	public static void warnMsg(Throwable e, String warningMsg) {
		ExceptionUtils.doWarn(warningMsg, ExConstants.DEFAULT_ERROR_CODE, e);
	}
	
	/**
	 * 根据异常编码和异常，添加提示类异常。根据异常编码获取异常提示配置，如果获取不到异常提示配置，异常提示会被设置成空字符串
	 * 
	 * @param errorCode
	 * @param e
	 * @param params
	 */
	public static void warn(Throwable e, String errorCode, Object...params) {
		// 先简单实现，作为第一轮迭代的结果，支持基于java格式化输出，基于占位符
		String bussinessHintTemplate = configLoader.loadConfig(errorCode + "");
		
		// 暂时先使用占位符方式
		String businessHint = bussinessHintTemplate;
		try {
			businessHint = MessageFormat.format(bussinessHintTemplate, params);
		} catch (Exception te) {
			// do nothings
		}
		
		ExceptionUtils.doWarn(businessHint, errorCode, e);
	}
	
	public static void fillEx(ReqResult result, BaseAppException e) {
		HeadInfo info = result.getHeadInfo();
		info.addProp(ExConstants.PROP_EX_KEY, ExceptionFormat.format(e));
	}
	
	public static void fillWarnings(ReqResult result, List<BaseAppException> exs) {
		HeadInfo info = result.getHeadInfo();
		info.addProp(ExConstants.PROP_WARN_KEY, ExceptionFormat.format(exs));
	}
	
	public static void readEx(ReqResult result) {
		HeadInfo info = result.getHeadInfo();
		String exStr = info.getPropsMap().get(ExConstants.PROP_EX_KEY);
		List<BaseAppException> exs = ExceptionFormat.parse(exStr);
		if (exs != null
				&& exs.size() > 0) {
			logger.error(exs.get(0).getMessage(), exs.get(0));
			
			throw exs.get(0);
		}
	}
	
	public static void readWarnings(ReqResult result) {
		HeadInfo info = result.getHeadInfo();
		String warningsStr = info.getPropsMap().get(ExConstants.PROP_WARN_KEY);
		
		List<BaseAppException> warnings = ExceptionFormat.parse(warningsStr);
		if (warnings != null
				&& warnings.size() > 0) {
			CrmSessionContext.addWarnings(warnings);
		}
	}
	
	public static void read(ReqResult result) {
		readEx(result); // 优先异常处理
		readWarnings(result);
	}
	
}
