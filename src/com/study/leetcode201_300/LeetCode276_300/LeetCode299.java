package com.study.leetcode201_300.LeetCode276_300;

/**
 * @author jianghui
 * @date 2022/5/5
 */
public class LeetCode299 {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] nums = new int[10];
        int countA = 0, countB = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                if (nums[secret.charAt(i) - '0']-- > 0) {
                    countB++;
                }
                if (nums[guess.charAt(i) - '0']++ < 0) {
                    countB++;
                }
            }
        }
        return countA + "A" + countB + "B";
    }
}
