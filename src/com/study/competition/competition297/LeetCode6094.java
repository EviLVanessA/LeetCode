package com.study.competition.competition297;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-06-12 11:19
 */
public class LeetCode6094 {
    public long distinctNames(String[] ideas) {
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        Collections.addAll(set, ideas);
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                String newString1 = ideas[i].charAt(0) + ideas[j].substring(1);
                String newString2 = ideas[j].charAt(0) + ideas[i].substring(1);
                if (!set.contains(newString1) && !set.contains(newString2)) {
                    ans.add(newString1 + " " + newString2);
                    ans.add(newString2 + " " + newString1);
                    set.add(newString1);
                    set.add(newString2);
                }
            }
        }
        return ans.size();
    }

    class Solution {
        public long distinctNames(String[] ideas) {
            Set<String> set = new HashSet<>();
            int[][] records = new int[26][26];
            for(int i = 0 ; i < ideas.length ; i++){
                set.add(ideas[i]);
            }
            String temp;
            for(int i = 0 ; i < ideas.length ; i++){
                for(char c = 'a' ; c <= 'z' ; c++){
                    temp = c+ideas[i].substring(1);
                    if(!set.contains(temp)){
                        records[c-'a'][ideas[i].charAt(0)-'a']++;
                    }
                }
            }
            long ans = 0;
            for(int i = 0 ; i < ideas.length ; i++){
                for(char c = 'a' ; c <= 'z' ; c++){
                    temp = c+ideas[i].substring(1);
                    if(!set.contains(temp)){
                        ans += records[ideas[i].charAt(0)-'a'][c-'a'];
                    }
                }
            }
            return ans;
        }
    }
}
