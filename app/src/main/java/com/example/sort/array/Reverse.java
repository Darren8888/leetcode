package com.example.sort.array;

public class Reverse {
    public static void reverseArray(int arr1[]) {
        //TODO judge

        int index = 0;
        for (int i=0; i<arr1.length/2; ++i) {
            index = arr1.length-i-1;

            arr1[i] = arr1[i] + arr1[index];
            arr1[index] = arr1[i] - arr1[index];
            arr1[i] = arr1[i] - arr1[index];
        }
    }
}
