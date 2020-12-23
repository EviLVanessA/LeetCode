package com.study.leetcode1_100.leetcode76_100;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * @author jianghui
 * @date 2020-12-23 14:09
 */
public class LeetCode96 {
    public int numTrees(int n) {
        int[] ans = new int[n + 1];
        //若为空树
        ans[0] = 1;
        //只有一个节点
        ans[1] = 1;
        //枚举所有
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] += ans[j - 1] * ans[i - j];
            }
        }
        return ans[n];
    }
}
