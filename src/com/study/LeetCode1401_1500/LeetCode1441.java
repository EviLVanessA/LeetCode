package com.study.LeetCode1401_1500;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/10/14
 */
public class LeetCode1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            ans.add("push");
            if (target[index] == i) {
                index++;
                if (index == target.length) {
                    break;
                }
            } else {
                ans.add("pop");
            }
        }
        return ans;
    }
}
