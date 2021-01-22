package com.study.LeetCode501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * @author jianghui
 * @date 2021-01-21 16:27
 */
public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //需要的子串
        char[] t = s1.toCharArray();
        //搜索的字符串
        char[] s = s2.toCharArray();
        //将所需要的字符放入need中
        for (char c : t) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        //valid是当前window所匹配的字符个数
        int valid = 0;
        while (right < s.length) {
            char c = s[right];
            right++;
            //假如此时需要当前字符
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果window的字符和所需要的字符一致
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //当前字符串和目标字符串长度一致
            if (right - left == t.length) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s[left];
                left++;
                //窗口内数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
