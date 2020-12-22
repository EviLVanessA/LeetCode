package com.study.leetcode1_100.leetcode26_50;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author jianghui
 * @date 2020-09-27  18:44
 **/
public class LeetCode32 {
    public static void main(String[] args) {
        String str = "(()";
        System.out.println(new LeetCode32().longestValidParentheses2(str));
    }
    /**
     * 动态规划
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * 正向逆向遍历
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int left = 0, right = 0,maxLength = 0;
        //正向遍历
        for (int i = 0; i < n; i++) {
            if (ch[i] == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxLength = Math.max(maxLength,2 * left);
            } else if (right > left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        //逆向遍历
        for (int i = n-1; i >= 0 ; i--) {
            if (ch[i] == ')'){
                right++;
            }
            if (ch[i] == '('){
                left++;
            }
            if (left == right){
                maxLength = Math.max(maxLength,2 * left);
            } else if (right < left){
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }
}
