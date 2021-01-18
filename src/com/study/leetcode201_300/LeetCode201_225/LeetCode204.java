package com.study.leetcode201_300.LeetCode201_225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2021-01-18 10:53
 */
public class LeetCode204 {
    public int countPrimes(int n) {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃氏筛
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans = ans + 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 线性筛
     *
     * @param n
     * @return
     */
    public int countPrimes3(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
