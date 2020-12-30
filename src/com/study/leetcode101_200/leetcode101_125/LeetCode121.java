package com.study.leetcode101_200.leetcode101_125;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * @author jianghui
 * @date 2020-12-30 10:30
 */
public class LeetCode121 {
    /**
     * 暴力
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length ; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    /**
     * 遍历一次
     * @param prices
     * @return
     */
    public int maxProfit2(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(new LeetCode121().maxProfit2(new int[]{2,5,1,3}));
    }
}
