package com.ffcs.crmd.platform.pub.utils.rwbalance.filter;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.utils.rwbalance.RwBalanceUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by linzhiqiang on 16/5/5.
 */
public class RwBalanceFilter implements Filter {
    private static final ILogger LOGGER = LoggerFactory.getLogger(RwBalanceFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            String uri = ((HttpServletRequest) servletRequest).getRequestURI();
            LOGGER.debug("uri:" + uri);
            if (RwBalanceUtils.isForceReadUrl(uri)) {
                CrmSessionContext.getContext().openForceReadFlag();
            } else if (!uri.endsWith(".jsp") && !uri.endsWith(".html") && !uri.endsWith(".htm")
                && !uri.endsWith(".png") && !uri.endsWith(".jpg")) {
                //如果当前请求的是界面,或者图片,则不做判断

                String url = ((HttpServletRequest) servletRequest).getRequestURL().toString();
                LOGGER.debug("url:" + url);
                //获取web的context路径
                String contextPath = url.substring(0, url.indexOf(uri));
                LOGGER.debug("contextPath:" + contextPath);
                //获取原始路径
                String orignUrl = ((HttpServletRequest) servletRequest).getHeader("Referer");
                LOGGER.debug("orignUrl:" + orignUrl);

                if (!CrmStringUtils.isNullOrEmpty(orignUrl)) {
                    String orignUri = orignUrl.substring(contextPath.length(), orignUrl.length());
                    LOGGER.debug("orignUri:" + orignUri);

                    if (RwBalanceUtils.isForceReadUrl(orignUri)) {
                        CrmSessionContext.getContext().openForceReadFlag();
                    }
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
