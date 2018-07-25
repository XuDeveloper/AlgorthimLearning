package com.xu.array;

public class Maximum_Swap_670 {

    public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        // record the last position of digit 0 ~ 9 in this num.
        // index 为每个位上数字的大小，loc[index]为在digit中最后出现index值的位置
        int[] loc = new int[10];

        for (int i = 0; i < digit.length; i ++) {
            loc[digit[i] - '0'] = i;
        }
        for (int i = 0; i < digit.length; i ++) {
            for (int j = 9; j > digit[i] - '0'; j --) {
                // loc[j]表示大数所在位数，i表示小数所在位数，只有当大数位数在小数位数的后面时才互换
                if (i < loc[j]) {
                    char tmp = digit[i];
                    digit[i] = digit[loc[j]];
                    digit[loc[j]] = tmp;
                    return Integer.valueOf(new String(digit));
                }
            }
        }
        return num;
    }
}
