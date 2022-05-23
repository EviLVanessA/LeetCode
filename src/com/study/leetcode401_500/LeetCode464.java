package com.study.leetcode401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghui
 * @date 2022-05-22 10:38
 */
public class LeetCode464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //总长度不满足目标值
        if (maxChoosableInteger * (maxChoosableInteger + 1) < (desiredTotal * 2)) {
            return false;
        }
        //存储state的变量值，由于state一共有2^maxChoosableInteger种
        Map<Integer, Boolean> memory = new HashMap<>(1 << maxChoosableInteger);
        //开始遍历整个树
        return dfs(maxChoosableInteger, 0, desiredTotal, 0, memory);
    }

    /**
     * @param maxChoosableInteger 最大可选择的数字
     * @param state               状态位
     * @param desiredTotal        目标值
     * @param curTotal            当前值
     * @param memory              存储搜索过的状态
     * @return
     */
    private boolean dfs(int maxChoosableInteger, int state, int desiredTotal, int curTotal, Map<Integer, Boolean> memory) {
        if (!memory.containsKey(state)) {
            boolean ans = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                //state的第i位表示 第i+1个数字被使用
                if (((state >> i) & 1) == 1) {
                    continue;
                }
                //先手取i看 能不能赢 不能赢则轮到对手取数字
                if (curTotal + i + 1 >= desiredTotal) {
                    ans = true;
                    break;
                }
                //轮到对手取数字 若对手不能赢（必然输掉的状态） 则我方赢
                //state | (1 << i), 将state的第i位置为已使用
                if (!dfs(maxChoosableInteger, state | (1 << i), desiredTotal, curTotal + i + 1, memory)) {
                    ans = true;
                    break;
                }
            }
            memory.put(state, ans);
        }
        return memory.get(state);
    }
}
