package com.study.leetcode401_500;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jianghui
 * @date 2022-06-05 08:43
 */
public class LeetCode478 {

    private final double xCenter;
    private final double yCenter;
    private final double radius;

    public LeetCode478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        while (true) {
            //随机生成x
            double xRandom = random.nextDouble() * 2 * this.radius - this.radius;
            //随机生成y
            double yRandom = random.nextDouble() * 2 * this.radius - this.radius;

            if (Math.sqrt(xRandom * xRandom + yRandom * yRandom) <= this.radius) {
                return new double[]{xRandom + this.xCenter, yRandom + this.yCenter};
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode478(1.0, 0, 0).randPoint()));
    }
}
