package com.example.sort.string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringDeal {
    public static int atoi(String a) {
        if (null == a || 0 == a.trim().length()) return 0;

        a = a.trim();

        if (isStartWrong(a, 0)) {
            return 0;
        }

        int index0 = 0;
        if ('0' == a.charAt(0)) {
            index0 = 1;
            for (; index0<a.length(); ++index0) {
                if ('0' != a.charAt(index0)) break;
            }

            if ((index0 == a.length())
                ||('-' == a.charAt(index0))
                || ('+' == a.charAt(index0))
                || (isStartWrong(a, index0))
            ) {
                return 0;
            }
        }

        int isSub = 0;
        if ('-' == a.charAt(index0)) {
            isSub = 1;
            ++index0;
        } else if ('+' == a.charAt(index0)) {
            isSub = 2;
            ++index0;
        }

        int end = index0;
        boolean start0 = true;
        for (; end<a.length(); ++end) {
            if (!isNumber(a, end)) break;

            if ('0' == a.charAt(end) && start0) {
                ++index0;
            } else {
                start0 = false;
            }
        }

        if (index0 >= end) {
            return 0;
        }

        a = a.substring(index0, end);

        if (1 == isSub) {
            if (a.length()>String.valueOf(Integer.MIN_VALUE).length()) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (a.length()>String.valueOf(Integer.MAX_VALUE).length()) {
                return Integer.MAX_VALUE;
            }
        }

        long target = Long.valueOf(a);
        if (1 == isSub) {
            if (-target<=Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int)-target;
            }
        } else {
            if (target>=Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)target;
            }
        }
    }

    private static boolean isStartWrong(String a, int index) {
        if (null == a || 0 == a.trim().length() || index>=a.trim().length()) return true;

        if (!isNumber(a, index) && ('-' != a.charAt(index)) && ('+' != a.charAt(index))) {
            return true;
        } else if (('-' == a.charAt(index) || ('+' == a.charAt(index)) || ('0' == a.charAt(index))) && (1 == a.trim().length())) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isNumber(String a, int index) {
        if ((null == a)
            || (0 == a.trim().length())
            || (a.trim().length()<=index)
        ) {
            return true;
        }

        char num = a.charAt(index);
        if ('0'<=num && num<='9') return true;
        return false;
    }
}
