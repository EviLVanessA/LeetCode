package com.study.leetcode101_200.leetcode126_150;

/**
 * @author jianghui
 * @date 2021-01-06 15:28
 */
public class LeetCode134 {
    /**
     * 暴力
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int curGas = 0;
            int j = 0;
            int k = i;
            while (j < n) {
                k = k % n;
                curGas += gas[k];
                if (curGas < cost[k]) {
                    break;
                } else {
                    curGas = curGas - cost[k];
                    k++;
                    j++;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 遍历一次
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumGas = 0;
            int sumCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas < sumCost){
                    break;
                }
                cnt++;
            }
            if (cnt == n){
                return i;
            }else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    /**
     * 贪心算法优化
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit3(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            // 当前累加rest[i]和 curSum一旦小于0
            if (curSum < 0) {
                // 起始位置更新为i+1
                start = i + 1;
                // curSum从0开始
                curSum = 0;
            }
        }
        // 说明怎么走都不可能跑一圈了
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {5, 8, 2, 8};
        int[] cost = {6, 5, 6, 6};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
