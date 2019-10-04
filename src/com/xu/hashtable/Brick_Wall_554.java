package com.xu.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brick_Wall_554 {

    // https://blog.csdn.net/huanghanqian/article/details/75367837
    public int leastBricks(List<List<Integer>> wall) {
        int totalHeight = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (List<Integer> list : wall) {
            int width = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                width += list.get(i);
                int count = map.getOrDefault(width, 0);
                count++;
                map.put(width, count);
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        int res = totalHeight - maxCount;
        return res;
    }

}
