package com.study.leetcode101_200.leetcode101_125;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * @author jianghui
 * @date 2020-12-31 08:52
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().trim();
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        int i = 0, j = n - 1;
        char[] chars = s1.toCharArray();
        while (i <= j) {
            if (Character.isLetterOrDigit(chars[i]) && Character.isLetterOrDigit(chars[j])){
                if (chars[i] != chars[j]){
                    return false;
                }else {
                    i++;
                    j--;
                }
            }else{
                if (!Character.isLetterOrDigit(chars[i])){
                    i++;
                }
                if (!Character.isLetterOrDigit(chars[j])){
                    j--;
                }
            }
        }
        return true;
    }

    private boolean checkIsNumOrLetter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    public static void main(String[] args) {
        LeetCode125 test = new LeetCode125();
        System.out.println(test.isPalindrome("race a car"));
    }
}
