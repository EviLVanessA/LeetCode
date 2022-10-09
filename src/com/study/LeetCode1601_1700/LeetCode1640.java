package com.study.LeetCode1601_1700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022/9/20
 */
public class LeetCode1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> data = new HashMap<>();
        for (int[] piece : pieces) {
            data.put(piece[0], piece);
        }
        int i = 0, n = arr.length;
        while (i < n) {
            if (!data.containsKey(arr[i])) {
                return false;
            }
            int[] curArr = data.get(arr[i]);
            for (int value : curArr) {
                if (arr[i++] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canFormArray2(int[] arr, int[][] pieces) {
        int[] index2Num = new int[101];
        Arrays.fill(index2Num, -1);
        for (int i = 0; i < arr.length; i++) {
            index2Num[arr[i]] = i;
        }
        for (int[] piece : pieces) {
            if (piece.length > 1) {
                for (int j = 1; j < piece.length; j++) {
                    if (index2Num[piece[j]] == -1 || index2Num[piece[j - 1]] == -1) {
                        return false;
                    }
                    if (index2Num[piece[j]] - index2Num[piece[j - 1]] != 1) {
                        return false;
                    }
                }
            } else {
                if (index2Num[piece[0]] == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
