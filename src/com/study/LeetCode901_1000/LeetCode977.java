package com.study.LeetCode901_1000;

/**
 * @author jianghui
 * @date 2022-06-28 08:49
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 0;
        while (i < nums.length && nums[i] < 0) {
            i++;
            j++;
        }
        j--;
        int k = 0;
        while (j >= 0 && i < nums.length) {
            if (nums[i] * nums[i] <= nums[j] * nums[j]) {
                ans[k++] = nums[i] * nums[i];
                i++;
            } else {
                ans[k++] = nums[j] * nums[j];
                j--;
            }
        }
        while (j >= 0) {
            ans[k++] = nums[j] * nums[j];
            j--;
        }
        while (i < nums.length) {
            ans[k++] = nums[i] * nums[i];
            i++;
        }
        return ans;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int k = nums.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[k--] = nums[j] * nums[j];
                j--;
            } else {
                ans[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return ans;
    }
}
