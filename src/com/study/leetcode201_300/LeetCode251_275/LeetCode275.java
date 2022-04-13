package com.study.leetcode201_300.LeetCode251_275;

public class LeetCode275 {
    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int right = n - 1;
        int left = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
