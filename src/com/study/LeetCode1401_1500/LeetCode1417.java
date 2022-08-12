package com.study.LeetCode1401_1500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/8/11
 */
public class LeetCode1417 {
    public String reformat(String s) {
        List<Character> num1 = new ArrayList<>();
        List<Character> num2 = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                num1.add(aChar);
            } else {
                num2.add(aChar);
            }
        }
        if (Math.abs(num1.size() - num2.size()) >= 2) {
            return "";
        }
        if (num1.size() > num2.size()) {
            return handler(num1, num2, s.length());
        } else {
            return handler(num2, num1, s.length());
        }
    }

    private String handler(List<Character> num1, List<Character> num2, int n) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while (k < n) {
            if (k % 2 == 0) {
                sb.append(num1.get(i++));
            } else {
                sb.append(num2.get(j++));
            }
            k++;
        }
        return sb.toString();
    }


    public String reformat2(String s) {
        int num1 = 0, num2 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num1++;
            } else {
                num2++;
            }
        }
        if (Math.abs(num1 - num2) > 1) {
            return "";
        }
        if (num1 > num2) {
            num1 = 0;
            num2 = 1;
        } else {
            num1 = 1;
            num2 = 0;
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars[num1] = c;
                num1 += 2;
            } else {
                chars[num2] = c;
                num2 += 2;
            }
        }
        return new String(chars);
    }
}
