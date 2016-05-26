package com.ffcs.crmd.platform.pub.proxy.callframework.impl;

import com.ctg.itrdc.event.utils.StringUtils;
import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.pub.bean.ReqResult;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ffcs.crmd.lmax.base.Producers;
import com.ffcs.crmd.lmax.base.TransEventProducer;
import com.ffcs.crmd.lmax.pool.CommandPoolUtils;
import com.ffcs.crmd.lmax.pool.CommandPools;
import com.ffcs.crmd.platform.pub.ex.ExceptionUtils;
import com.ffcs.crmd.platform.pub.facade.CrmSessionContext;
import com.ffcs.crmd.platform.pub.proxy.callframework.CallContextConstants;
import com.ffcs.crmd.platform.pub.proxy.callframework.CallEntity;
import com.ffcs.crmd.platform.pub.proxy.callframework.ICallContext;
import com.ffcs.crmd.platform.pub.proxy.callframework.lmax.ModCallCommand;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.poi.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * Created by linzhiqiang on 16/3/7.
 */
public class DefaultCallContext implements ICallContext {

    private List<CallEntity> callEntities = new ArrayList<CallEntity>();

    Map<String, List<CallEntity>> groupBaseKeyMap = new HashMap<String, List<CallEntity>>();

    @Override
    public void reset() {
        SessionContext.removeValue(CallContextConstants.CONTEXT_THREAD_KEY);
        SessionContext.removeValue(CallContextConstants.CONTEXT_BATCH_START_FALG);
        SessionContext.removeValue(CallContextConstants.CONTEXT_DATA_START_FALG);
    }

    @Override
    public void startBatch() {
        //标记开始批量调用
        SessionContext.setObject2TreadLocal(CallContextConstants.CONTEXT_BATCH_START_FALG, "1");
        //自身存入
        SessionContext.setObject2TreadLocal(CallContextConstants.CONTEXT_THREAD_KEY, this);
    }

    @Override
    public void commitBatch() throws InterruptedException {
        if (StringUtils.isNullOrEmpty(
            SessionContext.getObject4TreadLocal(CallContextConstants.CONTEXT_BATCH_START_FALG))) {
            ExceptionUtils.throwEx(new RtManagerException("you must call startBatch before commit"));
            return;
        }
        //移除不必要的线程变量
        SessionContext.removeValue(CallContextConstants.CONTEXT_THREAD_KEY);
        SessionContext.removeValue(CallContextConstants.CONTEXT_BATCH_START_FALG);

        Map<String, List<CallEntity>> groupMap = groupAndMergeCallByMod(callEntities);
        //分中心异步调用
        //异步等待锁
        CountDownLatch latch = new CountDownLatch(groupMap.size());
        TransEventProducer producer = Producers.getProducer("remote", "remoteClient");
        for (Map.Entry<String, List<CallEntity>> entry : groupMap.entrySet()) {
            ModCallCommand callCommand = CommandPoolUtils.getCommand(ModCallCommand.class);
            callCommand.setMod(entry.getKey());
            callCommand.setCallEntitys(entry.getValue());
            callCommand.setLatch(latch);
            producer.produce(callCommand);
        }
        latch.await();
        //按照服务名称分组
        groupBaseKeyMap = groupAndMergeCallByBaseKey(groupMap);

    }

    @Override
    public void startData() {
        //标记开始批量调用
        SessionContext.setObject2TreadLocal(CallContextConstants.CONTEXT_DATA_START_FALG, "1");
        //自身存入
        SessionContext.setObject2TreadLocal(CallContextConstants.CONTEXT_THREAD_KEY, this);
    }

    @Override
    public void endData() {
        //移除不必要的线程变量
        SessionContext.removeValue(CallContextConstants.CONTEXT_THREAD_KEY);
        SessionContext.removeValue(CallContextConstants.CONTEXT_DATA_START_FALG);
    }

    @Override
    public void addCallEntity(CallEntity entity) {
        callEntities.add(entity);
    }

    @Override
    public ReqResult getReqResult(CallEntity entity) {
        if (groupBaseKeyMap.containsKey(entity.getBaseKey())) {
            List<CallEntity> entitys = groupBaseKeyMap.get(entity.getBaseKey());
            for (CallEntity callEntity : entitys) {
                if (callEntity.equals(entity)) {
                    return callEntity.getReqResult();
                }
            }
        }
        return null;
    }

    //调用分组,合并
    private Map<String, List<CallEntity>> groupAndMergeCallByMod(List<CallEntity> callEntities) {
        Map<String, List<CallEntity>> map = new HashMap<String, List<CallEntity>>();
        if (callEntities != null && callEntities.size() > 0) {
            for (CallEntity entity : callEntities) {
                if (map.get(entity.getMod()) == null) {
                    map.put(entity.getMod(), new ArrayList<CallEntity>());
                }
                List<CallEntity> entitys = map.get(entity.getMod());
                boolean equal = false;
                if (entitys != null && entitys.size() > 0) {
                    for (CallEntity modEntity : entitys) {
                        if (modEntity.equals(entity)) {
                            equal = true;
                            break;
                        }
                    }
                }
                if (!equal) {
                    entitys.add(entity);
                    map.put(entity.getMod(), entitys);
                }
            }
        }
        return map;
    }

    //调用分组,合并
    private Map<String, List<CallEntity>> groupAndMergeCallByBaseKey(
        Map<String, List<CallEntity>> groupMap) {
        Map<String, List<CallEntity>> map = new HashMap<String, List<CallEntity>>();
        if (groupMap != null && groupMap.size() > 0) {
            for (List<CallEntity> callEntities : groupMap.values()) {
                for (CallEntity entity : callEntities) {
                    if (map.get(entity.getBaseKey()) == null) {
                        map.put(entity.getBaseKey(), new ArrayList<CallEntity>());
                    }
                    List<CallEntity> entitys = map.get(entity.getBaseKey());
                    entitys.add(entity);
                    map.put(entity.getBaseKey(), entitys);
                }
            }
        }
        return map;
    }

}
