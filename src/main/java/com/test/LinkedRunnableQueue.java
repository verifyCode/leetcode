package com.test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author xjn
 * @since 2020-07-06
 */
public class LinkedRunnableQueue implements RunnableQueue {

    private final int limit;

    private final DenyPolicy denyPolicy;

    private final LinkedBlockingDeque<Runnable> linkedBlockingDeque;

    private final ThreadPool threadPool;


    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
        this.linkedBlockingDeque = new LinkedBlockingDeque<>(limit);
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (linkedBlockingDeque) {
            if (linkedBlockingDeque.size() >= limit) {
                this.denyPolicy.reject(runnable, threadPool);
            } else {
                linkedBlockingDeque.add(runnable);
                //todo 这句话到底是啥意思?
                linkedBlockingDeque.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() {
        synchronized (linkedBlockingDeque) {
            //队列为空则挂起等待
            while (linkedBlockingDeque.isEmpty()) {
                try {
                    linkedBlockingDeque.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            return linkedBlockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int size() {
        synchronized (linkedBlockingDeque) {
            return linkedBlockingDeque.size();
        }
    }
}
