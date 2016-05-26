package com.ffcs.crmd.platform.data.cache;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.data.dao.ICrmBaseDao;
import com.ffcs.crmd.platform.data.entity.impl.CrmBaseEntityImpl;
import com.ffcs.crmd.platform.pub.cache.context.entt.EnttCacheContext;
import com.ffcs.crmd.platform.cache.api.utils.CacheUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linzhiqiang on 16/3/29.
 */
@Component("crmCacheEnttService")
public class CrmCacheEnttServiceImpl implements ICrmCacheEntityService {

    protected ILogger logger = LoggerFactory.getLogger(CrmCacheEnttServiceImpl.class);

    @Override
    public void putObject(Serializable Id, Object object) {
        String key = CacheUtils.generateKey(object.getClass().getName(), Id);
        logger.debug("put to cache : " + key);

        EnttCacheContext.getInstance().putEnttToCache(object.getClass().getName(), key,
            (Serializable) object);
    }

    @Override
    public <T> T getObject(Serializable Id, Class<T> classType) {
        String key = CacheUtils.generateKey(classType.getName(), Id);
        logger.debug("get from cache " + key);

        Object o = EnttCacheContext.getInstance().getEnttFromCache(key, classType);
        if (o != null) {
            return (T) o;
        }
        return null;
    }

    @Override
    public <T> void removeObject(Serializable Id, Class<T> classType) {
        String key = CacheUtils.generateKey(classType.getName(), Id);
        logger.debug("remove from cache " + key);
        EnttCacheContext.getInstance().removeEnttFromCache(classType.getName(), key, null);
    }

    @Override
    public <T> void putObjectList(Class<?> classType, String sql, List<Object> params, List<T> objs) {
        String key = CacheUtils.generateKey(classType.getName(), sql, params);
        logger.debug("put list to cache " + key);

        if (objs != null && objs.size() > 0 && objs.get(0) instanceof CrmBaseEntityImpl) {
            List<Serializable> ids = new ArrayList<Serializable>();
            for (Object entity : objs) {
                ids.add(((CrmBaseEntityImpl) entity).getId());
            }
            EnttCacheContext.getInstance().putEnttToCache(classType.getName(), key,
                (Serializable) ids);
        } else {
            EnttCacheContext.getInstance().putEnttToCache(classType.getName(), key,
                (Serializable) objs);
        }

    }

    @Override
    public <T> List<T> getObjectList(Class<T> classType, String sql, List<Object> params,ICrmBaseDao dao) {
        String key = CacheUtils.generateKey(classType.getName(), sql, params);
        logger.debug("get list from cache " + key);

        if (CrmBaseEntityImpl.class.isAssignableFrom(classType)) {
            List<Serializable> ids = (List<Serializable>) EnttCacheContext.getInstance()
                .getEnttFromCache(key,classType);
            if (ids == null) {
                return null;
            }
            if (ids != null && ids.size() <= 0) {
                return new ArrayList<T>();
            }
            List<T> entitys = new ArrayList<T>();
            for (Serializable id : ids) {
                CrmBaseEntityImpl entity = null;
                try {
                    entity = (CrmBaseEntityImpl) classType.newInstance();
                    entity.setId(id);
                    CrmBaseEntityImpl actualEntity = (CrmBaseEntityImpl) dao.selectByPrimaryKey(entity);
                    entitys.add((T) actualEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                    entitys.add(null);
                }
            }
            return entitys;
        } else {
            return (List<T>) EnttCacheContext.getInstance()
                .getEnttFromCache(key,classType);
        }
    }
}
