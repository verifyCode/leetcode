package com.q1115;

/**
 * @author xjn
 * @since 2020-07-01
 */
public class FooBar4 {
    private int n;
    volatile boolean flag = true;
    private Object lock = new Object();

    public FooBar4(int n) {
        this.n = n;

    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!flag) {
                    lock.wait();
                }
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 1; i < n; i++) {
            synchronized (lock) {
                if (flag) {
                    lock.wait();
                }
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        FooBar4 p = new FooBar4(10);
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
