package com.xu.string;

// 刷过1遍（2019.07.17 ）

public class Judge_Route_Circle_657 {

    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) {
            return true;
        }
        int hor = 0, ver = 0;
        for (char c: moves.toCharArray()) {
            switch (c) {
                case 'U':
                    ver++;
                    break;
                case 'D':
                    ver--;
                    break;
                case 'L':
                    hor++;
                    break;
                case 'R':
                    hor--;
                    break;
            }
        }
        return hor == 0 && ver == 0;
    }
}
