package com.xu.lintcode.math_and_bit_manipulation;

/**
 * https://algorithm.yuanbin.me/zh-hans/math_and_bit_manipulation/hash_function.html
 */
public class Hash_Function_128 {

    public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length == 0) return -1;
        long hashSum = 0;
        for (int i = 0; i < key.length; i++) {
            hashSum = hashSum * 33 + key[i];
            hashSum %= HASH_SIZE;
        }
        return (int) hashSum;
    }

}
