package com.test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xjn
 * @since 2020-07-06
 */
public class BasicThreadPool extends Thread implements ThreadPool {

    private int initSize;

    private int maxSize;

    private Long keepAliveTime;

    private int activeCount;

    private ThreadFactory threadFactory;

    private RunnableQueue runnableQueue;

    private volatile boolean isShutdown = false;

    private final Queue<ThreadTask> internalTasks = new ArrayDeque<>();


    @Override
    public boolean hasShutdown() {
        return false;
    }

    @Override
    public void execute(Runnable runnable) {

    }

    //把线程和internalTask一个组合
    private static class ThreadTask {
        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }

        Thread thread;
        InternalTask internalTask;
    }

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
        private static final ThreadGroup group = new ThreadGroup("我的线程-" +
                GROUP_COUNTER.getAndDecrement());
        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread creatThread(Runnable runnable) {
            return new Thread(group, runnable, "线程池-" + COUNTER.getAndDecrement());
        }
    }
}
