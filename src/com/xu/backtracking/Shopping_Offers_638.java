package com.xu.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// dfs + 记忆化搜索
public class Shopping_Offers_638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(0).append(",");
        }
        map.put(sb.toString(), 0);
        return dfs(price, special, needs, 0, map);
    }

    private int dfs(List<Integer> price, List<List<Integer>> specials, List<Integer> needs, int start, Map<String, Integer> map) {
        int min = findPossibleMin(price, needs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(needs.get(i)).append(",");
        }
        if (map.containsKey(sb.toString())) {
            return map.get(sb.toString());
        }
        for (int i = start; i < specials.size(); i++) {
            List<Integer> special = specials.get(i);
            List<Integer> newNeeds = new ArrayList<>();
            boolean isUse = true;
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < special.get(j)) {
                    isUse = false;
                    break;
                } else {
                    newNeeds.add(needs.get(j) - special.get(j));
                }
            }
            if (isUse) {
                min = Math.min(min, special.get(special.size() - 1) + dfs(price, specials, newNeeds, i, map));
            }
        }
        // cache
        map.put(sb.toString(), min);
        return min;
    }

    private int findPossibleMin(List<Integer> price, List<Integer> needs) {
        int min = 0;
        for (int i = 0; i < price.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        return min;
    }

}
