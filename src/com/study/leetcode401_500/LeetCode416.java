package com.study.leetcode401_500;

import javax.print.attribute.standard.NumberUp;

/**
 * 分割集和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 相关问题 322 377 474 139 494
 * @author jianghui
 * @date 2020-09-19  15:55
 **/
public class LeetCode416 {
    /**
     * 记忆搜索 自顶向下进行
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        sum = sum / 2;

        //memory[i][c] 表示使用索引为[0...i]的这些元素，是否可以完全填充一个容量为c的背包
        //0未计算 1可以填充 2不可以填充
        int[][] memory = new int[nums.length][sum+1];

        return tryPartition(nums,nums.length-1,sum,memory);
    }

    /**
     * 使用nums[0...index],是否可以完全填充一个容量为sum的背包
     * @param nums
     * @param index
     * @param c
     * @return
     */
    private boolean tryPartition(int[] nums,int index,int c,int[][] memory){
        if (c == 0){
            return true;
        }
        if (c < 0 || index < 0){
            return false;
        }

        if (memory[index][c] != 0){
            return memory[index][c] == 1;
        }
        memory[index][c] = tryPartition(nums,index-1,c,memory) ||
                        tryPartition(nums,index-1,c-nums[index],memory) ? 1 : 2;
        return memory[index][c] == 1;
    }

    /**
     * 动态规划 自底向上
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[] memory = new boolean[sum+1];
        for (int i = 0; i <= sum; i++) {
            memory[i] = nums[0] == i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                memory[j] = memory[j] || memory[j-nums[i]];
            }
        }
        return memory[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2};
        System.out.println(new LeetCode416().canPartition2(nums));
    }
}






















