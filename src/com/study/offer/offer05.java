package com.study.offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @author jianghui
 * @date 2021-01-28 15:08
 */
public class offer05 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                ans.append("%20");
            } else {
                ans.append(aChar);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new offer05().replaceSpace("We are happy"));
    }
}
