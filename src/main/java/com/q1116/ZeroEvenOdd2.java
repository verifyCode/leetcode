package com.q1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author xjn
 * @since 2020-06-30
 * Semaphore
 */
public class ZeroEvenOdd2 {
    private int n;
    //0
    Semaphore z = new Semaphore(1);
    //偶数
    Semaphore e = new Semaphore(0);
    //奇数
    Semaphore o = new Semaphore(0);

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                //当前值是偶数,需要打印奇数
                o.release();
            } else {
                //当前值是奇数,需要打印偶数
                e.release();
            }
        }
    }
    //2 4 6 8 10
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
    //1 3 5 7 9
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (Exception e) {

            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (Exception e) {

            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (Exception e) {

            }
        }).start();

    }
}
