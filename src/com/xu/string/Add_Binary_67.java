package com.xu.string;

public class Add_Binary_67 {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String rst = "";

        while (pb >= 0) {
            int result = (int) (a.charAt(pa) - '0') + (int) (b.charAt(pb) - '0') + carries;
            rst = String.valueOf(result % 2) + rst;
            carries = result / 2;
            pa--;
            pb--;
        }

        while (pa >= 0) {
            int result = (int) (a.charAt(pa) - '0') + carries;
            rst = String.valueOf(result % 2) + rst;
            carries = result / 2;
            pa--;
        }

        if (carries == 1) {
            rst = "1" + rst;
        }
        return rst;
    }

}
