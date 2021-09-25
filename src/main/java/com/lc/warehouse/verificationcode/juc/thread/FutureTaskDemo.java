package com.lc.warehouse.verificationcode.juc.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: FutureTask
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/8/19 下午5:17
 */


class MyThread1 implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable {


    @Override
    public Object call() throws Exception {
        Thread.sleep(10000);
        return 200;
    }
}

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());

        FutureTask<Integer> futureTask2 = new FutureTask<>(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " come in callable");
                    return 1024;
                });

        new Thread(futureTask1, "AA").start();
        new Thread(futureTask2, "BB").start();

        while (!futureTask2.isDone()) {
            System.out.println("wait...");
        }

        System.out.println(futureTask2.get());
        System.out.println(futureTask1.get());
        System.out.println(futureTask1.get());

        System.out.println(Thread.currentThread().getName() + " is over");

    }
}
