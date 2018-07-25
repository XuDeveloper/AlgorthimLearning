package com.xu.offer;

public class Print_1_To_Max_Of_N_Digits_12 {

    public void Print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n + 1];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            Print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    public void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            PrintNumber(number);
            return;
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    // 字符串number表示一个数字，数字有若干个0开头
    // 打印出这个数字，并忽略开头的0
    public void PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        // 标志位的思想，从第一位不为0的数字开始打印，如000123，打印123
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0')
                isBeginning0 = false;

            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

}
