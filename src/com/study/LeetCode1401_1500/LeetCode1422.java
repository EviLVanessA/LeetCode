package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022-08-14 09:31
 */
public class LeetCode1422 {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] leftZero = new int[n];
        //记录0的个数
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftZero[i] = chars[i] == '0' ? 1 : 0;
            } else {
                leftZero[i] = chars[i] == '0' ? leftZero[i - 1] + 1 : leftZero[i - 1];
            }
        }
        int[] rightOne = new int[n];
        //记录1的个数
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                rightOne[i] = chars[i] == '1' ? 1 : 0;
            } else {
                rightOne[i] = chars[i] == '1' ? rightOne[i + 1] + 1 : rightOne[i + 1];
            }
        }
        //累加
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int cur = leftZero[i] + rightOne[i + 1];
            max = Math.max(cur, max);
        }
        return max;
    }

    public int maxScore2(String s) {
        char[] chars = s.toCharArray();
        int score = chars[0] == '0' ? 1 : 0;
        //分割左边1  右边n-1个字符
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                score++;
            }
        }

        int max = score;
        //每次移动一个字符 计算得分
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '0') {
                score++;
            } else {
                score--;
            }
            max = Math.max(score, max);
        }
        return max;
    }
}
