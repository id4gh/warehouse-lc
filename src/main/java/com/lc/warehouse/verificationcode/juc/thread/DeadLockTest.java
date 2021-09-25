package com.lc.warehouse.verificationcode.juc.thread;

/**
 * @ClassName: DeadLockTest
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/19 下午7:32
 */
class DeadLockTest {

    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get ResourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get ResourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + " get ResourceB");
                    }
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get ResourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + " waiting get ResourceA");
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + " get ResourceA");
                    }
                }

            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //死锁解决办法，将2个线程锁的顺序保持一致
}


