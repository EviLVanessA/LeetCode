package com.study.facetext;

import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianghui
 * @date 2021-03-24 09:06
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t----------->come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t----------->被唤醒");
        }, "AAA");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t----------->come in");
            LockSupport.unpark(t1);
        }, "BBB");
        t2.start();
    }
}
