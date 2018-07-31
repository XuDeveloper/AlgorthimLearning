package com.xu.greedy;

/**
 * 汽车加油问题（贪心）
 *
 * 一辆汽车加满油后可行驶n公里。旅途中有若干个加油站。设计有效算法，指出应在哪些加油站
 * 停靠加油，使沿途加油次数最少。
 *
 * Input
 * 第一行有2个正整数n和k，表示汽车加满油后可行驶n公里，且旅途中有k个加油站。
 * 接下来1行中有k+1个整数，表示第k个加油站与第k-1个加油站之间的距离。第0个加油站表示
 * 出发地，汽车已加满油。第k+1个加油站表示目的地。
 *
 * Output
 * 输出最少加油次数，如果无法到达，则输出“No Solution”
 */
public class Car_Refueling {

    public int getSolution(int n, int k, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > n) {
                return -1;
            }
        }
        int time = 0;
        int dist = n;
        for (int i = 0; i <= k + 1; i++) {
            if (a[i] > dist) {
                time++;
                dist = n;
            }
            dist = dist - a[i];
        }
        return time;
    }

}
