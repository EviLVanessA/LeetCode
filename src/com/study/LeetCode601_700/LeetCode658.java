package com.study.LeetCode601_700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-06-10 11:17
 */
public class LeetCode658 {
    public static void main(String[] args) {
        System.out.println(new LeetCode658().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;
        left = ans;
        right = left + 1;
        while (count != k) {
            if (left >= 0 && right < arr.length) {
                if (x - arr[left] <= arr[right] - x) {
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
            } else if (left == -1) {
                res.add(arr[right]);
                right++;
            } else {
                res.add(arr[left]);
                left--;
            }
            count++;
        }
        Collections.sort(res);
        return res;
    }
}
