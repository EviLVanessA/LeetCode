package com.study.leetcode301_400.LeetCode326_350;

/**
 * @author jianghui
 * @date 2022/7/22
 */
public class LeetCode345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && isNotVowels(chars[i])) {
                i++;
            }
            while (i < j && isNotVowels(chars[j])) {
                j--;
            }
            if (i < j) {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public boolean isNotVowels(char ch) {
        return ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
                ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }

}
