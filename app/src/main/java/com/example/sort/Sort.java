package com.example.sort;

import java.io.IOException;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;

public class Sort {
    //二分查找
//    public static int binarySearchSort(int[] array, int value) {
//        if ((null == array)
//            || (1 >= array.length)) {
//            return -1;
//        }
//
//        int low = 0, hi = array.length-1;
//        int mid = 0;
//        while (low < hi) {
//            mid = (low + hi) / 2;
//            if (array[mid] < value) {
//                low = mid + 1;
//            } else if (array[mid] > value) {
//                hi = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//
//        return ~low;
//    }

    //1 二分排序 ==========================================================begin
    public static void binarySort(int array[]) {
        for(int i=1; i<array.length; ++i) {
            int temp = array[i];
            int low = 0, high = i-1, mid=-1;

            while (low<=high) {
                mid = (low+high) >> 2;
                if (temp < array[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }

            for (int j=i-1; j>=low; --j) {
                array[j+1] = array[j];
            }

            if (i != low) { //插入的位置不等于原来的i，说明位置发生改变；如果插入位置不变，则说明low即为i。
                array[low] = temp;
            }
        }
    }
    //1 二分排序 ===============================================================end

    //2 快速排序 ==========================================================begin
    public static void quickSort(int[] array, int left, int right) {
        if ((null == array)
                || (1 >= array.length)
                || (left < 0)
                || (right >= array.length)
                || (right <= left)
        ) {
            return;
        }

        int i = left, j = right, x = array[left];

        while (i < j) {
            while (i < j && array[j] >= x) {
                --j;
            }
            if (i < j) {
                array[i++] = array[j];
            }

            while (i < j && array[i] < x) {
                ++i;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }

        array[i] = x;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
    //2 快速排序 ===============================================================end

    //3 插入排序 ==========================================================begin
    public static void insertSort(int[] array) {
        if ((null == array)
            || (1 >= array.length)) {
            return;
        }

        int tmp = 0, j = 0, length = array.length;
        for (int i = 1; i < length; ++i) {
            tmp = array[i];
            j = i;
            while ((0 < j) && (array[j - 1] > tmp)) {
                array[j] = array[j - 1];
                --j;
            }
            if (i != j) {
                array[j] = tmp;
            }
        }
    }
    //3 插入排序 ===============================================================end

    //4 希尔排序；在插入排序的基础上，新增了二分分段、等间隔插入排序，最后再进行一次从头到位的插入排序
    public static void shellSort(int[] array) {
        if ((null == array) || (1>=array.length)) {
            return;
        }

        int length = array.length, start=0, i=0, tmp=0, j=0;
        for (start = length >> 1; start>0; start >>= 1) {
            for (i=start; i<length; ++i) {
                tmp = array[i];
                for (j=i-start; (0<=j) && (tmp<array[j]); j-=start) {
                    array[j+start] = array[j];
                }
                array[j+start] = tmp;
            }
        }
    }
    //4 希尔排序 ===============================================================end

    //5 选择排序，从剩余的数据里面挑出最小的，往前移动
    public static void selectionSort(int[] array) {
        if ((null == array) || (1 >= array.length)) {
            return ;
        }

        int i=0, j=0, min=-1;
        for (; i<array.length; ++i) {
            min = i;
            for (j=i+1; j<array.length; ++j) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                array[i] = array[i]+array[min];
                array[min] = array[i] - array[min];
                array[i] = array[i] - array[min];
            }
        }
    }
    //5 选择排序 =====================================================end

    //6 堆排序 ================================================begin
    private static void swap(int[] array, int sourceIndex, int targetIndex) {
        array[sourceIndex] = array[sourceIndex] + array[targetIndex];
        array[targetIndex] = array[sourceIndex] - array[targetIndex];
        array[sourceIndex] = array[sourceIndex] - array[targetIndex];
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param array
     * @param current
     * @param length
     */
    private static void heapTopBig(int[] array, int current, int length) {
        int tmp = array[current]; //先取出当前元素
        for (int k = 2*current+1; k<length; k=2*k+1) { //从current结点的左子结点开始，也就是2*current+1处开始，自顶向下，自左向右
            if ((k+1 < length) && (array[k]<array[k+1])) { //如果左子结点小于右子结点，k指向右子结点
                ++k;
            }

            if (array[k] > tmp) { //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[current] = array[k];
                current = k;
            } else {
                break;
            }
        }

        array[current] = tmp; //将tmp值放到最终的位置
    }

    public static void heapSort(int[] array) {
        if ((null == array)
            || (1 >= array.length)
        ) {
            return;
        }

        //创建大顶堆
        for (int i=array.length/2-1; i>=0; --i) { //从第一个非叶子结点从下至上，从右至左调整结构
            heapTopBig(array, i, array.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j=array.length-1; j>0; --j) {
            swap(array, 0, j); //将堆顶元素与末尾元素进行交换
            heapTopBig(array, 0, j); //重新对堆进行调整
        }
    }
    //6 堆排序 ================================================end

    //7 二路归并　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝begin
    public static void binaryMergeSort(int array[], int low, int high) {
        if (low<high) {
            int mid = (low+high) >> 2;
            binaryMergeSort(array, low, mid);
            binaryMergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int array[], int low, int mid, int high) {
        int temp[] = new int[high-low+1];
        int i=low, j=mid+1, k=0;
        while (i<=mid && j<=high) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }

        while (i<=mid) {
            temp[k++] = array[i++];
        }

        while (j<=high) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, low, temp.length);
    }
    //7 二路归并 -================================================end

    //8 计数算法 优化算法 ===================================begin
    public static int[] countSort(int array[]) {
        int max=0, min = 0;
        for (int i=0; i<array.length; ++i) {
            if (max < array[i]) {
                max = array[i];
            }

            if (min > array[i]) {
                min = array[i];
            }
        }

        int count[] = new int[max-min+1];
        for (int i=0; i<array.length; ++i) {
            count[array[i]-min]++;
        }

        //
        for (int i=1; i<count.length; ++i) {
            count[i] = count[i] + count[i-1];
        }

        //从后往前遍历，count每位值 对应 原数组当前值在排序后的第几位，位数以1开始
        int sort[] = new int[array.length];
        for (int i=array.length-1; 0<=i; --i) {
            sort[count[array[i]-min]-1] = array[i];
            --count[array[i]-min];
        }
        return sort;
    }
    //8 计数算法 优化算法 ===================================end

    //9 基数排序 ==========================================begin
    public static int[] baseSort(int[] array) {
        if (null == array || 1>=array.length) {
            return null;
        }

        int max = array[0];
        for (int i=1; i<array.length; ++i) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        final int BASE_NUM = 10;

        int baseBox[][] = new int[BASE_NUM][array.length];
        int baseCount[] = new int[BASE_NUM];

        int length = (""+max).length();
        int num=0, index=0;
        for (int i=1, n=1; i<=length; ++i, n *= BASE_NUM) {
            for (int j = 0; j < array.length; ++j) {
                num = array[i] / n % BASE_NUM;
                baseBox[num][baseCount[num]] = array[j];
                ++baseCount[num];
            }

            for(int j=0; j<BASE_NUM; ++j) {
                if (0<baseCount[j]) {
                    for (int k=0; k<baseCount[j]; ++k) {
                        array[index++] = baseBox[j][k];
                    }
                    baseCount[j] = 0;
                }
            }
            index = 0;
        }

        return array;
    }
    //9 基数排序 ==========================================end

    //10 桶排序 ================================================begin
    private static class BucketNode {
        public int value;
        public BucketNode next;

        public BucketNode(int value) {
            this.value = value;
        }
    }

    /* 此哈希值计算适合于桶个数等于数组长度
     * @param value 为数组当前值
     * @param max 为数组最大值
     * @param length 为数组长度
     * @return int 为数组当前值对应的hash值
     */
    private static int bucketHash(int value, int max, int length) {
        return value*length/(max+1);
    }

    private static void bucketInsert(int value, int hash, BucketNode bucketNode[]) {
        BucketNode node = new BucketNode(value);

        if (value <= bucketNode[hash].value) {
            node.next = bucketNode[hash];
            bucketNode[hash] = node;
        } else {
            BucketNode current = bucketNode[hash], prev=current;
            while ((null != current) && (value>current.value)) {
                prev = current;
                current = current.next;
            }

            prev.next = node;
            if (null != current) {
                node.next = current;
            }
        }
    }

    public static void bucketSort(int array[]) {
        if ((null == array) || (1>=array.length)) return;

        int max = array[0];
        for (int i=1; i<array.length; ++i) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        BucketNode bucket[] = new BucketNode[array.length];
        int hash = 0;
        for (int i=0; i<array.length; ++i) {
            hash = bucketHash(array[i], max, array.length);
            if (null == bucket[hash]) {
                bucket[hash] = new BucketNode(array[i]);
            } else {
                bucketInsert(array[i], hash, bucket);
            }
        }

        int index=0;
        for (BucketNode node : bucket) {
            while (null != node) {
                array[index++] = node.value;
                node = node.next;
            }
        }
    }
    //10 桶排序 ================================================end


}
