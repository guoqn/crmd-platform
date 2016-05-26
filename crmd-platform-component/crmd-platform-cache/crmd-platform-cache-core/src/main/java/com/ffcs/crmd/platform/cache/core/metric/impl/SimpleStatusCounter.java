package com.ffcs.crmd.platform.cache.core.metric.impl;

import com.ffcs.crmd.platform.cache.api.StatsCounter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by linzhiqiang on 16/3/30.
 */
public class SimpleStatusCounter implements StatsCounter {

    private AtomicLong putIn  = new AtomicLong(0);
    private AtomicLong hits   = new AtomicLong(0);
    private AtomicLong misses = new AtomicLong(0);
    private AtomicLong evicts = new AtomicLong(0);

    @Override
    public void recordPutIn(int count) {
        putIn.addAndGet(count);
    }

    @Override
    public void recordHits(int count) {
        hits.addAndGet(count);
    }

    @Override
    public void recordMisses(int count) {
        misses.addAndGet(count);
    }

    @Override
    public void recordEviction(int count) {
        evicts.addAndGet(count);
    }

    public Long getPutIn() {
        return putIn.get();
    }

    public Long getHits() {
        return hits.get();
    }

    public Long getMisses() {
        return misses.get();
    }

    public Long getEvicts() {
        return evicts.get();
    }
}
