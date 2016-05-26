package com.ffcs.crmd.platform.pub.dats;

import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by linzhiqiang on 16/5/7.
 */
public class DataServiceSwitchServlet extends HttpServlet {

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

        String switchStr = req.getParameter("switch");
        if (CrmStringUtils.isNullOrEmpty(switchStr)) {
            jsonStr =
                "{\"result\":\"fail\",\"message\":\"switch must not null\",\"currentSwitch\":\""
                    + DataServiceUtils.isOpenDataService() + "\"}";
        } else if (DataServiceUtils.isOpenDataService() == Boolean.valueOf(switchStr)) {
            jsonStr = "{\"result\":\"fail\",\"message\":\"switch do not need change to " + switchStr
                + "\",\"currentSwitch\":\"" + DataServiceUtils.isOpenDataService() + "\"}";
        } else {
            DataServiceUtils.setOpenDataService(Boolean.valueOf(switchStr));
            jsonStr = "{\"result\":\"success\",\"currentSwitch\":\"" + DataServiceUtils
                .isOpenDataService() + "\"}";
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
