package com.study.LeetCode1501_1600;

/**
 * @author jianghui
 * @date 2022-05-29 10:59
 */
public class LeetCode1539 {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }
}
