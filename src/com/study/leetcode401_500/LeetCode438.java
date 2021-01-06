package com.study.leetcode401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串s和p的长度都不超过 20100。
 *
 * @author jianghui
 * @date 2021-01-06 17:18
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();
        // 定义一个 needs 数组记录 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];
        // 先将 arrP 中的元素保存到 needs 数组中
        for (char c : arrP) {
            needs[c - 'a'] ++;
        }
        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] ++;
            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] --;
            }
            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }
}
