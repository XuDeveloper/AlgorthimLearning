package com.xu.offer;

public class Add_Two_Numbers_47 {

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;//不算进位，各位相加
            num2 = (num1 & num2) << 1;//得到进位数
            num1 = temp;//与进位数相加，即循环以上操作
        }
        return num1;
    }

}
