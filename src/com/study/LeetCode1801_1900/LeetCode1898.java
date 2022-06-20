package com.study.LeetCode1801_1900;

import java.util.Arrays;

/**
 * @author jianghui
 * @date 2022/6/20
 */
public class LeetCode1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(s, p, mid, removable)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(String s, String p, int k, int[] removable) {
        int ns = s.length();
        int ps = p.length();
        int i = 0, j = 0;
        boolean[] state = new boolean[ns];
        for (int l = 0; l <= k; l++) {
            state[removable[l]] = true;
        }
        while (i < ns && j < ps) {
            if (s.charAt(i) == p.charAt(j) && !state[i]) {
                j++;
            }
            i++;
        }
        return j == ps;
    }
}
