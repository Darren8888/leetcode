package com.example.sort;

import java.util.ArrayList;
import java.util.List;

public class ArrayDep {
    /*
     * array数组长度为n，数组每个值0<=array[i]<=n-1
     */
    public static int findDep(int[] nums) {
        if (null == nums || 1>=nums.length) throw new IllegalArgumentException("array value error");;

        for (int i=0; i<nums.length; ++i) {
            if (0>nums[i] || nums.length<=nums[i]) {
                throw new IllegalArgumentException("array value error");
            }
        }

        for (int i=0; i<nums.length; ++i) {
            if (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }

        throw new IllegalArgumentException("array value error");
    }

    //找多个重复的值
    public static void sortArray(int[] nums) {
        if (null == nums || 1>=nums.length) throw new IllegalArgumentException("array value error");;

        for (int i=0; i<nums.length; ++i) {
            if (0>nums[i] || nums.length<=nums[i]) {
                throw new IllegalArgumentException("array value error");
            }
        }

        //第一遍
        for (int i=0; i<nums.length; ++i) {
            if (i != nums[i]) {
                if (nums[nums[i]] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }

        //第二遍
        for (int i=0; i<nums.length; ++i) {
            if (i != nums[i]) {
                if (nums[nums[i]] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }

        for (int i=0; i<nums.length; ++i) {
            if (i != nums[i]) {
                System.out.println("darren i: " + i + ", value: " + nums[i]);
            }
        }
    }

    //给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数
    public static int findFirst(int[] nums) {
        if (null == nums || 0>=nums.length) throw new IllegalArgumentException("array value error");;

        for (int i=0; i<nums.length; ++i) {
            /*
             * nums[nums[i]]-1 != nums[i]
             * 含义：数值nums[i]应该放在nums[i]-1的下表中（数组值本应该是从1到n的，n为数组长度），即1应该放在0的下标，2应该放在1的下标，3应该放在2的下标...n应该放在n-1的下标
             */
            while (0<nums[i] && nums[i]<=nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, nums[i]-1, i);
            }
        }

        for (int i=0; i<nums.length; ++i) {
            if (nums[i] != (i+1)) {
                return i+1;
            }
        }

        return nums.length+1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
