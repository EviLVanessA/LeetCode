package com.study.leetcode1_100.leetcode76_100;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 题目数据保证答案肯定是一个 32 位的整数。
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * @author jianghui
 * @date 2020-12-23 09:28
 */
public class LeetCode91 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {

            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                //如果是20、10
                if (s.charAt(i) == '0') {
                    dp[i + 1] = dp[i - 1];
                }
                //如果是11-19、21-26
                else {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            } else if (s.charAt(i) == '0') {
                //如果是0、30、40、50
                return 0;
            } else {
                //i-1和i无法构成一个字母
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode91().numDecodings("226"));
    }
}
