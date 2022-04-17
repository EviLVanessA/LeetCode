package com.study.LeetCode801_900;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-04-17 08:49
 */
public class LeetCode819 {
    public static void main(String[] args) {
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] bans = {"hit"};
        System.out.println(mostCommonWord(para, bans));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] s = paragraph.replace("!", "")
                .replace("?", " ")
                .replace("'", " ")
                .replace(",", " ")
                .replace(";", " ")
                .replace(".", " ")
                .replace("  "," ")
                .toLowerCase()
                .split(" ");
        Map<String, Integer> result = new TreeMap<>();
        HashSet<String> bans = new HashSet<>(Arrays.asList(banned));
        for (String str : s) {
            if (!bans.contains(str)) {
                result.put(str, result.getOrDefault(str, 0) + 1);
            }
        }
        int max = 0;
        String target = "";
        for (String s1 : result.keySet()) {
            if (result.get(s1) >= max) {
                max = result.get(s1);
                target = s1;
            }
        }
        return target;
    }
}