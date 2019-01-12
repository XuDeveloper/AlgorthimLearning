package com.xu.hashtable;

import javafx.util.Pair;

import java.util.*;

public class Top_K_Frequent_Elements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 统计每个元素出现的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        // 优先按照频率排序，所以Pair为频率，元素
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new PairComparator());
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (queue.size() == k) {
                if (freq > queue.peek().getKey()) {
                    queue.poll();
                    queue.add(new Pair<>(freq, key));
                }
            } else {
                queue.add(new Pair<>(freq, key));
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().getValue());
        }
        return result;
    }

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            if (o1.getKey() != o2.getKey()) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        }
    }

}
