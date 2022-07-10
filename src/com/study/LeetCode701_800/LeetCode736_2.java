package com.study.LeetCode701_800;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-07-05 22:06
 */
public class LeetCode736_2 {
    private static final String LET = "let";
    private static final String ADD = "add";
    private static final String MUlT = "mult";

    public int evaluate(String expression) {
        return cal(expression, new HashMap<>());
    }

    private int cal(String expression, Map<String, Integer> preScope) {
        String[] strs = splitExpression(expression);
        if (LET.equals(strs[0])) {
            //let表达式都是 let v1 e1 ..... expr
            //先处理赋值
            Map<String, Integer> curScope = new HashMap<>(preScope);
            for (int i = 1; i < strs.length - 2; i += 2) {
                int e1;
                //遇到括号证明 e1仍然是一个表达式
                if (strs[i + 1].charAt(0) == '(') {
                    //递归调用cal 解析表达式
                    e1 = cal(strs[i + 1], curScope);
                } else {
                    //获取str[i]的值，是数字还是变量，变量的话需要从map中获取
                    if (curScope.containsKey(strs[i + 1])) {
                        e1 = curScope.get(strs[i + 1]);
                    } else {
                        e1 = Integer.parseInt(strs[i + 1]);
                    }
                }
                curScope.put(strs[i], e1);
            }
            //处理let的最后一个表达式expr
            if (strs[strs.length - 1].charAt(0) == '(') {
                return cal(strs[strs.length - 1], curScope);
            } else {
                //有可能是变量或者数字 比如:(let x 3 x 2 x) 最后是变量
                //如果scope中存在该字符串，一定是变量
                if (curScope.containsKey(strs[strs.length - 1])) {
                    return curScope.get(strs[strs.length - 1]);
                }
                return Integer.parseInt(strs[strs.length - 1]);
            }
        } else {
            //不是let 一定是add or mult
            int[] ans = new int[2];
            //add和mult处理相似 所以合并处理
            //分别计算e1和e2
            for (int i = 1; i <= 2; i++) {
                if (strs[i].charAt(0) == '(') {
                    //表达式 递归处理
                    ans[i - 1] = cal(strs[i], preScope);
                } else {
                    //数字或者变量
                    if (preScope.containsKey(strs[i])) {
                        ans[i - 1] = preScope.get(strs[i]);
                    } else {
                        ans[i - 1] = Integer.parseInt(strs[i]);
                    }
                }
            }
            return ADD.equals(strs[0]) ? ans[0] + ans[1] : ans[0] * ans[1];
        }
    }

    private String[] splitExpression(String expression) {
        List<String> res = new ArrayList<>();
        //去掉两个括号
        expression = expression.substring(1, expression.length() - 1);
        int i = 0, j = 0;
        while (j < expression.length()) {
            if (expression.charAt(j) == ' ') {
                //分割字符串
                res.add(expression.substring(i, j));
                i = j + 1;
            } else if (expression.charAt(j) == '(') {
                //统计括号数量 也就是当前括号内的进行递归处理
                //需要找到和此左括号匹配的右括号作为子表达式的结束
                int count = 0;
                while (j < expression.length()) {
                    //进行括号匹配
                    if (expression.charAt(j) == '(') {
                        count++;
                    } else if (expression.charAt(j) == ')') {
                        count--;
                    }
                    j++;
                    if (count == 0) {
                        break;
                    }
                }
                res.add(expression.substring(i, j));
                i = j + 1;
            }
            j++;
        }
        if (i < expression.length()) {
            res.add(expression.substring(i));
        }
        return res.toArray(new String[0]);
    }

}
