package com.lc.warehouse.verificationcode.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierDemo
 * @Author: mayanchao
 * @Description: 循环栅栏
 * @Date: 2021/8/20 下午4:52
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //循环栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,
                () -> {
                    System.out.println("集齐7颗龙珠召唤神龙");
                });


        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 星龙珠被发现");
                    //等待
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
