package com.study.leetcode201_300.LeetCode201_225;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * @author jianghui
 * @date 2021-01-27 15:48
 */
public class LeetCode224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int curResult = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+') {
                curResult += sign * operand;
                operand = 0;
                sign = 1;
            } else if (ch == '-') {
                curResult += sign * operand;
                operand = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(curResult);
                stack.push(sign);
                curResult = 0;
                sign = 1;
            } else if (ch == ')') {
                curResult += sign * operand;
                curResult *= stack.pop();
                curResult += stack.pop();
                operand = 0;
            }
        }
        return curResult + sign * operand;
    }

    public static void main(String[] args) {
        String str = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new LeetCode224().calculate(str));
    }
}
