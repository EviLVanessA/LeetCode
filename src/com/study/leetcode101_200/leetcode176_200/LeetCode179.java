package com.study.leetcode101_200.leetcode176_200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author jianghui
 * @date 2021-01-14 17:21
 */

public class LeetCode179 {
    public String largestNumber(int[] nums) {
        String[] asStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStr, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });

        if ("0".equals(asStr[0])){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String s : asStr){
            ans.append(s);
        }
        return ans.toString();
    }
}
