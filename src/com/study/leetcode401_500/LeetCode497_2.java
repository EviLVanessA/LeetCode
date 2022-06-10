package com.study.leetcode401_500;

import java.util.Random;

/**
 * @author jianghui
 * @date 2022-06-09 08:49
 */
public class LeetCode497_2 {
    private int[][] rects;
    private int[] prefixSum;
    private int total = 0;
    private Random random = new Random();

    public LeetCode497_2(int[][] rects) {
        this.rects = rects;
        //存放前缀和
        this.prefixSum = new int[rects.length];
        //计算前缀和
        for (int i = 0; i < rects.length; i++) {
            total += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            prefixSum[i] = total;
        }
    }

    public int[] pick() {
        //随机出来一个目标点
        int target = random.nextInt(total);
        //二分查找在哪个矩形
        int left = 0;
        int right = rects.length - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            if (target >= prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //确认完矩形在确认点的坐标
        int[] select = rects[left];
        int x = select[2] - select[0] + 1;
        int y = select[3] - select[1] + 1;
        //当前矩形开始的编号 target - base 表示当前点(target)在当前矩阵处于多少编号
        int base = prefixSum[left] - x * y;
        return new int[]{select[0] + (target - base) % x, select[1] + (target - base) / x};
    }
}
