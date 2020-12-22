package com.study.leetcode1_100.leetcode1_25;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *
 * @author jianghui
 * @date 2020-09-25  12:38
 **/
public class LeetCode22 {
    /**
     * 暴力法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[2*n],0,res);
        return res;
    }
    private void  generateAll(char[] ch,int pos,List<String> res){
        if (pos == ch.length){
            if (isValid(ch)){
                res.add(new String(ch));
            }
        }else {
            ch[pos] = '(';
            generateAll(ch,pos+1,res);
            ch[pos] = ')';
            generateAll(ch,pos+1,res);
        }

    }
    private boolean isValid(char[] ch){
        int balance = 0;
        for (char c : ch){
            if (c == '('){
                balance ++;
            }else {
                balance --;
            }
            if (balance < 0){
                return false;
            }
        }
        return balance == 0;
    }


    /**
     * 改进上述暴力算法 只有匹配才加 （回溯法）
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    /**
     * 按括号序列的长度递归
     */
    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis1(int n) {
        return generate(n);
    }
}
