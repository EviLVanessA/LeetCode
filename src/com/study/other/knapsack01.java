package com.study.other;

/**
 * @author jianghui
 * @date 2020-09-19  14:50
 **/
public class knapsack01 {
    public static void main(String[] args) {
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        System.out.println(new knapsack01().knapsack(w,v,5));
    }

    /**
     * 0-1背包问题 记忆化搜索
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack(int[] w,int[] v,int c){
        int n = w.length;
        int[][] memory = new int[n][c+1];

        return bestValue(w,v,n-1,c,memory);
    }
    private int bestValue(int[] w,int[] v,int index,int c,int[][] memory){
        if (index < 0 || c <= 0){
            return 0;
        }
        if (memory[index][c] != 0){
            return memory[index][c];
        }

        int res = bestValue(w,v,index-1,c,memory);
        if (c >= w[index]){
            res = Math.max(res,v[index] + bestValue(w,v,index-1,c-w[index],memory));
        }
        memory[index][c] = res;
        return res;
    }

    /**
     * 0-1背包问题 动态规划 自底向上的解决问题
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack2(int[] w,int[] v,int c){
        int n = w.length;
        if (n == 0){
            return 0;
        }

        int[][] memory = new int[n][c+1];

        for (int i = 0; i <= c; i++) {
            memory[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                //如果不考虑第i号物品
                memory[i][j] = memory[i-1][j];
                //如果考虑第i号物品
                if (j >= w[i]){
                    //比较当前不考虑i号物品和考虑之后谁更大
                    memory[i][j] = Math.max(memory[i][j],v[i] + memory[i-1][j-w[i]]);
                }
            }
        }
        return memory[n-1][c];
    }
    /**
     * 0-1背包问题 动态规划 自底向上的解决问题 代码优化
     * 由于第i行值只第i-1行，故只需要两行空间即可，空间复杂度为O(c)
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack3(int[] w,int[] v,int c){
        int n = w.length;
        if (n == 0){
            return 0;
        }

        int[][] memory = new int[2][c+1];

        for (int i = 0; i <= c; i++) {
            memory[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                //如果不考虑第i号物品
                memory[i % 2][j] = memory[(i-1) % 2][j];
                //如果考虑第i号物品
                if (j >= w[i]){
                    //比较当前不考虑i号物品和考虑之后谁更大
                    memory[i % 2][j] = Math.max(memory[i % 2][j],v[i] + memory[(i-1) % 2][j-w[i]]);
                }
            }
        }
        return memory[(n-1) % 2][c];
    }
    /**
     * 0-1背包问题 动态规划 自底向上的解决问题 代码优化
     * 根据两行空间 压缩为一行空间的实现，当容量小于最小容量时可进行提前结束
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack4(int[] w,int[] v,int c){
        int n = w.length;
        if (n == 0){
            return 0;
        }
        int[] memory = new int[c+1];
        for (int i = 0; i <= c; i++) {
            memory[i] = i >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            //从数组的最右侧开始更新数组
            for (int j = c; j >= w[i]; j--) {
                //比较当前不考虑i号物品和考虑之后谁更大
                memory[j] = Math.max(memory[j],v[i] + memory[j-w[i]]);
            }
        }
        return memory[c];
    }

    /**
     *   0-1背包的变种：
     *   完全背包问题：每个物品可以无限使用
     *   多重背包问题：每个物品有nums[i]个
     *   多维费用背包问题：考虑物品的体积和重量两个维度  三维数组
     *   物品之间互相排斥、物品之间相互依赖（加入约束）
     */
}
