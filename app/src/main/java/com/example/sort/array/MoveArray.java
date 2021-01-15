package com.example.sort.array;

public class MoveArray {
    public static void moveK(int array[], int k) {
        if ((null == array) || (0>=array.length) || (0>k) || (k>array.length)) {
            return;
        }

        for (int value : array) {
            System.out.println("1: " + value);
        }

        int copyArray[] = new int[array.length];
        System.arraycopy(array, k, copyArray, 0, array.length-k);
        System.arraycopy(array, 0, copyArray, array.length-k, k);

        array = copyArray;

        for (int value : array) {
            System.out.println("2: " + value);
        }
    }
}
