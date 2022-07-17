package com.study.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-07-16 07:56
 */
public class offer2_041 {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}

class MovingAverage {

    List<Integer> data;
    int size;
    int leftIndex;
    int rightIndex;
    double sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        data = new ArrayList<>();
        this.size = size;
        this.leftIndex = 0;
        this.rightIndex = 0;
        this.sum = 0;
    }

    public double next(int val) {
        data.add(val);
        sum += val;
        rightIndex++;
        //超范围,右移
        if (rightIndex - leftIndex > size) {
            sum = sum - data.get(leftIndex);
            leftIndex++;
        }
        return sum / (Math.min(data.size(), size));
    }
}
