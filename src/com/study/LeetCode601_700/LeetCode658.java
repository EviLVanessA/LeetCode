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


    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        //数组长度
        int n = arr.length;
        //左右指针
        int left = 0, right = n - 1;
        //要删除的个数
        int delCnt = n - k;
        while (delCnt > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            delCnt--;
        }
        //从左到右添加元素
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
