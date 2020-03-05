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
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();

    private volatile int flag = 1;
    private volatile int who = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            try {
                lock.lock();
                if (who != 0) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                who = 1;
                if (flag % 2 == 0) {
                    //偶数
                    evenCondition.signal();
                }
                if (flag % 2 == 1) {
                    //奇数
                    oddCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    //2 4 6 8 10
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            try {
                lock.lock();
                //奇数就在暂停
                if (flag % 2 == 1 || who == 0) {
                    evenCondition.await();
                }
                printNumber.accept(i);
                flag++;
                who = 0;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    //1 3 5 7 9
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            try {
                lock.lock();
                //偶数就暂停
                if (flag % 2 == 0 || who == 0) {
                    oddCondition.await();
                }
                printNumber.accept(i);
                flag++;
                who = 0;
                zeroCondition.signal();
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
