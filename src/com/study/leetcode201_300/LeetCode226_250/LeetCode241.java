package com.study.leetcode201_300.LeetCode226_250;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-06-30 21:50
 */
public class LeetCode241 {
    public List<Integer> diffWaysToCompute(String expression) {
        //表达式为空
        if (expression == null || expression.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = expression.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //如果当前字符是操作符，也就是op，进行分割
            if (!Character.isDigit(aChar)) {
                //递归拿到左右两个表达式的结果集
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                //对两个结果集的所有结果进行op运算
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        if (aChar == '+') {
                            ans.add(left + right);
                        } else if (aChar == '-') {
                            ans.add(left - right);
                        } else {
                            ans.add(left * right);
                        }
                    }
                }
            }
        }
        //结果集是空，证明该字符字符串是单个数字，将单个数字加入结果集
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }

    public List<Integer> diffWaysToCompute2(String expression) {
        List<Object> ops = new ArrayList<>();
        //将字符串分割为digit、op、digit、op、digit......这样的数列（其实有操作符，严格意义不叫数列）
        for (int i = 0; i < expression.length(); ) {
            if (!Character.isDigit(expression.charAt(i))) {
                //添加操作符
                ops.add(expression.charAt(i));
                i++;
            } else {
                //添加数字
                int digit = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    digit = digit * 10 + expression.charAt(i) - '0';
                    i++;
                }
                ops.add(digit);
            }
        }
        //dp[i][j]表示从i到j子问题（子表达式）的答案
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        //初始时，所有的digit都是自己本身并且数字都是隔着存放的 所以+2
        //eg：digit、op、digit、op、digit......
        for (int i = 0; i < ops.size(); i += 2) {
            dp[i][i].add((int) ops.get(i));
        }
        //从长度为3的子问题开始计算
        for (int len = 3; len <= ops.size(); len += 2) {
            //左边界从0开始
            for (int left = 0; left + len <= ops.size(); left += 2) {
                //右边界
                int right = left + len - 1;
                //按照op进行分割左右两个子表达式 +2表示下一个op
                for (int k = left + 1; k < right; k += 2) {
                    List<Integer> leftAns = dp[left][k - 1];
                    List<Integer> rightAns = dp[k + 1][right];
                    //对左右两个子集进行合并处理
                    for (int num1 : leftAns) {
                        for (int num2 : rightAns) {
                            char op = (char) ops.get(k);
                            if (op == '+') {
                                dp[left][right].add(num1 + num2);
                            } else if (op == '-') {
                                dp[left][right].add(num1 - num2);
                            } else if (op == '*') {
                                dp[left][right].add(num1 * num2);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][ops.size() - 1];
    }
}
