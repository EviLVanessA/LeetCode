package com.study.leetcode401_500;

import java.util.Random;

/**
 * @author jianghui
 * @date 2022-06-08 23:13
 */
public class LeetCode497 {

    private int[][] rects;

    public LeetCode497(int[][] rects) {
        this.rects = rects;
    }

    public int[] pick() {
        Random random = new Random();
        int selectIndex = -1, sumPoint = 0;
        for (int i = 0; i < rects.length; i++) {
            //当前矩形的整点个数
            int k = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            sumPoint += k;
            //每个矩形都是k/n的概率被抽取到
            if (random.nextInt(sumPoint) < k) {
                selectIndex = i;
            }
        }
        //收取到矩形后在抽取点 矩形中每个点的概率是1/k
        int[] select = rects[selectIndex];
        //随机X
        int ranDomX = random.nextInt(select[2] - select[0] + 1) + select[0];
        //随机Y
        int ranDomY = random.nextInt(select[3] - select[1] + 1) + select[1];
        return new int[]{ranDomX, ranDomY};
    }

}
