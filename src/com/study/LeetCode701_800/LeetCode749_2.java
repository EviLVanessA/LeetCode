package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022/7/18
 */
public class LeetCode749_2 {
    public int containVirus(int[][] grid) {
        int result = 0;
        while (true) {
            int walls = process(grid);
            if (walls == 0) {
                break;
            }
            result += walls;
        }
        return result;
    }

    //对整个场景进行业务逻辑梳理
    private int process(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // cnt 是最大面积，ans是对应的墙
        int cnt = 0, res = 0, color = -1, row = -1, col = -1;
        //用一个数组来装当前这个点的状态
        int[][] stateArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0) {
                    Wall wall = new Wall();
                    wall.walls = 0;
                    int maxArea = getMaxAreaDfs(grid, stateArray, i, j, color, wall);
                    if (maxArea > cnt) {
                        cnt = maxArea;
                        res = wall.walls;
                        row = i;
                        col = j;
                    }
                    color--;
                }
            }
        }
        //修墙，将目标区域设置为未活动
        buildWall(grid, row, col);
        //另一块传播病毒
        //spread(grid,stateArray,row,col);
        stateArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0) {
                    spread(grid, stateArray, i, j);
                }
            }
        }
        return res;

    }

    private void spread(int[][] grid, int[][] stateArray, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || stateArray[row][col] == 1) {
            return;
        }
        if (grid[row][col] == 0) {
            grid[row][col] = 1;
            stateArray[row][col] = 1;
        } else if (grid[row][col] == 1) {
            stateArray[row][col] = 1;
            int[] dir = {-1, 0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                spread(grid, stateArray, row + dir[i], col + dir[i + 1]);
            }
        }
    }

    private void buildWall(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) {
            return;
        }
        //设置为不活动
        grid[row][col] = -1;
        int[] dir = {-1, 0, 1, 0, -1};
        //DFS
        for (int i = 0; i < 4; i++) {
            buildWall(grid, row + dir[i], col + dir[i + 1]);
        }
    }

    private int getMaxAreaDfs(int[][] grid, int[][] stateArray, int row, int col, int color, Wall wall) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        //异常排除
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        //0不是病毒
        if (grid[row][col] == 0) {
            wall.walls++;
            //第二次进入
            if (stateArray[row][col] == color) {
                return 0;
            }
            //第一次进入
            stateArray[row][col] = color;
            return 1;
        }
        // 不是grid[i][j]==1 or 0
        if (stateArray[row][col] == 1 || grid[row][col] != 1) {
            return 0;
        }
        //grid[i][j]==1
        stateArray[row][col] = 1;
        //前后左右,再来一次，直到出现不再是1的结果。DFS的思想。
        int[] dir = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            res += getMaxAreaDfs(grid, stateArray, row + dir[i], col + dir[i + 1], color, wall);
        }
        return res;
    }

    class Wall {
        public int walls;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode749_2().containVirus(new int[][]{
                {0, 1, 1, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0}}
        ));
    }
}
