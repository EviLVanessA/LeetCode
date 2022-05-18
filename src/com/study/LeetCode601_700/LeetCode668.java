package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2022/5/18
 */
public class LeetCode668 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(new LeetCode668().findKthNumber(4, 4, 12));
        System.out.println(System.currentTimeMillis());
    }

    public int findKthNumber1(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(x / i, n);
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }

    public int findKthNumber3(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            int max = Math.min(m, x);
            for (int i = x / n + 1; i <= max; i++) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
