package com.study.LeetCode1201_1300;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-07-20 07:59
 */
public class LeetCode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(0);
            }
            ans.add(row);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index1 = (i * cols + j + k) % (rows * cols);
                ans.get(index1 / cols).set(index1 % cols, grid[i][j]);
            }
        }
        return ans;
    }

    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //展开到一维中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.add(grid[i][j]);
            }
        }
        //移动k次
        for (int i = 0; i < k; i++) {
            temp.add(0, temp.remove(temp.size() - 1));
        }
        int i = 0;
        //封装结果
        while (i < temp.size()) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(temp.get(i));
                i++;
            }
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new LeetCode1260().shiftGrid2(arr, 1));
    }
}
