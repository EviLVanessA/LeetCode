package com.study.LeetCode1401_1500;

/**
 * @author jianghui
 * @date 2022/9/1
 */
public class LeetCode1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int curPrices = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    curPrices -= prices[j];
                    break;
                }
            }
            ans[i] = curPrices;
        }
        return ans;
    }
}
