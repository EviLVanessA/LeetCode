package com.study.LeetCode801_900;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/8/2
 */
public class LeetCode899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            //模拟往后移一个元素
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(s) < 0) {
                    s = sb.toString();
                }
            }
            return s;
        } else {
            //直接排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
