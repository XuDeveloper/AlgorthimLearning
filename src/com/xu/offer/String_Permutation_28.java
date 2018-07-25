package com.xu.offer;

public class String_Permutation_28 {

    public void permutation(char[] chars) {
        permutation(chars, 0, chars.length - 1);
    }

    public void permutation(char[] chars, int begin, int end) {
        if (begin == end) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        } else {
            for (int i = begin; i <= end; i++) {
                if (canSwap(chars, begin, i)) { //去重
                    swap(chars, begin, i); //交换
                    permutation(chars, begin + 1, end); //递归求子数组的全排列
                    swap(chars, begin, i); //还原
                }
            }
        }
    }

    public void swap(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }

    //判断去重
    public boolean canSwap(char[] chars, int begin, int end) {
        for (int i = begin; i < end; ++i) {
            if (chars[i] == chars[end]) {
                return false;
            }
        }
        return true;
    }

}
