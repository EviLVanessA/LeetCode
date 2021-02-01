package com.study.LeetCode801_900;


import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2021-01-26 08:42
 */
public class LeetCode887 {
    Map<String, Integer> memory = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memory.containsKey(N + "," + K)) {
            return memory.get(N + "," + K);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            //                          第i层没碎          第i层碎了
            ans = Math.min(ans, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        memory.put(N + "," + K, ans);
        return ans;
    }

    /**
     * 动态规划+二分搜索优化
     *
     * @param K
     * @param N
     * @return
     */
    private int dp2(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memory.containsKey(N + "," + K)) {
            return memory.get(N + "," + K);
        }
        int ans = Integer.MAX_VALUE;
        int low = 1, high = N;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int broken = dp2(K - 1, mid - 1);
            int notBroken = dp2(K, N - mid);
            if (broken > notBroken) {
                high = mid - 1;
                ans = Math.min(ans, broken + 1);
            } else {
                low = mid + 1;
                ans = Math.min(ans, notBroken + 1);
            }
        }
        memory.put(N + "," + K, ans);
        return ans;
    }

    /**
     * 动态规划的另一种方法
     * dp[k][m]=N 表示 有k个蛋 扔m次 在最坏情况下 可确定N层楼
     * 蛋没碎,楼上  本层   蛋碎了,楼下
     * 则dp[k][m] = dp[k][m-1] + 1 + dp[k-1][m-1];
     *
     * @param K
     * @param N
     * @return
     */
    int superEggDrop2(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i][m - 1] + 1 + dp[i - 1][m - 1];
            }
        }
        return m;
    }

    /**
     * 数学方法
     *
     * @param K
     * @param N
     * @return
     */
    int superEggDrop3(int K, int N) {
        int T = 1;
        while (calcF(K, T) < N + 1) {
            T++;
        }
        return T;
    }

    private int calcF(int K, int T) {
        if (T == 1 || K == 1) {
            return T + 1;
        }
        return calcF(K - 1, T - 1) + calcF(K, T - 1);
    }
}
