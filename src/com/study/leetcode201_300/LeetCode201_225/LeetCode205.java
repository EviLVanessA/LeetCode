package com.study.leetcode201_300.LeetCode201_225;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * @author jianghui
 * @date 2021-01-18 11:30
 */
public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> seen = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (seen.containsKey(chars1[i])){
                if (seen.get(chars1[i]) != chars2[i]){
                    return false;
                }
            }else {
                seen.put(chars1[i],chars2[i]);
            }
        }
        seen.clear();
        for (int i = 0; i < chars2.length; i++) {
            if (seen.containsKey(chars2[i])){
                if (seen.get(chars2[i]) != chars1[i]){
                    return false;
                }
            }else {
                seen.put(chars2[i],chars1[i]);
            }
        }
        return true;
    }
}
