package com.example.sort.array;

public class SubCount {
    public static int subCount(String str1, String str2) {
        if ((null == str1)
            || (str1.isEmpty())
            || (null == str2)
            || (str1.isEmpty())
        ) {
            return 0;
        }

        if (str1.equals(str2)) {
            return 1;
        } else if (str1.length() < str2.length()) {
            int length = str2.length()-str1.length();
            int count = 0;
            for (int i=0; i<=length; ++i) {
                if (str1.equals(str2.substring(i, str1.length()+i))) {
                    ++count;
                }
            }
            return count;
        } else {
            int length = str1.length()-str2.length();
            int count = 0;
            for (int i=0; i<=length; ++i) {
                if (str2.equals(str1.substring(i, str2.length()+i))) {
                    ++count;
                }
            }
            return count;
        }
    }
}
