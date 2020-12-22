package com.study.leetcode1_100.leetcode51_75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author jianghui
 * @date 2020-12-21 08:58
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        StringBuilder ans = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (String s : pathArray) {
            if (s.length() == 0 || (".").equals(s)) {
                continue;
            }
            if (!stack.isEmpty()) {
                if ("..".equals(s)) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            } else {
                if (!"..".equals(s)) {
                    stack.push(s);
                }
            }
        }
        if (stack.isEmpty()){
            return ans.append('/').toString();
        }

        while (!stack.isEmpty()){
            ans.insert(0,stack.pop());
            ans.insert(0,'/');
        }
        return ans.toString();
    }
}
