package com.study.LeetCode801_900;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jianghui
 * @date 2022-07-01 22:48
 */
public class LeetCode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        //遍历加油站
        for (int i = 0; i < stations.length; i++) {
            //更新dp
            for (int j = i; j >= 0; j--) {
                //必须能达到此加油站才能更新dp[j]
                if (dp[j] >= stations[i][0]) {
                    //判断加j+1次油（也就是加了j次+当前路过的这次油量）
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        //找到第一个大于等于target的 i，也就是加油次数
        for (int i = 0; i <= stations.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        //最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int ans = 0;
        int curGas = startFuel;
        int i = 0;
        while (curGas < target) {
            //只要当前油量可以支撑到下一个加油站，就选择不加油
            if (i < stations.length && curGas >= stations[i][0]) {
                heap.add(stations[i][1]);
                i++;
            } else {
                //无法到达，加油
                if (!heap.isEmpty()) {
                    //堆中有元素 证明路过很多加油站，选择最多油的加油站加油
                    curGas += heap.poll();
                    ans++;
                } else {
                    //无元素，证明无法到达
                    return -1;
                }
            }
        }
        return ans;
    }

}
