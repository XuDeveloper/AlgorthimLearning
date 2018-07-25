package com.xu.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：滑动窗口的最大值
 * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
 * 原则：
 * 对新来的元素k，将其与双端队列中的元素相比较
 * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 * 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 * 队列的第一个元素是滑动窗口中的最大值
 */
public class Max_in_Window_65 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }
        // 用来保存可能是滑动窗口最大值的数字的下标
        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            // 如果已有数字小于待存入的数据，
            // 这些数字已经不可能是滑动窗口的最大值
            // 因此它们将会依次地从队尾删除
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            // 如果已有数字小于待存入的数据，
            // 这些数字已经不可能是滑动窗口的最大值
            // 因此它们将会依次地从队尾删除
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }

}
