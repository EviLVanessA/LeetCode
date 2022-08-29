package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022/8/29
 */
public class LeetCode1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int i = 0, j = n, k = 0;
        while (k < 2 * n) {
            ans[k++] = nums[i++];
            ans[k++] = nums[j++];
        }
        return ans;
    }
}
