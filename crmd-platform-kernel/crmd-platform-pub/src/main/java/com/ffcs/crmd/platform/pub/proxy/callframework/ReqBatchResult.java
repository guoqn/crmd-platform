package com.ffcs.crmd.platform.pub.proxy.callframework;

import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.bean.ReqResult;

import java.io.Serializable;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public class ReqBatchResult implements Serializable {
    private String uuid;

    private ReqResult reqResult;

    public ReqBatchResult(ReqResult reqResult, String uuid) {
        this.reqResult = reqResult;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ReqResult getReqResult() {
        return reqResult;
    }

    public void setReqResult(ReqResult reqResult) {
        this.reqResult = reqResult;
    }
}
