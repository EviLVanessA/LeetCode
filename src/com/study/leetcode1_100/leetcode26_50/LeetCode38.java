package com.study.leetcode1_100.leetcode26_50;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 * @author jianghui
 * @date 2020-09-28  12:48
 **/
public class LeetCode38 {
    public static void main(String[] args) {
        System.out.println(new LeetCode38().countAndSay(5));
    }
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        if (n == 2){
            return "11";
        }
        String str = "11";
        for (int i = 3 ; i <= n;i++){
            StringBuilder builder = new StringBuilder();
            char[] ch = str.toCharArray();
            int k = 0,sum = 0;
            for (int j = 0; j <= ch.length; j++) {
                if (j == ch.length){
                    builder.append(sum).append(ch[k]);
                    break;
                }
                if (ch[j] == ch[k]){
                    sum++;
                }
                if (ch[j] != ch[k]){
                    builder.append(sum).append(ch[k]);
                    k = j;
                    sum = 1;
                }
            }

            str = builder.toString();
        }
        return str;
    }


    public String countAndSay2(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        // 拿到上一层的字符串
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始指针为0
        int start = 0;
        // 注意这从起始条件要和下面长度统一
        for (int i = 1; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start) ) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }
}
