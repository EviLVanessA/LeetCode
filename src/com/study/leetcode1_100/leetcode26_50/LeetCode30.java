package com.study.leetcode1_100.leetcode26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 
 * words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * @author jianghui
 * @date 2020-09-27  12:36
 **/
public class LeetCode30 {
    public List<Integer> findSubstring1(String s, String[] words) {
        //单词个数
        int n = words.length;
        //单词长度
        int wordLength = words[0].length();
        List<Integer> ans = new ArrayList<>();
        //存放所有单词
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        //移动i
        for (int i = 0; i < s.length() - wordLength * n + 1; i++) {
            HashMap<String, Integer> curMap = new HashMap<>();
            //是否存在异常情况
            boolean errorFlag = false;
            for (int j = 0; j < n; j++) {
                //第j个单词
                String curWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                //出现不存在单词
                if (!wordsMap.containsKey(curWord)) {
                    errorFlag = true;
                    break;
                }
                curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
                //出现超数量单词
                if (curMap.get(curWord) > wordsMap.get(curWord)) {
                    errorFlag = true;
                    break;
                }
            }
            //没有异常情况 记录答案
            if (!errorFlag) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int wordLength = words[0].length();
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int num = 0;
            HashMap<String, Integer> curMap = new HashMap<>();
            for (int j = i; j < s.length() - wordLength * n + 1; j = j + wordLength) {
                boolean removeFlag = false;
                while (num < n) {
                    String curWord = s.substring(j + num * wordLength, j + (num + 1) * wordLength);
                    if (wordsMap.containsKey(curWord)) {
                        curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
                        num++;
                        int removeNum = 0;
                        while (curMap.get(curWord) > wordsMap.get(curWord)) {
                            String word = s.substring(j + removeNum * wordLength, j + (removeNum + 1) * wordLength);
                            curMap.put(word, curMap.get(word) - 1);
                            removeNum++;
                        }
                        if (removeNum > 0) {
                            removeFlag = true;
                            num = num - removeNum;
                            j = j + num * wordLength;
                            break;
                        }
                    } else {
                        curMap.clear();
                        j = j + num * wordLength;
                        num = 0;
                        break;
                    }
                }
                if (num == n) {
                    ans.add(j);
                }
                if (num > 0 && !removeFlag) {
                    String firstWord = s.substring(j, j + wordLength);
                    curMap.put(firstWord, curMap.get(firstWord) - 1);
                    num--;
                }
            }
        }
        return ans;
    }


    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hasWords.get(word) > allWords.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
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
