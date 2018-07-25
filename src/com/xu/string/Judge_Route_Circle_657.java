package com.xu.string;

public class Judge_Route_Circle_657 {

    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) {
            return true;
        }
        int countL = 0, countR = 0, countU = 0, countD = 0;
        for (int i = 0; i < moves.length(); i++) {
            char t = moves.charAt(i);
            switch (t) {
                case 'L':
                    countL++;
                    break;
                case 'R':
                    countR++;
                    break;
                case 'U':
                    countU++;
                    break;
                case 'D':
                    countD++;
                    break;
            }
        }
        return countL == countR && countU == countD;
    }
}
