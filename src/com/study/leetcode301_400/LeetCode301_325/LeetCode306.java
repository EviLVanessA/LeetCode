package com.study.leetcode301_400.LeetCode301_325;

/**
 * @author jianghui
 * @date 2022/5/10
 */
public class LeetCode306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        //暴力拆数  第一个数 [0 , secondStart) 第二个数 [secondStart , secondEnd]
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {
            //若第一个字符为0 则第一个数必须为0，也就是说第二个数的开始index必须为 1
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            //穷举第二个数的结束index
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                //若第二个数的开始index为0,则第二个数必须为 0
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                //判断是否合法
                if (isValid(num, secondStart, secondEnd)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否合法
     *
     * @param num         字符串
     * @param secondStart 第二个数的开始索引
     * @param secondEnd   第二个数的结束索引
     * @return
     */
    private boolean isValid(String num, int secondStart, int secondEnd) {
        int n = num.length();
        int firstStart = 0;
        while (secondEnd <= n - 1) {
            //累加第一个数和第二个数，得到第三个数
            String third = stringAdd(num, firstStart, secondStart, secondEnd);
            //拿到第三个数的index
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            //如果第三个数的结束index 超过了字符串num的长度 直接break
            if (thirdEnd > n - 1) {
                break;
            }
            //拿到字符串的第三个数
            String curThird = num.substring(thirdStart, thirdEnd + 1);
            if (!third.equals(curThird)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            //第二个数 变为第一个数
            firstStart = secondStart;
            //第三个数 变为第二个数 循环判断
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    /**
     * 两数累加
     *
     * @param s           字符串
     * @param firstStart  第一个数开始index
     * @param secondStart 第二个数开始index
     * @param secondEnd   第二个数结束index
     * @return
     */
    private String stringAdd(String s, int firstStart, int secondStart, int secondEnd) {
        //此题 n<=35 long可以存储19位 所以每个数最多17位 long可以存储
        long numOne = Long.parseLong(s.substring(firstStart, secondStart));
        long numTwo = Long.parseLong(s.substring(secondStart, secondEnd + 1));
        long third = numOne + numTwo;
        return String.valueOf(third);
    }
}
