package com.study.LeetCode601_700;

import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/23
 */
public class LeetCode675 {
    public int cutOffTree(List<List<Integer>> forest) {
        //移动的四个方向
        int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        List<int[]> allTree = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                //大于1的才是树
                if (forest.get(i).get(j) > 1) {
                    allTree.add(new int[]{i, j});
                }
            }
        }
        //给树的高度从小到大排序
        allTree.sort(Comparator.comparingInt(a -> forest.get(a[0]).get(a[1])));
        //存储答案
        int ans = 0;
        //存储当前所处的坐标位置
        int curX = 0, curY = 0;
        for (int[] nextTree : allTree) {
            int step = bfs(move, forest, curX, curY, nextTree[0], nextTree[1]);
            if (step == -1) {
                return -1;
            }
            //增加步数
            ans += step;
            //更新当前坐标
            curX = nextTree[0];
            curY = nextTree[1];
        }
        return ans;
    }

    /**
     * 计算两个点的最短距离
     *
     * @param move   移动的四个坐标
     * @param forest 森林
     * @param curX   当前坐标x
     * @param curY   当前坐标y
     * @param nextX  下一个树的坐标x
     * @param nextY  下一个树的坐标y
     * @return 最近的步数
     */
    private int bfs(int[][] move, List<List<Integer>> forest, int curX, int curY, int nextX, int nextY) {
        if (curX == nextX && curY == nextY) {
            return 0;
        }
        //BFS
        Deque<int[]> queue = new LinkedList<>();
        //存放访问过的坐标
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        queue.offerLast(new int[]{curX, curY});
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] curLocation = queue.pollFirst();
                //移动四个方向
                for (int j = 0; j < 4; j++) {
                    //新的坐标
                    int newX = curLocation[0] + move[j][0];
                    int newY = curLocation[1] + move[j][1];
                    //判断新坐标是否在森林中
                    if (newX >= 0 && newX < forest.size() && newY >= 0 && newY < forest.get(0).size()) {
                        //判断新坐标是否不是障碍物，并且没有被访问到
                        if (forest.get(newX).get(newY) > 0 && !visited[newX][newY]) {
                            //新坐标等于目标坐标 直接返回步数
                            if (newX == nextX && newY == nextY) {
                                return step;
                            } else {
                                //进一步做BFS
                                queue.offerLast(new int[]{newX, newY});
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
