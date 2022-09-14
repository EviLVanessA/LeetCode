package com.study.LeetCode1501_1600;

/**
 * @author jianghui
 * @date 2022/9/8
 */
public class LeetCode1598 {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                depth = depth > 0 ? depth - 1 : depth;
            } else if ("./".equals(log)) {
            } else {
                depth++;
            }
        }
        return depth;
    }
}
