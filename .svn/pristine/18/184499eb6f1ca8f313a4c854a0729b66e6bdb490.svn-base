package com.ffcs.crmd.platform.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.vo.RetVo;

/**
 * 
 * 功能说明: SpringMVC 应用Controler基类
 *
 * 
 *
 *
 *       版本号 | 作者 | 修改时间 | 修改内容
 *
 */
public abstract class AbstractController {
    
    protected ILogger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 拦截请求异常
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    public RetVo exception(HttpServletRequest request, Exception e) {
        
        logger.error(this.getClass() + "发生异常。", e);
        // TODO 添加异常处理逻辑，如日志记录
        
        RetVo retVo;
        if (e instanceof BaseAppException) {
        	retVo = RetVo.newInstance(false, (BaseAppException)e);
        } else {
        	// 非业务异常，统一转换成系统异常
        	// TODO 底层异常的转换，暂未考虑清楚
        	BaseAppException ex = ExceptionUtils.transEx(e);
        	logger.error("系统内部异常", ex);
        	retVo = RetVo.newInstance(false, ex);
        }

        request.setAttribute("exceptionRetVo", retVo);
        
        // 返回异常VIEW显示
        return retVo;
    }
}
