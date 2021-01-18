package com.study.leetcode201_300.LeetCode201_225;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2021-01-18 10:39
 */
public class LeetCode202 {
    private int getNext(int n){
        int totalSum = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum = totalSum + d * d;
        }
        return totalSum;
    }
    public boolean isHappy(int n){
        Set<Integer> see = new HashSet<>();
        while (n != 1 && !see.contains(n)){
            see.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
