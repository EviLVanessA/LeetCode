package com.study.LeetCode1301_1400;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jianghui
 * @date 2022-06-01 20:44
 */
public class LeetCode1337 {
    public static void main(String[] args) {
//        int[][] w = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[][] w = {{1, 0}, {0, 0}, {1, 0}};
        System.out.println(Arrays.toString(kWeakestRows(w, 3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        //最小堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((x1, x2) -> {
            if (x1[0] != x2[0]) {
                return x1[0] - x2[0];
            } else {
                return x1[1] - x2[1];
            }
        });
        //统计每行的个数并放入最小堆
        for (int i = 0; i < row; i++) {
            int left = 0, right = col - 1;
            //二分查找最后一个1
            int pos = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 1) {
                    pos = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (pos == -1) {
                pos = 0;
            } else {
                pos++;
            }
            queue.offer(new int[]{pos, i});
        }
        //输出K个最小
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[1];
        }
        return ans;
    }
}
