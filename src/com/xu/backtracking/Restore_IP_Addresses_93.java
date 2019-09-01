package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

// 刷过1遍（2019.09.01 ）

public class Restore_IP_Addresses_93 {

    private ArrayList<ArrayList<String>> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        findIP(s, 0, new ArrayList<>());
        ArrayList<String> finalResult = new ArrayList<>();
        for (ArrayList<String> l: result) {
            StringBuilder sb = new StringBuilder();
            for (String str: l) {
                sb.append(str).append(".");
            }
            sb.setLength(sb.length() - 1);
            finalResult.add(sb.toString());
        }
        return finalResult;
    }

    public void findIP(String s, int index, ArrayList<String> temp) {
        if (temp.size() >= 4 && index != s.length()) {
            return;
        }
        if (temp.size() + s.length() - index + 1 < 4) {
            return;
        }
        if (temp.size() == 4) {
            ArrayList<String> t = new ArrayList<>(temp);
            result.add(t);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            String sub = s.substring(index, index + i);
            if (i > 1 && s.charAt(index) == '0') {
                break;
            }
            if (Integer.valueOf(sub) > 255) {
                break;
            }
            temp.add(sub);
            findIP(s, index + i, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
