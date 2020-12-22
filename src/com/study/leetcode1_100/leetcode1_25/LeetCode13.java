package com.study.leetcode1_100.leetcode1_25;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @author jianghui
 * @date 2020-09-24  17:20
 **/
public class LeetCode13 {
    public static void main(String[] args) {
        System.out.println(new LeetCode13().romanToInt1("MCMXCIV"));
    }
    public int romanToInt1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] ch = s.toCharArray();
        int sum = 0;
        int preNum = map.get(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            int num = map.get(ch[i]);
            if (preNum < num){
                sum = sum - preNum;
            }else {
                sum = sum + preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    public int romanToInt(String s) {
        int sum = 0;
        char[] ch = s.toCharArray();
        int preNum = getValue(ch[0]);
        for(int i = 1;i < ch.length; i ++) {
            int num = getValue(ch[i]);
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
