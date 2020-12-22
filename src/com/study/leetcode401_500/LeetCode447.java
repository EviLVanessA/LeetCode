package com.study.leetcode401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找两个点到一个点的距离相等 149
 * @author jianghui
 * @date 2020-09-16  9:28
 **/
public class LeetCode447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    int len = (points[i][0] - points[j][0])*(points[i][0] - points[j][0])+
                            (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                    record.put(len,record.containsKey(len)?record.get(len)+1:1);
                }
            }
            for (Integer key : record.keySet()){
                int value = record.get(key);
                if (value >= 2){
                    res += value*(value-1);
                }
            }
        }
        return res;
    }
}
