package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022-08-21 08:33
 */
public class LeetCode1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
