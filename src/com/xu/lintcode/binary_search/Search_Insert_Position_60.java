package com.xu.lintcode.binary_search;

/**
 * 分析三种典型情况：
 *
 * 目标值在数组范围之内，最后返回值一定是start + 1
 * 目标值比数组最小值还小，此时start 一直为-1, 故最后返回start + 1 也没错，也可以将-1 理解为数组前一个更小的值
 * 目标值大于等于数组最后一个值，由于循环退出条件为start + 1 == end, 那么循环退出时一定有start = A.length - 1, 应该返回start + 1
 * 综上所述，返回start + 1是非常优雅的实现。其实以上三种情况都可以统一为一种方式来理解，即索引-1 对应于在数组前方插入一个非常小的数，索引end 即对应数组后方插入一个非常大的数，那么要插入的数就一定在start 和end 之间了。
 *
 * 有时复杂的边界条件处理可以通过『补项』这种优雅的方式巧妙处理。
 */
public class Search_Insert_Position_60 {

    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = -1, end = A.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid; // no duplicates
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start + 1;
    }

}
