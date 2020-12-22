package com.study.leetcode1_100.leetcode1_25;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * @author jianghui
 * @date 2020-09-25  9:04
 **/
public class LeetCode14 {
    /**
     * 横向查找
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            prefix = longestCommonPrefix(prefix, str);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;

    }
    private String longestCommonPrefix(String str1,String str2){
        int len = Math.min(str1.length(),str2.length());
        int i = 0;
        while (i < len && str1.charAt(i) == str2.charAt(i)){
            i++;
        }
        return str1.substring(0,i);
    }

    /**
     * 纵向查找
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(new LeetCode14().longestCommonPrefix(arr));
    }
}
