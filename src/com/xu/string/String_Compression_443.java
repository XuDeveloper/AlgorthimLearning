package com.xu.string;

public class String_Compression_443 {

    public int compress(char[] chars) {
        int write = 0;
        int mark = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[write] = chars[mark];
                write++;
                if (mark < i) {
                    for (char a : ("" + (i - mark + 1)).toCharArray()) {
                        chars[write++] = a;
                    }
                }
                mark = i + 1;
            }
        }
        return write;
    }

}
