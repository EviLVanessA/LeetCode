package com.study.leetcode301_400.LeetCode326_350;

/**
 * @author jianghui
 * @date 2022/7/8
 */
public class LeetCode330 {
    public int minPatches(int[] nums, int n) {
        int ans = 0;
        long x = 1;
        int len = nums.length, index = 0;
        while (x <= n) {
            if (index < len && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x = 2 * x;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode330().minPatches(new int[]{1, 5, 10}, 20));
    }
}
