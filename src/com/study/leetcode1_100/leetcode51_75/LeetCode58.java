package com.study.leetcode1_100.leetcode51_75;

/**
 * @author jianghui
 * @date 2020-12-14 10:25
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if (s1.length == 0){
            return 0;
        }
        return s1[s1.length-1].length();
    }
    public int lengthOfLastWord2(String s) {
        boolean flag = false;
        int num = 0;
        for (int i = s.length()-1; i >= 0 ; i--) {
            if (s.charAt(i) == ' ' && !flag){
                continue;
            }
            flag = true;
            if (s.charAt(i) != ' '){
                num++;
            }else {
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode58().lengthOfLastWord2("a"));
    }
}
