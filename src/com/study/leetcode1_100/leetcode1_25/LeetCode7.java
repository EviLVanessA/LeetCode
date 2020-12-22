package com.study.leetcode1_100.leetcode1_25;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 *
 * @author jianghui
 * @date 2020-09-24  11:05
 **/
public class LeetCode7 {
    public int reverse(int x) {
        long temp = 0;
        while(x != 0){
            int pop = x % 10;
            temp = temp * 10 + pop;

            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)temp;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode7().reverse(-123));
    }
}
