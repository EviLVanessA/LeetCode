package com.study.leetcode301_400;

import java.util.HashMap;

/**
 * @author jianghui
 * @date 2021-03-17 14:48
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> ans = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            ans.put(ch, ans.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (ans.get(chars[i]) == 1) {
                return i;
            }
        }
        return 0;
    }

    public int firstUniqChar2(String s) {
        int[] ans = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            ans[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (ans[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
