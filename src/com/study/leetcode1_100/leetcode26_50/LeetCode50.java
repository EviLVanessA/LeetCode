package com.study.leetcode1_100.leetcode26_50;

/**
 * @author jianghui
 * @date 2020-12-11 14:26
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        return n > 0 ? quickMul(x, n ) : 1.0 / quickMul(x, n );
    }
    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode50().myPow(2,3));
    }

}
