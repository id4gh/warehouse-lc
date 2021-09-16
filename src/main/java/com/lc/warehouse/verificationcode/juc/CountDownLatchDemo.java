package com.lc.warehouse.verificationcode.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchDemo
 * @Author: mayanchao
 * @Description: 减少计数
 * @Date: 2021/8/19 下午5:42
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);


        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 离开了教室...");

                countDownLatch.countDown();
            }, i + "号同学").start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长锁门了...");
    }
}
