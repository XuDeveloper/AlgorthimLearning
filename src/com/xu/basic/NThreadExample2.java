package com.xu.basic;

public class NThreadExample2 {

    public static void main(String[] args) {
        int n = 3;
        int maxInt = 100;
        for (int i = 0; i < n; i++) {
            new Thread(new TestThread(i, n, maxInt)).start();
        }
    }

}

class TestThread implements Runnable {

    private static final Object lock = new Object();

    private static int cur = 0;

    private int threadNo;

    private int threadCount;

    private int maxInt;

    public TestThread(int threadNo, int threadCount, int maxInt) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.maxInt = maxInt;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (cur % threadCount != threadNo) {
                    if (cur > maxInt) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (cur > maxInt) {
                    break;
                }
                System.out.println("thread" + threadNo + ": " + cur);
                cur++;
                lock.notifyAll();
            }
        }
    }
}
