package com.lc.warehouse.verificationcode.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ShareResource
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/8/18 下午3:22
 */
class ShareResource {

    private int flag = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + " 轮数:" + loop);
            }
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + " 轮数:" + loop);
            }
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + " 轮数:" + loop);
            }
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadDemo1 {

//    public static void main(String[] args) {
//        ShareResource shareResource = new ShareResource();
//        new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                try {
//                    shareResource.print5(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "AA").start();
//
//        new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                try {
//                    shareResource.print10(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "BB").start();
//
//        new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                try {
//                    shareResource.print15(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "CC").start();
//    }

}

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2, 1};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    break;
                }
                if (j == nums.length - 1) {
                    System.out.println(nums[i]);
                }
            }
        }
        System.out.println(nums[nums.length - 1]);
    }
}
