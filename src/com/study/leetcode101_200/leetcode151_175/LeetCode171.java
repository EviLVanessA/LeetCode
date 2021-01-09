package com.study.leetcode101_200.leetcode151_175;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * @author jianghui
 * @date 2021-01-09 15:51
 */
public class LeetCode171 {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            int num = chars[i] - 'A' + 1;
            sum += (int) (num *  Math.pow(26,j));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode171().titleToNumber("ZY"));
    }
}
