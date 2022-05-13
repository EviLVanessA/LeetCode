package com.study.LeetCode901_1000;

/**
 * @author jianghui
 * @date 2022/5/12
 */
public class LeetCode944 {
    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();
        int index = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    index++;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] str = {"zyx", "wvu", "tsr"};
        System.out.println(new LeetCode944().minDeletionSize(str));
    }
}
