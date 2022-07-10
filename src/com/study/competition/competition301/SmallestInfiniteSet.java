package com.study.competition.competition301;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author jianghui
 * @date 2022-07-10 10:56
 */
public class SmallestInfiniteSet {
    int min = 1;
    private HashSet<Integer> hashSet = new HashSet<>();

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        int temp = min;
        hashSet.add(temp);
        while (hashSet.contains(min)) {
            min++;
        }
        return temp;
    }

    public void addBack(int num) {
        if (hashSet.contains(num)) {
            if (min > num) {
                min = num;
            }
            hashSet.remove(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(2);
        smallestInfiniteSet.addBack(3);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}
