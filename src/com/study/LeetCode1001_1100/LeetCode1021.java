package com.study.LeetCode1001_1100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-05-28 07:21
 */
public class LeetCode1021 {
    public static String removeOuterParentheses(String s) {

        Deque<String> queue = new LinkedList<>();
        int left = 0;
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                left++;
                queue.addLast(String.valueOf(aChar));
            } else {
                left--;
                queue.addLast(String.valueOf(aChar));
                if (left == 0) {
                    if (!queue.isEmpty()) {
                        queue.pollLast();
                        queue.pollFirst();
                    }
                    while (!queue.isEmpty()) {
                        ans.append(queue.pollFirst());
                    }
                }
            }
        }
        return ans.toString();
    }


    public String removeOuterParentheses2(String s) {
        int left = 0;
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //先判断是不是右括号，因为要删除最外层的括号，第一个左括号默认删除
            if (aChar == ')') {
                left--;
            }
            //当前原语有多余的左右括号 可以添加
            if (left > 0) {
                ans.append(aChar);
            }
            if (aChar == '(') {
                left++;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
