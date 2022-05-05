package com.study.other;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/4/27
 */
class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> b - a);
        max = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (max.size() + 1 < min.size()) {
                max.offer(min.poll());
            }
        } else {
            max.offer(num);
            if (min.size() < max.size()) {
                min.offer(max.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        }
        return (min.peek() + max.peek()) / 2.0;
    }
}
