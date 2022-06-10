package com.study.LeetCode1001_1100;

/**
 * @author jianghui
 * @date 2022-06-07 22:32
 */
public class LeetCode1037 {
    public boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]) - (points[0][1] - points[1][1]) * (points[1][0] - points[2][0]) != 0;
    }

    public boolean isBoomerang2(int[][] points) {
        int[] vectorOne = new int[]{points[0][0] - points[1][0], points[0][1] - points[1][1]};
        int[] vectorTwo = new int[]{points[1][0] - points[2][0], points[1][1] - points[2][1]};
        return vectorOne[0] * vectorTwo[1] - vectorOne[1] * vectorTwo[0] != 0;
    }

    public boolean isBoomerang3(int[][] points) {
        return (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) != (points[2][0] - points[0][0]) * (points[1][1] - points[0][1]);
    }
}
