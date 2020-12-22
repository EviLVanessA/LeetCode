package com.study.leetcode101_200;

/**
 *     你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷
 * 窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一
 * 晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计
 * 算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author jianghui
 * @date 2020-09-19  13:51
 **/
public class LeetCode198 {
    /**
     * 方案一 采用记忆化搜索的方式 自顶向下
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] memory = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memory[i] = -1;
        }

        return tryRob(nums,0,memory);
    }
    private int tryRob(int[] nums,int index,int[] memory){
        if (index >= nums.length){
            return 0;
        }
        if (memory[index] != -1){
            return memory[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res,nums[i] + tryRob(nums,i+2,memory));
        }
        memory[index] = res;
        return res;
    }

    /**
     * 方案二 采用动态规划 自底向上
     * 相关试题213 337 309
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int[] memory = new int[n];
        //memory[i]表示抢劫nums[i...n-1]的最大收益
        for (int i = 0; i < n; i++) {
            memory[i] = -1;
        }
        memory[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            //求解memory[i]
            //n可以改为i+2
            for (int j = i; j < n; j++) {
                memory[i] = Math.max(memory[i],nums[j] + (j+2<n ? memory[j+2] : 0));
            }
        }
        return memory[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,5,6,3,1};
        System.out.println(rob2(arr));
    }
}