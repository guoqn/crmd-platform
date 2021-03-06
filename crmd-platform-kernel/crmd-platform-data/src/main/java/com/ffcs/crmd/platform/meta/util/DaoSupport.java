package com.ffcs.crmd.platform.meta.util;

import com.ctg.itrdc.platform.data.jdbctemplate.ItrdcJdbcTemplate;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by linzq on 2016/1/20.
 */
public class DaoSupport {
    private static JdbcTemplate jdbcTemplate = ApplicationContextUtil.getBean("jdbcTemplate");

    public static List<Map<String,Object>> jdbcFindMapList(String sql,List<Object> params) {
        return jdbcTemplate.queryForList(sql,params.toArray());
    }

    public static int excuteUpate(String sql,List<Object> params) {
        return jdbcTemplate.update(sql,params.toArray());
    }
}
