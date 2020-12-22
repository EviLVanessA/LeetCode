package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-21 09:19
 */
public class LeetCode72 {
    /**
     * 基于动态规划
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int lenA = word1.length();
        int lenB = word2.length();
        if (lenA * lenB == 0) {
            return lenA + lenB;
        }
        int[][] dp = new int[lenA + 1][lenB + 1];
        //从wordA 向一个空串转化
        for (int i = 0; i < lenA + 1; i++) {
            dp[i][0] = i;
        }
        //从"" 向一个wordB转化
        for (int i = 0; i < lenB + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < lenA + 1; i++) {
            for (int j = 1; j < lenB + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left,Math.min(down,leftDown));
            }
        }
        return dp[lenA][lenB];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode72().minDistance("horse", "ros"));
    }
}
