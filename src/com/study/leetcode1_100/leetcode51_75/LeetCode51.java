package com.study.leetcode1_100.leetcode51_75;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题 相关问题52 37
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 经典为8皇后问题 国际棋盘8*8
 * @author jianghui
 * @date 2020-09-19  9:19
 **/
public class LeetCode51 {
    public static void main(String[] args) {
        LeetCode51 a = new LeetCode51();
        List<List<String>> lists = a.solveNQueens(4);
        for (List<String> list : lists) {
            for (String str : list){
                System.out.println(str);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int[] col = new int[n];
        int[] dia1 = new int[2 * n -1];
        int[] dia2 = new int[2 * n -1];
        putQueue(n,0,row,col,dia1,dia2,res);
        return res;
    }

    /**
     * 在index位置摆放皇后的位置
     * @param n
     * @param index
     * @param row
     */
    private void putQueue(int n,int index,List<Integer> row,int[] col,int[] dia1,int[] dia2,List<List<String>> res){
        if (index == n){
            List<String> list = generateBoard(n,row);
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            //尝试将第index行的皇后摆放在第i列
            if (col[i] == 0 && dia1[index+i] == 0 && dia2[index-i+n-1] == 0){
                row.add(i);
                col[i] = 1;
                dia1[index+i] = 1;
                dia2[index-i+n-1] = 1;
                putQueue(n,index+1,row,col,dia1,dia2,res);
                //回溯
                dia2[index-i+n-1] = 0;
                dia1[index+i] = 0;
                col[i] = 0;
                row.remove(row.size() - 1);
            }
        }
    }
    private List<String> generateBoard(int n,List<Integer> row){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (j!= row.get(i)){
                    str = str + ".";
                }else {
                    str = str + "Q";
                }
            }
            list.add(str);
        }
        return list;
    }
}
