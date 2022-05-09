package com.study.leetcode401_500;

import java.sql.Struct;
import java.util.*;

/**
 * @author jianghui
 * @date 2022/5/7
 */
public class LeetCode433 {
    public int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (start.equals(end)) {
            return 0;
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        char[] chs = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            //当前层级的个数
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curGene = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (curGene != null && chs[k] != curGene.charAt(j)) {
                            StringBuilder sb = new StringBuilder(curGene);
                            sb.setCharAt(j, chs[k]);
                            String newGene = sb.toString();
                            System.out.println(newGene);
                            if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                                if (newGene.equals(end)) {
                                    return step;
                                }
                                queue.offer(newGene);
                                visited.add(newGene);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(new LeetCode433().minMutation(start, end, bank));
    }
}
