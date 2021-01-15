package com.example.sort.array;


//java最小覆盖子串：给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串
public class MoveWindow {
    public static String minWindow(String str1, String str2) {
        if ((null == str1) || (null == str2)) return "";

        int str1Len = str1.length(), str2Len = str2.length();
        if ((0 == str1Len) || (0 == str2Len) || (str1Len < str2Len)) return "";

        char str1Chars[] = str1.toCharArray(), str2Chars[] = str2.toCharArray();
        int str1CharCount[] = new int[128], str2CharCount[] = new int[128];
        for (char str2Char : str2Chars) {
            str2CharCount[str2Char]++;
        }

        int minLen = str1Len+1, begin = 0, right = 0, left = 0, distance = 0;
        char str1CurrentChar = 0;

        while (right<str1Len) {
            str1CurrentChar = str1Chars[right];

            if (0 == str2CharCount[str1CurrentChar]) {
                right++;
                continue;
            }

            if (str1CharCount[str1CurrentChar] < str2CharCount[str1CurrentChar]) {
                distance++;
            }
            str1CharCount[str1CurrentChar]++;
            right++;

            while (distance == str2Len) {
                if (left>=right) {
                    break;
                }

                if (right-left < minLen) {
                    minLen = right-left;
                    begin = left;
                }

                str1CurrentChar = str1Chars[left];

                if (0 == str2CharCount[str1CurrentChar]) {
                    ++left;
                    continue;
                }

                if (str1CharCount[str1CurrentChar] == str2CharCount[str1CurrentChar]) {
                    --distance;
                }

                --str1CharCount[str1CurrentChar];
                ++left;
            }
        }

        if (minLen == (str1Len+1)) {
            return "";
        } else {
            return str1.substring(begin, begin+minLen);
        }
    }
}
