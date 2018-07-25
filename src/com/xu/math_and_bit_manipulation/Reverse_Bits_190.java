package com.xu.math_and_bit_manipulation;

public class Reverse_Bits_190 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //获取n对应的二进制数的最右边（最低位）上的数
            int temp = n & 1;
            //左移到对应位置上，实现翻转
            int reserve = temp << (31 - i);
            //将翻转的结果加入到result中
            result = result | reserve;
            //进入次低位 >>>:表示无符号数的右移动
            n = n >>> 1;
        }
        return result;
    }

}
