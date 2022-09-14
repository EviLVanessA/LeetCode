package com.study.LeetCode601_700;

/**
 * @author jianghui
 * @date 2022/9/13
 */
public class LeetCode670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        //找到 [i+1,n]中的最大值和i进行交换
        for (int i = 0; i < chars.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[maxIndex] <= chars[j]) {
                    maxIndex = j;
                }
            }
            if (i < maxIndex && chars[i] < chars[maxIndex]) {
                char temp = chars[i];
                chars[i] = chars[maxIndex];
                chars[maxIndex] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }


    public int maximumSwap2(int num) {
        //转化为字符数组
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int max = n - 1;
        int candidateMin = 0, candidateMax = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            //找到更大的元素
            if (chars[i] > chars[max]) {
                max = i;
            } else if (chars[i] < chars[max]) {
                candidateMin = i;
                candidateMax = max;
            }
        }
        //找到一组交换的候选min max 并且min < max && chars[min] < chars[max]
        if (candidateMin < candidateMax && chars[candidateMin] < chars[candidateMax]) {
            char temp = chars[candidateMin];
            chars[candidateMin] = chars[candidateMax];
            chars[candidateMax] = temp;
            return Integer.parseInt(new String(chars));
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode670 leetCode670 = new LeetCode670();
        System.out.println(leetCode670.maximumSwap(98368));

    }
}
