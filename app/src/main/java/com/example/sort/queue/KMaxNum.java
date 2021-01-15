package com.example.sort.queue;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class KMaxNum {
    public static boolean printKMaxNum(int array[], int k) {
        if ((null == array)
            || (0>=array.length)
            || (k>array.length)
            || (0>=k)) {
            return false;
        }

        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(array.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //o2为前一个数，o1为后一个数
                return o2-o1;
            }
        });

        for(int value : array) {
            queue.add(value);
        }

        int num = 0;
        while(0 < k--) {
            num = queue.poll();
        }
        System.out.println("k max num: " + num);

        return true;
    }

//    public static void main(String[] args) {
//        int array[] = {2, 8, 3, 9, 4, 6, 22, 33};
//        printKMaxNum(array, 4);
//    }
}