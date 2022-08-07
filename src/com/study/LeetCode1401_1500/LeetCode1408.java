package com.study.LeetCode1401_1500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-08-06 09:11
 */
public class LeetCode1408 {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<String>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public List<String> stringMatching2(String[] words) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //拼成一个字符串
        for (String word : words) {
            sb.append(word).append(",");
        }
        //是不是存在两个位置
        for (String word : words) {
            if (sb.indexOf(word) != sb.lastIndexOf(word)) {
                ans.add(word);
            }
        }
        return ans;
    }
}
