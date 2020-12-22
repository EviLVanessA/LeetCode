package com.study.leetcode1_100.leetcode1_25;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *s 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author jianghui
 * @date 2020-09-23  9:23
 **/
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            int midIndex = total / 2;
            return getMidNum(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = total / 2 - 1, midIndex2 = total / 2;
            return (getMidNum(nums1, nums2, midIndex1 + 1) + getMidNum(nums1, nums2, midIndex2 + 1)) / 2.0;
        }

    }
    private int getMidNum(int[] nums1,int[] nums2,int k){
        int length1 = nums1.length,length2 = nums2.length;
        int index1 = 0,index2 = 0;
        int kth = 0;
        while (true){
            //考虑边界情况
            //数组1 空
            if (index1 == length1){
                return nums2[index2 + k - 1];
            }
            //数组2 空
            if (index2 == length2){
                return nums1[index1 + k - 1];
            }
            if (k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half,length1) - 1;
            int newIndex2 = Math.min(index2 + half,length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2){
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
