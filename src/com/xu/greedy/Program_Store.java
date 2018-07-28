package com.xu.greedy;

import java.util.Arrays;

/**
 * 程序存储问题（贪心）
 * 有n个程序要存放在长度为L的磁带上，程序i存放在磁带上的长度是li。
 * 要求确定一个方案，使得能够在磁带上存储尽可能多的程序。
 * <p>
 * Input
 * 第一行是2个正整数，表示文件个数n和磁带的长度L
 * 接下来一行中，有n个正整数，表示程序存放在磁带上的长度
 * <p>
 * Output
 * 输出最多可以存储的程序数
 * <p>
 * 6 50
 * 2 3 13 8 80 20
 * <p>
 * 5
 */
public class Program_Store {

    public static int solve(int n, int L, int[] programs) {
        Arrays.sort(programs);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (L >= programs[i]) {
                count++;
                L -= programs[i];
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int L = 50;
        int[] programs = new int[6];
        programs[0] = 2;
        programs[1] = 3;
        programs[2] = 13;
        programs[3] = 8;
        programs[4] = 80;
        programs[5] = 20;
        System.out.println(solve(n, L, programs));
    }

}
