package com.study.LeetCode901_1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianghui
 * @date 2022/5/9
 */
public class LeetCode942 {

    public static void main(String[] args) {
        String s = "IDII";
        for (int i : new LeetCode942().diStringMatch(s)) {
            System.out.print(i + " ");
        }
    }

    public int[] diStringMatch(String s) {
        //元素的个数 也是数组元素的最大值
        int n = s.length();
        //最大值就是n
        int max = n;
        //最小值0
        int min = 0;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            //如果是I 则取出最小值 篮子中最小值+1 比如取出0则最小值变为1
            if (s.charAt(i) == 'I') {
                result[i] = min;
                min++;
            } else {
                //如果是D 则取出最大值 篮子中最大值-1 比如取出4,则最大值变为3
                result[i] = max;
                max--;
            }
        }
        //把剩余的最后一个数字放到末尾。此时max = min
        result[n] = max;
        return result;
    }

    /**
     * 回溯   超时
     *
     * @param s
     * @return
     */
    public int[] diStringMatch1(String s) {
        Set<Integer> visited = new HashSet<>();
        int[] result = new int[s.length() + 1];
        List<int[]> results = new ArrayList<>();
        doFill(results, result, 0, s, visited);
        return results.get(0);
    }

    public void doFill(List<int[]> results, int[] result, int index, String s, Set<Integer> visited) {
        if (results.size() > 0) {
            return;
        }
        if (index == s.length() + 1) {
            results.add(result.clone());
            return;
        }
        for (int i = 0; i <= s.length(); i++) {
            if (index != 0) {
                if (s.charAt(index - 1) == 'I') {
                    if (!visited.contains(i) && result[index - 1] < i) {
                        visited.add(i);
                        result[index] = i;
                        doFill(results, result, index + 1, s, visited);
                        visited.remove(i);
                    }
                } else {
                    if (!visited.contains(i) && result[index - 1] > i) {
                        visited.add(i);
                        result[index] = i;
                        doFill(results, result, index + 1, s, visited);
                        visited.remove(i);
                    }
                }
            } else {
                visited.add(i);
                result[index] = i;
                doFill(results, result, index + 1, s, visited);
                visited.remove(i);
            }
        }
    }
}
