package com.ffcs.crmd.platform.pub;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.sql.SQLUtils;
import com.ffcs.crmd.platform.pub.utils.sql.Dialect;
import com.ffcs.crmd.platform.pub.utils.sql.translater.SqlTranslaterUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by linzhiqiang on 16/2/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath*:conf/spring/test-applicationContext.xml"})
public class SqlTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testMysql() {
        String sql = "select cust_id,Cust_name from cust";
        System.out.println(PagerUtils.count(sql, Dialect.MYSQL.dialect()));
        System.out.println(PagerUtils.limit(sql,Dialect.MYSQL.dialect(),1,20));
        System.out.println(SQLUtils.format(sql,Dialect.MYSQL.dialect()));
    }

    @Test
    public void testOracle() {
        String sql = "select cust_id,Cust_name from cust";
        System.out.println(PagerUtils.count(sql, Dialect.ORACLE.dialect()));
        System.out.println(PagerUtils.limit(sql,Dialect.ORACLE.dialect(),1,20));
    }

    @Test
    public void testSubString() {
        System.out.println("ssfffddd".substring(3));
        System.out.println("ssfffddd".substring(0,3));
        System.out.println("ssfefddd".indexOf("f"));
        System.out.println("ssfefddd".charAt(2));
    }

    @Test
    public void testMatcher() {
        String sql = "select char_lenGth('test')";
        String sql2 = "select char_leNGth('test') from dual";
        String sql3 = "select char_leNGth(char_lenGth('test2')) from dual";
        String sql4 = "select datediff('test',char_lenGth('test2'))";
        String sql5 = "select locate('ssssss','aaa')";
        String sql6 = "/*sqlb*//*mysqlb*/select 1/*mysqle*//*oracleb*/select 2/*oraclee*//*sqle*/";

        System.out.println(SqlTranslaterUtil.translateSql(sql));
        System.out.println(SqlTranslaterUtil.translateSql(sql2));
        System.out.println(SqlTranslaterUtil.translateSql(sql3));
        System.out.println(SqlTranslaterUtil.translateSql(sql4));
        System.out.println(SqlTranslaterUtil.translateSql(sql5));
        System.out.println(SqlTranslaterUtil.translateSql(sql6));

    }

    @Test
    public void testClassPathLoaderProp() throws IOException {
        ClassPathResource resource = new ClassPathResource("dialect.properties");
        Properties defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
        System.out.println(defaultStrategies);
    }

}
