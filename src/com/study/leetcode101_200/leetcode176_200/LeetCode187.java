package com.study.leetcode101_200.leetcode176_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianghui
 * @date 2021-01-15 10:09
 */
public class LeetCode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0, j = 10; j <= s.length(); i++, j++) {
            String str = s.substring(i, j);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : map.keySet()){
            if (map.get(str) > 1){
                ans.add(str);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "123456789A";
    }
}
