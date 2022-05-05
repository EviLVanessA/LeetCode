package com.study.leetcode201_300.LeetCode276_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022/4/27
 */
public class LeetCode290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> wordToChar = new HashMap<>();
        Map<Character, String> charToWord = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int j = 0; j < pattern.length(); j++) {
            char c = pattern.charAt(j);
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(words[j])) {
                return false;
            }
            if (wordToChar.containsKey(words[j]) && wordToChar.get(words[j]) != c) {
                return false;
            }
            wordToChar.put(words[j], c);
            charToWord.put(c, words[j]);
        }
        return true;
    }

}
