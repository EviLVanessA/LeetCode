package com.study.leetcode401_500;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author jianghui
 * @date 2022/6/1
 */
public class LeetCode473 {

    public static void main(String[] args) {
        System.out.println(new LeetCode473().makesquare(new int[]{1, 1, 2, 2, 2}));
    }

    public boolean makesquare(int[] matchsticks) {
        //周长
        int totalLength = Arrays.stream(matchsticks).sum();
        //不是4的整数倍一定拼不成正方形
        if (totalLength % 4 != 0) {
            return false;
        }
        //边长
        int edgeLength = totalLength / 4;
        Arrays.sort(matchsticks);
        //最长火柴的长度大于边长 无法拼成
        if (matchsticks[matchsticks.length - 1] > edgeLength) {
            return false;
        }
        //转化为降序
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, edgeLength);
    }

    private boolean dfs(int index, int[] matchsticks, int[] edges, int edgeLength) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            //第i个边尝试 使用matchsticks[index]火柴
            if (edges[i] + matchsticks[index] > edgeLength || (i > 0 && edges[i - 1] == edges[i])) {
                continue;
            }
            edges[i] += matchsticks[index];
            if (dfs(index + 1, matchsticks, edges, edgeLength)) {
                return true;
            }
            //回溯
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public boolean makesquare2(int[] matchsticks) {
        //周长
        int totalLength = Arrays.stream(matchsticks).sum();
        //不是4的整数倍一定拼不成正方形
        if (totalLength % 4 != 0) {
            return false;
        }
        //边长
        int edgeLength = totalLength / 4;
        int n = matchsticks.length;
        //一共有2^n种状态
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                int state = i & ~(1 << j);
                if (dp[state] >= 0 && dp[state] + matchsticks[j] <= edgeLength) {
                    dp[i] = (dp[state] + matchsticks[j]) % edgeLength;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    public boolean makesquare3(int[] matchsticks) {
        //周长
        int totalLength = Arrays.stream(matchsticks).sum();
        //不是4的整数倍一定拼不成正方形
        if (totalLength % 4 != 0) {
            return false;
        }
        //边长
        int edgeLength = totalLength / 4;
        Arrays.sort(matchsticks);
        //最长火柴的长度大于边长 无法拼成
        if (matchsticks[matchsticks.length - 1] > edgeLength) {
            return false;
        }
        //转化为降序
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        return backtrack(matchsticks, 0, edgeLength, edges);
    }

    //index表示访问到当前火柴的位置，target表示正方形的边长，size是长度为4的数组，
    //分别保存正方形4个边的长度
    private boolean backtrack(int[] matchsticks, int index, int target, int[] edges) {
        if (index == matchsticks.length) {
            return true;
        }
        //到这一步说明火柴还没访问完
        for (int i = 0; i < edges.length; i++) {
            //如果把当前火柴放到size[i]这个边上，他的长度大于target，我们直接跳过。或者
            // edges[i] == edges[i - 1]即上一个分支的值和当前分支的一样，上一个分支没有成功，
            //说明这个分支也不会成功，直接跳过即可。
//            if (edges[i] + matchsticks[index] > target || (i > 0 && edges[i] == edges[i - 1]) || (index == 0 && i != 0)) {
            if (edges[i] + matchsticks[index] > target) {
                continue;
            }
            //如果当前火柴放到size[i]这个边上，长度不大于target，我们就放上面
            edges[i] += matchsticks[index];
            //然后在放下一个火柴，如果最终能变成正方形，直接返回true
            if (backtrack(matchsticks, index + 1, target, edges)) {
                return true;
            }
            //如果当前火柴放到size[i]这个边上，最终不能构成正方形，我们就把他从
            //edges[i]这个边上给移除，然后在试其他的边
            edges[i] -= matchsticks[index];
        }
        //如果不能构成正方形，直接返回false
        return false;
    }

}
