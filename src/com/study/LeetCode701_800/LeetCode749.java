package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022-07-17 23:02
 */
public class LeetCode749 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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
        // maxArea 是最大面积，res是对应的墙
        int maxArea = 0, res = 0, color = -1, targetX = -1, targetY = -1;
        //用一个数组来装当前这个点的状态
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    Wall wall = new Wall();
                    wall.walls = 0;
                    int curMaxArea = dfs(grid, visited, i, j, color, wall);
                    if (curMaxArea > maxArea) {
                        maxArea = curMaxArea;
                        res = wall.walls;
                        targetX = i;
                        targetY = j;
                    }
                    color--;
                }
            }
        }
        //修墙，将目标区域设置为未活动
        if (targetX == -1) {
            return 0;
        }
        buildWall(grid, targetX, targetY);
        //另一块传播病毒
        //spread(grid,visited,targetX,targetY);
        visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    spread(grid, visited, i, j);
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

    private void buildWall(int[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        grid[x][y] = -2;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                buildWall(grid, newX, newY);
            }
        }
    }

    private int dfs(int[][] grid, int[][] visited, int x, int y, int color, Wall wall) {
        int rows = grid.length;
        int cols = grid[0].length;
        int curArea = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] != 1) {
                //不是病毒
                if (grid[newX][newY] == 0) {
                    wall.walls++;
                    if (visited[newX][newY] != -1) {
                        curArea++;
                        visited[newX][newY] = -1;
                    }
                } else {
                    //是病毒
                    visited[newX][newY] = 1;
                    curArea += dfs(grid, visited, newX, newY, color, wall);
                }
            }
        }
        return curArea;
    }

    class Wall {
        public int walls;

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode749().containVirus(new int[][]{{0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}}));
    }
}
