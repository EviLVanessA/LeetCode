package com.study.LeetCode1401_1500;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/8/23
 */
public class LeetCode1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
