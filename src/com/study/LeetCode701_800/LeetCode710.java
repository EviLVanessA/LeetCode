package com.study.LeetCode701_800;

import java.util.*;

/**
 * @author jianghui
 * @date 2022-06-26 08:14
 */
public class LeetCode710 {


    private final Map<Integer, Integer> blackToWhite = new HashMap<>();
    private final Random random = new Random();
    private int whiteLength = 0;

    public LeetCode710(int n, int[] blacklist) {
        //黑名单长度
        int blackLength = blacklist.length;
        //白名单长度
        whiteLength = n - blackLength;
        //记录后半部分中黑名单的位置 表示在后半部分这个这个位置是黑名单，不能做映射
        int[] black = new int[blackLength];
        for (int value : blacklist) {
            if (value >= whiteLength) {
                black[value - whiteLength] = 1;
            }
        }
        int pos = 0;
        for (int value : blacklist) {
            //前半部分范围中的黑名单，要对其做映射
            if (value < whiteLength) {
                while (black[pos] == 1) {
                    pos++;
                }
                //映射到黑名单中的白名单位置
                blackToWhite.put(value, pos + whiteLength);
                pos++;
            }
        }
    }

    public int pick() {
        //随机数
        int i = random.nextInt(whiteLength);
        return blackToWhite.getOrDefault(i, i);
    }

    public static void main(String[] args) {
        LeetCode710 leetCode710 = new LeetCode710(7, new int[]{2, 3, 5});
        System.out.println(leetCode710.pick());

    }
}
