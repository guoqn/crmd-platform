package com.ffcs.crmd.platform.meta.daaction.interceptor.pool;

import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.impl.DaInterceptorChainImpl;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorManager;
import com.ffcs.crmd.platform.pub.pool.AbstractPoolObjectFactory;
import org.apache.commons.pool2.PooledObject;

/**
 * Created by linzq on 2016/1/18.
 */
public class DaInterceptorChainPoolObjectFactory extends AbstractPoolObjectFactory<DaInterceptorChain> {

    @Override
    public DaInterceptorChain createObject() {
        return new DaInterceptorChainImpl(DaInterceptorManager.getInstance().getInterceptorList());
    }

    @Override
    public void destroyObject(PooledObject<DaInterceptorChain> pooledObject) throws Exception {

    }

    @Override
    public void activateObject(PooledObject<DaInterceptorChain> pooledObject) throws Exception {
        DaInterceptorChain chain = pooledObject.getObject();
        chain.reset();
    }

}
