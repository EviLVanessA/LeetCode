package com.study.leetcode1_100.leetcode76_100;

/**
 * @author jianghui
 * @date 2020-12-21 17:48
 */
public class LeetCode80 {
    /**
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                n--;
                if (nums.length - 1 - i >= 0) {
                    System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                }
                i--;
            }
        }
        return n;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6};
        int i = new LeetCode80().removeDuplicates(arr);
        for (int j = 0; j < i; j++) {
            System.out.println(arr[j]);
        }
    }
}
