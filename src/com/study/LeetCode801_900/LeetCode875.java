package com.study.LeetCode801_900;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-06-06 22:37
 */
public class LeetCode875 {
    public int minEatingSpeed(int[] piles, int h) {
        //找到最大值
        int max = Arrays.stream(piles).max().getAsInt();
        //边界
        int left = 1, right = max;
        //目标K
        int ans = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //计算花费时长
            int costTime = 0;
            for (int pile : piles) {
                int curCostTime = pile / mid;
                //有剩余香蕉
                if (curCostTime * mid < pile) {
                    curCostTime++;
                }
                costTime += curCostTime;
            }
            //记录结果，缩小范围
            if (costTime <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
