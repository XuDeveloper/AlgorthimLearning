package com.xu.basic;

public class ShellSort {

    public void sort(int[] vals) {
        int j = 0;
        int temp = 0;
        int len = vals.length;
        for (int increment = len / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < len; i++) {
                temp = vals[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    // System.out.println("j:" + j);
                    // System.out.println("temp:" + temp);
                    // System.out.println("data[" + j + "]:" + data[j]);
                    if (temp < vals[j]) {
                        vals[j + increment] = vals[j];
                    } else {
                        break;
                    }
                }
                vals[j + increment] = temp;
            }
        }
    }

}
