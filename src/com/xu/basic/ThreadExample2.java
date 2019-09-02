package com.xu.basic;

/**
 * 两个线程交替输出奇数和偶数
 */
public class ThreadExample2 {

    private volatile static int i = 0;
    private static int count = 100;

    public static void main(String[] args) {
        // 方法2：volatile
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (i <= count) {
                    if (i % 2 == 1) {
                        System.out.println("thread1--奇数线程--输出" + i);
                        i++;
                    }
                }

            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (i <= count) {
                    if (i % 2 == 0) {
                        System.out.println("thread2--偶数线程--输出" + i);
                        i++;
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }

}
