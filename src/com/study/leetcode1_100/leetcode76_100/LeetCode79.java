package com.study.leetcode1_100.leetcode76_100;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 二维状态下的回溯算法
 * @author jianghui
 * @date 2020-09-18  11:23
 **/
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        //存储四个方向
        int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
        //该路径是否被访问过
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               return searchWord(board,word,0,i,j,d,visited);
            }
        }
        return false;
    }

    /**
     * 从startX,startY寻找word[index...end];
     * @param board
     * @param word
     * @param index
     * @param startX
     * @param startY
     * @return
     */
    private boolean searchWord(char[][] board ,String word, int index,
                               int startX,int startY,int[][] d,boolean[][] visited){
        if (index == word.length() - 1){
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)){
            //从startX,startY出发，向四个方向寻找
            visited[startX][startY] = true;
            boolean result = false;
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX,newY,board) && !visited[newX][newY]){
                    if (searchWord(board,word,index+1,newX,newY,d,visited)){
                        result = true;
                        break;
                    }
                }
            }
            //回溯状态
            visited[startX][startY] = false;
            return result;
        }
        return false;
    }
    private boolean inArea(int x,int y,char[][] board){
        int m = board.length;
        int n = board[0].length;
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    //自己的有问题 下边是别人的

    public boolean exist1(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
