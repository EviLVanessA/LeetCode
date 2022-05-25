package com.study.leetcode301_400.LeetCode351_375;

/**
 * @author jianghui
 * @date 2022/5/24
 */
public class LeetCode374 {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    int guess(int num) {
        return Integer.compare(num, 5);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode374().guessNumber(10));
    }
}
