package com.example.sort.bitset;

import java.util.BitSet;
import java.util.HashSet;

public class FindNum {
    public static void bitSetFind(int[] array1, int[] array2) {
        if (null == array1 || null == array2 || 0>=array1.length || 0>=array2.length) return;

        int max1 = array1[0];
        int max2 = array2[0];
        for (int i=1; i<array1.length; ++i) {
            if (max1<array1[i]) {
                max1 = array1[i];
            }
        }
        for (int i=1; i<array2.length; ++i) {
            if (max2<array2[i]) {
                max2 = array2[i];
            }
        }

        BitSet bitSet = null;
        if (max1>max2) {
            bitSet = new BitSet(max1);
            for (int value : array1) {
                bitSet.set(value);
            }
            System.out.println("darren 1 bitset length: " + bitSet.length());
            for (int value : array2) {
                if (bitSet.get(value)) {
//                    bitSet.set(value, false);
                    bitSet.clear(value);
                    System.out.println("darren 1: "+value);
                }
            }
        } else {
            bitSet = new BitSet(max2);
            for (int value : array2) {
                bitSet.set(value);
            }
            System.out.println("darren 2 bitset length: " + bitSet.length());
            for (int value : array1) {
                if (bitSet.get(value)) {
//                    bitSet.set(value, false);
                    bitSet.clear(value);
                    System.out.println("darren 2: "+value);
                }
            }
        }

    }

    public static void find(int a[], int m, int b[], int k) {
        HashSet<Integer> aSet = new HashSet<>(a.length);
        for (int aIndex=0; aIndex<a.length; ++aIndex) {
            aSet.add(a[aIndex]);
        }

        for (int bIndex=0; bIndex<b.length; ++bIndex) {
            if (aSet.contains(b[bIndex])) {
                System.out.println(b[bIndex]);
            }
        }
    }

    public static void findDep(int[] array) {
        if (null == array || 1 >= array.length) return ;

        int max = array[0];
        for (int i=1; i<array.length; ++i) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        BitSet bitSet = new BitSet(max);
        for (int i=0; i<array.length; ++i) {
            if (bitSet.get(array[i])) {
                System.out.println("darren: " + array[i]);
            } else {
                bitSet.set(array[i], true);
            }
        }
    }
}
