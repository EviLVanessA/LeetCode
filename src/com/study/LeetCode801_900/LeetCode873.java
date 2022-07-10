package com.study.LeetCode801_900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-07-09 08:26
 */
public class LeetCode873 {
    public int lenLongestFibSubseq1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            map.put(value, value);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int pre = arr[i];
                int cur = arr[j];
                int count = 2;
                //判断是否有第三项
                while (map.containsKey(pre + cur)) {
                    count++;
                    int temp = map.get(pre + cur);
                    pre = cur;
                    cur = temp;
                }
                if (count >= 3) {
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    public int lenLongestFibSubseq2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int ans = 0;
        //记忆化搜索
        int[][] memo = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int count = dfs(map, i, j, memo, arr);
                if (count >= 3) {
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    public int dfs(Map<Integer, Integer> map, int i, int j, int[][] memo, int[] arr) {
        //已经计算 直接返回
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        //默认长度是两个
        memo[i][j] = 2;
        //寻找下一个
        int key = arr[i] + arr[j];
        if (map.containsKey(key)) {
            memo[i][j] = 1 + dfs(map, j, map.get(key), memo, arr);
        }
        return memo[i][j];
    }

    public int lenLongestFibSubseq3(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                if (map.containsKey(arr[i] - arr[j])) {
                    int k = map.get(arr[i] - arr[j]);
                    dp[j][i] = dp[k][j] + 1;
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode873().lenLongestFibSubseq2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
