package com.study.LeetCode601_700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-05-14 12:06
 */
public class LeetCode691 {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        //存储所有子序列所需的贴纸值
        int[] memory = new int[1 << n];
        Arrays.fill(memory, -1);
        //空序列不需要贴纸
        memory[0] = 0;
        //计算target对应的状态号的贴纸数量
        //我们可以把每个子序列都对应到一个mask(掩码，类比到网络的子网掩码)上，这里是一对一的关系
        //以“tar”为例：
        // 000 ->  ""      100 ->  "t"
        // 001 ->  "r"     101 ->  "tr"
        // 010 ->  "a"     110 ->  "ta"
        // 011 ->  "ar"    111 ->  "tar"
        int ans = dp(stickers, target, memory, (1 << n) - 1);
        //最多是n个贴纸，否则贴纸没有完全覆盖所有的字母，返回-1
        return ans <= n ? ans : -1;
    }

    /**
     * 返回mask对应的贴纸数量
     *
     * @param stickers 贴纸
     * @param target   目标值
     * @param memory   有可能会重复计算 mask对应的贴纸
     * @param mask     子序列
     * @return
     */
    private int dp(String[] stickers, String target, int[] memory, int mask) {
        int n = target.length();
        if (memory[mask] < 0) {
            int ans = n + 1;
            for (String sticker : stickers) {
                int left = mask;
                int[] chars = new int[26];
                //统计每个贴纸的 字母个数
                for (int i = 0; i < sticker.length(); i++) {
                    chars[sticker.charAt(i) - 'a']++;
                }
                for (int i = 0; i < target.length(); i++) {
                    char c = target.charAt(i);
                    //判断mask是否有第i个字母 并且该贴纸是否有此字母
                    if (((mask >> i) & 1) == 1 && chars[c - 'a'] > 0) {
                        chars[c - 'a']--;
                        //做异或处理
                        //比如现在是i == 0 并且 111 -> "tar"；c == ‘r’
                        //则剩余left ^= 1
                        //    111
                        // ^  001
                        // -------
                        // =  110
                        left ^= (1 << i);
                    }
                }
                //left是剩下没有的字母
                if (left < mask) {
                    // 计算left 再加上当前sticker（也就是+1）就是mask所需要的stickers
                    // 即 f(mask) = f(left) + 1
                    ans = Math.min(ans, dp(stickers, target, memory, left) + 1);
                }
            }
            memory[mask] = ans;
        }
        return memory[mask];
    }
}
