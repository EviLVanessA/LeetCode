package com.study.LeetCode801_900;

/**
 * @author jianghui
 * @date 2022-06-03 13:38
 */
public class LeetCode829 {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5));
    }

    public static int consecutiveNumbersSum2(int n) {
        while ((n & 1) == 0) {
            n >>= 1;
        }
        int ans = 1, d = 3;

        while (d * d <= n) {
            int e = 0;
            while (n % d == 0) {
                n /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }

        if (n > 1) {
            ans <<= 1;
        }
        return ans;
    }

    public static int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int k = 1; k * k < 2 * n; k++) {
            if (2 * n % k == 0 && (2 * n / k - k + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
