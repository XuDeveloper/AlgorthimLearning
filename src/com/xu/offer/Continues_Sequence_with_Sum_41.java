package com.xu.offer;

import java.util.ArrayList;

public class Continues_Sequence_with_Sum_41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3)
            return list;
        ArrayList<Integer> l = new ArrayList<>();
        int small = 2;
        int middle = (1 + sum) / 2;//因为至少连续2个且顺序增加，所以取中间值
        l.add(1);
        l.add(2);
        int s = 3;
        if (s == sum) {
            list.add(new ArrayList<>(l));
        }

        while (small <= middle) {
            small++;
            s += small;
            l.add(small);
            if (s == sum) {
                list.add(new ArrayList<>(l));
            }
            //两个指针，若大，减去左边数字，若小，加右边数字
            while (s > sum && small <= middle) {
                s -= l.remove(0);
                if (s == sum) {
                    list.add(new ArrayList<>(l));
                }
            }

        }
        return list;
    }

}
