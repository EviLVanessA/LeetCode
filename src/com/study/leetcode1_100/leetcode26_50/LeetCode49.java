package com.study.leetcode1_100.leetcode26_50;

import java.util.*;

/**
 * @author jianghui
 * @date 2020-12-11 14:02
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans = new HashMap<>();
        for (String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Long, Integer> hashIndexMap = new HashMap<>();
        int size = 0;
        for(String str : strs){
            long hash = getHash(str);
            List<String> list;
            if(hashIndexMap.containsKey(hash)){
                int index = hashIndexMap.get(hash);
                list = ans.get(index);
            }else{
                list = new ArrayList<>();
                ans.add(list);
                hashIndexMap.put(hash, size++);
            }
            list.add(str);
        }
        return ans;
    }
    long getHash(String str){
        long hash;
        long sum = 0;
        long prod = 1;
        for(char c : str.toCharArray()){
            sum += c;
            prod *= c;
        }
        hash = sum + prod;
        return hash;
    }
}
