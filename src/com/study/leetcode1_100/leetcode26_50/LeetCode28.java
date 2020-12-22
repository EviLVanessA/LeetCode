package com.study.leetcode1_100.leetcode26_50;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author jianghui
 * @date 2020-09-27  11:09
 **/
public class LeetCode28 {
    public static void main(String[] args) {
        String str = "aaaaa";
        String str2 = "bba";
        System.out.println(strStr(str,str2));
    }

    /**
     * 基于滑动窗口
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 基于双指针
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) {
            return 0;
        }

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                ++pn;
            }

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) {
                return pn - L;
            }

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }
}
