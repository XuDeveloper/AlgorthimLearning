package com.xu.array;

public class Duplicate_Zeros_1089 {

    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        int[] copyArr = arr.clone();
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (index >= len) {
                break;
            } else if (copyArr[i] == 0 && index + 1 < len) {
                arr[index++] = 0;
                arr[index++] = 0;
            } else {
                arr[index++] = copyArr[i];
            }
        }
    }

}
