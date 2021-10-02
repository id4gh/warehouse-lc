package com.lc.warehouse.verificationcode.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Demo
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/9/26 下午9:04
 */
public class Demo {

    private Lock lock = new ReentrantLock();

    private Condition c = lock.newCondition();

    //用来证明await的时候是会释放锁的
    //AA进来了
    //BB进来了
    //10秒后
    //BBawait结束
    //AAawait结束
    public void print() throws InterruptedException {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "进来了");
            c.await(10, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "await结束");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            try {
                demo.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                demo.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
