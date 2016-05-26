package com.ffcs.crmd.platform.pub.proxy.callframework.pool;

import com.ffcs.crmd.platform.pub.pool.AbstractPoolObjectFactory;
import com.ffcs.crmd.platform.pub.proxy.callframework.ICallContext;
import com.ffcs.crmd.platform.pub.proxy.callframework.impl.DefaultCallContext;
import org.apache.commons.pool2.PooledObject;

/**
 * Created by linzhiqiang on 16/3/7.
 */
public class CallContextPoolObjectFactory extends AbstractPoolObjectFactory<ICallContext> {

    @Override
    public ICallContext createObject() {
        return new DefaultCallContext();
    }

    @Override
    public void destroyObject(PooledObject<ICallContext> pooledObject) throws Exception {

    }


    @Override
    public void activateObject(PooledObject<ICallContext> pooledObject) throws Exception {
        if (pooledObject.getObject() != null) {
            pooledObject.getObject().reset();
        }
    }

}
