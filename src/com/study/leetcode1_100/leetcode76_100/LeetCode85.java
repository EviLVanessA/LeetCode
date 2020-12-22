package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.regex.Pattern;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * @author jianghui
 * @date 2020-12-22 14:11
 */
public class LeetCode85 {
    /**
     * 动态规划
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    //对每个点的最大宽度进行判断
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int width = dp[i][j];
                    for (int k = i; k >= 0; --k) {
                        width = Math.min(width, dp[k][j]);
                        //以当前点为宽向上延伸画出最大长度的矩形
                        maxArea = Math.max(maxArea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxArea;
    }

    public int maxArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    /**
     * 将每一行都看成一个 坐标轴上的柱状图
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = chars[j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, maxArea(dp));
        }
        return maxarea;
    }

    /**
     * 动态规划 根据每个点进行最大高度的延伸 然后再向左向右进行延伸
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle3(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        //记录每个点的向上的高 向左的长 向右的长
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n);
        int maxArea = 0;
        for (char[] chars : matrix) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    //更新height
                    height[j]++;
                    //更新left
                    left[j] = Math.max(left[j], curLeft);

                } else {
                    //更新height
                    height[j] = 0;
                    //更新left
                    left[j] = 0;
                    curLeft = j + 1;

                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (chars[j] == '1') {
                    //更新right
                    right[j] = Math.min(right[j], curRight);
                } else {
                    //更新right
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }
}
