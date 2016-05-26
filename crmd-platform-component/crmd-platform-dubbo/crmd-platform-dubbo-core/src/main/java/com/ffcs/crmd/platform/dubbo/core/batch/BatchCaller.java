package com.ffcs.crmd.platform.dubbo.core.batch;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.pub.bean.HeadInfo;
import com.ctg.itrdc.platform.pub.bean.ReqData;
import com.ctg.itrdc.platform.pub.constant.BaseUnitConstants;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ffcs.crmd.lmax.base.AbstractCommand;
import com.ffcs.crmd.lmax.base.Producers;
import com.ffcs.crmd.lmax.base.TransEventProducer;
import com.ffcs.crmd.lmax.pool.CommandPoolUtils;
import com.ffcs.crmd.platform.dubbo.core.batch.lmax.BatchCallCommand;
import com.ffcs.crmd.platform.pub.proxy.callframework.IBatchCaller;
import com.ffcs.crmd.platform.pub.proxy.callframework.ReqBatchData;
import com.ffcs.crmd.platform.pub.proxy.callframework.ReqBatchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by linzhiqiang on 16/3/8.
 */
@Service("batchCaller")
public class BatchCaller implements IBatchCaller {

    private static final ILogger LOGGER = LoggerFactory.getLogger(BatchCaller.class);

    private TransEventProducer producer = Producers.getProducer("remote", "remoteService");

    @Override
    public List<ReqBatchResult> batchCall(String mod, List<ReqBatchData> datas) {

        HeadInfo headInfo = (HeadInfo) SessionContext
            .getObject4TreadLocal(BaseUnitConstants.REQ_HEAD);
        CountDownLatch latch = new CountDownLatch(datas.size());
        List<ReqBatchResult> list = new ArrayList<ReqBatchResult>();
        for (ReqBatchData data : datas) {
            ReqData reqData = new ReqData();
            reqData.setHeadInfo(headInfo);
            reqData.setServiceName(data.getServiceName());
            reqData.setMethod(data.getMethodName());
            reqData.setArgs(data.getArgs());
            ReqBatchResult batchResult = new ReqBatchResult(null, data.getUuid());

            BatchCallCommand command = CommandPoolUtils.getCommand(BatchCallCommand.class);
            command.setLatch(latch);
            command.setReqData(reqData);
            command.setSerialType(data.getSerialType());
            command.setReqBatchResult(batchResult);
            producer.produce(command);
            list.add(batchResult);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            LOGGER.error("latch await err", e);
        }

        return list;
    }
}
