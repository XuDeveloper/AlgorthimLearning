package com.xu.basic;

public class NThreadExample1 {

    private static int result = 0;
    private static int n = 3;
    private static boolean[] printFlag = new boolean[n];

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            final int index = i;
            if (0 == i) {
                printFlag[index] = true;
            }
            new Thread(new Runnable() {
                public void run() {
                    try {
                        while (result <= 100) {
                            if (printFlag[index]) {
                                System.out.println("thread" + index + ": " + result++);
                                printFlag[index] = false;
                                if (index == (n - 1)) {
                                    printFlag[0] = true;
                                } else {
                                    printFlag[index + 1] = true;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }

}
