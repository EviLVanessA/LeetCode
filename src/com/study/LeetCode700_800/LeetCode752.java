package com.study.LeetCode700_800;

import java.util.*;

/**
 * @author jianghui
 * @date 2021-01-20 11:29
 */
public class LeetCode752 {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String s = queue.poll();
                if (target.equals(s)) {
                    return step;
                }
                if (deadSet.contains(s)) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    String upString = upLock(s, j);
                    if (!visited.contains(upString)) {
                        queue.offer(upString);
                        visited.add(upString);
                    }
                    String downString = downLock(s, j);
                    if (!visited.contains(downString)) {
                        queue.offer(downString);
                        visited.add(downString);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String upLock(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j]++;
        }
        return new String(chars);
    }

    private String downLock(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j]--;
        }
        return new String(chars);
    }

    /**
     * 双向BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock2(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        Set<String> queue1 = new HashSet<>();
        Set<String> queue2 = new HashSet<>();
        queue1.add("0000");
        queue2.add(target);
        int step = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            if (queue1.size() > queue2.size()) {
                // 交换 q1 和 q2
                temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
            for (String cur : queue1) {
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (queue2.contains(cur)) {
                    return step;
                }
                visited.add(cur);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        String upString = upLock(cur, j);
                        if (!visited.contains(upString)) {
                            temp.add(upString);
                        }
                        String downString = downLock(cur, j);
                        if (!visited.contains(downString)) {
                            temp.add(downString);
                        }
                    }
                }
            }
            step++;
            queue1 = queue2;
            queue2 = temp;
        }
        return -1;
    }
}
