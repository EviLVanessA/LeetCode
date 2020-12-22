package com.study.leetcode1_100.leetcode1_25;

/**
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @author jianghui
 * @date 2020-09-24  12:50
 **/
public class LeetCode9 {
    /**
     * 使用字符串
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        String str = String.valueOf(x);

        int left = 0,right = str.length() - 1;
        while (left <= right){
            if (str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 不使用字符串
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        //过滤不符合的条件
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int reserveNum = 0;
        while (x > reserveNum){
            reserveNum = reserveNum * 10 + x % 10;
            x = x / 10;
        }
        //奇数偶数则相等 奇数则除以10相等
        return x == reserveNum || x == reserveNum / 10;
    }

}
