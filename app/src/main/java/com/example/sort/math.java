package com.example.sort;

public class math {
    private static boolean isEqual(double a, double b) {
        if (((a>=b) && ((a-b)<0.000001))
                || ((a<b) && ((b-a)<0.000001))
        ) {
            return true;
        } else {
            return false;
        }
    }

    private static double directPow(double base, int count) {
        double result = 1.0;
        for (int i=0; i<count; ++i) {
            result *= base;
        }
        return result;
    }

    //求数的平方1  ======================================begin
    public static double pow(double base, int count) {
        if (isEqual(base, 0.0)) {
            throw new IllegalStateException("num cann't be 0.0");
        }

        if (0 == count) {
            return 1.0;
        } else if (0>count) {
            return directPow(1.0/base, count);
        } else {
            return directPow(base, count);
        }
    }
    //求数的平方1  ======================================end

    //求数的平方2  ======================================begin
    public static double recurrencePow(double base, int count) {
        if (isEqual(base, 0.0)) {
            throw new IllegalArgumentException("num cann't be 0.0");
        }

        if (0 == count) {
            return 1;
        } else if (1 == count) {
            return base;
        }

        int n = (0>count) ? -count:count;
        base = (0>count) ? 1.0/base:base;
        double result = recurrencePow(base, n>>1);
        result *= result;
        if (1 == (0x01&n)) {
            result *= base;
        }

        return result;
    }
    //求数的平方2  ======================================end

    /*
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     * 思路：青蛙能跳1个台阶或者2个台阶，那最后青蛙可能跳1台阶或者2台阶，那第n台阶就是（n-1）台阶与（n-2）台阶的方式总和
     */
    //n种方式1  ======================================begin
    public static int countStep1(int target) {
        if (2>=target) {
            return target;
        } else {
            return (countStep1(target-1) + countStep1(target-2)) % 1000000007;
        }
    }
    //n种方式1  ======================================end

    //n种方式2  ======================================begin
    public static int countStep2(int target) {
        if (1>=target) {
            return target;
        }

        int n1=1, n2=2, tmp=0;
        for (int i=2; i<target; ++i) {
            tmp = n2;
            n2 = n1+n2;
            n1 = tmp;
        }
        return n2 % 1000000007;
    }
    //n种方式2  ======================================end

    public static int fib(int target) {
        if (1>=target) {
            return target;
        } else {
            return ((fib(target-1) + fib(target-2))) % 1000000007;
        }
    }
}
