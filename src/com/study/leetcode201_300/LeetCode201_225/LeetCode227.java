package com.study.leetcode201_300.LeetCode201_225;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * @author jianghui
 * @date 2021-01-27 16:50
 */
public class LeetCode227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(operand);
                        break;
                    case '-':
                        stack.push(-operand);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * operand);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / operand);
                        break;
                    default:
                        break;
                }
                sign = ch;
                operand = 0;
            }

        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "3 + 2*2";
        System.out.println(new LeetCode227().calculate(str));
    }
}
