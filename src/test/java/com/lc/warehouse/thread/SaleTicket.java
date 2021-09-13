package com.lc.warehouse.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SaleTick
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/8/16 下午4:22
 */

class Tickcet {
    //    private List<Integer> list = new ArrayList<>();
    private Queue<Integer> list = new LinkedList<>();

    synchronized void push(int num) {
        list.offer(num);
        System.out.println(Thread.currentThread().getName() + "输入：" + num);
    }

    synchronized int pull() {
        if (list.size() > 0) {
            Integer poll = list.poll();
            System.out.println(poll);
            return poll;
        }
        return 0;
    }
}

public class SaleTicket {

    public static void main(String[] args) throws InterruptedException {

        Tickcet tickcet = new Tickcet();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        tickcet.push(i);

                    }
                }
            }
        }, "thread1-1").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 != 0) {
                        tickcet.push(i);
                    }
                }
            }
        }, "thread1-2").start();

        new Thread(new Runnable() {
            int nums = 0;

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int pull = tickcet.pull();
                    nums = nums + pull;
                    System.out.println(Thread.currentThread().getName() + "输出：" + pull);
                }
                System.out.println(Thread.currentThread().getName() + "和：" + nums);
            }

        }, "thread2-1").start();

        new Thread(new Runnable() {
            int nums = 0;

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int pull = tickcet.pull();
                    nums = nums + pull;
                    System.out.println(Thread.currentThread().getName() + "输出：" + pull);
                }
                System.out.println(Thread.currentThread().getName() + "和" + nums);
            }

        }, "thread2-2").start();

        Thread.sleep(10000);
    }
}
