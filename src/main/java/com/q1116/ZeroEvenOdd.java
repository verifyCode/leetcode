package com.q1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author xjn
 * @since 2020-03-05
 */
public class ZeroEvenOdd {
    private int n;


    private Lock lock = new ReentrantLock();
    private Condition zeroCondition = lock.newCondition();
    Condition z = lock.newCondition();
    Condition num = lock.newCondition();
    volatile boolean zTurn = true;
    volatile int zIndex = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (; zIndex < n; ) {
            lock.lock();
            try {
                while (!zTurn) {
                    z.await();
                }
                printNumber.accept(0);
                zTurn = false;
                num.signalAll();
                zIndex++;
            } finally {
                lock.unlock();
            }
        }
    }

    //2 4 6 8 10
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (zTurn || (zIndex & 1) == 1) {
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    //1 3 5 7 9
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (zTurn || (zIndex & 1) == 0) {
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
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
