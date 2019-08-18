package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Split_Array_into_Fibonacci_Sequence_842 {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        helper(S, 0, res);
        return res;
    }

    public boolean helper(String str, int start, List<Integer> res) {
        if (start == str.length() && res.size() > 2) {
            return true;
        }
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(start) == '0' && i != start) {
                break;
            }
            long num = Long.parseLong(str.substring(start, i + 1));
            if (num > Integer.MAX_VALUE) {
                return false;
            }
            int size = res.size();
            if (size > 2 && num > res.get(size - 2) + res.get(size - 1)) {
                break;
            }
            if (size <= 1 || num == res.get(size - 2) + res.get(size - 1)) {
                res.add((int)num);
                if (helper(str, i + 1, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

}
