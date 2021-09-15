package com.lc.warehouse.verificationcode.juc;


import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SemaphoreDemo
 * @Author: mayanchao
 * @Description: 信号灯
 * @Date: 2021/8/21 下午3:51
 */
public class SemaphoreDemo {
    //信号灯
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    //抢占
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位了");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + " 离开了车位了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
