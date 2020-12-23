package com.study.leetcode1_100.leetcode76_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * @author jianghui
 * @date 2020-12-23 13:40
 */
public class LeetCode93 {
    static final int COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        //找到四段 并且遍历完字符串 则将字符串加入ans中
        if (segId == COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != COUNT - 1) {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        //如果不够四段但字符串长度已经不够了 直接return
        if (segStart == s.length()) {
            return;
        }
        //无前导0 所以0 为单独一个segment
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        //对一般情况进行枚举
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            //如果在范围内 进行dfs
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            }else {
                break;
            }
        }
    }
}
