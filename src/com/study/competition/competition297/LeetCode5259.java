package com.study.competition.competition297;

/**
 * @author jianghui
 * @date 2022-06-12 10:30
 */
public class LeetCode5259 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int last = 0;
        for (int[] bracket : brackets) {
            if (income >= bracket[0]) {
                ans += (bracket[0] - last) * bracket[1] / 100.0;
                last = bracket[0];
            } else {
                ans += (income - last) * (bracket[1] / 100.0);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5259().calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
    }
}
