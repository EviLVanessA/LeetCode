package com.study.LeetCode901_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022/5/17
 */
public class LeetCode953 {
    public boolean isAlienSorted(String[] words, String order) {
        //存放字典序
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            dict.put(c, i);
        }
        //判断是否有序
        for (int i = 1; i < words.length; i++) {
            if (!compareWord(words[i - 1], words[i], dict)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 比较两个单词的顺序
     *
     * @param firstWord  第一个单词
     * @param secondWord 第二个单词
     * @param dict       字典序
     * @return
     */
    private boolean compareWord(String firstWord, String secondWord, Map<Character, Integer> dict) {
        //找到最小的位置
        int min = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < min; i++) {
            //比较每个字符是否是 字典序
            if (dict.get(firstWord.charAt(i)) > dict.get(secondWord.charAt(i))) {
                return false;
            } else if (dict.get(firstWord.charAt(i)) < dict.get(secondWord.charAt(i))) {
                return true;
            }
        }
        //走到这儿证明 前min个字符都相等 所以第一个单词必须小于等于第二个单词的长度
        return firstWord.length() <= secondWord.length();
    }
}
