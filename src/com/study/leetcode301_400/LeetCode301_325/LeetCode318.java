package com.study.leetcode301_400.LeetCode301_325;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-05-22 21:26
 */
public class LeetCode318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                mask[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public int maxProduct2(String[] words) {
        int n = words.length;
        Map<Integer, Integer> mask = new HashMap<>();
        for (String word : words) {
            int curMask = 0;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                curMask |= 1 << (c - 'a');
            }
            mask.put(curMask, Math.max(mask.getOrDefault(curMask, 0), word.length()));
        }
        int max = 0;
        for (int i : mask.keySet()) {
            for (int j : mask.keySet()) {
                if ((i & j) == 0) {
                    max = Math.max(max, mask.get(i) * mask.get(j));
                }
            }
        }
        return max;
    }
}
