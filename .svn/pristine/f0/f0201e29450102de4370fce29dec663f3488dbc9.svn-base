package com.ffcs.crmd.platform.pub.interfaces;

import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.filter.FilterRetObject;
import com.ffcs.crmd.platform.pub.interfaces.filter.impl.server.AbstractServerPostFilter;
import com.ffcs.crmd.platform.pub.interfaces.filter.impl.server.AbstractServerPreFilter;
import com.ffcs.crmd.platform.pub.interfaces.handle.AbstractInterfHandler;
import org.springframework.stereotype.Component;

/**
 * Created by linzhiqiang on 16/5/4.
 */
@Component
public class DefaultPostFilter extends AbstractServerPostFilter {
    @Override
    protected FilterRetObject doFilter(IMsgContext contect, AbstractInterfHandler handler) {
        System.out.println("testDefaultPost");
        return null;
    }

    @Override
    public String getRequester() {
        return "";
    }

    @Override
    public String getResponder() {
        return "";
    }

    @Override
    public String getExtraKey() {
        return "";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
