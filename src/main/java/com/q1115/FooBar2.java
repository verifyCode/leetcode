package com.q1115;

/**
 * @author xjn
 * @since 2020-03-05
 * synchronized
 */
public class FooBar2 {
    private int n;
    private Object lock;
    private boolean runFoo = true;

    public FooBar2(int n) {
        this.lock = new Object();
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (!runFoo) {
                    lock.wait();
                }
                runFoo = false;
                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock) {
                if (runFoo) {
                    lock.wait();
                }
                printBar.run();
                runFoo = true;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        FooBar2 p = new FooBar2(3);
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


