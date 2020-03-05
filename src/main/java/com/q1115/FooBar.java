package com.q1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xjn
 * @since 2020-03-05
 */
public class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private boolean runFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            try {
                lock.lock();
                if (!runFoo) {
                    condition.await();
                }
                printFoo.run();
                runFoo = false;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                lock.lock();
                if (runFoo) {
                    condition.await();
                }
                printBar.run();
                runFoo = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        FooBar p = new FooBar(3);
        new Thread() {
            public void run() {
                try {
                    p.foo(new Print_Foo());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    p.bar(new Print_Bar());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


}

class Print_Bar implements Runnable {

    @Override
    public void run() {
        System.out.print("Bar");
    }
}

class Print_Foo implements Runnable {

    @Override
    public void run() {
        System.out.print("Foo");
    }
}