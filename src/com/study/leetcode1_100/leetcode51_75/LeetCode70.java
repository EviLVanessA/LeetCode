package com.study.leetcode1_100.leetcode51_75;

/**
 * 爬楼梯问题
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author jianghui
 * @date 2020-09-19  13:32
 **/
public class LeetCode70 {
    public int climbStairs(int n) {
        int[] memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = -1;
        }

        return climb(memory,n);
    }

    /**
     *
     * 自顶向下解决问题
     * 递归 + 记忆化搜索
     * @param memory
     * @param n
     * @return
     */
    private int climb(int[] memory,int n){
        if (n == 0 || n == 1){
            return 1;
        }
        if (memory[n] == -1){
            memory[n] = climb(memory,n-1) + climb(memory,n-2);
        }
        return memory[n];
    }

    /**
     * 自底向上解决问题
     * 采用动态规划  相关题120 64
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] memory = new int[n+1];
        memory[0] = 1;
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n];
    }

}
