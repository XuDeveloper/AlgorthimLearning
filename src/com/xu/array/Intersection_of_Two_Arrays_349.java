package com.xu.array;

import java.util.HashSet;
import java.util.Iterator;

// 刷过1次 （2019.06.10 ）

public class Intersection_of_Two_Arrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] result = new int[resultSet.size()];
        Iterator<Integer> it = resultSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i] = it.next();
            i++;
        }
        return result;
    }

}
