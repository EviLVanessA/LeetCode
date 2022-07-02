package com.study.LeetCode501_600;

/**
 * @author jianghui
 * @date 2022/6/30
 */
public class LeetCode557 {
    public String reverseWords(String s) {
        //按照空格分割
        String[] s1 = s.split(" ");
        //逐个对字符串进行翻转
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            reverseString(chars);
            s1[i] = new String(chars);
        }
        return String.join(" ", s1);
    }

    //反转字符串
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
