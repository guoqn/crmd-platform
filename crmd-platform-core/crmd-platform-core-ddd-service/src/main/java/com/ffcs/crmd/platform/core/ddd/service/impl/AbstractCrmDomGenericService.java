package com.ffcs.crmd.platform.core.ddd.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.ICrmDomBaseRepository;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.core.ddd.service.ICrmDomGenericService;

public abstract class AbstractCrmDomGenericService<T extends AbstractCrmDomBaseEntityImpl, ID extends Serializable>
    implements ICrmDomGenericService<T, ID> {

    protected ILogger logger = LoggerFactory.getLogger(this.getClass());
    protected final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractCrmDomGenericService() {
        Class<?> clazz = getClass();
        //升级spring3.2.13 ，增加后缀。
        if (getClass().getSimpleName().indexOf("$$EnhancerByCGLIB$$") != -1
            || getClass().getSimpleName().indexOf("$$EnhancerBySpringCGLIB$$") != -1) {
            clazz = clazz.getSuperclass();
        }
        this.entityClass = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass())
            .getActualTypeArguments()[0];
    }

    //    @Autowired
    //    @Qualifier("defaultRepository")
    //    private IBaseRepository defaultRepository;

    public ICrmDomBaseRepository getDefaultRepository() {
        return RepositoryRegister.getInstance().getDefaultRepository();
    }

    @Override
    public int save(T t) {
        return t.save();
    }

    @Override
    public int remove(T t) {
        return t.remove();
    }

    @Override
    public int update(T t) {
        return t.update();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(ID id) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.getById(id);
    }

    /**
     * 根据框架生成查询语句，尽量少用
     */
    @Override
    public List<T> listAll() {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.queryAll();
    }

    /**
     * 根据框架生成查询语句，尽量少用
     */
    @Override
    public List<T> listByMap(Map<String, Object> map) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.queryByMap(map);
    }

    /**
     * 根据框架生成查询语句，尽量少用
     */
    @Override
    public PageInfo findPageInfoByMap(Map<String, Object> map, int page, int pageSize) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.queryPageInfoByMap(map, page, pageSize);
    }

    @Override
    public T get(ID id, boolean isCache) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.getById(id, isCache);
    }

    @Override
    public List<T> listAll(boolean isCache) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.queryAll(isCache);
    }

    @Override
    public List<T> listByMap(Map<String, Object> map, boolean isCache) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.queryByMap(map, isCache);
    }

    @Override
    public PageInfo findPageInfoByMap(Map<String, Object> map, int page, int pageSize,
        boolean isCache) {
        ICrmDomBaseRepository<T, ID> rep = RepositoryRegister.getInstance().getRepository(entityClass);
        return rep.queryPageInfoByMap(map, page, pageSize, isCache);
    }

    /**
     * @param id
     * @param shardingId
     * @return
     */
    public T getByIdAndShardingId(ID id, Long shardingId) {
        ICrmDomBaseRepository<T, ID> rep = (ICrmDomBaseRepository<T, ID>) RepositoryRegister
            .getInstance().getRepository(entityClass);
        return rep.getByIdAndShardingId(id, shardingId);
    }
}
