package com.study.LeetCode1601_1700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-09-17 10:41
 */
public class LeetCode1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int n = s.lastIndexOf(chars[i]);
            if (n - i - 1 > ans) {
                ans = n - i - 1;
            }
        }
        return ans;
    }

    public int maxLengthBetweenEqualCharacters2(String s) {
        int ans = -1;
        List<Integer>[] list = new ArrayList[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (list[index] == null) {
                list[index] = new ArrayList<>();
            }
            list[chars[i] - 'a'].add(i);
        }
        for (int i = 0; i < 26; i++) {
            if (list[i] != null && list[i].size() > 1) {
                ans = Math.max(ans, (list[i].get(list[i].size() - 1) - list[i].get(0)) - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1624().maxLengthBetweenEqualCharacters2("cbzxy"));
    }
}
