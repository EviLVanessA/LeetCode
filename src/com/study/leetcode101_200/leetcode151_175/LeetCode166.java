package com.study.leetcode101_200.leetcode151_175;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 *
 * @author jianghui
 * @date 2021-01-09 14:19
 */
public class LeetCode166 {
    /**
     * 计算除数
     *
     * @param numerator   分子
     * @param denominator 分母
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        //两者只有一个是负数
        if (numerator < 0 ^ denominator < 0) {
            ans.append("-");
        }
        //被除数
        long dividend = Math.abs(Long.valueOf(numerator));
        //除数
        long divisor = Math.abs(Long.valueOf(denominator));
        ans.append(dividend / divisor);
        long remain = dividend % divisor;
        if (remain == 0){
            return ans.toString();
        }
        ans.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while (remain != 0){
            if (map.containsKey(remain)){
                ans.insert(map.get(remain),"(");
                ans.append(")");
                break;
            }
            map.put(remain,ans.length());
            remain *= 10;
            ans.append(remain/divisor);
            remain %= divisor;
        }
        return ans.toString();
    }
}
