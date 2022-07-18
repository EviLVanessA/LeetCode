package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022-07-17 23:02
 */
public class LeetCode749 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int curWall = 0;
    int rows;
    int cols;

    public int containVirus(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int result = 0;
        while (true) {
            int walls = getMaxAreaNeedWalls(grid);
            if (walls == 0) {
                break;
            }
            result += walls;
        }
        return result;
    }

    private int getMaxAreaNeedWalls(int[][] grid) {
        //maxArea代表最大的感染区,ans代表需要修的墙的数量,
        //targetX、targetY表示此区域的DFS开始的坐标
        //state表示当前区域要修建墙的状态,如果没有修过,需要给maxArea+1,修过的话，只加墙的数量,不加maxArea
        //并且每个区域的state都是不一样的，互相不能影响 DFS完给state--
        int maxArea = 0, ans = 0, targetX = -1, targetY = -1, state = -3;
        //用一个数组来装当前这个点的状态
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    curWall = 0;
                    int curMaxArea = dfs(grid, visited, i, j, state);
                    if (curMaxArea > maxArea) {
                        maxArea = curMaxArea;
                        ans = curWall;
                        targetX = i;
                        targetY = j;
                    }
                    state--;
                }
            }
        }
        if (targetX == -1) {
            return 0;
        }
        //将活跃的病毒改为死亡状态
        modifyDead(grid, targetX, targetY);
        visited = new int[rows][cols];
        //病毒扩散
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    spread(grid, visited, i, j);
                }
            }
        }
        return ans;
    }

    private void spread(int[][] grid, int[][] visited, int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                    && visited[newX][newY] == 0) {
                //扩散区域
                if (grid[newX][newY] == 0) {
                    grid[newX][newY] = 1;
                    visited[newX][newY] = 1;
                } else if (grid[newX][newY] == 1) {
                    spread(grid, visited, newX, newY);
                }
            }
        }
    }

    private void modifyDead(int[][] grid, int x, int y) {
        grid[x][y] = -2;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                modifyDead(grid, newX, newY);
            }
        }
    }

    private int dfs(int[][] grid, int[][] visited, int x, int y, int state) {
        int curArea = 0;
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && visited[newX][newY] != 1) {
                //不是病毒
                if (grid[newX][newY] == 0) {
                    curWall++;
                    if (visited[newX][newY] != state) {
                        curArea++;
                        visited[newX][newY] = state;
                    }
                } else if (grid[newX][newY] == 1) {
                    //是存活病毒
                    curArea += dfs(grid, visited, newX, newY, state);
                }
            }
        }
        return curArea;
    }

}
