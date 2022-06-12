package com.study.LeetCode801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-06-11 23:11
 */
public class LeetCode890 {
    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isMatch(pattern, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean isMatch(String pattern, String word) {
        //单词长度是否一致
        if (word.length() != pattern.length()) {
            return false;
        }
        //两个映射
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();
        char[] chars = word.toCharArray();
        char[] patterns = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //判断映射是否与之前一致
            if (wordToPattern.containsKey(chars[i])) {
                if (wordToPattern.get(chars[i]) != patterns[i]) {
                    return false;
                }
            }
            if (patternToWord.containsKey(patterns[i])) {
                if (patternToWord.get(patterns[i]) != chars[i]) {
                    return false;
                }
            }
            //保存映射
            wordToPattern.put(chars[i], patterns[i]);
            patternToWord.put(patterns[i], chars[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        new LeetCode890().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb").forEach(
                System.out::println
        );
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char c1 = word.charAt(i);
                char c2 = pattern.charAt(i);
                if (cnt1[c1 - 'a'] == 0) {
                    cnt1[c1 - 'a'] = c2;
                }
                if (cnt2[c2 - 'a'] == 0) {
                    cnt2[c2 - 'a'] = c1;
                }
                if (cnt1[c1 - 'a'] != c2 || cnt2[c2 - 'a'] != c1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(word);
            }
        }
        return ans;
    }
}
