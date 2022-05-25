package com.study.LeetCode801_900;

/**
 * @author jianghui
 * @date 2022/5/25
 */
public class LeetCode852 {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }
        return arr.length - 1;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
