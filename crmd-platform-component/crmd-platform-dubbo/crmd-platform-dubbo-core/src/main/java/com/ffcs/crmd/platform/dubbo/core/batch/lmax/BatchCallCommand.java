package com.ffcs.crmd.platform.dubbo.core.batch.lmax;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.lmax.base.AbstractCommand;
import com.ffcs.crmd.platform.pub.proxy.IExchangeService;
import com.ffcs.crmd.platform.pub.proxy.callframework.ReqBatchResult;

import java.util.concurrent.CountDownLatch;

/**
 * Created by linzhiqiang on 16/3/8.
 */
public class BatchCallCommand extends AbstractCommand {
    private transient static final ILogger LOGGER = LoggerFactory.getLogger(BatchCallCommand.class);
    private CountDownLatch latch;
    private ReqData        reqData;
    private String         serialType;
    private ReqBatchResult reqBatchResult;

    public BatchCallCommand() {

    }

    public BatchCallCommand(CountDownLatch latch, ReqData reqData, String serialType,
        ReqBatchResult reqBatchResult) {
        this.latch = latch;
        this.reqData = reqData;
        this.serialType = serialType;
        this.reqBatchResult = reqBatchResult;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public void setReqData(ReqData reqData) {
        this.reqData = reqData;
    }

    public void setSerialType(String serialType) {
        this.serialType = serialType;
    }

    public void setReqBatchResult(ReqBatchResult reqBatchResult) {
        this.reqBatchResult = reqBatchResult;
    }

    @Override
    public void execute(long sequence, boolean endOfBatch) throws Exception {
        try {
            IExchangeService exchangeService = ApplicationContextUtil.getBean("exchangeService");
            if (reqData == null || serialType == null || reqBatchResult == null) {
                LOGGER.error("args error!");
                return;
            }
            ReqResult reqResult = exchangeService.exchange(reqData, serialType);
            reqBatchResult.setReqResult(reqResult);
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    @Override
    public void clear() {
        latch = null;
        reqBatchResult = null;
        reqData = null;
        serialType = null;
    }
}
