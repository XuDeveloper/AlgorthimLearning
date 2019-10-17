package com.xu.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Find_And_Replace_in_String_833 {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = indexes.length;
        for (int i = 0; i < n; i++) {
            map.put(indexes[i], i);
            list.add(indexes[i]);
        }
        Collections.sort(list);
        for (int i = n - 1; i >= 0; i--) {
            int pos = list.get(i);
            int curInd = map.get(pos);
            if (S.indexOf(sources[curInd], pos) == pos) {
                S = S.substring(0, pos) + targets[curInd] + S.substring(pos + sources[curInd].length());
            }
        }
        return S;
    }

}
