package com.ffcs.crmd.platform.data.entity.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ffcs.crmd.platform.data.entity.ICrmBaseEntity;
import com.ffcs.crmd.platform.data.utils.CrmEntityUtils;

import javax.persistence.Column;

/**
 * CRM-平台,DAO模式基类 .
 *
 * @版权：福富软件 版权所有 (c) 2011
 * @author linzq
 * @version Revision 1.0.0
 * @see: @创建日期： 2015年10月20日 @功能说明：
 */
public abstract class CrmBaseEntityImpl<ID extends Serializable> extends BaseEntity<ID>
    implements ICrmBaseEntity<ID>,Serializable {

    public CrmBaseEntityImpl() {
        super();
    }

    public CrmBaseEntityImpl(boolean genId) {
        super();
        String seq = CrmEntityUtils.getGlobalSeqName(this);
        Long id = CrmEntityUtils.getSeq(seq);
        setId((ID) id);
    }

}
