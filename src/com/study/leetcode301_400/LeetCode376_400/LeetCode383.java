package com.study.leetcode301_400.LeetCode376_400;

/**
 * @author jianghui
 * @date 2022/9/15
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char aChar : magazine.toCharArray()) {
            count[aChar - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
