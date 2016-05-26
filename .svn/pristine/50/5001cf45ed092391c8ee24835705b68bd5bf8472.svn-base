/**
 * 
 */
package com.ffcs.crmd.platform.pub.ex.text;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ctg.itrdc.event.utils.StringUtils;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExType;

/**
 * 异常信息的格式化,格式化的异常信息用于服务框架中间层交互
 * .
 * 备注：使用明文作为编码，使协议层友好
 * 
 * @author hehuang
 *
 */
public class ExceptionFormat  {
	
	private static final Logger logger = Logger.getLogger(ExceptionFormat.class);
	
	private static final String ATTR_SPERATOR_REGEX						= "\\$:\\$";
	private static final String EXCEP_SPERATOR_REGEX 					= "\\$#\\$";
	private static final String ATTR_SPERATOR 							= "$:$";
	private static final String EXCEP_SPERATOR							= "$#$";

	public static List<BaseAppException> parse(String source) {
		List<BaseAppException> exs = new ArrayList<BaseAppException>();
		try {
			if (!StringUtils.isNullOrEmpty(source)) {
				String[] exStrs = source.split(EXCEP_SPERATOR_REGEX);
				if (exStrs != null
						&& exStrs.length > 0) {
					for (String exStr
							: exStrs) {
						String[] attrs = exStr.split(ATTR_SPERATOR_REGEX);
						if (attrs.length == 3) {
							BaseAppException ex = new BaseAppException(attrs[1], attrs[0]);
							ex.setExType(ExType.valueOf(attrs[2]));
							
							exs.add(ex);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.warn(e);
		}
		
		return exs;	
	} 
	
	/**
	 * 将提示转换成
	 * @param warnings
	 * @return
	 */
	public static String format(List<BaseAppException> warnings) {
		String format = "";
		if (warnings != null
				&& warnings.size() > 0) {
			for (BaseAppException warning
					: warnings) {
				if (!StringUtils.isNullOrEmpty(format)) {
					format += EXCEP_SPERATOR + format(warning) ;
				} else {
					format += format(warning);
				}
			}
		}
		
		return format;	 
	}
	
	public static String format(BaseAppException ex) {
		String errCode = ex.getErrorCode();
		String hint = ex.getBusinessHint();
		ExType type = ex.getExType();
		
		return errCode + ATTR_SPERATOR + hint + ATTR_SPERATOR + type;
	}

}
