package com.study.LeetCode701_800;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianghui
 * @date 2022/10/12
 */
public class LeetCode769 {
    public int maxChunksToSorted2(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    public int maxChunksToSorted3(int[] arr) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int num : arr) {
            int max = num;
            int min = num;
            while (!queue.isEmpty() && (queue.peekLast()[1] > num || queue.peekLast()[0] > num)) {
                int[] ints = queue.pollLast();
                max = Math.max(max, ints[1]);
                min = Math.min(min, ints[0]);
            }
            queue.addLast(new int[]{min, max});
        }
        return queue.size();
    }

    public static void main(String[] args) {
        LeetCode769 leetCode769 = new LeetCode769();
        System.out.println(leetCode769.maxChunksToSorted2(new int[]{0, 2, 3}));
        System.out.println(leetCode769.maxChunksToSorted3(new int[]{0, 2, 3}));
    }
}
