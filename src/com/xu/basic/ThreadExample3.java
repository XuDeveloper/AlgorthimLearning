package com.xu.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替输出奇数和偶数
 */
public class ThreadExample3 {

    private static int i = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static int count = 100;

    public static void main(String[] args) {
        // 方法3：ReentrantLock
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (i <= count) {
                    try {
                        lock.lock();
                        System.out.println("thread1--奇数线程--输出" + i);
                        i++;
                        condition1.await();
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (i <= count) {
                    try {
                        lock.lock();
                        System.out.println("thread2--偶数线程--输出" + i);
                        i++;
                        condition1.signal();
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }

}
