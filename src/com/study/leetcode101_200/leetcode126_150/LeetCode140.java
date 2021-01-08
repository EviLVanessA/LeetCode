package com.study.leetcode101_200.leetcode126_150;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * @author jianghui
 * @date 2021-01-07 10:01
 */
public class LeetCode140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backTrack(s,s.length(),new HashSet<>(wordDict),0,map);
        List<String> ans = new ArrayList<>();
        for(List<String> wordBreak : wordBreaks){
            ans.add(String.join(" ",wordBreak));
        }
        return ans;
    }

    private List<List<String>> backTrack(String s, int length, HashSet<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if(!map.containsKey(index)){
            List<List<String>> wordBreaks = new ArrayList<>();
            if (index == length){
                wordBreaks.add(new ArrayList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index,i);
                if (wordSet.contains(word)){
                    List<List<String>> nextWordBreaks = backTrack(s,length,wordSet,i,map);
                    for (List<String> nextWordBread : nextWordBreaks){
                        LinkedList<String> wordBreak = new LinkedList<>(nextWordBread);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index,wordBreaks);
        }
        return map.get(index);
    }
}
