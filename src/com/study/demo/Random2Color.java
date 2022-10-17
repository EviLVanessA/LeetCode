package com.study.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jianghui
 * @date 2022/10/17
 */
public class Random2Color {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                int num = random.nextInt(33) + 1;
                String tar;
                if (num >= 10) {
                    tar = num + "";
                } else {
                    tar = "0" +num;
                }
                while (list.contains(tar)) {
                    num = random.nextInt(33) + 1;
                    if (num >= 10) {
                        tar = num + "";
                    } else {
                        tar = "0" +num;
                    }
                }
                list.add(tar);
            }
            Collections.sort(list);
            int num = random.nextInt(15) + 1;
            String tar;
            if (num >= 10) {
                tar = num + "";
            } else {
                tar = "0" +num;
            }
            list.add(tar);
            System.out.println(list.toString());
        }
    }
}
