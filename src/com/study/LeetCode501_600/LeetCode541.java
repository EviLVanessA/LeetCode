package com.study.LeetCode501_600;

/**
 * @author jianghui
 * @date 2022/9/15
 */
public class LeetCode541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i = i + 2 * k) {
            reverse(chars, i, Math.min(i + k, n) - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
