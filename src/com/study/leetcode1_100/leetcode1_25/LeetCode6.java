package com.study.leetcode1_100.leetcode1_25;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author jianghui
 * @date 2020-09-24  10:22
 **/
public class LeetCode6 {
    /**
     * 找规律
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j = j + cycle) {
                res.append(s.charAt(j + i));
                //添加上升的元素
                if (i != 0 && i != numRows - 1 && j + cycle - i < n){
                    res.append(s.charAt(j + cycle - i));
                }
            }
        }
        return res.toString();
    }

    /**
     * 逐行添加
     * @param s
     * @param numRows
     * @return
     */
    public static String convert2(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++){
            res.add(new StringBuilder());
        }
        boolean goDown = false;
        int go = 0;

        for (char c : s.toCharArray()) {
            res.get(go).append(c);
            if (go == 0 || go == numRows - 1){
                goDown = !goDown;
            }
            go += goDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : res) {
            ret.append(row);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        System.out.println(convert2(str,4));
    }
}
