package com.study.LeetCode501_600;

/**
 * @author jianghui
 * @date 2022-07-03 08:17
 */
public class LeetCode556 {
    public int nextGreaterElement(int n) {
        //转化为字符数组
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int pos = -1;
        //找到pos
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i > 0 && chars[i - 1] < chars[i]) {
                pos = i - 1;
                break;
            }
        }
        //没有pos，返回
        if (pos == -1) {
            return -1;
        }
        //找到第一个大于pos的值，交换
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[pos]) {
                swap(chars, pos, i);
                break;
            }
        }
        //将pos后边的序列翻转
        int j = pos + 1, k = chars.length - 1;
        while (j < k) {
            swap(chars, j, k);
            j++;
            k--;
        }
        //判断是否越界
        long ans = Long.parseLong(String.valueOf(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
