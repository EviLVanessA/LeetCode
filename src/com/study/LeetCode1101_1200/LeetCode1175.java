package com.study.LeetCode1101_1200;

/**
 * @author jianghui
 * @date 2022-06-29 21:33
 */
public class LeetCode1175 {
    int mod = (int) (1e9) + 7;

    public int numPrimeArrangements(int n) {
        int prime = 0;
        //获取所有质数的个数
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                prime++;
            }
        }
        //对质数和非质数进行全排列
        return (int) (f(prime) * f(n - prime) % mod);
    }

    /**
     * 计算质数
     *
     * @param n 判断n是不是质数
     * @return
     */
    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算n的阶乘
     *
     * @param n
     * @return
     */
    public long f(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ans * i;
            ans = ans % mod;
        }
        return ans;
    }

}
