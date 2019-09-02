package com.xu.basic;

/**
 * 两个线程交替输出奇数和偶数
 * https://zhuanlan.zhihu.com/p/47948392
 */
public class ThreadExample1 {

    private static Object lock = new Object();
    private static int i = 0;
    private static int count = 100;

    public static void main(String[] args) {
        // 方法1：同步
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (i <= count) {
                        if (i % 2 == 1) {
                            System.out.println("thread1--奇数线程--输出" + i);
                            i++;
                        } else {
                            lock.notifyAll();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (i <= count) {
                        if (i % 2 == 0) {
                            System.out.println("thread2--偶数线程--输出" + i);
                            i++;
                        } else {
                            lock.notifyAll();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }

}
