package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022/7/4
 */
public class LeetCode733 {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];
                if (newX >= 0 && newX < image.length
                        && newY >= 0 && newY < image[0].length) {
                    dfs(image, newX, newY, oldColor, newColor);
                }
            }
        }
    }
}
