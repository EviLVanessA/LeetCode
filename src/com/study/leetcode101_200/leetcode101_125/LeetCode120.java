package com.study.leetcode101_200.leetcode101_125;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * @author jianghui
 * @date 2020-12-30 10:01
 */
public class LeetCode120 {
    /**
     * 经典的动态规划 时间复杂度O(n²) 空间复杂度O(n²)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            //初始化左边界
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            //初始化右边界
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    /**
     * 进行空间复杂度优化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        //优化为n个空间复杂度
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            //先更新右边界
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            //由于需要再一个数组上进行 所以需要从右向左更新
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            //更新左边界
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int min = dp[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
