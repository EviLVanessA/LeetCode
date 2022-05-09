package com.study.leetcode401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/8
 */
public class LeetCode442 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        new LeetCode442().findDuplicates(arr);
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                printArr(nums);
                System.out.println();
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
