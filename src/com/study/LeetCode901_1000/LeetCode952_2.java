package com.study.LeetCode901_1000;

/**
 * @author jianghui
 * @date 2022-07-29 22:59
 */
public class LeetCode952_2 {
    static int N = 100010;
    //设为静态变量可以给每个用例使用，不用重复计算
    static int[] st = new int[N];
    static int[] pri = new int[N];
    int[] p = new int[N];
    static int k = 0;
    //欧拉筛，找出1~N的所有质数
    void euler(){
        //已经计算过了，不必重复计算
        if(k != 0){
            return;
        }

        for(int i = 2; i < N; i++){
            if(st[i] == 0){
                pri[k++] = i;
            }

            for(int j = 0; pri[j] * i < N; j++){
                st[pri[j] * i] = 1;

                if(i % pri[j] == 0){
                    break;
                }
            }
        }
    }

    //并查集模板
    int find(int x){
        return p[x] == x ? x : (p[x] = find(p[x]));
    }

    void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px != py){
            p[px] = py;
        }
    }

    public int largestComponentSize(int[] nums) {
        euler();

        //初始化并查集
        for(int i = 1; i < N; i++){
            p[i] = i;
        }

        //遍历nums中的每个数，让这些数指向他们的质因子
        for(int num : nums){
            int y = num;

            for(int j = 0; j < k && pri[j] * pri[j] <= y; j++){
                if(y % pri[j] == 0){
                    union(num, pri[j]);
                    while(y % pri[j] == 0){
                        y /= pri[j];
                    }
                }
            }

            if(y > 1) {
                union(y, num);
            }
        }

        int[] count = new int[N];
        int ans  = 0;
        for(int i : nums){
            ans = Math.max(ans, ++count[find(i)]);
        }

        return ans;
    }
}
