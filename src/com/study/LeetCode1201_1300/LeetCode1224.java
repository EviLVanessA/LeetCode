package com.study.LeetCode1201_1300;

/**
 * @author jianghui
 * @date 2022-08-18 08:16
 */
public class LeetCode1224 {
    public int maxEqualFreq(int[] nums) {
        int length = (int) 1e5 + 7;
        //存放数字的个数
        int[] hash = new int[length];
        //记录最大的数字频率
        int maxFreq = 0;
        //记录最大数字频率的数字种类
        int maxSpecies = 0;
        //记录数字种类
        int species = 0;
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            //当前没有的新数字
            if (hash[num] == 0) {
                hash[num]++;
                species++;
            }
            if (hash[num] > maxFreq) {
                //超过了 最大数字频率
                maxFreq = hash[num];
                //最大数字频率的数字种类 只有一种
                maxSpecies = 1;
            } else if (hash[num] == maxFreq) {
                //新加入一个最大频率的数字
                maxSpecies++;
            }
            //有以下几种情况
            //①频率都是1 如：1、2、3、4、5 随便删除一个即可
            //②频率都是maxFreq 如：111 222 333 4 删除4即可
            //③最大频率的种类是1个 并且maxFreq是 i / species（平均数量）多一个
            //如：111 222 333 4444 删除1个4  或者如 1111111 随便删除一个
            if (maxFreq == 1 || maxFreq * maxSpecies == i || maxSpecies == 1 && maxFreq == i / species + 1) {
                ans = i + 1;
            }
        }
        return ans;
    }
}