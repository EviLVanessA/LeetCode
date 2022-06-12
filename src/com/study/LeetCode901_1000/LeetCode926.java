package com.study.LeetCode901_1000;

/**
 * @author jianghui
 * @date 2022-06-11 07:35
 */
public class LeetCode926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        //多加一列初始状态
        int[][] dp = new int[n + 1][2];
        //初始状态都是0
        dp[0][0] = 0;
        dp[0][1] = 0;
        char[] chars = s.toCharArray();
        //计算变换次数
        for (int i = 0; i < n; i++) {
            //把第i个字符变成0
            dp[i + 1][0] = dp[i][0] + (chars[i] == '1' ? 1 : 0);
            //把第i个字符变成1
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]) + (chars[i] == '0' ? 1 : 0);
        }
        return Math.min(dp[n][0], dp[n][1]);
    }

    public int minFlipsMonoIncr2(String s) {
        int n = s.length();
        //初始状态都是0
        int dp0 = 0;
        int dp1 = 0;
        char[] chars = s.toCharArray();
        //计算变换次数
        for (int i = 0; i < n; i++) {
            //把第i个字符变成0
            int curDp0 = dp0 + (chars[i] == '1' ? 1 : 0);
            //把第i个字符变成1
            int curDp1 = Math.min(dp0, dp1) + (chars[i] == '0' ? 1 : 0);
            dp0 = curDp0;
            dp1 = curDp1;
        }
        return Math.min(dp0, dp1);
    }

    public int minFlipsMonoIncr3(String s) {
        int dp0 = 0, dp1 = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            //先更新dp[i][1]，需要用到dp[i][0] 由于只有0和1，也不在使用三目运算
            dp1 = Math.min(dp0, dp1) + ('1' - ch);
            dp0 += ch - '0';
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode926().minFlipsMonoIncr("00110"));
    }
}
