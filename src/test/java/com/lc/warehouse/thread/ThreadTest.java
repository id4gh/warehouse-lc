package com.lc.warehouse.thread;

import com.lc.warehouse.leetcode.Solution;
import org.junit.jupiter.api.Test;

/**
 * @ClassName: Wait
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/19 上午11:32
 */
class ThreadTest {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    @Test
    void wait1() {

        com.lc.warehouse.verificationcode.test.Wait wait = new com.lc.warehouse.verificationcode.test.Wait();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    wait.producer(String.valueOf(i));
                    System.out.println("现在放入字符：++++++++++++++++++++++++++" + i);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                int all = 0;
                for (int i = 0; i <= 100; i++) {
                    String consumer = wait.consumer();
                    all = all + Integer.parseInt(consumer);
                    System.out.println("现在取出字符：__________________________" + consumer);
                }
                System.out.println("求和一共是：=============================" + all);
            }
        });

        threadA.start();
        threadB.start();
    }

    @Test
    void interrupt() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });

        //启动子程序
        thread.start();

        //主程序休眠1s，以便中断前让子程序输出
        Thread.sleep(1000);

        //中断子程序
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子程序执行完毕
        thread.join();
        System.out.println("main is over");
    }

    @Test
    void interrupt2() throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("threadOne begin sleep for 2000 seconds");
                    Thread.sleep(2000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    return;
                }

                System.out.println("threadOne-leaving normally");
            }
        });

        //启动子程序
        threadOne.start();

        //主程序休眠1s，以便中断前让子程序输出
        Thread.sleep(1000);

        //中断子程序
        System.out.println("main thread interrupt thread");
        threadOne.interrupt();

        //等待子程序执行完毕
        threadOne.join();
        System.out.println("main is over");
    }

    /**
     * interrupt:仅仅是设置中断标志，线程实际并没有被中断，它会继续往下执行。如果线程因为调用了wait系列函数、join方法(其他线程调用本线程的join)或者sleep方法而被阻塞挂起，这时候其他线程调用threadOne的interrupt()，threadOne会在调用这些方法的地方抛出InterruptedException异常而返回。
     * isInterrupted:检测当前线程是否被中断，如果是返回true，否则返回false。
     * interrupted:检测当前线程是否被中断，如果是返回true，否则返回false。与isInterrupted不同的是，该方法如果发现当前线程被中断，则会清除中断标志，并且该方法是static，可以通过Thread类直接调用。(在interrupted()内部是获取当前调用的中断标志而不是调用interrupted()方法的实例对象的中断标志)
     *
     * @throws InterruptedException
     */
    @Test
    void interrupt3() throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        //启动子程序
        threadOne.start();

        //设立中断标志
        //仅仅是设置中断标志，线程实际并没有被中断，它会继续往下执行。
        //如果线程因为调用了wait系列函数、join方法或者sleep方法而被阻塞挂起，这时候其他线程调用threadOne的interrupt()，threadOne会在调用这些方法的地方抛出InterruptedException异常而返回。
        threadOne.interrupt();

        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //获取中断标志并重置
        //(其实此处获取的是主程序的中断标志，因为没有，所以是false)
        System.out.println("isInterrupted:" + threadOne.interrupted());
        //获取中断标志并重置
        //(其实此处获取的是主程序的中断标志，因为没有，所以是false)
        System.out.println("isInterrupted:" + Thread.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        //等待子程序执行完毕
        //(其实中断不了，因为后续没有wait，sleep或者join)
        threadOne.join();
        System.out.println("main is over");
    }


    @Test
    void join() {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run!");
                for (; ; ) {
                }
            }
        });

        //获取主线程
        final Thread mainThread = Thread.currentThread();

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
//                threadOne.interrupt();//是threadOne标记中断的话，threadOne无法结束死循环
            }
        });

        //启动子程序
        threadOne.start();

        //延迟1s启动子程序
        threadTwo.start();

        try {
            //等待线程1之行结束
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }
    }


    @Test
    void isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        System.out.println(f[m][n]);


    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
