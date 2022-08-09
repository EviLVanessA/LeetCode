package com.study.LeetCode901_1000;


/**
 * @author jianghui
 * @date 2022-07-29 21:10
 */
public class LeetCode952 {

    public static int n = (int) 1e5 + 7;
    public static int[] isPrime = new int[n];
    public static int[] primes = new int[n];
    //并查集
    public static int[] parent = new int[n];
    int k = 0;

    public int largestComponentSize(int[] nums) {
        //欧拉筛，找出1-n的所有质数
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 0) {
                primes[k++] = i;
            }
            for (int j = 0; primes[j] * i < n; j++) {
                isPrime[primes[j] * i] = 1;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
        //初始化并查集
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        //遍历nums中的每个数,和他们的质因数连接
        for (int num : nums) {
            int quotient = num;
            for (int j = 0; j < k && primes[j] * primes[j] <= quotient; j++) {
                if (quotient % primes[j] == 0) {
                    //primes[i]是他的质因数
                    union(num, primes[j]);
                    while (quotient % primes[j] == 0) {
                        quotient /= primes[j];
                    }
                }
            }
            //假如剩下了一个质因数，也和num连接，使得不同的质因数可以联合到一起
            //这种情况是因为 num是一个合数 由不同的质因数相乘组成 把他的质因数 连接起来
            if (quotient > 1) {
                union(quotient, num);
            }
        }
        int[] cnt = new int[n];
        int ans = 0;
        //是否属于某个根
        for (int num : nums) {
            ans = Math.max(ans, ++cnt[find(num)]);
        }
        return ans;
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }

//    public void union2(int x, int y) {
//        int parentX = find(x);
//        int parentY = find(y);
//        if (parentX == parentY) {
//            return;
//        }
//        if (rank[parentX] < rank[parentY]) {
//            parent[parentX] = parentY
//        } else {
//            parent[parentY] = parentX;
//            if (rank[parentX] == rank[parentY]) {
//                rank[parentX]++;
//            }
//        }
//    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode952().largestComponentSize(new int[]{4, 6, 15, 35}));
    }

}
