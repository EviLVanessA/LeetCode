package com.study.leetcode1_100.leetcode1_25;

import java.util.Stack;

/**
 * 有效的括号
 * 相关题150 71  递归遍历144 94 145
 * @author jianghui
 * @date 2020-09-17  9:14
 **/
public class LeetCode20 {
    public static void main(String[] args) {
        String str = "(]";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if (!stack.empty()){
                if (s.charAt(i) == ']'){
                    if (stack.pop() != '['){
                        return false;
                    }
                }
                if (s.charAt(i) == ')'){
                    if (stack.pop() != '('){
                        return false;
                    }
                }
                if (s.charAt(i) == '}'){
                    if (stack.pop() != '{'){
                        return false;
                    }
                }
            }else {
                return false;
            }

        }
        return stack.empty();
    }
    public static boolean isValid1(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()){
                    return false;
                }
                char c = stack.peek();
                char match = 0;
                stack.pop();
                if (s.charAt(i) == ']'){
                    match = '[';
                }
                if (s.charAt(i) == ')'){
                    match = '(';
                }
                if (s.charAt(i) == '}'){
                    match = '{';
                }
                if (match != c){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
