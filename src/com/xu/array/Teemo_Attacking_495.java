package com.xu.array;

public class Teemo_Attacking_495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        int length = timeSeries.length;
        for (int i = 1; i < length; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            res += (diff < duration) ? diff : duration;
        }
        return res + duration;
    }
}
