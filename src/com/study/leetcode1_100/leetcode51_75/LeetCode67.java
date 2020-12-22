package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-18 09:50
 */
public class LeetCode67 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int n = Math.max(a.length(), b.length());
        for (int i = 0; i < n; i++){
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char)(carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0){
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode67().addBinary("0","0"));
    }
}
