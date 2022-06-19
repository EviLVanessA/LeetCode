package com.study.competition.competition298;

/**
 * @author jianghui
 * @date 2022-06-19 10:44
 */
public class LeetCode5218 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        int gewei = num % 10;
        int i = 1;
        if (k == 0 && gewei != 0) {
            return -1;
        }
        while (k * i <= num) {
            int tar = (k * i) % 10;
            if (gewei == tar) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
