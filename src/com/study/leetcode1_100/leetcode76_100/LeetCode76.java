package com.study.leetcode1_100.leetcode76_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2020-12-21 11:26
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen) {
                current.put(s.charAt(r), current.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check(target, current) && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                current.put(s.charAt(l), current.getOrDefault(s.charAt(l), 0) - 1);
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check(Map<Character, Integer> target, Map<Character, Integer> current) {
        for (Character c : target.keySet()) {
            if (current.getOrDefault(c, 0) < target.get(c)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        //英文字母所以最大52位，其中还多占用了6位特殊字符的位置，直接使用ascII码值为index
        int[] need = new int[58];
        int[] window = new int[58];
        //count记录已经覆盖的字母的数量
        int count = 0, maxL = -1, max = s.length() + 1, tCount = 0;
        int l = 0, r = 0, sLen = s.length(), tLen = t.length();
        //填充需要覆盖的t中字母和对应的数量
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need[c - 65]++;
        }
        for (int value : need) {
            if (value > 0) {
                tCount++;
            }
        }
        while (r < sLen) {
            int c = s.charAt(r) - 65;
            if (need[c] != 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    count++;
                    while (count == tCount) {
                        int cL = s.charAt(l) - 65;
                        if (need[cL] != 0) {
                            window[cL]--;
                            if (window[cL] < need[cL]) {
                                count--;
                                if (max > r - l + 1) {
                                    max = r - l + 1;
                                    maxL = l;
                                }
                            }
                        }
                        l++;
                    }
                }
            }
            r++;
        }
        return maxL == -1 ? "" : s.substring(maxL, maxL + max);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
