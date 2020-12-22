package com.study.leetcode1_100.leetcode1_25;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射与电话按键相同。注意 1 不对应任何字母。
 *
 * 回溯法是暴力解法的一个主要手段
 *
 * 相关题 93 131
 * @author jianghui
 * @date 2020-09-18  9:58
 **/
public class LeetCode17 {
    public final static String[] LETTER = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits == null){
            return res;
        }
        findCombination(digits,0,"");
        return res;
    }
    public void findCombination(String digits,int index,String s){
        if (index == digits.length()){
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = LETTER[c-'0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits,index+1,s+letters.charAt(i));
        }
    }
}
