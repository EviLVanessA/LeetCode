package com.study.LeetCode601_700;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022/9/14
 */
public class LeetCode672 {
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return presses == 1 ? 3 : 4;
        } else {
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }

    public int flipLights2(int n, int presses) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < 1 << 4; i++) {
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }
            int sum = Arrays.stream(pressArr).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArr[0] ^ pressArr[1] ^ pressArr[3];
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }

}
