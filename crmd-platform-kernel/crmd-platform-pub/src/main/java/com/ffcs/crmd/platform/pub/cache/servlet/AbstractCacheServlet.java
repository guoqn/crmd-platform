package com.ffcs.crmd.platform.pub.cache.servlet;

import com.ctg.itrdc.platform.common.utils.json.JSONUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.cache.api.Cache;
import com.ffcs.crmd.platform.cache.api.CacheProvider;
import com.ffcs.crmd.platform.cache.api.CacheStatus;
import com.ffcs.crmd.platform.pub.vo.RetVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/31.
 */
public abstract class AbstractCacheServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    protected static final String CLEAR_REGION_NAME = "clear";

    protected static final String CLEAR_ALL = "clearAll";

    protected static final String QUERY_ALL_CACHE = "query";

    protected abstract String providerName();

    protected CacheProvider getCacheProvider() {
        return ApplicationContextUtil.getBean(providerName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        resp.setHeader("Cache-Control", "must-revalidate,no-cache,no-store");
        resp.setStatus(HttpServletResponse.SC_OK);

        RetVo retVo = new RetVo(true);

        String opType = req.getParameter("op");
        if (StringUtils.isNullOrEmpty(opType)) {
            retVo.setResult(false);
            retVo.setMsgTitle("操作类型为空");
        } else if (CLEAR_REGION_NAME.equals(opType)) {
            retVo = clearRegionName(req);
        } else if (CLEAR_ALL.equals(opType)) {
            retVo = clearAllCache(req);
        } else if (QUERY_ALL_CACHE.equals(opType)) {
            retVo = queryStatus(req);
        } else {
            retVo.setResult(false);
            retVo.setMsgTitle("操作类型未知");
        }

        final OutputStream output = resp.getOutputStream();
        try {
            output.write(JSONUtils.toJsonString(retVo).getBytes());
            output.flush();
        } finally {
            output.close();
        }
    }

    protected RetVo queryStatus(HttpServletRequest req) {
        CacheProvider cacheProvider = getCacheProvider();
        RetVo retVo = new RetVo(true);
        if (cacheProvider != null) {
            List<Cache> caches = cacheProvider.getAllCache();
            List<CacheStatus> allStatus = new ArrayList<CacheStatus>();
            for (Cache cache : caches) {
                allStatus.add(cache.status());
            }
            retVo.setDataList(allStatus);
        }
        return  retVo;
    }

    protected RetVo clearAllCache(HttpServletRequest req) {
        CacheProvider cacheProvider = getCacheProvider();
        RetVo retVo = new RetVo(true);
        if (cacheProvider != null) {
            List<Cache> caches = cacheProvider.getAllCache();
            for (Cache cache : caches) {
                cache.clear();
                retVo.addMsgTitle("清理缓存" + cache.status().getRegionName() + "完成");
            }
        }
        return  retVo;
    }

    protected RetVo clearRegionName(HttpServletRequest req) {
        String regionName = req.getParameter("region");
        RetVo retVo = new RetVo(true);
        if (StringUtils.isNullOrEmpty(regionName)) {
            retVo.setResult(false);
            retVo.setMsgTitle("region名称为空");
        }
        CacheProvider cacheProvider = getCacheProvider();
        if (cacheProvider != null) {
            Cache cache = cacheProvider.buildCache(regionName);
            if (cache != null) {
                cache.clear();
                retVo.setMsgTitle("清理缓存" + regionName + "完成");
            } else {
                retVo.setMsgTitle("缓存" + regionName + "未配置");
            }
        }

        return retVo;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
