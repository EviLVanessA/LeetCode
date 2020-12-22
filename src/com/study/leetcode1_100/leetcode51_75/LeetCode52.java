package com.study.leetcode1_100.leetcode51_75;

/**
 * n皇后问题2
 * @author jianghui
 * @date 2020-09-19  10:25
 **/
public class LeetCode52 {
    public static void main(String[] args) {
        LeetCode52 a = new LeetCode52();
        System.out.println(a.totalNQueens(4));
    }
    public int totalNQueens(int n) {
        int[] col = new int[n];
        int[] dia1 = new int[2 * n -1];
        int[] dia2 = new int[2 * n -1];
        return putQueue(n,0,col,dia1,dia2,0);
    }
    public int putQueue(int n,int index,int[] col,int[] dia1,int[] dia2,int res){

        for (int i = 0; i < n; i++) {
            //尝试将第index行的皇后摆放在第i列
            if (col[i] == 0 && dia1[index+i] == 0 && dia2[index-i+n-1] == 0){
                col[i] = 1;
                dia1[index+i] = 1;
                dia2[index-i+n-1] = 1;
                if (index + 1 == n){
                    res++;
                } else{
                    res = putQueue(n,index+1,col,dia1,dia2,res);
                }
                //回溯
                dia2[index-i+n-1] = 0;
                dia1[index+i] = 0;
                col[i] = 0;
            }
        }
        return res;
    }
}
