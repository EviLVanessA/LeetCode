package com.study.facetext;

import java.util.Random;

/**
 * @author jianghui
 * @date 2021-03-23 17:31
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "aaaaaaa";
        while (true){
            str += str +new Random().nextInt(111111)+new Random().nextInt(222);
            str.intern();
        }
    }
}
