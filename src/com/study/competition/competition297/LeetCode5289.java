package com.study.competition.competition297;

/**
 * @author jianghui
 * @date 2022-06-12 10:49
 */
public class LeetCode5289 {
    public static void main(String[] args) {
        System.out.println(new LeetCode5289().distributeCookies(new int[]{8,15,10,20,8}, 2));
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] kids = new int[k];
        dfs(0, cookies, kids, 0);
        return result;
    }


    private int result = Integer.MAX_VALUE;

    private void dfs(int index, int[] cookies, int[] kids, int curMax) {
        if (index == cookies.length) {
            result = Math.min(result, curMax);
            return;
        }
        for (int i = 0; i < kids.length; i++) {
            kids[i] += cookies[index];
            int lastMax = curMax;
            curMax = Math.max(curMax, kids[i]);
            dfs(index + 1, cookies, kids, curMax);
            curMax = lastMax;
            kids[i] -= cookies[index];
        }
    }
}
