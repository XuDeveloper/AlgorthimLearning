package com.xu.hashtable;

import java.util.HashMap;
import java.util.Map;

public class N_Repeated_Element_in_Size_2N_Array_961 {

    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                return A[i];
            }
        }
        return 0;
    }

}
