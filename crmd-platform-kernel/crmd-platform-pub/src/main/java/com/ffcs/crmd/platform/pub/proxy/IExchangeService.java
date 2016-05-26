package com.ffcs.crmd.platform.pub.proxy;

import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.bean.ReqResult;

/**
 * 
 * 前后端交互统一服务.
 * 
 * @版权：福富软件 版权所有 (c) 2011
 * @author linzq
 * @version Revision 1.0.0
 * @see:
 * @创建日期： 2015年10月22日
 * @功能说明：
 */
public interface IExchangeService {
    /**
     * 
     * 方法功能:
     *  统一交互入口.
     * @param reqData
     * @param serialType
     * @return
     * @author: linzq
     * @修改记录： 
     * ==============================================================<br>
     * 日期:2015年10月22日 linzq 创建方法，并实现其功能
     * ==============================================================<br>
     */
    public ReqResult exchange(ReqData reqData, String serialType);
}
