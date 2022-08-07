package com.study.demo;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022-07-29 22:12
 */
public class ComputePrime {
    public static void main(String[] args) {
        euler();
        erichsen();
    }

    private static void euler() {
        int n = (int) 1e5;
        //判断是否是质数
        int[] isPrime = new int[n + 7];
        //存放质数
        int[] primes = new int[n + 7];
        int k = 0;
        Arrays.fill(isPrime, 1);
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] == 1) {
                primes[k++] = i;
                count++;
            }
            for (int j = 0; primes[j] * i <= n; j++) {
                //每个质数都和i相乘 得到合数
                isPrime[primes[j] * i] = 0;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        System.out.println(count);
    }


    private static void erichsen() {
        int n = (int) 1e5;
        //是否是质数，1-质数 0-合数
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        //采用i < n / i 防止i*i超范围
        for (int i = 2; i < n / i; i++) {
            if (isPrime[i] == 1) {
                //删除i的倍数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
            }
        }
        System.out.println(count);
    }

}
