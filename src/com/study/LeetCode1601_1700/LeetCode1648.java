package com.study.LeetCode1601_1700;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/6/22
 */
public class LeetCode1648 {
    public int maxProfit(int[] inventory, int orders) {
        int mod = (int) 1e9 + 7;
        int n = inventory.length;
        Arrays.sort(inventory);
        int sum = 0;
        for (int i = 0; i < orders; i++) {
            sum = (sum + inventory[n - 1]) % mod;
            inventory[n - 1]--;
            if (n - 1 != 0 && inventory[n - 1] < inventory[n - 2]) {
                int temp = inventory[n - 1];
                inventory[n - 1] = inventory[n - 2];
                inventory[n - 2] = temp;
            }
        }
        return sum;
    }
}
