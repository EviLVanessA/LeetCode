package com.study.competition.competition303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-07-24 10:30
 */
public class LeetCode6124 {
    public char repeatedCharacter(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (set.contains(aChar)) {
                return aChar;
            }
            set.add(aChar);
        }
        return 'a';
    }
}
