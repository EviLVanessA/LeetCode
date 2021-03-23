package com.study.facetext;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author jianghui
 * @date 2021-03-22 15:03
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        //默认非公平锁
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\tput 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "\tput 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "\tput 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
