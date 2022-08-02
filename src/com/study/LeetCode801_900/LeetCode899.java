package com.study.LeetCode801_900;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/8/2
 */
public class LeetCode899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(s) < 0) {
                    s = sb.toString();
                }
            }
            return s;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
