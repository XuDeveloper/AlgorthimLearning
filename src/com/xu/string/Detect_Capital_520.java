package com.xu.string;

public class Detect_Capital_520 {

    public boolean detectCapitalUse(String word) {
        // 长度小于2，返回true
        if (word.length() < 2) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        // 如果第一个字母之后全是小写（第一个字母大小写无所谓）
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }

}
