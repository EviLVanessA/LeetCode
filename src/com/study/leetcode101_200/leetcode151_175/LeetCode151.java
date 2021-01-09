package com.study.leetcode101_200.leetcode151_175;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 *
 * @author jianghui
 * @date 2021-01-08 10:49
 */
public class LeetCode151 {
    public static String reverseWords(String s) {
        //处理空串
        s = s.trim();
        if (s.length() == 0){
            return "";
        }
        List<String> list = new ArrayList<>();
        int k = 0;
        //定义一个Flag用来去除中间多余的空格
        boolean startFlag = false;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != ' ') {
                if (!startFlag) {
                    k = j;
                    startFlag = true;
                }
            } else if (s.charAt(j) == ' ') {
                if (startFlag) {
                    list.add(0, s.substring(k, j));
                }
                startFlag = false;
            }
        }
        //加入最后一个单词
        list.add(0, s.substring(k));
        //返回分割的字符串
        return String.join(" ", list);
    }

    public static void main(String[] args) {
//        System.out.println(reverseWords(""));
        System.out.println(" 1 1 2       3     ".trim());
    }
}
