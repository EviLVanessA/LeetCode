package com.study.leetcode201_300.LeetCode251_275;

public class LeetCode268 {
    public static void main(String[] args) {

    }

    /**
     * 辅助空间
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        int[] result = new int[nums.length + 1];
        for (int num : nums) {
            result[num] = 1;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                return i;
            }
        }
        return 0;
    }


    public int missingNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            while (nums[i] != nums.length && nums[i] != i) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 位运算
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        return xor;
    }

    /**
     * 数学求和
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : nums) {
            arrSum += num;
        }
        return total - arrSum;
    }

}
