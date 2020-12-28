package com.study.leetcode101_200.leetcode176_200;

/**
 * floodfill算法  相关题130 417
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  输入:
 * [
 *      ['1','1','1','1','0'],
 *      ['1','1','0','1','0'],
 *      ['1','1','0','0','0'],
 *      ['0','0','0','0','0']
 * ]
 * 输出: 1
 *
 *
 * @author jianghui
 * @date 2020-09-18  17:18
 **/
public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
        int m = grid.length;
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' ){
                    res ++ ;
                    dfs(grid,i,j,d);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int i, int j,int[][] d){
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            int newX = i + d[i][0];
            int newY = j + d[j][1];
            if (newX >= 0 && newX < m && newY >= 0
                    && newY < n && grid[newX][newY] == '1'){
                dfs(grid,newX,newY,d);
            }
        }
    }

    public int numIslands1(char[][] grid) {
        int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
        int m = grid.length;
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][i]){
                    res ++ ;
                    dfs1(grid,i,j,visited,d);
                }
            }
        }
        return res;
    }
    private void dfs1(char[][] grid,int i, int j,boolean[][] visit,int[][] d){
        int m = grid.length;
        int n = grid[0].length;
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + d[i][0];
            int newY = j + d[j][1];
            if (newX >= 0 && newX < m && newY >= 0
                    && newY < n && !visit[newX][newY] && grid[newX][newY] == '1'){
                dfs1(grid,newX,newY,visit,d);
            }
        }
    }
}
