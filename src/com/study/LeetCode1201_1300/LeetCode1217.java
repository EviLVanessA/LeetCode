package com.study.LeetCode1201_1300;

/**
 * @author jianghui
 * @date 2022/7/7
 */
public class LeetCode1217 {
    public int minCostToMoveChips(int[] position) {
        int count1 = 0;
        int count2 = 0;
        for (int i : position) {
            if ((i & 1) == 0) {
                count1++;
            } else {
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}
