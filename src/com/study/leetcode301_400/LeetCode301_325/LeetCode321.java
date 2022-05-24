package com.study.leetcode301_400.LeetCode301_325;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author jianghui
 * @date 2022/5/23
 */
public class LeetCode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        //nums1 分i个 num2 分k-i个
        String cur = "";
        for (int i = 0; i <= k; i++) {
            if (nums1.length < i || nums2.length < k - i) {
                continue;
            }
            String str1 = findK(nums1, i);
            String str2 = findK(nums2, k - i);
            String mergeStr = merge(str1, str2);
            if (cur.compareTo(mergeStr) < 0) {
                cur = mergeStr;
            }
        }
        char[] chars = cur.toCharArray();
        int[] ans = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ans[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return ans;
    }

    private String merge(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (sb.length() < str1.length() + str2.length()) {
            if (compare(str1, i, str2, j) > 0) {
                sb.append(str1.charAt(i));
                i++;
            } else {
                sb.append(str2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }

    private String findK(int[] nums, int k) {
        if (k == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int deleteCount = nums.length - k;
        for (int num : nums) {
            while (deleteCount > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) < num + '0') {
                sb.deleteCharAt(sb.length() - 1);
                deleteCount--;
            }
            sb.append(num);
        }
        return sb.toString().substring(0, k);
    }

    public int compare(String subsequence1, int index1, String subsequence2, int index2) {
        int x = subsequence1.length(), y = subsequence2.length();
        while (index1 < x && index2 < y) {
            int difference = subsequence1.charAt(index1) - subsequence2.charAt(index2);
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

    public static void main(String[] args) {
        int[] num1 = {2, 5, 6, 4, 4, 0};
        int[] num2 = {7, 3, 8, 0, 6, 5, 7, 6, 2};
        System.out.println(Arrays.toString(new LeetCode321().maxNumber(num1, num2, 15)));
    }
}
