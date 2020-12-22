package com.study.leetcode1_100.leetcode51_75;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2020-12-18 09:15
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int newDigit = digits[digits.length - 1] + 1;
        int carry = newDigit / 10;
        newDigit = newDigit % 10;
        StringBuilder str = new StringBuilder();
        str.append(newDigit);
        for (int i = digits.length - 2; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            temp = temp % 10;
            str.append(temp);
        }
        if (carry > 0){
            str.append(carry);
        }
        char[] chars = str.reverse().toString().toCharArray();
        int[] newArray = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newArray[i] = chars[i] - '0';
        }
        return newArray;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode66().plusOne(new int[]{9,9,9,9})));
    }
}
