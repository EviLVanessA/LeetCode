package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022-08-24 08:15
 */
public class LeetCode1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] hash = new int[1001];
        for (int i : target) {
            hash[i]++;
        }
        for (int i : arr) {
            if (--hash[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
