package com.study.leetcode1_100.leetcode26_50;

/**
 * @author jianghui
 * @date 2020-12-10 17:36
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            //补0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                //有可能会超出num1的长度 j为-1
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            res = addString(res, temp.reverse().toString());
        }
        return res;
    }

    private String addString(String s1, String s2) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = s1.length() - 1, j = s2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : s1.charAt(i) - '0';
            int y = j < 0 ? 0 : s2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            stringBuilder.append(sum);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode43().multiply("2","3"));
    }
}
