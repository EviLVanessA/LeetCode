package com.study.leetcode1_100.leetcode51_75;

import java.util.*;

/**
 * @author jianghui
 * @date 2020-12-14 11:11
 */
public class LeetCode60 {
    boolean[] use;
    private int num = 1;
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        use = new boolean[n];
        boolean[] use = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        Map<Integer,List<Integer>> ans = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        permutations(arr,0,ans,list,k);
//        ans.values().forEach(System.out::println);
        List<Integer> list1 = ans.get(k);
        StringBuilder builder = new StringBuilder();
        for (int i : list1){
            builder.append(i);
        }
        return builder.toString();
    }
    private void permutations(int[] arr,int index,Map<Integer,List<Integer>> ans,List<Integer> list,int k){
        if (num > k){
            return;
        }
        if (index == arr.length){
            ans.put(num++, new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (use[i]){
                continue;
            }
            use[i] = true;
            list.add(arr[i]);
            permutations(arr,index+1,ans,list,k);
            use[i] = false;
            list.remove(list.size()-1);
        }
    }

    public String getPermutation2(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(new LeetCode60().getPermutation(3,2));
    }
}
