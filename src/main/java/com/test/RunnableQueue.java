package com.test;

/**
 * @author xjn
 * @since 2020-07-06
 */
public interface RunnableQueue {
    //新线程进来时,提交任务到缓存队列
    void offer(Runnable runnable);

    //取出线程
    Runnable take() throws InterruptedException;

    //获取队列中线程的数量
    int size();
}
