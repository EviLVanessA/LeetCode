package com.study.leetcode401_500;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/5/25
 */
public class LeetCode467 {
    public int findSubstringInWraproundString(String p) {
        int length = p.length();
        //存储以字符结尾的个数
        int[] counts = new int[26];
        //第一个字符默认一个
        counts[p.charAt(0) - 'a'] = 1;
        int count = 1;
        for (int i = 1; i < length; i++) {
            //当前字符
            char curChar = p.charAt(i);
            //前一个字符
            char lastChar = p.charAt(i - 1);
            //是否连续
            int remainder = (curChar - lastChar) % 26;
            //相差1或者-25（za） 表示连续
            if (remainder == 1 || remainder == -25) {
                count++;
            } else {
                count = 1;
            }
            //更新以字符curChar结尾的子串数量，有重复结尾的字符，以最大的为准
            counts[curChar - 'a'] = Math.max(count, counts[curChar - 'a']);
        }
        return Arrays.stream(counts).sum();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode467().findSubstringInWraproundString("zab"));
    }

}
