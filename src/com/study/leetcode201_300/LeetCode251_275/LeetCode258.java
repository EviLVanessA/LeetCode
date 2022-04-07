package com.study.leetcode201_300.LeetCode251_275;

public class LeetCode258 {
    public static void main(String[] args) {
        System.out.println(addDigits(10));
    }

    /**
     * 使用循环
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }
}
