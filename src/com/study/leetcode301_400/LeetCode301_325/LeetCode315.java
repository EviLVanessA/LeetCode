package com.study.leetcode301_400.LeetCode301_325;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/17
 */
public class LeetCode315 {
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private int[] index;
    private int[] tempIndex;
    private int[] temp;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        //存放对应数组元素的索引
        index = new int[n];
        //计数
        count = new int[n];
        //合并排序的临时数组
        temp = new int[n];
        //临时的index index也要同步做归并排序 和影子一样
        tempIndex = new int[n];
        //存放nums的位置
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, n - 1);
        List<Integer> ans = new ArrayList<>();
        for (int i : count) {
            ans.add(i);
        }
        return ans;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        //元素复制
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
            tempIndex[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                index[k] = tempIndex[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                index[k] = tempIndex[i];
                //j前边的数和当前i产生贡献值
                count[tempIndex[i]] += (j - mid - 1);
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                index[k] = tempIndex[i];
                //j前边的数和当前temp[i]产生贡献值
                count[tempIndex[i]] += (j - mid - 1);
                i++;
            } else {
                nums[k] = temp[j];
                index[k] = tempIndex[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};
        System.out.println(new LeetCode315().countSmaller(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
