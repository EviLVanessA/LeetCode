package com.study.LeetCode601_700;


import java.util.List;

/**
 * @author jianghui
 * @date 2022/7/6
 */
public class LeetCode648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] s = sentence.split(" ");
        for (String root : dictionary) {
            for (int i = 0; i < s.length; i++) {
                if (s[i].startsWith(root)) {
                    s[i] = root;
                }
            }
        }
        return String.join(",", s);
    }
}
