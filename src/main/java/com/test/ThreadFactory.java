package com.test;

/**
 * @author xjn
 * @since 2020-07-06
 */
public interface ThreadFactory {
    Thread creatThread(Runnable runnable);
}
