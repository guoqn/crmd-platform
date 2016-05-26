package com.ffcs.crmd.platform.pub.interfaces.log.impl;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.data.dao.impl.CrmBaseDaoImpl;
import com.ffcs.crmd.platform.data.entity.ICrmBaseEntity;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import org.springframework.stereotype.Component;

/**
 * Created by linzhiqiang on 16/4/30.
 */
@Component
public class DbInterfLoggerAppender extends AbstractInterfLoggerAppender {
    private ILogger logger = LoggerFactory.getLogger(this.getClass());
    private ICrmBaseDao dao = ApplicationContextUtil.getBean("crmBaseDao");

    @Override
    public String getAppenderType() {
        return "db";
    }

    @Override
    public void saveLog(IInterfLog log, IMsgContext context) {
        if (!(log instanceof BaseEntity)) {
            ExceptionUtils.throwEx(new RtManagerException("log must implement BaseEntity"));
        }
        dao.insert((BaseEntity) log);
    }
}
