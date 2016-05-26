package com.ffcs.crmd.platform.mq;

/**
 * 
 * 功能说明:发送消息结果反馈
 *
 * @author CHENZHI
 * 
 * @Date 2015年10月30日 下午2:59:03
 *
 *
 * 版本号  |   作者   |  修改时间   |   修改内容
 *
 */
public class ProdResult {
    
    private MqMessage  mqMessage;
    
    private SendStatus sendStatus;
    
    private String     errorMessage;
    
    public MqMessage getMqMessage() {
        return mqMessage;
    }
    
    public void setMqMessage(MqMessage mqMessage) {
        this.mqMessage = mqMessage;
    }
    
    public SendStatus getSendStatus() {
        return sendStatus;
    }
    
    public void setSendStatus(SendStatus sendStatus) {
        this.sendStatus = sendStatus;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public String toString() {
        return "ProdResult [msgId=" + mqMessage.getMsgId() + ",sendStatus=" + sendStatus
            + ", MqMessage=" + mqMessage + "]";
    }
}
