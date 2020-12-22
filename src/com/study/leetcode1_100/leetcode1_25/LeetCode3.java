package com.study.leetcode1_100.leetcode1_25;

/**
 * 寻找字符串中连续最长无公共字符的子串  438 76
 * @author jianghui
 * @date 2020-09-15  16:48
 **/
public class LeetCode3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }


    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[256];
        int l = 0,r = -1;
        int res = 0;
        while (l < s.length()){
            if (r + 1 < s.length() && freq[s.charAt(r+1)] == 0 ){
                r++;
                freq[s.charAt(r)] = 1;
            }else {
                freq[s.charAt(l)] = 0;
                l++;
            }
            res = Math.max(res,r - l + 1);
        }

        return res;
    }
}
