package com.ffcs.crmd.platform.pub.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * Created by linzhiqiang on 16/3/12.
 */
public abstract class AbstractPoolObjectFactory<T> implements PooledObjectFactory<T> {

    @Override
    public PooledObject<T> makeObject() throws Exception {
        T t = createObject();
        return new DefaultPooledObject<T>(t);
    }

    /**
     * 创建对象
     * @return
     */
    public abstract T createObject();

    @Override
    public abstract void destroyObject(PooledObject<T> pooledObject) throws Exception;

    @Override
    public boolean validateObject(PooledObject<T> pooledObject) {
        return true;
    }

    @Override
    public abstract void activateObject(PooledObject<T> pooledObject) throws Exception;

    @Override
    public void passivateObject(PooledObject<T> pooledObject) throws Exception {

    }

}
