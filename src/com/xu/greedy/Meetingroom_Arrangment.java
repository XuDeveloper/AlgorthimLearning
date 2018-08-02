package com.xu.greedy;

import java.util.PriorityQueue;

/**
 * 会场安排问题（贪心）
 *
 * 假设要在足够多的会场里安排一批活动，并希望使用尽可能少的会场。
 * 设计一个有效的算法进行安排。
 *
 * Input：
 * 第一行有1个正整数k，表示有k个待安排的活动。接下来的k行中，每行有2个正整数，分别表示k个待安排的
 * 活动开始时间和结束时间。
 *
 * Output：
 * 最少会场数
 */
public class Meetingroom_Arrangment {

    public int getSolution(int k, int[][] temp) {
        PriorityQueue<ACT> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            ACT act = new ACT(temp[1][0], temp[1][1]);
            queue.offer(act);
        }
        int count = 1;
        int curEnd = queue.poll().end;
        for (int i = 1; i < k; i++) {
            if (curEnd < queue.peek().start) {
                count++;
                curEnd = queue.peek().end;
            }
            queue.poll();
        }
        queue.clear();
        return count;
    }

    class ACT implements Comparable<ACT>{
        int start;
        int end;

        public ACT(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ACT o) {
            if (this.end > o.end) {
                return 1;
            }
            return -1;
        }
    }

}
