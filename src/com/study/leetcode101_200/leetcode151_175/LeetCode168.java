package com.study.leetcode101_200.leetcode151_175;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * @author jianghui
 * @date 2021-01-09 14:25
 */

public class LeetCode168 {
    //    49 == 1 65 == A
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            int remain = n % 26;
            if (remain == 0) {
                //n-1是为了回退
                n--;
                ans.append("Z");
            } else {
                ans.append((char) (remain + 64));
            }
            n = n / 26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode168().convertToTitle(28));
    }
}
