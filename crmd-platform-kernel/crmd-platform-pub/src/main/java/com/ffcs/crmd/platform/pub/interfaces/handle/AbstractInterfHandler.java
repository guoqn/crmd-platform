package com.ffcs.crmd.platform.pub.interfaces.handle;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ffcs.crmd.platform.pub.interfaces.async.AsyncTaskFactory;
import com.ffcs.crmd.platform.pub.interfaces.config.IInterfConfigure;
import com.ffcs.crmd.platform.pub.interfaces.context.DefaultMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.context.IMsgContext;
import com.ffcs.crmd.platform.pub.interfaces.entity.RequestParam;
import com.ffcs.crmd.platform.pub.interfaces.entity.RetObject;
import com.ffcs.crmd.platform.pub.interfaces.log.IInterfLog;
import com.ffcs.crmd.platform.pub.interfaces.log.LogLevel;
import com.ffcs.crmd.platform.pub.interfaces.log.impl.InterfLoggerFactory;
import com.ffcs.crmd.platform.pub.interfaces.thread.ThreadPoolFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by linzhiqiang on 16/4/27.
 */
public abstract class AbstractInterfHandler
    implements IInterfHandler, IProcessHandler, ILogHandler {

    protected ILogger logger = LoggerFactory.getLogger(this.getClass());

    public AbstractInterfHandler() {
        InterfHandleManager.getInstance()
            .registerHandler(getRequester(), getResponder(), getExtraKey(), this);
    }

    @Override
    public abstract String getExtraKey();

    @Override
    public abstract String getResponder();

    @Override
    public abstract String getRequester();

    @Override
    public String handle(String request, RequestParam param) {
        IMsgContext context = initContext(request, param);
        String respondMsg = "";

        try {
            preHandle(context);
            saveBeforeLog(context);
            //是否异步处理,是,调用异步处理方法,不是,调用同步处理的方法
            if (getConfigure().isAsync(this)) {
                respondMsg = asyncCall(context);
            } else {
                respondMsg = syncCall(context);
            }
        } finally {
            fillRespond(respondMsg,context);
            try {
                saveAfterLog(context);
            } finally {
                postHandle(context);
            }
        }
        return respondMsg;
    }

    /**
     * 异步调用
     * @param context
     * @return
     */
    private String asyncCall(IMsgContext context) {
        FutureTask<String> futureTask = AsyncTaskFactory
            .commitAsyncTask(getConfigure(), this, context);
        Long timeOut = getConfigure().getTimeOut(this);
        String respondMsg = "";

        try {
            if (timeOut == -1L) {
                respondMsg = futureTask.get();
            } else {
                respondMsg = futureTask.get(timeOut, TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException e) {
            respondMsg = createOtherExcetionRespon(e, context);
        } catch (ExecutionException e) {
            respondMsg = createOtherExcetionRespon(e, context);
        } catch (TimeoutException e) {
            context.setTimeOut(true);
            respondMsg = createTimeOutExcetionRespon(e, context);
        }
        return respondMsg;
    }

    /**
     * 同步调用
     * @param context
     * @return
     */
    private String syncCall(IMsgContext context) {
        return actualCall(context);
    }

    private String createOtherExcetionRespon(Exception e, IMsgContext context) {
        context.addException(e);
        return doCreateOtherExcetionRespon(e, context);
    }

    protected abstract String doCreateOtherExcetionRespon(Exception e, IMsgContext context);

    private String createTimeOutExcetionRespon(Exception e, IMsgContext context) {
        context.addException(e);
        return doCreateTimeOutExcetionRespon(e, context);
    }

    protected abstract String doCreateTimeOutExcetionRespon(Exception e, IMsgContext context);

    @Override
    public IMsgContext initContext(String request, RequestParam param) {
        IMsgContext context = buildeContext(request, param);
        context = fillRequest(request, param, context);
        return context;
    }

    /**
     * 创建Context对象
     * @param request
     * @param param
     * @return
     */
    protected IMsgContext buildeContext(String request, RequestParam param) {
        DefaultMsgContext msgContext = new DefaultMsgContext();
        return msgContext;
    }

    /**
     * 填充request信息
     * @param request
     * @param param
     *@param context  @return
     */
    protected IMsgContext fillRequest(String request, RequestParam param, IMsgContext context) {
        context.setRequestMsg(request);
        context.setRequestParam(param);
        return context;
    }

    @Override
    public RetObject preHandle(IMsgContext context) {
        return new RetObject();
    }

    @Override
    public RetObject beforeHandle(IMsgContext context) {
        return new RetObject();
    }

    @Override
    public RetObject afterHandle(IMsgContext context) {
        return new RetObject();
    }

    @Override
    public RetObject postHandle(IMsgContext context) {
        return new RetObject();
    }

    @Override
    public abstract String doHandle(IMsgContext context);

    @Override
    public abstract String doMockHandle(IMsgContext context);

    protected String busiHandle(IMsgContext context) {
        if (getConfigure().isNeedMock(this)) {
            return doMockHandle(context);
        } else {
            return doHandle(context);
        }
    }

    public String actualCall(IMsgContext context) {
        String respondMsg = "";
        try {
            beforeHandle(context);
            respondMsg = busiHandle(context);
        } catch (Exception e) {
            respondMsg = createOtherExcetionRespon(e, context);
        } finally {
            afterHandle(context);
        }
        return respondMsg;
    }

    /**
     * 填充respond信息
     * @param respond
     *@param context  @return
     */
    protected IMsgContext fillRespond(String respond, IMsgContext context) {
        context.setRequestMsg(respond);
        return context;
    }

    @Override
    public abstract IInterfLog createBeforeLog(IMsgContext context);

    @Override
    public abstract IInterfLog createAfterLog(IMsgContext context);

    /**
     * 调用前保存日志
     * @param context
     */
    protected void saveBeforeLog(IMsgContext context) {
        LogLevel level = getConfigure().getBeforeLogLevel(this);
        if (LogLevel.OFF.equals(level)) {

        } else if (LogLevel.SYNC.equals(level)) {
            syncBeforeLog(context);
        } else if (LogLevel.ASYNC.equals(level)) {
            asyncAfterLog(context);
        }
    }

    /**
     * 同步记录日志
     * @param context
     */
    protected void syncBeforeLog(IMsgContext context) {
        actualBeforeLog(context);
    }

    /**
     * 异步记录日志
     * @param context
     */
    protected void asyncBeforeLog(IMsgContext context) {
        try {
            ThreadPoolFactory.commitAsyncLog(getConfigure(), this, this, context, "before");
        } catch (Exception e) {
            //异步日志异常,不作处理
            logger.error("before log error.", e);
        }
    }

    public void actualBeforeLog(IMsgContext context) {
        IInterfLog log = createBeforeLog(context);
        InterfLoggerFactory.saveLog(getConfigure(), this, log, context);
    }

    /**
     * 调用后保存日志
     * @param context
     */
    protected void saveAfterLog(IMsgContext context) {
        LogLevel level = getConfigure().getAfterLogLevel(this);
        if (LogLevel.OFF.equals(level)) {

        } else if (LogLevel.SYNC.equals(level)) {
            syncAfterLog(context);
        } else if (LogLevel.ASYNC.equals(level)) {
            asyncAfterLog(context);
        }
    }

    /**
     * 同步记录日志
     * @param context
     */
    protected void syncAfterLog(IMsgContext context) {
        actualAfterLog(context);
    }

    /**
     * 异步记录日志
     * @param context
     */
    protected void asyncAfterLog(IMsgContext context) {
        try {
            ThreadPoolFactory.commitAsyncLog(getConfigure(), this, this, context, "after");
        } catch (Exception e) {
            //异步日志异常,不作处理
            logger.error("after log error.", e);
        }
    }

    public void actualAfterLog(IMsgContext context) {
        IInterfLog log = createAfterLog(context);
        InterfLoggerFactory.saveLog(getConfigure(), this, log, context);
    }

    /**
     * 获取配置类
     * @return
     */
    protected abstract IInterfConfigure getConfigure();

}
