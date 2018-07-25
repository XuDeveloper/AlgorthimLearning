package com.xu.array;

import java.util.HashMap;

/**
 * 比较直接的想法就是，既然我们首先要知道每一个数字出现的次数，那么就利用HashMap，而且我们还要知道 这个数字的最小index 和最大index，那么也可以存入map记录。
   设一个HashMap<Integer, int[]> map， key 就是 num，value 就是int[3]: int[0] 记录 firstIndex; int[1] 记录 lastIndex; int[2] 记录次数。
   这样的话，我们需要遍历两次：
   第一次遍历nums array：记录每一个数字的 firstIndex， lastIndex， 出现次数； 还要记录下最大的出现次数。
   第二次遍历map key set：当key (num) 的次数等于最大次数的时候，记录最小的长度。(lastIndex - firstIndex + 1)。
 */
public class Degree_of_an_Array_697 {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxFre = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[1] = i;
                map.get(nums[i])[2]++;
            } else {
                int[] temp = new int[3];
                temp[0] = i;
                temp[1] = i;
                temp[2] = 1;
                map.put(nums[i], temp);
            }
            maxFre = Math.max(maxFre, map.get(nums[i])[2]);
        }
        for (int num: map.keySet()) {
            if (maxFre == map.get(num)[2]) {
                minLen = Math.min(minLen, map.get(num)[1] - map.get(num)[0] + 1);
            }
        }
        return minLen;
    }

}
