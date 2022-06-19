package com.study.competition.competition298;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-06-19 10:30
 */
public class LeetCode5242 {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            set.add(aChar);
        }
        char ans = 'A' - 1;
        for (char aChar : chars) {
            if ('a' <= aChar && aChar <= 'z') {
                if (set.contains((char) (aChar - 32))) {
                    ans = ans > (aChar - 32) ? ans : (char) (aChar - 32);
                }
            } else {
                if (set.contains((char) (aChar + 32))) {
                    ans = ans > aChar ? ans : aChar;
                }
            }
        }
        return ans == 'A' - 1 ? "" : String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5242().greatestLetter("lEeTcOdE"));
    }
}
