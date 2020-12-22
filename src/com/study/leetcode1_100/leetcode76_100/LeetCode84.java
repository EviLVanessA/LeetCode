package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2020-12-22 10:32
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int newMax = (j - i + 1) * min;
                if (newMax > max) {
                    max = newMax;
                }
            }
        }
        return max;
    }

    /**
     * 单调栈解法  固定高度求最长宽度 最长宽度为 右侧的最近最小的左侧柱子-左侧的最近最小右侧柱子+1
     * 我们需要找到左右两侧最近的高度小于 hh 的柱子，这样这两根柱子之间（不包括其本身）的所有柱子高度均不小于 h，
     * 并且就是 i 能够扩展到的最远范围。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> monoStack = new ArrayDeque<>();
        //从左侧遍历找出每一根柱子的最近最小
        for (int i = 0; i < n; i++) {
            //当单调栈不为空 并且当前栈顶位置的元素的高度大于 heights[i]
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        //从右侧遍历找出每一根柱子的最近最小
        monoStack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                monoStack.pop();
            }
            //n 为右侧的哨兵
            right[i] = monoStack.isEmpty() ? n : monoStack.peek();
            monoStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    /**
     * 单调栈+常数优化
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                //若单调栈的栈顶元素的height >= height[i] 那么单调栈的栈顶元素的最右最小则为 i
                right[monoStack.peek()] = i;
                monoStack.pop();
            }
            left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode84().largestRectangleArea(new int[]{0, 9}));
    }


}
