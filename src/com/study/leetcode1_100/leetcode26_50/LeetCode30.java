package com.study.leetcode1_100.leetcode26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 
 * words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * @author jianghui
 * @date 2020-09-27  12:36
 **/
public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        //获取单词个数
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        //获取单词长度
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();

        for (String w : words) {
            allWords.put(w, allWords.getOrDefault(w, 0) + 1);
        }

        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            int num = 0;
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                //防止情况三移除后，情况一继续移除
                boolean hasRemoved = false;
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hasWords.get(word) > allWords.get(word)) {
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            num = num - removeNum + 1;
                            //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            i = i + (removeNum - 1) * wordLen;
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }

            }

        }
        return res;
    }
}
