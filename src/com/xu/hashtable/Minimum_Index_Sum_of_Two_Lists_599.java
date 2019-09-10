package com.xu.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Minimum_Index_Sum_of_Two_Lists_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> resList = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int sum = map1.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    resList.clear();
                    resList.add(list2[i]);
                } else if (sum == min) {
                    resList.add(list2[i]);
                }
            }
        }
        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

}
