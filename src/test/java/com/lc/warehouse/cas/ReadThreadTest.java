package com.lc.warehouse.cas;

/**
 * @ClassName: ReadThread
 * @Author: mayanchao
 * @Description: 指令重排序
 * @Date: 2021/5/27 下午3:37
 */

public class ReadThreadTest {

    private static int num = 0;
//    private static  boolean ready = false;
    private static volatile boolean ready = false;

    public static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) {
                    System.out.println(num + num);
                }
                System.out.println("read thread....");
            }
        }
    }

    public static class WriteThread extends Thread {
        @Override
        public void run() {
            //3
            num = 2;
            //4
            ready = true;
            //指令重排序可能会导致3，4顺序颠倒，会影响结果，所以要用volatile修饰ready


            System.out.println("writeThread set over....");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(5);
        rt.interrupt();
        System.out.println("main exit");
    }
}
