package com.study.LeetCode1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianghui
 * @date 2022-07-04 07:56
 */
public class LeetCode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //排序
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < min) {
                //比最小绝对差小
                ans.clear();
                min = arr[i] - arr[i - 1];
            } else if (arr[i] - arr[i - 1] > min) {
                //比最小绝对差大
                continue;
            }
            //添加答案
            List<Integer> list = new ArrayList<>();
            list.add(arr[i - 1]);
            list.add(arr[i]);
            ans.add(list);
        }
        return ans;
    }
}
