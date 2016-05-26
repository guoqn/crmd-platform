package com.ffcs.crmd.platform.idempotency.api.factory;

import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.idempotency.api.service.IIdempotencyDataService;

/**
 * 
 * 幂等性数据操作服务工厂类.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author chenye
 * @version Revision 1.0.0
 * @see:
 * @创建日期：2015年12月16日
 * @功能说明：
 *
 */
public class IdempotencyDataServiceFactory {
    
    /**
     * 幂等性组件数据处理服务
     */
    private final static String           DATA_SERVICE = "idempotencyDataService";
    
    public static IIdempotencyDataService emptyService = new IIdempotencyDataService() {
                                                           
                                                           @Override
                                                           public boolean isSysWorkRunning() {
                                                               // TODO Auto-generated method stub
                                                               return false;
                                                           }
                                                           
                                                           @Override
                                                           public int insert(BaseEntity<?> entity) {
                                                               // TODO Auto-generated method stub
                                                               return 0;
                                                           }
                                                           
                                                           @Override
                                                           public int updateByPrimaryKey(
                                                               BaseEntity<?> entity) {
                                                               // TODO Auto-generated method stub
                                                               return 0;
                                                           }
                                                           
                                                           @Override
                                                           public int deleteByPrimaryKey(
                                                               BaseEntity<?> entity) {
                                                               // TODO Auto-generated method stub
                                                               return 0;
                                                           }
                                                           
                                                           @Override
                                                           public int updateSelectiveByPrimaryKey(
                                                               BaseEntity<?> entity) {
                                                               // TODO Auto-generated method stub
                                                               return 0;
                                                           }
                                                           
                                                       };
    
    /**
     * 
     * 获取幂等性数据操作服务.
     * 
     * @return
     */
    public static IIdempotencyDataService getIdempotencyDataService() {
        if (ApplicationContextUtil.containsBean(IdempotencyDataServiceFactory.DATA_SERVICE)) {
            return ApplicationContextUtil.getBean(IdempotencyDataServiceFactory.DATA_SERVICE);
        } else {
            return emptyService;
        }
    }
    
}
