package com.test;

/**
 * @author xjn
 * @since 2020-07-06
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前线程在运行中切没有被中断，则不断从缓存队列中拿出线程运行
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
                break;
            }
        }
    }

    public void stop() {
        if (!running) {

        } else {
            running = false;
        }
    }
}
