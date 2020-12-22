package com.study.leetcode1_100.leetcode1_25;

/**
 * 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，
 * 即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 *
 * @author jianghui
 * @date 2020-09-24  17:04
 **/
public class LeetCode12 {
    public static void main(String[] args) {
        System.out.println(new LeetCode12().intToRoman(1994));
    }
    public String intToRoman(int num) {
        int[] nums = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        //                1    4   5   9    10  40  50   90  100  400 500 900 1000
        String[] roma = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder res = new StringBuilder();
        int index = 12;
        while (index >= 0){
            while (num >= nums[index]){
                res.append(roma[index]);
                num = num - nums[index];
            }
            index--;
        }
        return res.toString();
    }

}
