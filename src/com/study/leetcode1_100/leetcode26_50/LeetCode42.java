package com.study.leetcode1_100.leetcode26_50;

/**
 * @author jianghui
 * @date 2020-12-10 16:48
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int ans = 0;
        int max = getMax(height);
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int tempSum = 0;
            for (int value : height) {
                if (isStart && value < i) {
                    tempSum++;
                }
                if (value >= i) {
                    ans = ans + tempSum;
                    tempSum = 0;
                    isStart = true;
                }
            }
        }
        return ans;
    }

    private int getMax(int[] height) {
        int max = -1;
        for (int i : height) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * 动态规划解法
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 双指针解法
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                if (maxLeft > height[left]) {
                    sum += (maxLeft - height[left]);
                }
                left++;
            }else {
                maxRight = Math.max(maxRight,height[right+1]);
                if (maxRight > height[right]){
                    sum += (maxRight - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

}
