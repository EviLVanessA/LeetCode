package com.study.facetext;

import java.nio.ByteBuffer;

/**
 * @author jianghui
 * @date 2021-03-23 21:01
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("默认1/4");
        System.out.println("配置的maxDirectMemory\t" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        //配置5M，但是分配6M
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
