package com.lc.warehouse.thread;

import org.junit.jupiter.api.Test;

/**
 * @ClassName: ThreadLocalTest
 * @Author: mayanchao
 * @Description: 线程本地变量，每个线程都会有这个变量都本地副本
 * @Date: 2021/5/19 下午9:06
 */
class ThreadLocalTest {

    static void print(String str) {
        //打印当前线程本地内存中localVariable变量值
        System.out.println(str + ":" + localVariable.get());
        //清除当前线程本地内存中都localVariable变量
//        localVariable.remove();
    }

    //创建ThreadLocal变量
    private static ThreadLocal<String> localVariable = new ThreadLocal<>();

    private static ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal();

    private String i = "哈哈哈哈哈";

    @Test
    void ThreadLocal1() throws InterruptedException {

        //必须申明在创建线程之前
        //创建线程时，在构造函数里面会调用init方法，获取了父线程的inheritableThreadLocal值
        inheritableThreadLocal.set("threadOne inheritableThreadLocal variable");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadOne local variable");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + localVariable.get());
                System.out.println("threadOne inheritableThreadLocal" + ":" + inheritableThreadLocal.get());
                inheritableThreadLocal.set("1");
                System.out.println("threadOne inheritableThreadLocal" + ":" + inheritableThreadLocal.get());
                System.out.println(i);
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadTwo local variable");
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + localVariable.get());
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //不会变成1
                System.out.println("threadTwo inheritableThreadLocal" + ":" + inheritableThreadLocal.get());
            }
        });

//        inheritableThreadLocal.set("threadOne inheritableThreadLocal variable");

        threadOne.start();
        threadTwo.start();
        Thread.sleep(1000);
    }

}
