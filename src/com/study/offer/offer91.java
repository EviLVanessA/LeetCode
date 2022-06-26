package com.study.offer;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-24 23:04
 */
public class offer91 {
    public int minCost2(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        //刷第一个颜色
        dp[0][0] = costs[0][0];
        //刷第二个颜色
        dp[0][1] = costs[0][1];
        //刷第三个颜色
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            //第i个房子刷第一个颜色
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            //第i个房子刷第二个颜色
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            //第i个房子刷第三个颜色
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[2][3];
        //刷第一个颜色
        dp[0][0] = costs[0][0];
        //刷第二个颜色
        dp[0][1] = costs[0][1];
        //刷第三个颜色
        dp[0][2] = costs[0][2];
        int[] temp;
        for (int i = 1; i < n; i++) {
            //第i个房子刷第一个颜色
            dp[1][0] = Math.min(dp[0][1], dp[0][2]) + costs[i][0];
            //第i个房子刷第二个颜色
            dp[1][1] = Math.min(dp[0][0], dp[0][2]) + costs[i][1];
            //第i个房子刷第三个颜色
            dp[1][2] = Math.min(dp[0][0], dp[0][1]) + costs[i][2];
            //将i-1的覆盖为i的
            temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }

    public int minCost3(int[][] costs) {
        int n = costs.length;
        int[] oldDp = new int[3];
        int[] newDp = new int[3];
        //刷第一个颜色
        oldDp[0] = costs[0][0];
        //刷第二个颜色
        oldDp[1] = costs[0][1];
        //刷第三个颜色
        oldDp[2] = costs[0][2];
        int[] temp;
        for (int i = 1; i < n; i++) {
            //第i个房子刷第一个颜色
            newDp[0] = Math.min(oldDp[1], oldDp[2]) + costs[i][0];
            //第i个房子刷第二个颜色
            newDp[1] = Math.min(oldDp[0], oldDp[2]) + costs[i][1];
            //第i个房子刷第三个颜色
            newDp[2] = Math.min(oldDp[1], oldDp[0]) + costs[i][2];
            //将旧值替换为新值，直接替换数组引用
            temp = newDp;
            newDp = oldDp;
            oldDp = temp;
        }
        return Math.min(oldDp[0], Math.min(oldDp[2], oldDp[1]));
    }

    public int minCost4(int[][] costs) {
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            //第i个房子刷第一个颜色
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]) + costs[i][0];
            //第i个房子刷第二个颜色
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]) + costs[i][1];
            //第i个房子刷第三个颜色
            costs[i][2] = Math.min(costs[i - 1][0], costs[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}
