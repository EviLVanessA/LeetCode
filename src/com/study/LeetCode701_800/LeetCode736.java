package com.study.LeetCode701_800;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-07-05 21:50
 */
public class LeetCode736 {
    public int evaluate(String expression) {
        return cal(expression);
    }

    int index = 0;
    Map<String, Deque<Integer>> varToValue = new HashMap<>();

    public int cal(String expression) {
        if (expression.charAt(index) != '(') {
            if (Character.isLowerCase(expression.charAt(index))) {
                String param = parseParam(expression);
                return varToValue.get(param).peek();
            } else {
                return parseInt(expression);
            }
        }
        int ans;
        index++;
        if (expression.charAt(index) == 'l') {
            index = index + 4;
            List<String> params = new ArrayList<>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(index))) {
                    ans = cal(expression);
                    break;
                }
                String param = parseParam(expression);
                if (expression.charAt(index) == ')') {
                    ans = varToValue.get(param).peek();
                    break;
                }
                params.add(param);
                index++;
                int e = cal(expression);
                varToValue.putIfAbsent(param, new ArrayDeque<>());
                varToValue.get(param).push(e);
                index++;
            }

        } else if (expression.charAt(index) == 'a') {
            index = index + 4;
            int e1 = cal(expression);
            index++;
            int e2 = cal(expression);
            ans = e1 + e2;
        } else {
            index = index + 5;
            int e1 = cal(expression);
            index++;
            int e2 = cal(expression);
            ans = e1 * e2;
        }
        index++;
        return ans;
    }

    private int parseInt(String expression) {
        int n = expression.length();
        int ans = 0, sign = 1;
        if (expression.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        while (index < n && Character.isDigit(expression.charAt(index))) {
            ans = ans * 10 + (expression.charAt(index) - '0');
            index++;
        }
        return sign * ans;
    }

    private String parseParam(String expression) {
        int n = expression.length();
        StringBuilder ans = new StringBuilder();
        while (index < n && expression.charAt(index) != ' ' && expression.charAt(index) != ')') {
            ans.append(expression.charAt(index));
            index++;
        }
        return ans.toString();
    }

}
