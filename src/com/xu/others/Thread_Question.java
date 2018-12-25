package com.xu.others;

/**
 * 用三个线程，顺序打印字母A-Z，输出结果是1A、2B、3C、1D 2E...
 */
public class Thread_Question {

    public static char c = 'A';
    public static int i = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                synchronized (this) {
                    try {
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.print(threadId + "" + c++);
                                i++;
                                notifyAll();
                            } else {
                                wait();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable, "1");
        Thread thread2 = new Thread(runnable, "2");
        Thread thread3 = new Thread(runnable, "3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
