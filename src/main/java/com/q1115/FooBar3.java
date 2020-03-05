package com.q1115;

import java.util.concurrent.CyclicBarrier;

/**
 * @author xjn
 * @since 2020-03-05
 */
public class FooBar3 {
    private int n;

    volatile boolean fin = true;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (!fin) {

            }
            printFoo.run();
            fin = true;
            try {
                cyclicBarrier.await();
            } catch (Exception e) {

            }
        }
    }


    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            try {
                cyclicBarrier.await();
            } catch (Exception e) {

            }
            printBar.run();
            fin = true;
        }
    }

    public static void main(String[] args) {
        FooBar3 p = new FooBar3(3);
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

