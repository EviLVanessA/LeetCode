package com.study.leetcode1_100.leetcode51_75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2020-12-11 16:56
 */
public class LeetCode54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(new LeetCode54().spiralOrder(matrix).toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int newRow = row + directions[directionIndex][0];
            int newCol = column + directions[directionIndex][1];
            if (newRow < 0 ||newRow>=rows||newCol<0||newCol>=columns||visited[newRow][newCol]){
                directionIndex = (directionIndex + 1 )% 4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return order;
    }

}
