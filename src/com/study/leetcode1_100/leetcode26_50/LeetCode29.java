package com.study.leetcode1_100.leetcode26_50;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，
 * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *
 * @author jianghui
 * @date 2020-09-27  11:28
 **/
public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) {
            divisor = -divisor;
        }
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = - result;
        }
        return result;
    }
}
