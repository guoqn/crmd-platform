package com.ffcs.crmd.platform.pub.proxy.callframework.lmax;

import com.ctg.itrdc.platform.App;
import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.lmax.base.AbstractCommand;
import com.ffcs.crmd.platform.pub.proxy.CrmServiceHelper;
import com.ffcs.crmd.platform.pub.proxy.callframework.CallEntity;
import com.ffcs.crmd.platform.pub.proxy.callframework.IBatchCaller;
import com.ffcs.crmd.platform.pub.proxy.callframework.ReqBatchData;
import com.ffcs.crmd.platform.pub.proxy.callframework.ReqBatchResult;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public class ModCallCommand extends AbstractCommand {

    private IBatchCaller caller = ApplicationContextUtil.getBean("batchCallerProxy");
    private String           mod;
    private List<CallEntity> callEntitys;
    private CountDownLatch   latch;

    public ModCallCommand() {

    }

    public ModCallCommand(String mod, List<CallEntity> callEntitys, CountDownLatch latch) {
        this.mod = mod;
        this.callEntitys = callEntitys;
        this.latch = latch;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public void setCallEntitys(List<CallEntity> callEntitys) {
        this.callEntitys = callEntitys;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void execute(long sequence, boolean endOfBatch) throws Exception {
        try {
            List<ReqBatchData> reqs = new ArrayList<ReqBatchData>();
            //生成批量请求报文的body
            for (CallEntity entity : callEntitys) {
                ReqBatchData batchData = new ReqBatchData(entity.getUuid(), entity.getServiceName(),
                    entity.getMethodName(), entity.getSerialType(), entity.getArgs());
                reqs.add(batchData);
            }

            if (reqs != null) {
                List<ReqBatchResult> results = caller.batchCall(mod, reqs);
                //结果回填
                for (ReqBatchResult reqBatchResult : results) {
                    for (CallEntity entity : callEntitys) {
                        if (reqBatchResult.getUuid().equals(entity.getUuid())) {
                            entity.setReqResult(reqBatchResult.getReqResult());
                            break;
                        }
                    }
                }
            }

        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    @Override
    public void clear() {
        mod = null;
        latch = null;
    }
}
