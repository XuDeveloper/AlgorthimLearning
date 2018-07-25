package com.xu.others;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            if (newInterval != null) {
                result.add(newInterval);
            }
            return result;
        }
        int insertPos = 0;
        for (Interval interval : intervals) {
            if (newInterval.end < interval.start) {
                // case 1: [new], [old]
                result.add(interval);
            } else if (interval.end < newInterval.start) {
                // case 2: [old], [new]
                result.add(interval);
                insertPos++;
            } else {
                // case 3, 4: [old, new] or [new, old]
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        result.add(insertPos, newInterval);
        return result;
    }

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
