package com.study.leetcode301_400.LeetCode301_325;

import com.study.leetcode1_100.leetcode1_25.LeetCode3;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/5/23
 */
public class LeetCode324 {
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left++;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
        new LeetCode324().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
