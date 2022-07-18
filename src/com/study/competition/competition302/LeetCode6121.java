package com.study.competition.competition302;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jianghui
 * @date 2022-07-17 10:42
 */
public class LeetCode6121 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int k = queries[i][0] - 1;
            int geshu = queries[i][1];
            PriorityQueue<String[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[0].equals(o2[0])) {
                    int num1 = Integer.parseInt(o1[1]);
                    int num2 = Integer.parseInt(o2[1]);
                    return num1 - num2;
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            });
            for (int j = 0; j < nums.length; j++) {
                String cur = nums[j].substring(nums[j].length() - geshu);
                queue.add(new String[]{cur, j + ""});
            }
            int count = 0;
            while (!queue.isEmpty() && count != k) {
                queue.poll();
                count++;
            }
            ans[i] = Integer.parseInt(queue.poll()[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"};
        int[][] arr = {{9, 4}, {6, 1}, {3, 8}, {12, 9}, {11, 4}, {4, 9}, {2, 7}, {10, 3}, {13, 1}, {13, 1}, {6, 1}, {5, 10}};
        System.out.println(Arrays.toString(new LeetCode6121().smallestTrimmedNumbers(str, arr)));
    }

}
