package com.xu.array;

public class Onebit_and_Twobit_Characters_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        return i == n - 1 ? true : false;
    }
}
