package com.study.leetcode401_500;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jianghui
 * @date 2022/5/19
 */
public class LeetCode402 {
    public String removeKdigits(String num, int k) {
        int kk = k;
        int n = num.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peekLast() > c && kk > 0) {
                stack.pollLast();
                kk--;
            }
            stack.offerLast(c);
        }
        for (int i = 0; i < kk; i++) {
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        while (!stack.isEmpty()) {
            char ch = stack.pollFirst();
            if (zero && ch == '0') {
                continue;
            }
            zero = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode402().removeKdigits("10", 2));
    }
}
