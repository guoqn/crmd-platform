package com.ffcs.crmd.platform.mq.impl;

import java.io.IOException;
import java.util.Properties;

import com.ffcs.crmd.platform.mq.MqException;
import com.ffcs.crmd.platform.mq.query.api.IQuery;
import com.ffcs.crmd.platform.mq.query.impl.QueryImpl;
import com.ffcs.crmd.platform.mq.util.PropertiesUtil;

public class QueryDefined {
    private QueryImpl query;
    
    public void init() throws MqException {
        Properties properties = null;
        try {
            properties = PropertiesUtil.getInstance().load("crm-mq.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        query = new QueryImpl();
        query.setNameSrv(properties.getProperty("namesrvAddr"));
        query.setAuthID(properties.getProperty("authID"));
        query.setAuthPWD(properties.getProperty("authPWD"));
        query.init();
    }
    
    public IQuery getQuery() throws MqException {
        return query;
    }
    
    public void close() throws MqException {
        query.close();
    }
}
