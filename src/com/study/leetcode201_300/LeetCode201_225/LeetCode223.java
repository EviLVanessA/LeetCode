package com.study.leetcode201_300.LeetCode201_225;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示
 *
 * @author jianghui
 * @date 2021-02-25 15:49
 */
public class LeetCode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int top = Math.min(D, H);
        int left = Math.max(A, E);
        int bottom = Math.max(B, F);
        int right = Math.min(C, G);

        int sumAll = (C - A) * (D - B) + (G - E) * (H - F);
        if (E >= C || G <= A || B >= H || F >= D) {
            return sumAll;
        }
        return sumAll - Math.abs(top - bottom) * Math.abs(right - left);
    }
}
