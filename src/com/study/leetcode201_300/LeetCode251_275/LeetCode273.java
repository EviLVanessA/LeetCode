package com.study.leetcode201_300.LeetCode251_275;

public class LeetCode273 {
    public static void main(String[] args) {

    }

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            //从高往低计算
            int curNum = num / unit;
            //没有则跳过
            if (curNum != 0) {
                //减去高三位
                num -= curNum * unit;
                StringBuilder cur = new StringBuilder();
                recursion(cur, curNum);
                cur.append(thousands[i]).append(" ");
                sb.append(cur);
            }
        }
        return sb.toString().trim();
    }

    public void recursion(StringBuilder cur, int num) {
        //等于0直接返回
        if (num == 0) {
            return;
            //数字小于10 直接添加
        } else if (num < 10) {
            cur.append(singles[num]).append(" ");
            //数字小于20 直接添加
        } else if (num < 20) {
            cur.append(teens[num - 10]).append(" ");
            //数字小于100
        } else if (num < 100) {
            cur.append(tens[num / 10]).append(" ");
            //递归添加个位数
            recursion(cur, num % 10);
            //大于100
        } else {
            //添加百位
            cur.append(singles[num / 100]).append(" Hundred ");
            //添加十位和个位
            recursion(cur, num % 100);
        }
    }
}
