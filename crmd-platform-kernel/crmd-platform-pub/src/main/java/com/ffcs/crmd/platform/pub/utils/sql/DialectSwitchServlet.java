package com.ffcs.crmd.platform.pub.utils.sql;

import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import com.ffcs.crmd.platform.pub.dats.DataServiceUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by linzhiqiang on 16/5/7.
 */
public class DialectSwitchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String jsonStr = "";
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        String dialectStr = req.getParameter("dialect");
        Dialect dialect = Dialect.getDialect(dialectStr);
        if (CrmStringUtils.isNullOrEmpty(dialectStr)) {
            jsonStr = "{\"result\":\"fail\",\"message\":\"dialect must not null\","
                + "\"currentDialect\":\"" + DialectUtils.getDialect().dialect() + "\"}";
        }
        if (dialect == null) {
            jsonStr = "{\"result\":\"fail\",\"message\":\"dialect is not suite\","
                + "\"currentDialect\":\"" + DialectUtils.getDialect().dialect() + "\"}";
        } else if (DialectUtils.getDialect().equals(dialect)) {
            jsonStr = "{\"result\":\"fail\",\"message\":\"dialect not need change to " + dialectStr
                + "\"," + "\"currentDialect\":\"" + DialectUtils.getDialect().dialect() + "\"}";
        } else {
            DialectUtils.setDialect(dialect);
            jsonStr = "{\"result\":\"success\",\"currentDialect\":\"" + DialectUtils.getDialect()
                .dialect() + "\"}";
        }
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            out.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
