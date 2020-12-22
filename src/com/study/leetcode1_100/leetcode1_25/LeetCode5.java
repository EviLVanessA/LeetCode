package com.study.leetcode1_100.leetcode1_25;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * @author jianghui
 * @date 2020-09-23  16:57
 **/
public class LeetCode5 {
    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null){
            return null;
        }
        int start = 0, end = 0,n = s.length();
        for (int i = 0; i < n; i++) {
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end + 1);
    }
    private int expand(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

}
