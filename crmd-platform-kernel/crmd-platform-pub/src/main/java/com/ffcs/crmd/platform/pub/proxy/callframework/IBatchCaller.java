package com.ffcs.crmd.platform.pub.proxy.callframework;

import java.util.List;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public interface IBatchCaller {

    public List<ReqBatchResult> batchCall(String mod,List<ReqBatchData> datas);

}
