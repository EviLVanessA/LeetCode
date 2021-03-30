package com.study.facetext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jianghui
 * @date 2021-03-30 12:29
 */
public class Test {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A","A","B","B","C");
        System.out.print("去重前：");
        for (String s : stringList) {
            System.out.print(s);
        }
        System.out.println();
        stringList = stringList.stream().distinct().collect(Collectors.toList());
        System.out.print("去重后：");
        for (String s : stringList) {
            System.out.print(s);
        }
        System.out.println();

    }
}
