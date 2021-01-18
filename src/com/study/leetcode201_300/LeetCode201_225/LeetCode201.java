package com.study.leetcode201_300.LeetCode201_225;

/**
 * @author jianghui
 * @date 2021-01-18 09:46
 */
public class LeetCode201 {
    /**
     * 找到公共前缀 即为 m-n的按位与操作
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n){
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    /**
     * 选择直接抹去公共前缀后边所有的1的位置
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }

}
