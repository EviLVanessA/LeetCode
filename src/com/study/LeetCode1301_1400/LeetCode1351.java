package com.study.LeetCode1301_1400;

/**
 * @author jianghui
 * @date 2022/5/31
 */
public class LeetCode1351 {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < col; i++) {
            int left = 0, right = row - 1;
            int pos = row;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (grid[mid][i] < 0) {
                    pos = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans += row - pos;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
