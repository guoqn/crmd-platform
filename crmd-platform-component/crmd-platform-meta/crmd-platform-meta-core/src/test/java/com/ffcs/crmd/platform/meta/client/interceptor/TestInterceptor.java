package com.ffcs.crmd.platform.meta.client.interceptor;

import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorChain;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorContext;
import com.ffcs.crmd.platform.meta.daaction.interceptor.DaInterceptorManager;
import com.ffcs.crmd.platform.meta.daaction.interceptor.impl.DaInterceptorChainFactory;
import org.junit.Test;

/**
 * Created by linzq on 2016/1/17.
 */
public class TestInterceptor {
    @Test
    public void testInterceptor() {
        new TestSaveInterceptor();
        new TestUpdateInterceptor();
        new TestDeleteInterceptor();

        Long begin = System.nanoTime();
        DaInterceptorManager.getInstance().getInterceptorList();
        System.out.println(System.nanoTime() - begin);
        begin = System.nanoTime();
        DaInterceptorChain chain = DaInterceptorChainFactory.createChain();
        System.out.println(System.nanoTime() - begin);
        DaInterceptorChainFactory.returnChain(chain);
        begin = System.nanoTime();
        chain = DaInterceptorChainFactory.createChain();
        System.out.println(System.nanoTime() - begin);
        System.out.println(chain.onSave(new DaInterceptorContext(), null));
        DaInterceptorChainFactory.returnChain(chain);
        chain = DaInterceptorChainFactory.createChain();
        System.out.println(chain.onUpdate(new DaInterceptorContext(), null));
        DaInterceptorChainFactory.returnChain(chain);
        chain = DaInterceptorChainFactory.createChain();
        System.out.println(chain.onDelete(new DaInterceptorContext(), null));
        DaInterceptorChainFactory.returnChain(chain);

    }
}
