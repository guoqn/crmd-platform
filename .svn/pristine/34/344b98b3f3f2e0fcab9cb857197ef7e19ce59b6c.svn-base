package com.ffcs.crmd.platform.ddl.core;

import java.util.List;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.utils.sql.Dialect;
import com.ffcs.crmd.platform.pub.utils.sql.DialectUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.pub.container.BeanLoader;
import com.ctg.udal.ddl.api.IDdlService;
import com.ffcs.crmd.platform.ddl.api.ICrmSeqService;

@Service("defaultCrmSeqService")
public class DefaultCrmSeqService implements ICrmSeqService {

    private JdbcTemplate jdbcTemplate = ApplicationContextUtil.getBean("jdbcTemplate");
//    private IDdlService ddlService;
    
    public DefaultCrmSeqService() {
//        ddlService = BeanLoader.getBean(IDdlService.class);
//        if (ddlService == null) {
//            throw new RtManagerException("ddlService未配置，请确认");
//        }
    }
    
    @Override
    public Long getSeq(String seqName) {
        Long id = jdbcTemplate.queryForObject(getSql(seqName),Long.class);
        return id;
    }
    
    @Override
    public List<Long> getSeqBatch(String seqName, int size) {
        ExceptionUtils.throwEx(new RtManagerException("not support"));
        return null;
    }

    private String getSql(String seqName) {
        String sql = "";

        if (Dialect.ORACLE.dialect().equals(DialectUtils.getDialect().dialect())) {
            sql = "select %s.nextval from dual".replaceFirst("%s",seqName);
        } else if (Dialect.MYSQL.dialect().equals(DialectUtils.getDialect().dialect())) {
            sql = "select %s.nextval from g_seq".replaceFirst("%s",seqName);
        }
        return sql;
    }
    
}
