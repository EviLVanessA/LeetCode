package com.study.LeetCode501_600;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022-07-17 08:46
 */
public class LeetCode565 {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) {
                continue;
            }
            int temp = num;
            int curAns = 0;
            while (!visited.contains(temp)) {
                visited.add(temp);
                temp = nums[temp];
                curAns++;
            }
            ans = Math.max(ans, curAns);
        }
        return ans;
    }

    public int arrayNesting2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int curAns = 0;
            int temp = i;
            while (nums[temp] != -1) {
                curAns++;
                int next = nums[temp];
                nums[temp] = -1;
                temp = next;
            }
            ans = Math.max(ans, curAns);
        }
        return ans;
    }
}
