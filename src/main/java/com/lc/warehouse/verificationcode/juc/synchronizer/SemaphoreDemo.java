package com.lc.warehouse.verificationcode.juc.synchronizer;


import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SemaphoreDemo
 * @Author: mayanchao
 * @Description: 信号灯
 * <p>
 * 以一个停车场是运作为例。假设停车场只有三个车位，一开始三个车位都是空的。
 * 这是如果同时来了五辆车，看门人允许其中三辆不受阻碍的进入，然后放下车拦，剩下的车则必须在入口等待，
 * 此后来的车也都不得不在入口处等待。
 * 这时，有一辆车离开停车场，看门人得知后，打开车拦，放入一辆，如果又离开两辆，则又可以放入两辆，如此往复。
 * </p>
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
