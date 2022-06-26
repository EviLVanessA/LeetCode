package com.study.LeetCode1401_1500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jianghui
 * @date 2022/6/21
 */
public class LeetCode1488 {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        Map<Integer, Integer> water = new HashMap<>();
        TreeSet<Integer> zero = new TreeSet<>();
        for (int i = 0; i < rains.length; ++i) {
            int rain = rains[i];
            //晴天，存下标
            if (rain == 0) {
                zero.add(i);
                continue;
            }
            //下雨天，且这个湖泊已经下过雨了
            if (water.containsKey(rain)) {
                //找到之前一次下雨的下标所对应的下一个晴天下标
                Integer r = zero.higher(water.get(rain));
                //如果没有满足要求的晴天下标，返回空数组
                if (r == null) {
                    return new int[]{};
                }
                //清空的湖泊下标
                ans[r] = rain;
                //移除已经使用过的晴天
                zero.remove(r);
            }
            //存放下雨的湖泊
            water.put(rain, i);
            //下雨不能操作
            ans[i] = -1;
        }
        return ans;
    }
}
