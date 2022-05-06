package com.study.leetcode301_400.LeetCode301_325;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/5/6
 */
public class LeetCode300 {
    public List<String> removeInvalidParentheses(String s) {
        int removeL = 0;
        int removeR = 0;
        //计算最少需要减少的括号数量
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                removeL++;
            } else if (ch == ')') {
                //遇到了右括号但是没左括号 需要删除一个右括号
                if (removeL == 0) {
                    removeR++;
                } else {
                    //匹配一对
                    removeL--;
                }
            }
        }
        List<String> result = new ArrayList<>();
        doRemove(s, 0, removeL, removeR, result);
        return result;
    }

    /**
     * 进行括号删除
     *
     * @param s       当前剩余的字符串
     * @param start   开始索引
     * @param removeL 要删除的左括号数量
     * @param removeR 要删除的右括号数量
     * @param result  结果集
     */
    private void doRemove(String s, int start, int removeL, int removeR, List<String> result) {
        //回溯终止条件 已经没有可删减的括号
        if (removeL == 0 && removeR == 0) {
            //判断字符串是否合法
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //去重 连续的括号如果相同，去除之后的字符串是一样的
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            //剩下的字符不满足删除的数量
            if (removeL + removeR > s.length() - i) {
                return;
            }
            //删除左括号
            if (removeL > 0 && s.charAt(i) == '(') {
                doRemove(s.substring(0, i) + s.substring(i + 1), i, removeL - 1, removeR, result);
            }
            //删除右括号
            if (removeR > 0 && s.charAt(i) == ')') {
                doRemove(s.substring(0, i) + s.substring(i + 1), i, removeL, removeR - 1, result);
            }
        }
    }

    /**
     * 判断括号是否匹配
     *
     * @param s 字符串
     * @return 是否匹配
     */
    private boolean isValid(String s) {
        int conut = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                conut++;
            } else if (ch == ')') {
                if (conut == 0) {
                    return false;
                }
                conut--;
            }
        }
        return conut == 0;
    }
}
