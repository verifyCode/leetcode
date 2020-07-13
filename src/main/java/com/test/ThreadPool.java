package com.test;

/**
 * @author xjn
 * @since 2020-07-06
 */
public interface ThreadPool {

    boolean hasShutdown();

    void execute(Runnable runnable);
}
