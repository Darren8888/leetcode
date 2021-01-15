package com.example.sort;

public class Sushu {
    private static boolean isPrimer(int num) {
        if (0 == num) return false;

        for (int i=2; i<num; ++i) {
            if (0 == num % i) {
                return false;
            }
        }
        return true;
    }

    public static void print(int num) {
        int j = 0;
        for (int i=2; i<num; ++i) {
            if (isPrimer(i)) {
                j = num-i;
                if (isPrimer(j)) {
                    System.out.println(num + "= " + i + "+" + j);
                }
            }
        }
    }
}
