package com.xu.offer;

public class Number_of_1_10 {

    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
