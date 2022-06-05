package com.study.leetcode401_500;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jianghui
 * @date 2022-06-05 08:43
 */
public class LeetCode478_2 {

    private final double xCenter;
    private final double yCenter;
    private final double radius;

    public LeetCode478_2(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(random.nextDouble());
        return new double[]{this.xCenter + this.radius * r * Math.cos(theta), this.yCenter + this.radius * r * Math.sin(theta)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode478_2(1.0, 0, 0).randPoint()));
    }
}
