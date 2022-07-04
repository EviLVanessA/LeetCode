package com.study.competition.competition300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-07-03 10:30
 */
public class LeetCode6108 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char[] chars = key.toCharArray();
        char index = 'a';
        for (char aChar : chars) {
            if (aChar != ' ' && !map.containsKey(aChar)) {
                map.put(aChar, index);
                index++;
            }
        }
        char[] chars1 = message.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != ' ') {
                chars1[i] = map.get(chars1[i]);
            }
        }
        return new String(chars1);
    }
}
