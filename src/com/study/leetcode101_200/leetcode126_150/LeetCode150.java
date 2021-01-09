package com.study.leetcode101_200.leetcode126_150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2021-01-08 10:33
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num3 = stack.pop();
                    int num4 = stack.pop();
                    stack.push(num4 / num3);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
