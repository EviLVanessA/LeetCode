package com.study.competition.competition302;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-07-17 10:33
 */
public class LeetCode6164 {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> data = new HashMap<>();
        for (int num : nums) {
            int temp = num;
            int sum = 0;
            while (num > 0) {
                int re = num % 10;
                num = num / 10;
                sum += re;
            }
            data.putIfAbsent(sum, new PriorityQueue<>((o1, o2) -> o2 - o1));
            data.get(sum).add(temp);
        }
        int max = -1;
        for (Integer key : data.keySet()) {
            PriorityQueue<Integer> cur = data.get(key);
            if (cur.size() > 1) {
                int num1 = cur.poll();
                int num2 = cur.poll();
                max = Math.max(max, num1 + num2);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6164().maximumSum(new int[]{18, 43, 36, 13, 7}));
    }
}
