package com.study.LeetCode1801_1900;

/**
 * @author jianghui
 * @date 2022-06-04 08:59
 */
public class LeetCode1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        for (int i = 0; i < nums1.length; i++) {
            int left = i, right = nums2.length - 1;
            int pos = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[i] <= nums2[mid]) {
                    pos = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (pos != -1) {
                maxDistance = Math.max(pos - i, maxDistance);
            }
        }
        return maxDistance;
    }

    public static int maxDistance3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = 0;
        int right = 0;
        while (left < len1 && right < len2) {
            if (nums1[left] > nums2[right]) {
                left++;
            }
            right++;
        }
        return Math.max(right - left - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxDistance3(new int[]{5, 4, 3, 2, 1}, new int[]{10, 9, 8, 7, 0}));
    }
}
