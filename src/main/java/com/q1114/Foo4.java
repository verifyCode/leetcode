package com.q1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xjn
 * @since 2020-03-05
 */
public class Foo4 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition first = lock.newCondition();
    private Condition second = lock.newCondition();
    private int state = 1;

    public Foo4() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        try {
            lock.lock();
            printFirst.run();
            state = 2;
            first.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        try {
            lock.lock();
            while (state != 2) {
                first.await();
            }
            printSecond.run();
            state = 3;
            second.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        try {
            lock.lock();
            while (state != 3) {
                second.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        Foo4 foo = new Foo4();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(1);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(2);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(3);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t3.start();
        t1.start();
    }

}
