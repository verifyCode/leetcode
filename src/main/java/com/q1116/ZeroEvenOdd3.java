package com.q1116;

import java.util.function.IntConsumer;

/**
 * @author xjn
 * @since 2020-06-30
 */
public class ZeroEvenOdd3 {
    private int n;
    volatile int stage = 0;

    public ZeroEvenOdd3(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (stage > 0) ;
            printNumber.accept(0);
            if ((i & 1) == 0) {
                stage = 1;
            } else {
                stage = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (stage != 2) ;
            printNumber.accept(i);
            stage = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (stage != 1) ;
            printNumber.accept(i);
            stage = 0;
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd3 zeroEvenOdd = new ZeroEvenOdd3(10);
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
