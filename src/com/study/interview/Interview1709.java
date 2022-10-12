package com.study.interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022/8/8
 */
public class Interview1709 {
    public int getKthMagicNumber(int k) {
        int[] nums = {3, 5, 7};
        //是否访问 相同的算一次
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        //初始值为1，即x = 1
        visited.add(1L);
        queue.offer(1L);
        //第k个元素
        int target = 0;
        for (int i = 0; i < k; i++) {
            //弹出堆顶元素
            long poll = queue.poll();
            target = (int) poll;
            for (int num : nums) {
                //依次相乘 即x是 3x、5x、7x也是
                long cur = poll * num;
                //相同元素仅仅加入一次
                if (!visited.contains(cur)) {
                    visited.add(cur);
                    queue.offer(cur);
                }
            }
        }
        return target;
    }

    public int getKthMagicNumber2(int k) {
        int[] dp = new int[k];
        //3的位置
        int i3 = 0;
        //5的位置
        int i5 = 0;
        //7的位置
        int i7 = 0;
        dp[0] = 1;
        for(int i = 1; i < k; i++){
            //找到最小的元素
            dp[i] = Math.min(dp[i3] * 3, Math.min(dp[i5] * 5, dp[i7] * 7));
            //相等的话给index++
            if(dp[i] == dp[i3] * 3){
                i3++;
            }
            //相等的话给index++
            if(dp[i] == dp[i5] * 5){
                i5++;
            }
            //相等的话给index++
            if(dp[i] == dp[i7] * 7){
                i7++;
            }
        }

        return dp[k - 1];
    }
}
