package com.xu.array;

// 刷过1遍（2019.08.16 ）

/**
 * 比较好的解决方法是构造两个数组相乘：

    [1, a1, a1*a2, a1*a2*a3]
    [a2*a3*a4, a3*a4, a4, 1]

    我们可以对上面的代码进行空间优化，用一个常数p来保存每次计算的结果值。

 */
public class Product_of_Array_Except_Self_238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int p = 1;
        int[] arr = new int[len];
        arr[0] = p;
        for (int i = 1; i < len; i++) {
            p = p * nums[i - 1];
            arr[i] = p;
        }
        p = 1;
        for (int i = len - 2; i >= 0; i--) {
            p = p * nums[i + 1];
            arr[i] *= p;
        }
        return arr;
    }
}
