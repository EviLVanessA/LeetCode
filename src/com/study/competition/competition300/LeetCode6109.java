package com.study.competition.competition300;

/**
 * @author jianghui
 * @date 2022-07-03 11:16
 */
public class LeetCode6109 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] add = new int[n];
        int[] live = new int[n];
        add[0] = 1;
        live[0] = 1;
        int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            int dead = 0;
            if (i - forget >= 0) {
                dead = add[i - forget];
            }
            for (int j = i - delay; j > i - forget && j >= 0; j--) {
                add[i] += add[j];
                add[i] = add[i] % mod;
            }
            live[i] = (live[i - 1] + add[i] - dead) % mod;
            live[i] = live[i] < 0 ? live[i] + mod : live[i];
        }
        return live[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6109().peopleAwareOfSecret(289, 7, 23));
    }
}
